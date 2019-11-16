<template>
  <div class="ltzq">
    <div class="llzq">
      <div class="topic">
        <p class="title">优惠专区</p>
        <p class="subtitle">
          <a href="#">上网记录</a><i>/</i>
          <a href="#">流量详单</a><i>/</i>
          <a href="#">订购记录</a>
          <a href="#" class="more">
            <span>更多</span>
            <!--<img :src="more_icon" alt="" />-->
          </a>
        </p>
      </div>
      <ul class="imgTopic">
        <li>
          <img :src="i8fe3" alt="" class="imgBg" />
          <img :src="traffic_ul1_li_fcBg1" alt="" class="imgCover" />
          <div class="txtCover">
            <p><a @click="linkorder('全国半年流量包')">全国半年流量包</a></p>
            <p><a @click="linkorder('定向视频包')">定向视频包</a></p>
          </div>
        </li>
        <li>
          <img :src="b540" alt="" class="imgBg" />
          <img :src="traffic_ul1_li_fcBg1" alt="" class="imgCover" />
          <div class="txtCover">
            <p><a  @click="linkorder('上网卡半年包100G')">上网卡半年包100G</a></p>
            <p><a @click="linkorder('上网卡体验卡')">上网卡体验卡</a></p>
          </div>
        </li>
      </ul>
      <ul class="proList">
        <li>
          <p class="title"><a @click="linkorder('冰激凌99元套餐')">冰激凌99元套餐</a></p>
          <p class="subtitle"><a @click="linkorder('冰激凌99元套餐')">99元不限量，20G后限速</a></p>
          <div class="proImg">
            <img :src="llb_icon3_zhl" alt="" />
            <img :src="bn_icon_blue" alt=""  class="tagImg"/>
          </div>
        </li>
        <li>
          <p class="title"><a @click="linkorder('冰激凌199元套餐')">冰激凌199元套餐</a></p>
          <p class="subtitle"><a @click="linkorder('冰激凌199元套餐')">199元不限量，40G后限速</a></p>
          <div class="proImg">
            <img :src="llb_icon2_zhl" alt="" />
            <img :src="yb_icon_green" alt=""  class="tagImg"/>
          </div>
        </li>
        <li>
          <p class="title"><a @click="linkorder('冰激凌399元套餐')">冰激凌399元套餐</a></p>
          <p class="subtitle"><a @click="linkorder('冰激凌399元套餐')">399元1GB，100G后限速</a></p>
          <div class="proImg">
            <img :src="llb_icon2_zhl" alt="" />
            <img :src="free_icon_orange" alt=""  class="tagImg"/>
          </div>
        </li>
      </ul>
    </div>
    <div class="kdzq">
      <div class="topic">
        <p class="title">特色号卡专区</p>
        <p class="subtitle">
          <a href="#">亲情号卡</a><i>/</i>
          <a href="#">情侣号卡</a><i>/</i>
          <a href="#">特靓号卡</a>
          <a href="#" class="more">
            <span>更多</span>
            <!--<img :src="more_icon" alt="" />-->
          </a>
        </p>
      </div>
      <ul class="imgTopic">
        <li>
          <img :src="kdzq_bg1" alt="" class="imgBg" />
          <img :src="kd_fc_bg" alt="" class="imgCover" />
          <div class="txtCover">
            <p><a @click="linkorder('亲情在线流量卡')">亲情在线流量卡</a></p>
            <p><a @click="linkorder('热聊语音卡')">热聊语音卡</a></p>
          </div>
        </li>
      </ul>
      <ul class="proList">
        <li>
          <p class="title"><a @click="linkorder('智慧沃家主副卡')">智慧沃家主副卡</a></p>
          <p class="subtitle"><a @click="linkorder('智慧沃家主副卡')">一人缴费，全家共用</a></p>
          <img :src="kdzq_pic1" alt="" />
        </li>
        <li>
          <p class="title"><a @click="linkorder('智慧沃家智能家居卡')">智慧沃家智能家居卡</a></p>
          <p class="subtitle"><a @click="linkorder('智慧沃家智能家居卡')">一号在手，随享智能家居</a></p>
          <img :src="kdzq_pic2" alt="" />
        </li>
        <li>
          <p class="title"><a @click="linkorder('沃派流量卡')">沃派流量卡</a></p>
          <p class="subtitle"><a @click="linkorder('沃派流量卡')">学生专用，流量任信用</a></p>
          <img :src="kdzq_pic3" alt="" />
        </li>
      </ul>
    </div>

  </div>


