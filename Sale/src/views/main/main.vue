<template>
    <div>
      <el-container direction="vertical" width="1200px">
      <CHeader></CHeader>
      <CContent></CContent>
      <CFooter></CFooter>
      </el-container>
    </div>
</template>

<script>
  import CHeader from './Header/Header';
  import CContent from './Content/Content';
  import CFooter from './Footer/Footer';

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
            CFooter
        }
    }
</script>

<style>

</style>
