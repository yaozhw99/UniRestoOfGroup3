<template>
    <div>
      <el-container direction="vertical" >
        <CHeader></CHeader>
        <shift></shift>
        <CContent></CContent>

        <CproductZq></CproductZq>
        <CMobileNew></CMobileNew>
        <CFooter></CFooter>
      </el-container>
    </div>
</template>

<script>
  import CHeader from './Header/Header';
  import CContent from './Content/Content';
  import CFooter from './Footer/Footer';
  import shift from './Content/shift'
  import CproductZq from "./Content/CproductZq";
  import CMobileNew from "./Content/CMobileNew";
  import Cbanner from "./Content/Cbanner";
  export default {
        name: "mainPage",
        data() {
            return {
                msg: "vue template"
            }
        },
        components:{
            CHeader,
            CContent,
            CFooter,
            shift,
            CproductZq,
            CMobileNew,
            Cbanner
        }
    }
</script>

<style>
  .el-carousel-item,.el-carousel__container,.el-carousel {
    height: 100%;
  }
  /*.app{*/
  /*  background-color: #F7F7F7;*/
  /*}*/

</style>
