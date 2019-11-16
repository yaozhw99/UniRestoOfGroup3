<template>
<div>
  <el-table
    :data="orderList"
    style="width: 100%; height: 100%;"
    :row-class-name="tableRowClassName"
    >

    <el-table-column
      v-for="(items,idx) in orderColumn" :key="idx" :prop="items.idd" v-if="items.idd=='OrderFlag'"
      :label="items.value"
      :fixed="items.fixed"
      :sortable="items.sortable"
      :filters="filterData"
      :filter-method="filterHandler"
      >
    </el-table-column>
    <el-table-column
      v-for="(items,idx) in orderColumn" :key="idx" :prop="items.idd" v-if="items.idd!='OrderFlag'"
      :label="items.value"
      :fixed="items.fixed"
      :sortable="items.sortable"
      >

    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="70">
      <template slot-scope="scope">


          <el-button type="primary" size="mini"
                     v-if="scope.row.OrderFlag=='订单预订'"

                     @click="commitRow(scope.row.OrderID)">
            <i class="fa fa-ban"></i> 开户
          </el-button>
          <el-button v-else-if="scope.row.OrderFlag=='订单已开户'"
                     type="primary" size="mini"
                     @click="commitRow(scope.row.OrderID)">
            <i class="fa fa-link"></i> 发货
          </el-button>
        <el-button v-else type="primary" size="mini"
                   @click="commitRow(scope.row.OrderID)">
          <i class="fa fa-link"></i> 查询
        </el-button>

      </template>
    </el-table-column>
  </el-table>
  <el-dialog
    title="请确认"
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="handleClose">
    <span>{{msg}}</span>
    <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="commitRowEnd()">确 定</el-button>
  </span>
  </el-dialog>
  <!-- Table -->
  <el-dialog title="收货地址" :visible.sync="dialogTableVisible">
    <el-table :data="fData"
              ref="singleTable"
              :row-class-name="RowClassName"
              @current-change="handleCurrentChange"
              highlight-current-row="true">
      <el-table-column property="name" label="姓名"></el-table-column>
      <el-table-column property="region" label="城市"></el-table-column>
      <el-table-column property="address" label="地址"></el-table-column>
      <el-table-column property="phone" label="联系电话" ></el-table-column>
      </el-table>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogTableVisible = false">取 消</el-button>
      <el-button type="primary" @click="setCurrent()">确 定</el-button>
    </span>
  </el-dialog>

</div>
       

</template>


