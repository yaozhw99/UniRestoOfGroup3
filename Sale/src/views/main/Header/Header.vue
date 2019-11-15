<template> 
     <div id="app">
       <div class="logo">
         <img src="@/icons/MainPageImg/logo.png"/>
       </div>
       <div class="body">
         <div class="search">
           <el-input
             placeholder="请输入内容"
             prefix-icon="el-icon-search">
           </el-input>
           <span><el-button size="small">搜索</el-button></span>
         </div>
         <div class="linkback"><a @click="goback">登录后台</a></div>
       </div>
     </div>
</template>


<script>

    export default {

        data() {

            return {msg: '头部'}

        },
        methods:{
            goback(){
                this.$router.push({path:'/'})
            }
        }

    }

</script>


<style scope>
  #app{
    width: 1200px;
    margin: 0 auto;
    padding: 15px 0;
    display: flex;
    flex-flow: row;
    justify-content: space-between;
    position: relative;
  }
.search{
  display: flex;
}
.body{

  height: 100%;
}
.linkback{
  text-align: right;
  color: #7f7f7f;
  font-size: 14px;
  position: absolute;
  right: 0;
  bottom: 5px;
}

.el-icon-search:before{
  position: absolute;
  margin-top: 10px;
}

.el-input__inner{
  margin-top: 10px;
  padding:0 !important;
  width: 155px;
}
.search .el-button{
  margin-top: 12px;
  margin-left: 3px;
  color: #AAAA;
  border-radius: 5px;
}

.search .el-button:hover{
  cursor: pointer;
  color: cornsilk;
  background-color: #FF6600;
}

input::-webkit-input-placeholder{text-align: center;}
</style>
