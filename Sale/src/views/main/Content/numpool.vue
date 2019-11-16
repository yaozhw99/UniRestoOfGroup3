<template>
<div class="num">
  <div class="numtitle" > <a v-show="ifshow">靓号任选</a> <span style="cursor: pointer" @click="changeNum()">换一批<i class="el-icon-refresh"></i></span> </div>
  <div class="numpool">
    <el-row>
      <el-col  :span="8" v-for="(item,idx) in num"  :key="idx"><div @click="showdialog(item.phonenum)" >{{item.phonenum.replace(/(.{3})(.{4})(.{4})/g, "$1 $2 $3")}}</div></el-col>
    </el-row>
  </div>
</div>

</template>


<script>
    import {Numpool} from '../../../api/numpool';
    export default {

        data() {

            return {num:[],
            }

        },
        props:[
            "ifshow"
        ],
        methods:{
            changeNum() {
                Numpool().then(res => {
                    this.num = res.data.num;
                }).catch(err => console.log(err));
            },
            showdialog(item){
                this.$emit("sendValue",[,item,])
            }
        },
        created() {
            this.changeNum()
        }

    }

</script>


<style scoped>
  .el-row .el-col{
    text-align: center;
    padding:10px;
  }
   .num{

    width: 600px;
    height: 389px;
    margin-top: 20px;
    padding: 0;
  }
   .num .numtitle{
    padding: 10px 40px;
    text-align: center;
    background-color: #F7F7F7;
    color: #333333;
    font-weight: 500;
    line-height: 30px;
    font-size: 30px;
    position: relative;
  }
   .num .numtitle span{
    font-size: 13px;
    position: absolute;
    right: 10px;
    bottom: 5px;
  }
  .num .numpool{
    border: 1px solid #EEEEEE;
    background-color: white;
  }
  .num .numpool .el-col:hover{
    cursor: pointer;
    color: #ff6600;
  }
  .numpool .el-row{
    margin:  0  !important;
    padding: 0;

  }
  /*.numpool .el-row .el-col:nth-child(2n+1){*/
  /*  border-right: 1px solid gray;*/
  /*}*/
  .numpool .el-row .el-col:nth-child(6n+4),
  .numpool .el-row .el-col:nth-child(6n+5),
  .numpool .el-row .el-col:nth-child(6n+6)
  {
    background-color: #e5e9f2;
  }
  .numpool .el-row .el-col{
    font-size: 14px;
    letter-spacing: 1px;
    height: 39px;
  }
  .el-col:hover{
    cursor: pointer;
    color: #ff6600;
  }


</style>
