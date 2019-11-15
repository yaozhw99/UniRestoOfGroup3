<template>
  <div class="all">
    <header>终端专场</header>
  <div class="middle">
    <div class="goods">
      <template>
        <el-carousel :interval="4000" type="card" width="400px" height="400px">
          <el-carousel-item v-for="(item,idx) in goods" :key="idx">
            <img :src="item.src">
          </el-carousel-item>
        </el-carousel>
      </template>
    </div>
    <div class="middleright">
      <div v-for="(item,idx) in phone" :key="idx" :class="item.ifhot?'hot':'normal'">
        <img :src="item.src">
      </div>
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
                        name: "手机1",
                        value: "p1",
                        src: require("../../../icons/MainPageImg/p1.jpg")
                    }
                ],
                goods: [
                    {
                        id: 0,
                        src: require("../../../icons/MainPageImg/robot.jpg")
                    },
                    {
                        id: 1,
                        src: require("../../../icons/MainPageImg/p5.jpg")
                    },
                    {
                        id: 2,
                        src: require("../../../icons/MainPageImg/p6.jpg")
                    }
                ]
            }

        }

    }

</script>


<style scoped>
  .middleright div {
    margin: 1px;

  }

  .middle {
    margin: 30px 25px;
    display: flex;
    min-width: 1200px;
    flex-flow: row;
    justify-content: space-around;
  }
  .all header {
  text-align: center;
    margin:10px;
}
  .middle .middleright {
    margin-top: 10px;
    width: 23%;
    height: 335px;
    position: relative;
  }

  .middle .middleright .hot {
    margin:22px 0 0 30px;
    float: left;
    width: 100%;
    height: 100%;
  }


  .middle .middleright .hot:hover, .middle .middleright .normal:hover {
    transform: translateY(-1px);
    transition-duration: 1s;
    box-shadow: 2px 2px 5px 1px #aaaaaa;
    overflow: hidden;
  }

  .middle .middleright div img {
    width: 100%;
    height: 100%;
  }

  .middle .middleright div img:hover {
    transform: scale(1.02);
    transition-duration: 1s;
  }

  .middle .goods {
    width: 70%;
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
