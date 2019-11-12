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
          <el-input placeholder="大王卡" class="input-with-select">
            <el-button slot="append" icon="el-icon-search"></el-button>
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
          <table>
            <tr>
              <td>价格：</td>
              <td>￥50.00</td>
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
                <el-select v-model="value" placeholder="请选择">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    import Mock from 'mockjs';

    export default {
        props:['serialNumber','actionName'],
        name: "index",
        data() {
            return {
                msg: "vue template",
                options: [{
                    value: '选项1',
                    label: '黄金糕'
                }, {
                    value: '选项2',
                    label: '双皮奶'
                }, {
                    value: '选项3',
                    label: '蚵仔煎'
                }, {
                    value: '选项4',
                    label: '龙须面'
                }, {
                    value: '选项5',
                    label: '北京烤鸭'
                }],
                value: ''
            }
        },
        mounted() {
            this.serialNumber='18676060960'
        }
    }
</script>

<style scoped>
  .ccmain {
    border: 1px solid red;
    width: 100%;
    height:500px;
    margin-left: 10px;
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
    height: 100%;
    margin: 0 auto;
    padding: 30px;
    border: 1px solid #9aaabf;
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
