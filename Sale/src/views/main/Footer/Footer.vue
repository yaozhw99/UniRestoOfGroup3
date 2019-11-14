<template>
  <div id="app">
    <div id="body">
      <div class="left">
        <ul>
          <li class="title">购物指南</li>
          <li><a href="#">购物流程</a></li>
          <li><a href="#">发票说明</a></li>
          <li><a href="#">联系客服</a></li>
          <li><a href="#">服务协议</a></li>
        </ul>
        <ul>
          <li class="title">支付方式</li>
          <li><a href="#">在线支付</a></li>
          <li><a href="#">快捷支付</a></li>
          <li><a href="#">货到付款</a></li>
        </ul>
        <ul>
          <li class="title"><a href="#">配送方式</a></li>
          <li><a href="#">快递配送</a></li>
          <li><a href="#">上门自提</a></li>
        </ul>
        <ul>
          <li class="title">售后服务</li>
          <li><a href="#">退换货政策</a></li>
          <li><a href="#">退换货流程</a></li>
          <li><a href="#">退款说明</a></li>
          <li><a href="#">手机维修</a></li>
        </ul>
        <ul>
          <li class="title">联通特色服务</li>
          <li><a href="#">充值交费</a></li>
          <li><a href="#">营业厅分布查询</a></li>
          <li><a href="#">号码归属地查询</a></li>
          <li><a href="#">常见问题</a></li>
        </ul>

      </div>
      <div class="right">
        <ul>
          <li>
            <p class="">APP下载</p>
            <img src="//m1.img.10010.com/net5/front/images/downLoad.png" alt="">
          </li>
          <li>
            <div class="">Android 下载</div>
            <div class="">iOS 下载</div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>


<script>

    export default {

        data() {

            return {msg: '底部'}

        }

    }

</script>


<style scoped>
#app{
  width: 100%;
  height: 150px;
  background-color: white;
  border-top: 5px solid lightgray;
  margin-top: 10px;
}
  #body{
    width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-around;
    font-size: 14px;
    color: darkgray;

  }
  .left{
    margin-top: 10px;
    width: 800px;
    border-right: 1px solid lightgray;
    display: flex;
    justify-content: space-between;
    padding-right: 20px;
  }
  ul{
    list-style: none;
    padding: 0;
    margin: 0;
  }
  ul .title{
    color: #C0C0C0;
    font-size: 15px;
    margin: 10px 0;
  }
  .left ul li {
    height: 20px;
    line-height: 20px;
  }
  a:hover {
    color: orange;
  }
  .right{
    margin-top: 10px;
    padding: 0 10px;
  }
  .right ul {
    display: flex;
  }
  .right ul li {
    margin-right: 30px;
  }
  .right div {
    border: 1px solid lightgray;
    padding: 5px 20px;
    text-align: center;
  }
  .right ul li:nth-child(2) {
    display: flex;
    flex-direction:column-reverse;
    justify-content:space-around;
  }



</style>
