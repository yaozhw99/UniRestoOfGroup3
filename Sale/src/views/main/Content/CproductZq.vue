<template>
<div id="CproductZq">
  <div class="header">
    <div class="left">套餐专区</div>
    <div class="right">查看更多></div>
  </div>
  <div class="banner">
    <i class="el-icon-minus"></i>
    <i class="el-icon-star-off"></i>
    明星产品
    <i class="el-icon-minus"></i>
  </div>
  <div class="body">
    <div class="box" @click="linkorder('腾讯地王卡')">
      <div class="top">
        <div class="boxleft">
          <ul>
            <li><img src="@/icons/image/simcard.png" alt="" style="width:70px"></li>
            <li class="productName">腾讯地王卡</li>
            <li><el-button type="warning">月费39元</el-button></li>
          </ul>
        </div>
        <div class="boxright"><img src="@/icons/image/huangguan1.png" alt="" style="width:80px"></div>
      </div>
      <div class="bottom">
        <ul>
          <li><i class="el-icon-phone-outline" style="color:orange;">&nbsp;&nbsp;</i>语音<span style="color:orange">300</span>分钟</li>
          <li><i class="el-icon-location-outline" style="color:orange">&nbsp;&nbsp;</i>流量 超百款专属APP免流</li>
        </ul>
      </div>
    </div>
    <div class="box" @click="linkorder('腾讯天王卡')">
      <div class="top">
        <div class="boxleft">
          <ul>
            <li><img src="@/icons/image/simcard.png" alt="" style="width:70px"></li>
            <li class="productName">腾讯天王卡</li>
            <li><el-button type="warning">月费59元</el-button></li>
          </ul>
        </div>
        <div class="boxright"><img src="@/icons/image/huangguan2.png" alt="" style="width:80px"></div>
      </div>
      <div class="bottom">
        <ul>
          <li><i class="el-icon-phone-outline" style="color:orange;">&nbsp;&nbsp;</i>语音<span style="color:orange">800</span>分钟</li>
          <li><i class="el-icon-location-outline" style="color:orange">&nbsp;&nbsp;</i>流量 超百款专属APP免流</li>
        </ul>
      </div>
    </div>
    <div class="box" @click="linkorder('5G畅爽冰激淋')">
      <div class="top">
        <div class="boxleft">
          <ul>
            <li><img src="@/icons/image/simcard.png" alt="" style="width:70px"></li>
            <li class="productName">5G畅爽冰激淋</li>
            <li><el-button type="warning">月费129元</el-button></li>
          </ul>
        </div>
        <div class="boxright"><img src="@/icons/image/5GN.png" alt="" style="width:70px"></div>
      </div>
      <div class="bottom">
        <ul>
          <li><i class="el-icon-phone-outline" style="color:orange;">&nbsp;&nbsp;</i><span style="color:orange">500</span>分钟语音</li>
          <li><i class="el-icon-location-outline" style="color:orange">&nbsp;&nbsp;</i><span style="color:orange">30G</span>流量</li>
        </ul>
      </div>
    </div>
    <div class="box" @click="linkorder('5G畅爽冰激淋')">
      <div class="top">
        <div class="boxleft">
          <ul>
            <li><img src="@/icons/image/simcard.png" alt="" style="width:70px"></li>
            <li class="productName">5G畅爽冰激淋</li>
            <li><el-button type="warning">月费159元</el-button></li>
          </ul>
        </div>
        <div class="boxright"><img src="@/icons/image/5GN.png" alt="" style="width:70px"></div>
      </div>
      <div class="bottom">
        <ul>
          <li><i class="el-icon-phone-outline" style="color:orange;">&nbsp;&nbsp;</i><span style="color:orange">500</span>分钟语音</li>
          <li><i class="el-icon-location-outline" style="color:orange">&nbsp;&nbsp;</i><span style="color:orange">40G</span>流量</li>
        </ul>
      </div>
    </div>
  </div>
</div>
</template>

<script>
    export default {
        name: "CproductZq",
        data() {
            return {
                msg: "vue asdfasdf"
            }
        },
        methods:{
            linkorder(item){
                this.$router.push({name:'order',params:{
                        serialNumber:'',
                        actionName:'',
                        productName:item}})
            }
        }
    }
</script>

<style scoped>
#CproductZq{
  font-size: 15px;
  width: 1200px;
  height: 360px;
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
  .banner{
    margin-bottom: 5px;
    text-align: center;
  }
  .body{
    display: flex;
    justify-content: space-around;
    height: 20px;
    line-height: 20px;
  }
  .box{
    height: 300px;
    width: 280px;
    background-color: white;
    border-radius: 5px;
    transition: all 0.2s ease-in-out;
  }
.box:hover{
  box-shadow: 1px 1px 9px gray;
}
  .box .top{
    display: flex;
  }
  .box .top .boxleft{
    width:180px;
  }
  .box .top .boxright{
    padding-top: 30px;
  }
  .box .top .productName{
    font-size: 20px;
    font-weight: bold;
    font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  }


  ul{
    list-style: none;
  }
  ul li:nth-child(3){
    margin-top: 40px;
  }
</style>
