<template>
    <div>
      <el-container direction="vertical" >
      <CHeader></CHeader>
        <shift></shift>
      <CContent></CContent>
      <CFooter></CFooter>
      </el-container>
    </div>
</template>

<script>
  import CHeader from './Header/Header';
  import CContent from './Content/Content';
  import CFooter from './Footer/Footer';
  import shift from './Content/shift'

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
            shift
        }
    }
</script>

<style>
</style>