<script>
  import Mock from 'mockjs'
  import bmap from 'echarts/extension/bmap/bmap';

    export default {

      data() {
        return {
          //form表单数据绑定
          newOrder: {
            Orderid: 0,
            OrderDate: '',
            UserName: '',
            Userid: '',
            Idtype: '',
            Idnumber: 0,
            ProductId: '',
            ProductName: '',
            FirstMonthfeetype: '',
            fee: 0
          },
          //form验证规则
          rules: {
            Orderid: [{required: true, message: '必填项', trigger: 'blur'}],
            ProductId: [{required: true, message: '必填项', trigger: 'blur'}],
          },

          //控制模态对话框显示与否
          dialogVisible: false,
          dialogTableVisible: false,
          RowClassName:'',

          //控制等待画面的显示与否
          msg: '',
          total: 0,
          //查询条件
          listQuery: {
            page: 1,
            limit: 10,
            OrderDate: '',
            Orderid: 0,
            ProductId: ''
          },
          //当前页的部门数据
          fData:[],
          form:{
            name: '',
            region: '',
            date: '',
            adress:'',
            delivery: false,
            phone:'',
            wlId:0
          },
          rowid: 0,
          count:0,
          rowFlag:'',
          //全部部门数据
          orderList: [],
          orderColumns: {
            OrderID: '订单号',
            OrderDate: '订单日期',
            OrderFlag: '订单状态',
            UserName: '用户姓名',
            Userid: '用户id',
            Idtype: '证件类型',
            Idnumber: '证件号码',
            ProductId: '产品id',
            ProductName: '产品名称',
            FirstMonthfeetype: '首月费用模式',
            fee: '应收费用',
            UserFlag: '用户状态',
            detail: '订单备注'
          },
          orderColumn: [
            {idd: "OrderID", value: '订单号', fixed: "left", sortable: true, 'sort-by': "OrderID"},
            {idd: 'OrderDate', value: '订单日期', sortable: true},
            {idd: 'OrderFlag', value: '订单状态',width:120},
            {idd: 'UserName', value: '用户姓名'},
            {idd: 'Userid', value: '用户id'},
            {idd: 'Idtype', value: '证件类型'},
            {idd: 'Idnumber', value: '证件号码', resizable: "true"},
            {idd: 'ProductId', value: '产品id'},
            {idd: 'ProductName', value: '产品名称'},
            {idd: 'FirstMonthfeetype', value: '首月费用模式'},
            {idd: 'fee', value: '应收费用'},
            {idd: 'UserFlag', value: '用户状态'},
            {idd: 'detail', value: '订单备注'}
          ]
        }
      },

      mounted() {
        let data = Mock.mock({
          "data|20-50": [{
            "OrderID|+1": 20190001,
            "OrderFlag|1": ["订单预订", "订单已开户", "订单配送中", "订单已签收", "订单完成"],
            'OrderDate': '@date',
            'UserName': "@cname",
            "Userid|20190000-20199999": 20191001,
            "Idtype|1": ["身份证", "护照港澳通行证", "军人证", "居留证"],
            'Idnumber': '@id',
            'ProductId|1': ["940003", "9500075", "94333389", "94000097"],
            'ProductName|1': ["冰激凌", "沃派", "低消", "流量王"],
            'FirstMonthfeetype|1': ["首月半价", "首月全价", "首月标准资费"],
            'fee|50.2': 100,
            'UserFlag|1': ["预订", "开户", "激活", "预销户", "销户"],
            "detail": '@ctitle',
          }]
        });

        this.orderList = data.data;
//        console.log(data.data);
        let wldata = Mock.mock({
            "data|3-6": [{
          'name': "@cname",
          'region': '@city',
              'date': '@date',
          'address':'@ctitle',
          'delivery': 'false',
          'phone|13002000000-18920199999':13088888888,
          'wlId':'@id'}]
        });
          this.fData=wldata.data;
//        setInterval(function(){
////          count++; // 调节速度
//          if (this.orderList[].OrderFlag == "订单配送中")
//            this.orderList[this.rowid].OrderFlag = "订单已签收";
//
//                },5000);
        },

      computed: {
        filterData() {
          let arr = [];
          for (let i = 0; i < this.orderColumn.length; i++) {
            if (this.orderColumn[i].idd == 'OrderFlag') {
              arr.push({
                  text: "订单预订", value: "订单预订"
                },
                {
                  text: "订单开户", value: "订单已开户"
                }
                ,
                {
                  text: "订单配送", value: "订单配送中"
                }
                ,
                {
                  text: "订单签收", value: "订单已签收"
                }
                ,
                {
                  text: "订单完成", value: "订单完成"
                });
            }
//            console.log("ss", arr)
          }

          return arr;
        }
      },
      methods: {
        tableRowClassName({row, rowIndex}) {
          if (rowIndex === 1) {
            return 'warning-row';
          } else if (rowIndex === 3) {
            return 'success-row';
          }
          return '';
        },
        filterHandler(value, row, column) {
          const property = column['property'];
          return row[property] === value;
        },
        commitRow(index) {

          this.msg='';
//
          for (let i = 0; i < this.orderList.length; i++) {
            if (this.orderList[i].OrderID == index)
              this.rowid = i;
          }
          console.log("----")
          console.log(this.orderList[this.rowid].OrderFlag);
          if (this.orderList[this.rowid].OrderFlag == "订单完成") {
            this.dialogVisible = true;
            this.msg = '用户已激活';
          }
          if (this.orderList[this.rowid].OrderFlag == "订单已签收") {
            this.dialogVisible = true;
            this.msg = '用户已签收，等待激活';
          }
          if (this.orderList[this.rowid].OrderFlag == "订单已签收") {
            this.dialogVisible = true;
            this.msg = '用户已签收，等待激活';
          }

          if (this.orderList[this.rowid].OrderFlag == "订单配送中") {
            this.dialogVisible = true;
            this.msg = '快递正快马加鞭';
          }
          if (this.orderList[this.rowid].OrderFlag == "订单已开户")
          {
            this.dialogVisible = true;
            this.orderList[this.rowid].OrderFlag = "订单配送中";
            console.log(this.orderList[this.rowid].OrderFlag);
            this.msg='物流公司已经取单，配送';
          }
          if (this.orderList[this.rowid].OrderFlag == "订单预订")
          {
            this.orderList[this.rowid].OrderFlag = "订单已开户";
          console.log(this.orderList[this.rowid].OrderFlag);
          this.msg='你好，开户成功，准备配送';
            console.log(this.msg);
            this.dialogTableVisible = true;
        }
            },
        commitRowEnd(){
              this.dialogVisible=false;
              this.dialogTableVisible=false;
        },
        handleClose(done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {
            });
        },
        setCurrent(row) {
          this.$refs.singleTable.setCurrentRow(row);
          this.dialogVisible = true;
          this.msg = '地址已选好，开户后派送';
          console.log(dialogTableVisible);
          this.RowClassName='info-row';
          this.dialogTableVisible = false;
        },
        handleCurrentChange(val) {
          this.currentRow = val;
        },

      }
    }

</script>


<style scoped>
  .el-table
  {
    border:2px solid darkorange;
    border-collapse: collapse;
    background-color: #F7F7F7;
  }
  .el-table .info-row {
    background: #c9e5f5;
  }
  .el-table .warning-row {
    background: oldlace;

  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
