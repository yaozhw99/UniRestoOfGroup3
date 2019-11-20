<template>
  <div>
    <div class="title">
      当前还有{{kaicount}}个订单待开户，{{facount}}单待发货。
    </div>
    <el-table
      :class="className"
      :data="orderList"
      style="width: 100%"
      :row-class-name="tableRowClassName"
      border>

      <el-table-column
        v-for="(items,idx) in orderColumn" :key="idx" :prop="items.idd" v-if="items.idd=='OrderFlag'"
        width="100px"
        :label="items.value"
        :fixed="items.fixed"
        :sortable="items.sortable"
        :filters="filterData"
        :filter-method="filterHandler"
        :formatter="formatFlag">
      </el-table-column>

      <el-table-column
        v-for="(items,idx) in orderColumn" :key="idx" :prop="items.idd" v-if="items.idd!='OrderFlag'"
        :label="items.value"
        :fixed="items.fixed"
        :sortable="items.sortable"
        :width="items.width"
      >
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="70">
        <template slot-scope="scope">
          <el-button type="primary" size="mini"
                     v-if="scope.row.OrderFlag=='订单预订'"
                     @click="commitRow(scope.row.orderId)">
            <i class="fa fa-ban"></i> 开户
          </el-button>
          <el-button v-else-if="scope.row.OrderFlag=='订单已开户'"
                     type="primary" size="mini"
                     @click="commitRow(scope.row.orderId)">
            <i class="fa fa-link"></i> 发货
          </el-button>
          <el-button v-else type="primary" size="mini"
                     @click="commitRow(scope.row.orderId)">
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
    <el-dialog title="开户已成功，请选择收货地址" :visible.sync="dialogTableVisible">
      <el-table :data="fData"
                ref="singleTable"
                :row-class-name="RowClassName"
                @current-change="handleCurrentChange"
                highlight-current-row>
        <el-table-column property="name" label="姓名"></el-table-column>
        <el-table-column property="region" label="城市"></el-table-column>
        <el-table-column property="address" label="地址"></el-table-column>
        <el-table-column property="phone" label="联系电话" ></el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
      <el-button @click="dialogTableVisible=false">取 消</el-button>
      <el-button type="primary" @click="commitRowEnd()">确 定</el-button>
    </span>
    </el-dialog>

  </div>
     

</template>


