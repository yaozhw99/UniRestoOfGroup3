<template>
  <div id="app">
    <div style="background-color: white">
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
    </div>
    <div class="main">
      <div class="mbody">
        <div class="title">
          <ul>
            <li>网上商城</li>
            <li> > </li>
            <li><a href="#">订单中心</a></li>
            <li> > </li>
            <li>我的订单</li>

          </ul>
        </div>
        <div class="body1">
          <div class="left">
            <div id="orderNo">订单号:{{formData.orderId}}</div>
            <div id="orderState">{{state[realState]}}</div>
            <button class="kaipiao">申请开票</button>
            <button class="pingjia">评价</button>
            <a class="print"><i class="el-icon-printer"></i> 打印订单</a>
          </div>
          <div class="right">
            <div class="title">订单{{formData.orderState}},感谢您在联通商城购买商品</div>
            <div class="body">
              <div class="item">
                <img :src="realState>=1?diconcomp.start:dicon.start" alt="">
                <span>提交订单</span>
              </div>
              <div class="item">
                <img :src="realState>=1?diconcomp.go:dicon.go" alt="">
              </div>
              <div class="item">
                <img :src="realState>=2?diconcomp.sto:dicon.sto" alt="">
                <span>商品出库</span>
              </div>
              <div class="item">
                <img :src="realState>=2?diconcomp.go:dicon.go" alt="">
              </div>
              <div class="item">
                <img :src="realState>=3?diconcomp.car:dicon.car" alt="">
                <span>等待收货</span>
              </div>
              <div class="item">
                <img :src="realState>=3?diconcomp.go:dicon.go" alt="">
              </div>
              <div class="item">
                <img :src="realState>=4?diconcomp.complete:dicon.complete" alt="">
                <span>完成</span>
              </div>
            </div>
          </div>
        </div>

        <div class="body1">
          <div class="left" id="body2_left">
            <div><img src="@/icons/body2_left_logo.jpg" style="width: 150px" alt=""></div>
            <div>
              <ul>
                <li>承运方式：天天快递</li>
                <li>承运人:张三</li>
                <li>订单号：{{formData.orderId}}</li>
              </ul>
            </div>
          </div>
          <div class="right" style="overflow: auto;width: 100%">
            <el-timeline>
              <el-timeline-item
                v-for="(activity, index) in activities"
                :key="index"
                :icon="activity.icon"
                :type="activity.type"
                :color="activity.color"
                :size="activity.size"
                :timestamp="activity.timestamp"
                reverse>
                {{activity.content}}
              </el-timeline-item>
            </el-timeline>
          </div>
        </div>

        <div class="body3">
          <span>订单相关信息</span>
          <span>姓名：{{formData.name}}</span>
          <span>地址：{{formData.address}}</span>
          <span>联系电话:{{formData.linkPhone}}</span>
          <span>配送范围:{{options[formData.epcode]}}</span>
          <span>订单编号:{{formData.orderId}}</span>
          <span>商品价格：￥50</span>
          <span>付款方式：在线支付</span>
          <span>发票类型：不开发票</span>

        </div>
      </div>
    </div>

  <Footer></Footer>
  </div>
</template>

<script>
    import Mock from 'mockjs';
    import Footer from "../main/Footer/Footer";
    export default {
        data() {
            return {
                realState:1,
                state:{1:"已提交",2:"商品出库",3:"等待收货",4:"完成"},
                formData:{epcode:'',name:'',psptId:'',address:'',linkPhone:'',orderId:0,orderState:1},
                msg: this.$route.params.epcode,
                dicon:{start:require('@/icons/dstart.png'),go:require('@/icons/dgo.png'),sto:require('@/icons/dsto.png'),car:require('@/icons/dcar.png'),complete:require('@/icons/dcomp.png')},
                diconcomp:{start:require('@/icons/dstartComplete.png'),go:require('@/icons/dgoComplete.png'),sto:require('@/icons/dstoComplete.png'),car:require('@/icons/dcarComplete.png'),complete:require('@/icons/dcompComplete.png')},
                activities: [],
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
                    {value:'0769',label:'东莞市'}]
            }
        },
        mounted() {
            this.formData.epcode=this.$route.params.epcode;
            this.formData.name=this.$route.params.name;
            this.formData.psptId=this.$route.params.psptId;
            this.formData.address=this.$route.params.address;
            this.formData.linkPhone=this.$route.params.linkPhone;
            this.formData.orderId=this.$route.params.orderId;
            this.realState=this.formData.orderState;
            this.activities.push({content:"您的订单已提交，请等候出库",icon: 'el-icon-more',timestamp:getNow()})
            setTimeout(()=>{
                this.realState=2;
                this.activities.push({content:"商品已出库！",icon: 'el-icon-more',timestamp:getNow()})
                setTimeout(()=>{
                    this.realState=3;
                    this.activities.push({content:"商品正在配送中！",icon: 'el-icon-more',timestamp:getNow()});
                    setTimeout(()=>{
                        this.realState=4;
                        this.activities.push({content:"商品配送完毕，感谢你的光临，欢迎下次光临！",icon: 'el-icon-more',timestamp:getNow()});
                    },15000)
                },5000)
            },5000)
        },
        components:{
            Footer
        }
    }

    function getNow() {
        var date=new Date();
        return date.getFullYear()+'-'+date.getMonth()+'-'+date.getDate()+'-'+(date.getHours()+1)+'-'+(date.getMinutes()+1);
    }
