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
          <li><a href="#">首页</a></li>
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
            <span class="ccleft_title">{{serialNumber}}</span>
            <img src="@/icons/yzw_uni_pinpai.png" alt="">
            <span><small>开通说明：</small></span>
            <span><small>按照国家实名制要求：开通号码必须提供身份证实名信息,并在接收到号卡后提供相关复印件</small></span>
          </div>
        </div>
        <div class="ccmain">
          <div class="title">填写开户资料</div>
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
            <tr>
              <td>号码归属：</td>
              <td>
                <select v-model="formData.epcode" placeholder="请选择" style="width:300px">
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
              <td>所选套餐：</td>
              <td>{{productName}}</td>
            </tr>
            <tr>
              <td>姓名：</td>
              <td>
                <input v-model="formData.name" placeholder="省份证姓名"></input></td>
            </tr>
            <tr>
              <td>身份证号：</td>
              <td><input v-model="formData.psptId" placeholder="身份证姓名"></input></td>
            </tr>
            <tr>
              <td>邮寄地址：</td>
              <td><input v-model="formData.address" placeholder="请输入邮寄地址"></input></td>
            </tr>
            <tr>
              <td>联系电话：</td>
              <td><input v-model="formData.linkPhone" placeholder="请输入联系电话"></input></td>
            </tr>
            <tr>
              <td></td>
              <td><el-button type="warning" @click="openuser">确定</el-button></td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    import Mock from 'mockjs';
    import { createUser } from '@/api/bforder'

    import {  } from '@/api/bforder'
    export default {
        acceptParams:{serialNumber:'',actionName:'',productName:''},
        name: "index",
        data() {
            return {
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
            openuser(){
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
        },mounted() {
            this.acceptParams.serialNumber=this.$route.params.serialNumber?this.$route.params.serialNumber:'13000000000';
            this.acceptParams.actionName=this.$route.params.serialNumber?this.$route.params.actionName:'默认活动';
            this.acceptParams.productName=this.$route.params.serialNumber?this.$route.params.productName:'默认产品';

        }

    }

    function getHb(fenzi,fenmu) {
        return Math.round(fenzi/fenmu*100,2)+'%';
    }
</script>

<style scoped>
  #price{
    color: orange;
    font-size: 30px;
    font-weight: bolder;
  }
  #table1{
    width: 100%;
  }
  #table1 tr{
    height: 40px;
  }
  .banner-right input{
    width:300px;
  }
  .ccmain {
    width: 100%;
    height:500px;
    margin-left: 10px;
  }
  .ccmain input,.ccmain select {
    width:300px;
    height: 30px;
    border-radius: 5px;
  }
  .ccmain .title {
    font-size: 28px;
    font-family: 隶书;
    font-weight: bold;
    color: #7d7d7f;
    margin:10px 0 0 10px;
  }
  .ccmain img {
    width: 18px;

  }
  .content {
    width: 1200px;
    margin: 0 auto;
    padding: 30px;
    border: 1px solid #c0ccda;
  }
  .cheader{
    border-bottom: 1px solid #e6e6e6;
    height: 30px;
    width: 100%;
  }
  .cheader-left {
    font-family: 黑体;
    font-size: 20px;
    font-weight: bolder;
  }
  .ccontent{
    width: 100%;
    margin-top: 10px;
    display: flex;
  }
  .ccleft{
    width: 330px;
    height: 500px;
  }
  .ccleft_box {
    margin:10px auto;
    border: 1px solid #f2f2f2;
    height: 400px;
    border-top: 3px solid orange;
    width: 280px;
    border-radius: 10px;
    box-shadow: 1px 5px 5px #8c939d;
  }
  .ccleft_box img {
    width: 95%;
    margin-left: 6px;
    margin-top: 10px;

  }
  .ccleft_title {
    font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 25px;
    font-weight: bold;
    color: #8c939d;
    text-align: center;
    width: 100%;
    display: block;
    margin-top: 5px;
  }
  .banner2 {
    width: 100%;
    height: 40px;
    background-color: #f2f2f2;
  }
  #banner{
    width: 100%;
    height: 60px;
    border-bottom: 1px solid #7d7d7f;
    background-color: white;
  }
  #banner .banner-content {
    width: 1200px;
    height: 60px;
    display: flex;
    margin: 0 auto;
  }
  #banner ul{
    display: flex;
    width: 1200px;
    height: 100%;
    line-height: 60px;
    margin:0 auto;
    padding: 0;

  }
  #banner ul li{
    text-decoration: none;
    list-style: none;
    margin-right: 50px;
    font-size: 18px;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  }
  #banner .banner-right {
    float: right;
    width: 520px;
  }
  #banner .banner-right .el-input {
    margin-top:10px;
  }
  #page-top{
    background-color: #666666;
    color: #f2f2f2;
    line-height: 40px;
    width: 100%;
    height: 40px;

  }
  #page-top>div{
    width: 1200px;
    margin: 0 auto;
  }
  #page-top2{
    width:1200px;
    height: 60px;
    margin: 30px auto 10px;
  }

  #page-top-left{
    float: left;
  }
  #page-top img{
    height: 30px;
    width: 30px;
    margin-top: 5px;

  }
  .wangt{
    display: inline-block;
    height: 40px;
    line-height: 40px;
    margin-top: 0;
  }
  #page-top-right{
    float: right;
  }


</style>
