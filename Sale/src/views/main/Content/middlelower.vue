<template>
  <div class="all">
    <header>终端专场     <span>更多 > </span></header>
    <div class="middle">
      <div class="goods">
      <template>
        <el-carousel :interval="4000" type="card" width="400px" height="250px">
          <el-carousel-item  v-for="(item,idx) in goods" :key="idx">
            <img :src="item.src" @click="linkorder(item.name)">
          </el-carousel-item>
        </el-carousel>
      </template>
    </div>
    <div class="middleright" >
      <img :src="phone[0].src" alt="" style="height: 100%" @click="linkorder(phone[0].name)">
    </div>
  </div>
  </div>
</template>


<script>

    export default {

        data() {

            return {
                phone: [
                    {
                        ifhot: 1,
                        name: "华为 Mate30 Pro 5G",
                        value: "p1",
                        src: require("../../../icons/MainPageImg/p1.jpg")
                    }
                ],
                goods: [
                    {
                        id: 0,
                        name:"智能机器人",
                        src: require("../../../icons/MainPageImg/robot.jpg")
                    },
                    {
                        id: 1,
                        name:"360路由",
                        src: require("../../../icons/MainPageImg/p5.jpg")
                    },
                    {
                        id: 2,
                        name:'智能儿童手表',
                        src: require("../../../icons/MainPageImg/p6.jpg")
                    }
                ]
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
  .middleright div {
    margin: 1px;
  }
.all{
  width: 1200px;
  border-top: 20px solid white;
  border-bottom: 20px solid white;
  height: 380px;
}
  .middle {
    display: flex;
    flex-flow: row;
    justify-content: space-around;
    height: 100%;
  }
  .all header {
    width: 1200px;
    text-align: center;
    margin:10px auto;
    font-size: 30px;
    color: #333333;
    border-bottom: 1px solid #EEEEEE;
    position: relative;
}
  .all header span {
    position: absolute;
    right: 50px;
    top: 10px;
    color: #aaaaaa;
    font-size: 16px;
  }
  .middle .middleright {
    width: 23%;
    height: 100%;
    position: relative;
  }


  .middle .middleright .hot:hover, .middle .middleright .normal:hover {
    transform: translateY(-1px);
    transition-duration: 1s;
    box-shadow: 2px 2px 5px 1px #aaaaaa;
    overflow: hidden;
  }

  .middle .middleright img {
    height: 281px!important;
  }

  .middle .middleright img:hover {
    transform: scale(1.02);
    transition-duration: 0.2s;
    box-shadow: 1px 1px 7px gray;
  }

  .middle .goods {
    width: 70%;
    height: 100%;
  }

  .goods .el-carousel {
    overflow: visible;
  }

  .goods img {
    width: 100%;
    height: 100%;
  }

  .goods div div {
    box-shadow: 1px 1px 5px lightgrey;
  }

  .goods .is-active {
    box-shadow: 1px 1px 5px orange;
  }



</style>
