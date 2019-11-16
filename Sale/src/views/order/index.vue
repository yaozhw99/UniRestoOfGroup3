<template>
  <div id="app">
    <div id="page-top">
      <div>
        <div id="page-top-left">
          <i class="el-icon-loading"></i> <span class="wangt">网上营业厅</span>
        </div>
        <div id="page-top-right"><a><i class="el-icon-star-off"></i>个人中心</a></div>
      </div>
    </div>
    <div id="page-top2">
      <div><a href="#">
        <img src="@/icons/uni-logo.png">
      </a>
      </div>
    </div>
    <div id="banner">
      <div class="banner-content">
        <ul>
          <li><a @click="goback">首页</a></li>
          <li><a href="#">靓号专区</a></li>
          <li><a href="#">热销推荐</a></li>
          <li><a href="#">特惠活动</a></li>
          <li><a href="#">终端专区</a></li>
        </ul>
        <div class="banner-right">
          <el-input
            placeholder="请输入内容" style="width:200px">
            <i slot="prefix" class="el-input__icon el-icon-search"></i>
          </el-input>
        </div>
      </div>
    </div>
    <div class="banner2"></div>
    <div class="content">
      <div class="cheader">
        <span class="cheader-left">靓号订单</span>
        <small>请于10分钟之内完成，避免被他人抢单</small>
      </div>
      <div class="ccontent">
        <div class="ccleft">
          <div class="ccleft_box">
            <span class="ccleft_title">{{acceptParams.serialNumber}}</span>
            <img src="@/icons/yzw_uni_pinpai.png" alt="">
            <span><small>开通说明：</small></span>
            <span><small>按照国家实名制要求：开通号码必须提供身份证实名信息,并在接收到号卡后提供相关复印件</small></span>
          </div>
        </div>
        <div class="ccmain">
          <div class="title">填写开户资料</div>
          <form>
            <table id="table1">
              <tr>
                <td>价格：</td>
                <td><span id="price">￥50.00</span></td>
              </tr>
              <tr>
                <td>商品评价：</td>
                <td>
                  <img src="@/icons/start.png" alt="">
                  <img src="@/icons/start.png" alt="">
                  <img src="@/icons/start.png" alt="">
                  <img src="@/icons/start.png" alt="">
                  <img src="@/icons/start.png" alt="">
                  <a style="color: blue;">(已有50人评价)</a>
                </td>
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
                  <input v-model="formData.name" placeholder="身份证姓名" required></input></td>
              </tr>
              <tr>
                <td>身份证号：</td>
                <td><input v-model="formData.psptId" placeholder="身份证姓名" required></input></td>
              </tr>
              <tr>
                <td>邮寄地址：</td>
                <td><input v-model="formData.address" placeholder="请输入邮寄地址" required></input></td>
              </tr>
              <tr>
                <td>联系电话：</td>
                <td><input v-model="formData.linkPhone" type="tel" placeholder="请输入联系电话" required="required"></input></td>
              </tr>
              <tr>
                <td></td>
                <td><el-button type="warning" @click="openuser">确定</el-button></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </div>


    <el-dialog title="选择号码" :visible.sync="dialogVisible">
      <Numpool :ifshow="true" @sendValue="dialog"></Numpool>
    </el-dialog>

    <Footer></Footer>

  </div>
</template>

