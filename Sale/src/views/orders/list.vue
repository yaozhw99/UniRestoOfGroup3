<template>
  <div class="app-container">
    <!--搜索条件区-->
    <div class="filter-container">
      <el-input v-model="listQuery.deptName"
                placeholder="部门名称" style="width: 200px"
                class="filter-item" @keyup.enter.native="handleFilter"></el-input>
      <el-select @change="handleFilter" v-model="listQuery.personCount" class="filter-item">
        <el-option key="0" label="-请选择-" :value="0"></el-option>
        <el-option v-for="item in personCount" :key="item.key" :value="item.key" :label="item.value"></el-option>
      </el-select>
    </div>

    <!--部门数据表格-->
    <el-table v-loading="listLoading" :data="pageData">
      <el-table-column sortable width="100" prop="id" label="编号"></el-table-column>
      <el-table-column sortable width="120" prop="peoples" label="人员数量">
        <template slot-scope="scope">
          <el-tag :type="scope.row.peoples | hotTagType">{{scope.row.peoples}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="deptName" label="部门名称"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="{row}">
          <el-button size="mini" type="success" @click="createDept()">新增</el-button>
          <el-button size="mini" type="danger" @click="delDept(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页组件-->
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <el-dialog title="新增" label-position="left" label-width="70px" :visible.sync="dialogVisible">
      <el-form ref="dataForm" :rules="rules" :model="newDept">
        <el-form-item label="部门名称" prop="deptName">
          <el-input v-model="newDept.deptName" placeholder="请输入部门名称"></el-input>
        </el-form-item>
        <el-form-item label="人员数量" prop="peoples">
          <el-input v-model="newDept.peoples" placeholder="请输入人员数量"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible=false">取消</el-button>
        <el-button type="primary" @click="saveDept()">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {fetchList,delDept,saveDept} from '@/api/dept'
  import Pagination from '@/components/Pagination'

  export default {
    data() {
      return {
        //form表单数据绑定
        newDept:{
          peoples:0,
          deptName:''
        },
        //form验证规则
        rules:{
          deptName:[{required:true,message:'必填项',trigger:'blur'}],
          peoples:[{required:true,message:'必填项',trigger:'blur'}],
        },
        //控制模态对话框显示与否
        dialogVisible:false,
        //控制等待画面的显示与否
        listLoading:true,
        total:0,
        personCount:[
          {key:1,value:"<15"},
          {key:2,value:"15—25"},
          {key:3,value:">25"},
        ],
        //查询条件
        listQuery:{
          page: 1,
          limit: 10,
          deptName:'',
          personCount:0
        },
        //当前页的部门数据
        pageData:[],
        //全部部门数据
        deptList:[]
      }
    },
    components:{
      Pagination
    },
    filters:{
      //对部门人员数量进行数据格式化
      hotTagType(value){
        return value>=25 ? 'danger' : (value>=15?'warning':'success')
      }
    },
    mounted(){
      //显示等待画面
      this.listLoading=true;
      //初始获取所有部门数据列表
      fetchList({}).then(res=>{
        console.log(res);
      this.deptList=res.data.items;
      this.total=res.data.items.length;

      //数据分页
      this.getList();

      //关闭等待页面
      this.listLoading=false;
    }).catch(err=>{
        console.log(err);
    })
    },
    methods:{
      getList(){
        let {page,limit,deptName,personCount}=this.listQuery;

        //对deptList数据进行过滤
        let filterData=[];
        filterData=this.deptList.filter(item=>{
          //针对部门人员数量进行过滤
          if(personCount==1 && item.peoples>=15)
        return false;
        if(personCount==2 && (item.peoples<15 || item.peoples>=25))
          return false;
        if(personCount==3 && item.peoples<25)
          return false;

        //针对部门名称进行过滤
        if(deptName && item.deptName.indexOf(deptName)==-1)
          return false;

        return true;
      })

        //设置数据总数为过滤后的总数据量
        this.total=filterData.length;

        //对deptList数据进行分页检索
        //this.pageData=this.deptList.slice(limit*(page-1),limit*page);
        this.pageData=filterData.filter((item,idx)=>{
          return idx>=limit*(page-1) && idx<limit*page;
      })
      },
      handleFilter(){
        this.listQuery.page=1;
        this.getList();
      },
      delDept(row){
        this.$confirm('是否删除？','提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=>{
          delDept({id:row.id}).then(res=>{
          this.$message({
          message:'删除成功',
          type:'success'
        })
        let idx=this.deptList.findIndex(item=>item.id==row.id);
        this.deptList.splice(idx,1);
        this.getList();
      })
      }).catch(()=>{
          this.$message({
          type: 'info',
          message: '已取消删除'
        });
      })


      },
      createDept(){
        this.dialogVisible=true;
        //Vue实例的下一个更新时钟
        this.$nextTick(()=>{
          this.$refs.dataForm.clearValidate();
      })
      },
      saveDept(){
        //验证数据有效性
        this.$refs.dataForm.validate((valid)=>{
          if(valid){
            //发起ajax请求，新增数据
            saveDept(this.newDept).then((res)=>{
              //关闭模态对话框
              this.dialogVisible=false;
            //页面插入新数据
            this.newDept.id=res.data;

            let {id,peoples,deptName}=this.newDept;
            this.deptList.push({id,peoples,deptName});

            this.getList();
            //弹出成功提醒
            this.$notify({
              title:'成功',
              message:'数据创建成功',
              type:'success',
              duration:2000
            })
            //数据清理
            this.newDept.peoples=0;
            this.newDept.deptName="";
          })
          }
        })
      }
    }
  }
</script>

<style>

</style>
