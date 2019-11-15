<template>

  <div class="card" style="margin: 20px 0px;">
    <div class="cardtitle">{{cardtitle}}</div>
    <div class="hotdecration">
      <div class="tu1" v-for="(item,idx) in cardupper" :key="idx">
        <img :src="item.src">
          <div class="text1" >
            <h1>{{item.p1}}</h1>
            <p>{{item.p2}}</p>
            <span>立即购买</span>
          </div>
        </div>

    </div>
    <div class="cardlower">
      <div @click="sendcardvalue([item.name,,])" v-for="(item,idx) in card" :key="idx" class="normal">
        <img :src="item.src"></div>
    </div>
  </div>

</template>


<script>

    export default {

        data() {
            return {
                cardtitle: "热销推荐",
                card: [
                    {
                        name: "腾讯王卡",
                        value: "txwk",
                        src: require("../../../icons/MainPageImg/card_txwk.png")
                    }, {
                        name: "冰淇淋卡",
                        value: "bqlk",
                        src: require("../../../icons/MainPageImg/card_bql.png")
                    }, {
                        name: "阿里宝卡",
                        value: "albk",
                        src: require("../../../icons/MainPageImg/card_ali.jpg")
                    }
                ],
                cardupper: [
                    {
                        src: require("../../../icons/MainPageImg/4G_top_bg1.jpg"),
                        p1: "300分钟国内语音",
                        p2: "40G国内流量"
                    },
                    {
                        src: require("../../../icons/MainPageImg/4G2.jpg"),
                        p1: "1000分钟国内语音",
                        p2: "20GB国内流量"
                    }
                ]
            }

        }, methods: {
            sendcardvalue(item) {
                this.$emit("sendcardvalue", item)
            }
        }

    }

</script>


<style scoped>


  .card {
    margin-top: 10px;
    margin-right: 60px;
    position: relative;
    width: 580px;
    height: 390px;
  }

  .cardtitle {
    padding: 10px 40px;
    text-align: center;
    color: #333333;
    font-weight: 500;
    line-height: 30px;
    font-size: 30px;
    position: relative;
  }

  .hotdecration {
    width: 100%;
    display: flex;
    justify-content: space-around;
  }

  .hotdecration div {
    width: 49%;
    height: 160px;
  }

  .tu1 {
    width: 280px;
    height: 160px;
    /*height: 100%;*/
    display: flex;
    justify-content: center;
    position: relative;
    overflow: hidden;
  }
.tu1 img{
  width: 100%;
  height: 100%;
}
  .tu1:hover img{
      transform: scale(1.1);
      cursor: pointer;
    }

  .tu1 img{
    transition: 2s;
  }
.tu1 .text1{
  cursor: pointer;
  width: 234px;
  height: 100px;
  background-image: url('../../../icons/MainPageImg/4G.png');
  background-repeat: no-repeat;
  background-size: 100%;
  opacity: 0.8;
  position: absolute;
  text-align: center;
  top: 30px;
}

  .tu1 .text1 h1 {
    font-size: 16px;
    height: 25px;
    line-height: 25px;
    margin-top: 18px;
  }

  .tu1 .text1 p {
    line-height: 0px;
    font-size: 12px;
  }

  .tu1 .text1 span{
    font-size: 12px;
    border: 1px solid #ff6600;
    padding: 1px 5px;
    border-radius: 5px;
    color: #ff6600;
  }

  .card .cardlower {
    display: flex;
    justify-content: space-around;
  }

  .card .cardlower .normal {
    width: 180px;
    height: 180px;
  }

  .card .hot:hover, .card .normal:hover {
    transform: translateY(-1px);
    transition-duration: 1s;
    box-shadow: 2px 2px 3px 1px #aaaaaa;
    overflow: hidden;
  }

  .card div img {
    width: 100%;
  }

</style>
