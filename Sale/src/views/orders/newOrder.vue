<template>
  <div class="container">
    <div class="cleft">
      <div class="title">填写开户资料</div>
      <form>
        <table id="table1">
          <tr>
            <td>价格：</td>
            <td><span id="price">￥50.00</span></td>
          </tr>

          <tr v-if="acceptParams.productName">
            <td>商品名称：</td>
            <td>
              {{acceptParams.productName}}
            </td>
          </tr>
          <tr v-if="!acceptParams.productName">
            <td>选择产品：</td>
            <td>
              <i v-for="(item,idx) in productList" style="margin-right: 5px;">
                <el-tag size="small" effect="light"  style="cursor: pointer" :type="item.selected?'warning':'info'" @click="changeProduct(idx)">{{item.name}}</el-tag>
              </i>

            </td>
          </tr>
          <tr v-if="acceptParams.actionName">
            <td>所选活动：</td>
            <td>
              {{acceptParams.actionName}}
            </td>
          </tr>
          <tr>
            <td>所选号码：</td>
            <td>
              {{acceptParams.serialNumber}}    <a style="color: blue;" @click="selectNumber">(选号)</a>
            </td>
          </tr>
          <tr>
            <td>号码归属：</td>
            <td>
              <select v-model="formData.epcode" placeholder="请选择" style="width:300px" required>
                <option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </option>
              </select>
            </td>
          </tr>
          <tr>
            <td>姓名：</td>
            <td>
              <input v-model="formData.name" placeholder="请输入身份证姓名" required></input></td>
          </tr>
          <tr>
            <td>身份证号：</td>
            <td><input v-model="formData.psptId" placeholder="请输入身份证号码" required></input></td>
          </tr>
          <tr>
            <td>邮寄地址：</td>
            <td><input v-model="formData.address" placeholder="请输入邮寄地址" required></input></td>
          </tr>
          <tr>
            <td>联系电话：</td>
            <td><input v-model="formData.linkPhone" type="tel" placeholder="请输入联系电话" required="required"></input></td>
          </tr>
          <tr style="text-align: center">
            <td><el-button  type="warning" @click="goback">返回订单处理</el-button></td>
            <td><el-button  type="warning" @click="openuser">确定</el-button></td>
          </tr>
        </table>
      </form>
      <el-dialog title="选择号码" :visible.sync="dialogVisible">
        <Numpool :ifshow="true" @sendValue="dialog"></Numpool>
      </el-dialog>

    </div>
    <div class="cright">
      <ul>
        <li>{{kaicount}}
        </li>
      </ul>
      <ul>
        <p>{{facount}}</p>
      </ul>
    </div>
  </div>
</template>

<script>
  import Numpool from "@/views/main/Content/numpool";
  import Mock from 'mockjs'

export default {
  name: 'Create',
  data() {
    return {
      kaicount:0,
      facount:0,
      ndata:[],
      productList:[{name:'冰激淋',selected:false},{name:'沃派卡',selected:false},{name:'腾讯大王卡',selected:false}],
      dialogVisible:false,
      acceptParams:{serialNumber:'',actionName:'',productName:''},
      formData:{epcode:'',name:'',psptId:'',address:'',linkPhone:'',orderId:0,productName:'',serialNumber:''},
      msg: "vue template",
      options: [{value:'020',label:'广州市'},
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
      value: ''
    }
  },
  mounted() {
    let data = Mock.mock({
      "data|20-40": [{
        "orderId|+1": 20190001,
        "OrderFlag|0-4": 0,
        'OrderDate': '@date',
        'epcode|1': ['020', '0660', '0662', '0663', '0668', '0750', '0751', '0752', '0753', '0754', '0755', '0756', '0757', '0758', '0759', '0760', '0762', '0763', '0766', '0768', '0769'],
        'name': "@cname",
        'psptId|+1': 510000,
        'address': '@ctitle',
        'linkPhone|13002000000-18920199999': 13088888888,
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

    this.ndata = data.data;
  },
  methods:{
    count(){
      console.log(this.ndata);
      for (let i = 0; i < this.ndata.length; i++) {
        if (this.ndata[i].OrderFlag==0) {this.kaicount+=1;}
        if (this.ndata[i].OrderFlag==1) {this.facount+=1;}
            }
      console.log(this.kaicount);
    },
    goback(){
      this.$router.push({path:'/orders/orderlist'})
    },
    changeProduct(idx){
      this.productList.forEach((item)=>{
        item.selected=false;
      })
      this.productList[idx].selected=true;
      this.formData.productName=this.productList[idx].name;
      console.log(this.productList[idx])
    },
    openuser(){
      let form=this.formData;
      if (form.name==''){this.$notify({title: '表单验证提示', message: '姓名不能为空！',type: 'error',duration: 2000})}
      else if (form.epcode==''){this.$notify({title: '表单验证提示', message: '号码归属不能为空！',type: 'error',duration: 2000})}
      else if (form.linkPhone==''){this.$notify({title: '表单验证提示', message: '联系电话不能为空！',type: 'error',duration: 2000})}
      else if (form.address==''){this.$notify({title: '表单验证提示', message: '邮寄地址不能为空！',type: 'error',duration: 2000})}
      else if (form.psptId==''){this.$notify({title: '表单验证提示', message: '证件号码不能为空！',type: 'error',duration: 2000})}
      else {
        this.formData.orderId='000000000';
        this.formData.serialNumber=this.acceptParams.serialNumber
        this.$router.push({path:'/orders/orderslist',params:this.formData})
        console.log(this.formData);

//          setTimeout(()=>{
//            this.$router.push({name:'orderslist',params:this.formData})
//          },2000)
        }
//      this.$alert('你好，开户已成功', '开户成功', {
//        confirmButtonText: '确定',
//        callback: action => {
//          this.$message({
//            type: 'info',
//            message: `action: ${ action }`
//          });
//        }
//      });
          },
    selectNumber(){
      this.dialogVisible=true;
    },
    handleClose(){
      this.dialogVisible=false;
    },
    dialog(num){

      this.acceptParams.serialNumber=(num[0]?num[0]:num[1]?num[1]:num[2]);
      this.dialogVisible=false;
    },
  },
  components:{
    Numpool,
   }
}
</script>

<style scoped>
  #price{
    color: orange!important;
    font-size: 30px!important;
    font-weight: bolder!important;
  }
  #table1{
    margin-top:10px;
    margin-left:60px;
    width: 100%!important;
    }
  tr{
    text-align: left;
    height:50px!important;
  }
  input{
    height:40px!important;
    weight:100px;
    }
  select{
    height:40px!important;

  }
 .container
 {
   margin-top: 10px!important;
   margin: 0;
   padding: 0;
   display:flex;
   background-color: #efefef;
   height: 600px;
 }
  .title {
    font-size: 28px!important;
    font-family: 隶书!important;
    font-weight: bold!important;
    color: #7d7d7f!important;
    margin:10px 0 0 10px!important;
  }
  .cleft
  {
    flex:1;
    /*border:2px solid yellow;*/
    padding: 10px, 0;
    height: 100%;
    text-align: center;
    justify-content: center;
    height:500px!important;
    margin-left: 10px!important;
  }
 .cright
 {
   padding: 10px, 0;
   flex:1;
   /*border:2px solid orange;*/
   height: 100%;
   text-align: center;
   justify-content: center;
   height:500px!important;
   margin-left: 10px!important;
 }
ul{
  display:flex;
  flex-flow: column;
  justify-content: center;
  /*flex:1;*/
  text-align: center;
  list-style: none;

  margin-top: 10px;
  height: 50%;
}

</style>