</script>

<style scoped>
  #app{
    background-color: #f2f2f2;
    height: 1111px;
  }
  .main{
    /*height: 100%;*/
  }
  .mbody {
    width: 1200px;
    height: 100%;
    margin: 0 auto;
  }
  .mbody .title {
    height: 30px;
    line-height: 30px;
  }
  .mbody .title ul {
    text-decoration: none;
    list-style: none;
    display: flex;
  }
  .mbody .title ul li {
    margin-right: 5px;
  }
  .body3 {
    width: 100%;
    height: 130px;
    padding: 10px;
    border: 1px solid #c0ccda;
    border-bottom-style: dotted;
    border-bottom-width: 2px;
    border-top: 3px solid orange;
    background-color: white;
    margin-bottom: 30px;
    column-count: 3;
    column-rule-style: dotted;
    column-rule-color: gray;
  }
  .body3 span{
    display: block;
    margin: 10px;
    height: 20px;
    line-height: 20px;
    color: darkgray;

  }






  .mbody .body1 {
    height: 330px;
    width: 100%;
    border: 1px solid #c0ccda;
    border-bottom-style: dotted;
    border-bottom-width: 2px;
    border-top: 3px solid orange;
    background-color: white;
    display: flex;
    margin-bottom: 30px;
  }
  .mbody .body1 .left {
    height: 100%;
    width: 326px;
    border-right: 1px solid lightgray;
    position: relative;
  }
  .mbody .body1 .left #orderNo {
    color: #7d7d7f;
    text-align: center;
  }
  .mbody .body1 .left #orderState {
    color: orange;
    font-size: 35px;
    text-align: center;
    margin: 30px auto;
    font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-weight: bold;
  }
  .mbody .body1 .left .kaipiao,
  .mbody .body1 .left .pingjia {
    display: block;
    margin: 15px auto;
    width: 100px;
    height: 35px;
    font-size: 18px;
  }
  .mbody .body1 .left .kaipiao {
    background-color: #e6e6e6;
    border: 1px solid #cccccc;
  }
  .mbody .body1 .left .pingjia {
    background-color: white;
    color: red;
    border: 1px solid red;
  }
  .mbody .body1 .left .print{
    display:  block;
    text-align: center;
    position: absolute;
    bottom: 10px;
    left: 50%;
    margin-left: -37px;
  }
  .mbody .body1 .right .title {
    margin: 10px 20px;
    color: gray;
  }
  .mbody .body1 .right .body {
    margin-top: 40px;
    display: flex;
    padding: 20px;
  }
  .mbody .body1 .right .body .item {

    width: 70px;
    margin:10px;
    text-align: center;
  }
  .mbody .body1 .right .body .item img {
    display: block;
    width: 50px;
    height: 50px;

  }
  .mbody .body1 .right .body .item img[src*="dgo"] {
    width: 100%;
    height: 20px;
    margin-top: 18px;
  }
  #body2_left {
    width: 445px;
    display: flex;
  }
  #body2_left ul{
    padding: 15px 0 0 5px!important;
    list-style: none;
    margin: 0!important;
  }
  #body2_left ul li {
    height: 30px;
    line-height: 30px;
  }
  .el-timeline {
    margin-top: 20px;
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
    background-color: white;
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
