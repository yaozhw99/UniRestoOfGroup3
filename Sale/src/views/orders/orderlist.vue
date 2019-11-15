<template>
<div>
  <el-table
    :data="orderList"
    style="width: 100%"
    :row-class-name="tableRowClassName"

    max-height="350">
    <!--<el-table-column-->
      <!--fixed-->
      <!--prop="OrderID"-->
      <!--label="订单号"-->
      <!--width="100">-->
    <!--</el-table-column>-->
    <el-table-column
      v-for="(items,idx) in orderColumn" :key="idx" :prop="items.idd" v-if="items.idd=='OrderFlag'"
      :label="items.value"
      :fixed="items.fixed"
      :sortable="items.sortable"
      :filters="filterData"
      :filter-method="filterHandler"
      width="100">
    </el-table-column>
    <el-table-column
      v-for="(items,idx) in orderColumn" :key="idx" :prop="items.idd" v-if="items.idd!='OrderFlag'"
      :label="items.value"
      :fixed="items.fixed"
      :sortable="items.sortable"
      width="100">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="130">
      <template slot-scope="scope">
        <el-row>
          <el-button type="primary" size="small" icon="el-icon-edit"></el-button>
          <el-button type="primary" size="small" icon="el-icon-check"></el-button>
        <!--<el-button-->
          <!--@click.native.prevent="commitRow(scope.$index, orderList)"-->
          <!--type="success" round-->
          <!--size="small">-->
          <!--确认-->
        <!--</el-button>-->
        </el-row>
      </template>
    </el-table-column>

  </el-table>
</div>
       

</template>


<script>
  import Mock from 'mockjs'

    export default {

        data() {
          return {
            //form表单数据绑定
            newOrder:{
              Orderid:0,
              OrderDate:'',
              UserName:'',
              Userid:'',
              Idtype:'',
              Idnumber:0,
              ProductId:'',
              ProductName:'',
              FirstMonthfeetype:'',
              fee:0
            },
            //form验证规则
            rules:{
              Orderid:[{required:true,message:'必填项',trigger:'blur'}],
              ProductId:[{required:true,message:'必填项',trigger:'blur'}],
            },
            //控制模态对话框显示与否
            dialogVisible:false,
            //控制等待画面的显示与否
            listLoading:true,
            total:0,
                        //查询条件
            listQuery:{
              page: 1,
              limit: 10,
              OrderDate:'',
              Orderid:0,
              ProductId:''
            },
            //当前页的部门数据
            fData:[],
            //全部部门数据
            orderList:[],
            orderColumns:{
              OrderID: '订单号',
              OrderDate: '订单日期',
              OrderFlag:'订单状态',
              UserName:'用户姓名',
              Userid:'用户id',
              Idtype:'证件类型',
              Idnumber:'证件号码',
              ProductId:'产品id',
              ProductName:'产品名称',
              FirstMonthfeetype:'首月费用模式',
              fee:'应收费用',
              UserFlag:'用户状态',
              detail:'订单备注'
            },
            orderColumn:[
              {idd:"OrderID",value: '订单号',fixed:"left",sortable:true,'sort-by':"OrderID"},
              {idd:'OrderDate',value: '订单日期',sortable:true},
              {idd:'OrderFlag',value: '订单状态'},
              {idd:'UserName',value: '用户姓名'},
              {idd:'Userid',value: '用户id'},
              {idd:'Idtype',value: '证件类型'},
              {idd: 'Idnumber',value: '证件号码',resizable:"true"},
              {idd:'ProductId',value: '产品id'},
              {idd: 'ProductName',value: '产品名称'},
              {idd: 'FirstMonthfeetype',value: '首月费用模式'},
              {idd: 'fee',value: '应收费用'},
              {idd: 'UserFlag',value: '用户状态'},
              {idd:'detail',value: '订单备注'}
            ]
          }
        },

    mounted(){
      let data=Mock.mock({
        "data|20-50":[{
          "OrderID|+1":20190001,
          "OrderFlag|1":["订单预订","订单开户","订单配送","订单签收","订单完成"],
          'OrderDate':'@date',
          'UserName':"@cname",
          "Userid|20190000-20199999":20191001,
          "Idtype|1":["身份证","护照港澳通行证","军人证","居留证"],
          'Idnumber':'@id',
          'ProductId|1':["940003","9500075","94333389","94000097"],
          'ProductName|1':["冰激凌","沃派","低消","流量王"],
          'FirstMonthfeetype|1':["首月半价","首月全价","首月标准资费"],
          'fee|50.2':100,
          'UserFlag|1':["预订","开户","激活","预销户","销户"],
          "detail":'@ctitle',
        }]
      });

      this.orderList=data.data;
      console.log(data.data);
          },
      computed:{
        filterData() {
//          this.fData=[];
          let arr = [];
          for (let i = 0; i < this.orderColumn.length; i++) {
            if (this.orderColumn[i].idd == 'OrderFlag') {
              arr.push({
                  text: "订单预订", value: "订单预订"
                },
                {
                  text: "订单开户", value: "订单开户"
                }
                ,
                {
                  text: "订单配送", value: "订单配送"
                }
                ,
                {
                  text: "订单签收", value: "订单签收"
                }
                ,
                {
                  text: "订单完成", value: "订单完成"
                });
            }
            console.log("ss", arr)
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
        }
      },
        }

</script>


<style scoped>
  .el-table
  {
    border:2px solid darkorange;
    border-collapse: collapse;
  }

  .el-table .warning-row {
    background: oldlace;

  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