<script>
    import Mock from 'mockjs';
    import { createUser } from '@/api/bforder'
    import Numpool from "@/views/main/Content/numpool"
    import Footer from "../main/Footer/Footer";

    import {  } from '@/api/bforder'
    export default {
        name: "index",
        data() {
            return {
                productList:[{name:'冰激淋',selected:false},{name:'沃派卡',selected:false},{name:'腾讯大王卡',selected:false}],
                dialogVisible:false,
                acceptParams:{serialNumber:'',actionName:'',productName:''},
                formData:{epcode:'',name:'',psptId:'',address:'',linkPhone:'',orderId:0},
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
        methods:{
            goback(){
                this.$router.push({path:'/index'})
            },
            changeProduct(idx){
                this.productList.forEach((item)=>{
                    item.selected=false;
                })
                this.productList[idx].selected=true;
            },
            openuser(){
                let form=this.formData;
                if (form.name==''){this.$notify({title: '表单验证提示', message: '姓名不能为空！',type: 'error',duration: 2000})}
                else if (form.epcode==''){this.$notify({title: '表单验证提示', message: '号码归属不能为空！',type: 'error',duration: 2000})}
                else if (form.linkPhone==''){this.$notify({title: '表单验证提示', message: '联系电话不能为空！',type: 'error',duration: 2000})}
                else if (form.address==''){this.$notify({title: '表单验证提示', message: '邮寄地址不能为空！',type: 'error',duration: 2000})}
                else if (form.psptId==''){this.$notify({title: '表单验证提示', message: '证件号码不能为空！',type: 'error',duration: 2000})}
                else {
                    createUser(this.formData).then(res=>{
                        this.formData.orderId=res.orderId;

                        this.$notify({
                            title: 'Success',
                            message: 'Created Successfully',
                            type: 'success',
                            duration: 2000
                        })
                        setTimeout(()=>{
                            this.$router.push({name:'orderdetail',params:this.formData})
                        },2000)
                    })
                }

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
        mounted() {
            console.log(this.$route.params);
            this.acceptParams.serialNumber=this.$route.params.serialNumber?this.$route.params.serialNumber:'';
            this.acceptParams.actionName=this.$route.params.actionName?this.$route.params.actionName:'';
            this.acceptParams.productName=this.$route.params.productName?this.$route.params.productName:'';

        },
        components:{
            Numpool,
            Footer
        }

    }

    function getHb(fenzi,fenmu) {
        return Math.round(fenzi/fenmu*100,2)+'%';
    }
</script>

<style scoped>
  #app{
    display: flex!important;
    flex-direction: column!important;
  }
  #price{
    color: orange!important;
    font-size: 30px!important;
    font-weight: bolder!important;
  }
  #table1{
    width: 100%!important;
  }
  #table1 tr{
    height: 40px!important;
  }
  .banner-right input{
    width:300px!important;
  }
  .error-message{color:red; font-size:12px;text-indent:108px;}
  .ccmain {
    width: 100%!important;
    height:500px!important;
    margin-left: 10px!important;
  }
  .ccmain input,.ccmain select {
    width:300px!important;
    height: 30px!important;
    border-radius: 5px!important;
  }
  .ccmain .title {
    font-size: 28px!important;
    font-family: 隶书!important;
    font-weight: bold!important;
    color: #7d7d7f!important;
    margin:10px 0 0 10px!important;
  }
  .ccmain img {
    width: 18px!important;

  }
  .content {
    width: 1200px!important;
    margin: 0 auto!important;
    padding: 30px;
    border: 1px solid #c0ccda!important;
  }
  .cheader{
    border-bottom: 1px solid #e6e6e6!important;
    height: 30px!important;
    width: 100%!important;
  }
  .cheader-left {
    font-family: 黑体!important;
    font-size: 20px!important;
    font-weight: bolder!important;
  }
  .ccontent{
    width: 100%!important;
    margin-top: 10px!important;
    display: flex!important;
  }
  .ccleft{
    width: 330px!important;
    height: 500px!important;
  }
  .ccleft_box {
    margin:10px auto!important;
    border: 1px solid #f2f2f2!important;
    height: 400px!important;
    border-top: 3px solid orange!important;
    width: 280px!important;
    border-radius: 10px!important;
    box-shadow: 1px 5px 5px #8c939d!important;
  }
  .ccleft_box img {
    width: 95%!important;
    margin-left: 6px!important;
    margin-top: 10px!important;

  }
  .ccleft_title {
    font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif!important;
    font-size: 25px!important;
    font-weight: bold!important;
    color: #8c939d!important;
    text-align: center!important;
    width: 100%!important;
    display: block!important;
    margin-top: 5px!important;
  }
  .banner2 {
    width: 100%!important;
    height: 40px!important;
    background-color: #f2f2f2!important;
  }
  #banner{
    width: 100%!important;
    height: 60px!important;
    border-bottom: 1px solid #7d7d7f!important;
    background-color: white!important;
  }
  #banner .banner-content {
    width: 1200px!important;
    height: 60px!important;
    display: flex!important;
    margin: 0 auto!important;
  }
  #banner ul{
    display: flex!important;
    width: 1200px!important;
    height: 100%!important;
    line-height: 60px!important;
    margin:0 auto!important;
    padding: 0!important;

  }
  #banner ul li{
    text-decoration: none!important;
    list-style: none!important;
    margin-right: 50px!important;
    font-size: 18px!important;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif!important;
  }
  #banner .banner-right {
    float: right!important;
    width: 520px!important;
  }
  #banner .banner-right .el-input {
    margin-top:10px!important;
  }
  #page-top{
    background-color: #666666!important;
    color: #f2f2f2!important;
    line-height: 40px!important;
    width: 100%!important;
    height: 40px!important;

  }
  #page-top>div{
    width: 1200px!important;
    margin: 0 auto!important;
  }
  #page-top2{
    width:1200px!important;
    height: 60px!important;
    margin: 30px auto 10px!important;
  }

  #page-top-left{
    float: left!important;
  }
  #page-top img{
    height: 30px!important;
    width: 30px!important;
    margin-top: 5px!important;

  }
  .wangt{
    display: inline-block!important;
    height: 40px!important;
    line-height: 40px!important;
    margin-top: 0!important;
  }
  #page-top-right{
    float: right!important;
  }
  .selectcard>span,.selectnum>span{
    margin-right: 10px!important;
    line-height: 26px!important;
    font-size:18px !important;
    margin-bottom: 20px!important;
  }

</style>
