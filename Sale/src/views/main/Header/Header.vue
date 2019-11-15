<template> 
    <el-header>
     <div>
       <div class="logo">
         <img src="@/icons/MainPageImg/logo.png"/>
       </div>
       <div class="search">
         <div>
           <el-input
             placeholder="请输入内容"
             prefix-icon="el-icon-search">
           </el-input>
           <span><el-button size="small">搜索</el-button></span>
         </div>
         <div class="linkback"><a @click="goback">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录后台管理</a></div>


       </div>
     </div>
    </el-header>
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
.el-header{
  width: 1200px;
  margin: 20px auto;
}
.search{
  display: flex;
  flex-direction: column!important;

}
.linkback{
  font-size: 14px;
  color: #7d7d7f;
  margin-top: 15px;
  text-align: right;
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
