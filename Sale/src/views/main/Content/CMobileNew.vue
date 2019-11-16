<template>
<div id="CMobileNew">
  <div class="header">
    <div class="left">手机新品专区</div>
    <div class="right">查看更多></div>
  </div>
  <div class="body">
    <div class="leftbar"><img src="@/icons/image/cphone1.png" alt=""></div>
    <div class="box" @click="linkorder('华为Mate30 Pro 5G')">
      <div class="top"><img src="@/icons/image/phone_mate9.png" alt=""></div>
      <ul>
        <li class="title1">华为Mate30 Pro 5G</li>
        <li class="title2">256GB</li>
        <li class="title3">￥6899</li>
      </ul>
    </div>
    <div class="box" @click="linkorder('华为P30 Pro')">
      <div class="top"><img src="@/icons/image/huawei_p30pro.png" alt=""></div>
      <ul>
        <li class="title1">华为P30 Pro</li>
        <li class="title2">4000万超感光徕卡四摄</li>
        <li class="title3">￥4888</li>
      </ul>
    </div>
    <div class="box" @click="linkorder('nubia Z20')">
      <div class="top"><img src="@/icons/image/zx_z20.png" style="height:260px;width:180px" alt=""></div>
      <ul>
        <li class="title1">nubia Z20</li>
        <li class="title2">4800万三摄 超清双屏自拍全网通</li>
        <li class="title3">￥3399</li>
      </ul>
    </div>
    <div class="box" @click="linkorder('nubia 红魔3')">
      <div class="top"><img src="@/icons/image/zx_hm3.png" style="height:260px;width:180px" alt=""></div>
      <ul>
        <li class="title1">nubia 红魔3</li>
        <li class="title2">骁龙855 内置风扇</li>
        <li class="title3">￥2499</li>
      </ul>
    </div>
  </div>
</div>
</template>

<script>
    export default {
        name: "CMobileNew",
        data() {
            return {
                msg: "vue template"
            }
        },
        methods:{
            linkorder(item){
                this.$router.push({name:'order',params:{
                        serialNumber:'',
                        actionName:item,
                        productName:''}})
            }
        }
    }
</script>

<style scoped>
#CMobileNew{
  font-size: 15px;
  width: 1200px;
  height: 420px;
  margin: 5px auto;
  background-color: #F7F7F7;
}
.header {
  height: 30px;
  line-height: 30px;
  display: flex;
  justify-content: space-between;
}
.header .left{
  border-left: 4px solid red;
  font-size: 20px;
  font-weight: bold;
  padding: 0 5px;
}
.body{
    display: flex;
    justify-content: space-around;
  }
  .box{
    width: 240px;
    height: 370px;
    background-color: white;
    border-radius: 5px;
    transition: all 0.2s ease-in-out;

  }
  .box:hover{
    box-shadow: 1px 1px 9px gray;
  }
  .box .top img{
    display: block;
    margin: 0 auto;
  }
  ul{
    list-style: none;
    text-align: center;
    padding: 0;
  }
  ul li {
    margin-bottom: 5px;
  }
  .title1{
    font-size: 20px;
    font-weight: lighter;
  }
  .title2{
    font-size: 14px;
    color: #8c939d;
  }
  .title3{
    font-size: 22px;
    color: orange;
    font-weight: bold;
  }
</style>
