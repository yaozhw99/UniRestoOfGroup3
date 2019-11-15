<template>
    <div>
      <CHeader></CHeader>
      <CContent></CContent>
      <CFooter></CFooter>
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
.el-header {
  width: 1200px;
  margin: 0 auto;
}
</style>