</template>
<script>
  import i8fe3	from '@/assets/img/8fe3.jpg'
  import b540	from '@/assets/img/b540.jpg'
  import back_top	from '@/assets/img/back_top.png'
  import bn_icon_blue	from '@/assets/img/bn_icon_blue.png'
  import free_icon_orange	from '@/assets/img/free_icon_orange.png'
  import kd_fc_bg	from '@/assets/img/kd_fc_bg.png'
  import kdzq_bg1	from '@/assets/img/kdzq_bg1.jpg'
  import kdzq_pic1	from '@/assets/img/kdzq_pic1.jpg'
  import kdzq_pic2	from '@/assets/img/kdzq_pic2.jpg'
  import kdzq_pic3	from '@/assets/img/kdzq_pic3.jpg'
  import llb_icon1_zhl	from '@/assets/img/llb_icon1_zhl.png'
  import llb_icon2_zhl	from '@/assets/img/llb_icon2_zhl.png'
  import llb_icon3_zhl	from '@/assets/img/llb_icon3_zhl.png'
  import online_dg	from '@/assets/img/online_dg.png'
  import online_dg_active	from '@/assets/img/online_dg_active.png'
  import online_kf	from '@/assets/img/online_kf.png'
  import online_kf_active	from '@/assets/img/online_kf_active.png'
  import traffic_ul1_li_fcBg1	from '@/assets/img/traffic_ul1_li_fcBg1.png'
  import wo_icon_zhl	from '@/assets/img/wo_icon_zhl.png'
  import yb_icon_green	from '@/assets/img/yb_icon_green.png'

  export default {
    data() {
      return {
        i8fe3:i8fe3,
        b540:b540,
        back_top:back_top,
        bn_icon_blue:bn_icon_blue,
        free_icon_orange:free_icon_orange,
        kd_fc_bg:kd_fc_bg,
        kdzq_bg1:kdzq_bg1,
        kdzq_pic1:kdzq_pic1,
        kdzq_pic2:kdzq_pic2,
        kdzq_pic3:kdzq_pic3,
        llb_icon1_zhl:llb_icon1_zhl,
        llb_icon2_zhl:llb_icon2_zhl,
        llb_icon3_zhl:llb_icon3_zhl,
        online_dg:online_dg,
        online_dg_active:online_dg_active,
        online_kf:online_kf,
        online_kf_active:online_kf_active,
        traffic_ul1_li_fcBg1:traffic_ul1_li_fcBg1,
        wo_icon_zhl:wo_icon_zhl,
        yb_icon_green:yb_icon_green
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
  *{
    margin: 0;
    padding: 0;
    font-family: "微软雅黑";
    background-color: #F7F7F7;
    color: #333;
    text-align: center;
  }
  a{
    text-decoration: none;
  }
  ul{
    list-style: none;
  }
  .ltzq{
    width: 1200px;
    margin: 20px auto 0;
    display: flex;
  }
  .ltzq .llzq,.ltzq .kdzq{
    flex: 1;

  }
  .llzq{
    margin-right: 10px;
  }
  .ltzq .title{
    font-size: 25px;
    font-weight: bold;
    margin-top: 25px;
  }
  .subtitle{
    position: relative;
  }
  .subtitle a{
    font-size: 14px;
    color: #666;
  }
  .subtitle a:hover{
    color: #ff6600;
  }
  .subtitle i{
    font-style: normal;
    font-size: 14px;
    color: #666;
    display: inline-block;
    margin: 5px 5px;
  }
  .subtitle .more{
    font-size: 14px;
    position: absolute;
    right: 0;
    top: 5px;
  }
  .subtitle .more *{
    color: #666;
    vertical-align: middle;
  }
  .imgTopic{
    display: flex;
  }
  .imgTopic li{
    flex: 1;
    width: 292px;
    height: 160px;
    position: relative;
    /*border: 1px solid green;*/
    overflow: hidden;
  }
  .imgTopic li:hover .imgBg{
    transform: scale(1.1);
    /*transform: translate(0,-3px);*/
    /*box-shadow: 0 5px 5px #959595;*/
  }

  .imgTopic li .imgBg{
    transition-duration: 1s;
  }
  .imgTopic li:first-child{
    margin-right: 10px;
  }

  .kdzq .imgTopic li{
    margin-right: 0px;
  }

  .imgTopic .imgCover,
  .imgTopic .txtCover{
    width: 292px;
    height: 160px;
    position: absolute;
    top:0;
    left: 0;
    background-color: transparent;
  }
  .imgTopic .txtCover{
    display: flex;
    flex-flow: column;
    justify-content: center;
  }
  .imgTopic .txtCover p{
    background-color: transparent;
  }
  .imgTopic .txtCover p:first-child{
    font-size: 16px;
    color: #555;
    font-weight: bold;
    margin-bottom: 15px;
  }
  .imgTopic .txtCover p:last-child{
    color: #ff6600;
    font-size: 14px;
    margin-top: -5px;
  }

  .kdzq .imgTopic li{
    width: 594px;
    position: relative;

  }
  .kdzq .imgTopic .imgCover,
  .kdzq .imgTopic .txtCover
  {
    width: 331px;
    height: 80px;
    position: absolute;
    left: unset;
    right: 0;
    top: 50%;
    margin-top: -40px;
  }
  .kdzq .imgTopic .txtCover p{
    text-align: left;
    margin-left: 25px;
  }



  .proList{
    height: 245px;
    display: flex;
  }
  .proList li{
    flex: 1;
    margin-top: 10px;
    padding-right: 10px;
    background-color: white;
    position: relative;
  }
  .proList li *{
    background-color: transparent;
  }
  .proList li .title{
    font-size: 16px;
    font-weight: normal;
    color: #333;
    margin-top: 30px;
  }
  .proList li .subtitle{
    font-size: 12px;
    color: #959595;
    margin-top: 5px;
  }
  .proList li .proImg{
    padding-top:30px;
    position: relative;
  }
  .proList li .tagImg{
    position: absolute;
    bottom: 0;
    right: 40px;
  }
  .kdzq .proList li img{
    width: 100%;
    position: absolute;
    bottom: 0;
    left: 0;
  }

</style>
