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
      <img src="@/icons/MainPageImg/logo2.jpg" style="width: 200px;height: 58px;"/>
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
        <a class="back" @click="goback">管理后台</a>
      </div>
    </div>
  </div>
  <div v-if="ifBanner" class="banner2"></div>
</div>
</template>

<script>
    export default {
        props:{ifBanner:Boolean},
        name: "Header",
        data() {
            return {
                operNo:'',
                password:'',
                activeName: 'first',
                dialogFormVisible:true,
                msg: "vue template"
            }
        },
        methods:{
            goback(){
                this.$router.push({path:'/'})
            }
        }
    }
</script>

<style scoped>
  #app{
    display: flex!important;
    flex-direction: column!important;
    background-color: white!important;
  }

  .el-dialog__body{
    padding:0 10px!important;
  }

  .back{
    color: darkgray;
    font-size: 14px;
  }

  .banner-right input{
    width:300px!important;
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

</style>