<script>
  import Mock from 'mockjs'
  import bmap from 'echarts/extension/bmap/bmap';

  export default {
    props:["flag",'className'],
    data() {

      return {
        //form表单数据绑定
        newOrder: {
          orderId: 0,
          OrderDate: '',
          name: '',
          Userid: '',
          Idtype: '',
          Idnumber: 0,
          ProductId: '',
          ProductName: '',
          FirstMonthfeetype: '',
          fee: 0
        },
        kaicount:0,
        facount:0,
        //form验证规则
        rules: {
          orderId: [{required: true, message: '必填项', trigger: 'blur'}],
          ProductId: [{required: true, message: '必填项', trigger: 'blur'}],
        },

        //控制模态对话框显示与否
        dialogVisible: false,
        dialogTableVisible:false,
        RowClassName:'',

        //控制等待画面的显示与否
        msg: '',
        total: 0,
        //查询条件
        listQuery: {
          page: 1,
          limit: 10,
          OrderDate: '',
          orderId: 0,
          ProductId: ''
        },
        //当前页的部门数据
        fData:[],
        epcode:[{value:'020',label:'广州市'},
          {value:'0660',label:'汕尾市'},
          {value:'0662',label:'阳江市'},
          {value:'0663',label:'揭阳市'},
          {value:'0668',label:'茂名市'},
          {value:'0750',label:'江门市'},
          {value:'0751',label:'韶关市'},
          {value:'0752',label:'惠州市'},
          {value:'0753',label:'梅州市'},
          {value:'0754',label:'汕头市'},
          {value:'0755',label:'深圳市'},
          {value:'0756',label:'珠海市'},
          {value:'0757',label:'佛山市'},
          {value:'0758',label:'肇庆市'},
          {value:'0759',label:'湛江市'},
          {value:'0760',label:'中山市'},
          {value:'0762',label:'河源市'},
          {value:'0763',label:'清远市'},
          {value:'0766',label:'云浮市'},
          {value:'0768',label:'潮州市'},
          {value:'0769',label:'东莞市'}],
        OrderFlag:
          [{value:'0',label:'订单预订'},
            {value:'1',label:'订单已开户'},
            {value:'2',label:'订单配送中'},
            {value:'3',label:'订单已签收'},
            {value:'4',label:'订单完成'}],
        rowid: 0,
        rowFlag: true,
        //全部部门数据
        orderList: [],
        orderColumn: [
          {idd: "orderId", value: '订单号', fixed: "left", sortable: true,width:120},
          {idd:'epcode',value:'区号', sortable: true},
          {idd: 'OrderDate', value: '订单日期', sortable: true,width:120},
          {idd: 'OrderFlag', value: '订单状态',width:120},
          {idd: 'name', value: '用户姓名'},
          {idd: 'psptId', value: '邮政编码'},
          {idd: 'address', value: '用户地址'},
          {idd: 'linkPhone', value: '联系电话'},
          {idd: 'Userid', value: '用户id'},
          {idd: 'Idtype', value: '证件类型'},
          {idd: 'Idnumber', value: '证件号码', resizable: true},
          {idd: 'ProductId', value: '产品id'},
          {idd: 'ProductName', value: '产品名称'},
          {idd: 'FirstMonthfeetype', value: '首月费用'},
          {idd: 'fee', value: '应收费用'},
          {idd: 'UserFlag', value: '用户状态'},
          {idd: 'detail', value: '订单备注'}
        ]
      }
    },

    mounted() {
      let data = Mock.mock({
        "data|20-50": [{
          "orderId|+1": 20190001,
          "OrderFlag|0-4":0,
          'OrderDate': '@date',
          'epcode|1':['020','0660','0662','0663','0668','0750','0751','0752','0753','0754','0755','0756','0757','0758','0759','0760','0762','0763','0766','0768','0769'],
          'name': "@cname",
          'psptId|+1':510000,
          'address': '@ctitle',
          'linkPhone|13002000000-18920199999':13088888888,
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

      console.log(this.kaicount);
      if(this.flag==1)
      {
        let newlist=data.data;

        this.orderList = newlist.filter(item=>item.OrderFlag==0||item.OrderFlag==1);

        newlist=this.orderColumn;
//        this.orderColumn=newlist.filter(item=>item.value=="订单号"||item.value=="订单状态"||item.value=="用户姓名"||item.value=="订单日期");
//      }
        this.orderColumn=newlist.filter(item=>
          item.value=="订单号"||
        item.value=="订单状态"||
        item.value=="用户姓名"||
        item.value=="订单日期"
//          item.value=="订单号";
//        return true;
//        item.value=="订单状态"
//        return true;
//        item.value=="用户姓名"
//        return true;
//        item.value=="订单日期"
//        return true;
      );
      }
      else{
        this.orderList = data.data;}
      for (let i = 0; i < this.orderList.length; i++) {
        if (this.orderList[i].OrderFlag==0) {this.kaicount+=1;}
        if (this.orderList[i].OrderFlag==1) {this.facount+=1;}
      }
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
                text: "订单已开户", value: "订单已开户"
              }
              ,
              {
                text: "订单配送中", value: "订单配送中"
              }
              ,
              {
                text: "订单已签收", value: "订单已签收"
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
      //格式转换
      formatFlag(row, column)
      {
        if (row.OrderFlag == 0)  {row.OrderFlag= "订单预订"};
        if (row.OrderFlag == 1)  {row.OrderFlag= "订单已开户"};
        if (row.OrderFlag == 2)  {row.OrderFlag= "订单配送中"};
        if (row.OrderFlag == 3)  {row.OrderFlag= "订单已签收"};
        if (row.OrderFlag == 4)  {row.OrderFlag= "订单完成"};
        return row.OrderFlag;
      },
      tableRowClassName(row, rowIndex) {
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
          if (this.orderList[i].orderId == index)
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

        if (this.orderList[this.rowid].OrderFlag == "订单配送中") {
          this.dialogVisible = true;
          this.msg = '快递正快马加鞭';
        }
        if (this.orderList[this.rowid].OrderFlag == "订单已开户")
        {
          this.dialogVisible = true;

          this.msg='物流公司已经取单，配送';
        }
        if (this.orderList[this.rowid].OrderFlag == "订单预订")
        {

          this.msg='你好，开户成功，准备配送';

          this.dialogTableVisible = true;
        }
      },
      commitRowEnd(){

        if (this.orderList[this.rowid].OrderFlag == "订单已开户")
        {
          this.orderList[this.rowid].OrderFlag = "订单配送中";
        }
        else
        if (this.orderList[this.rowid].OrderFlag =="订单预订")
        {
          this.orderList[this.rowid].OrderFlag = "订单已开户";
        }
        this.dialogVisible=false;
        this.dialogTableVisible=false;
//          setTimeout(()=>{
//            this.count++; // 调节速度
//
//            for (let i = 0; i < this.orderList.length; i++) {
//
//              if (this.rowFlag && this.orderList[i].OrderFlag == "订单配送中")
//              {this.orderList[i].OrderFlag = "订单已签收";
//                this.rowFlag=false;
//                console.log(i);}
//            }
//          },1000);
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

        this.RowClassName='info-row';
        this.dialogTableVisible = false;
      },
      handleCurrentChange(val) {
        this.currentRow = val;

      }
    }
  }

</script>


<style scoped>

  .aa{
    max-height: 500px;
    margin: 20px;
    width: 600px !important;
  }

  .title {
    font-size: 25px!important;
    font-family: 宋体!important;
    font-weight: bold!important;
    color: #7d7d7f!important;
    margin:10px 0 0 10px!important;
    text-align:center;
  }
  .el-table
  {
    /*border:2px solid darkorange;*/
    border-collapse: collapse;
    background-color: #F7F7F7;
  }
  .el-table .info-row {
    background: #c9e5f5;
  }
  .el-table .warning-row {
    background: lightseagreen;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
  .el-table td,.building-top .el-table th.is-leaf {
    border-bottom:  1px solid #f00;
  }
</style>
