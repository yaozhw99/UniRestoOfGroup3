<template> 
    <el-header>
     <div>
       <div class="logo">
         <img src="@/icons/MainPageImg/logo.png"/>
       </div>
       <div class="search">
         <el-input
           placeholder="请输入内容"
           prefix-icon="el-icon-search">
         </el-input>
         <span><el-button size="small">搜索</el-button></span>
       </div>
     </div>
    </el-header>
</template>


<script>

    export default {

        data() {

            return {msg: '头部'}

        }

    }

</script>


<style scope>
.el-header{
  width: 1200px;
  margin: 20px auto;
}
.el-header div{
  display: flex;
  flex-flow: row;
  justify-content: space-between;
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
