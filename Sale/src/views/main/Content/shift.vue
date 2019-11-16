<template>
  <div class="shift">
    <el-carousel :interval="5000" arrow="always">
      <el-carousel-item v-for="item in shift" :key="item.id">
        <img :src="item.src">
      </el-carousel-item>
    </el-carousel>
  </div>

</template>


<script>

    export default {

        data() {

            return {shift: [
                    {
                        id: 0,
                        src: require("../../../icons/MainPageImg/shift.jpg")
                    },
                    {
                        id: 1,
                        src: require("../../../icons/MainPageImg/shift1.jpg")
                    },
                    {
                        id: 2,
                        src: require("../../../icons/MainPageImg/shift2.jpg")
                    }
                ]}

        }

    }

</script>


<style scoped>

  .shift{
    margin:0px;
    height: 265px;
  }
  .shift  .el-carousel img {
    width: 100%;
    height: 100%;
  }

  .el-carousel__item,.el-carousel__container,.el-carousel {
    height: 100%;
  }
</style>
