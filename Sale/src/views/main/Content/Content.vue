<template xmlns="http://www.w3.org/1999/html">   
  <div class="content">
<!--    <div class="upper" style="margin-top: 20px">-->
<!--    <el-row >-->
<!--      <el-col :span="3" v-for="(item,idx) in menu" :key="idx" :class="item.property?'complex':'normal'"><i class="el-icon-star-on" style="color: orange;margin-right: 10px"></i>{{item.name}}<i class="el-icon-star-on" style="color: orange;margin-left: 10px"></i>-->
<!--        <div class="submenu" v-if="item.property"><span  v-for="p in item.subMenu" >{{p.name}}</span></div>-->
<!--      </el-col>-->
<!--      <el-col :span="3"><i class="el-icon-star-on" style="color: orange;margin-right: 10px"></i>登陆后台<i class="el-icon-star-on" style="color: orange;margin-left: 10px"></i></el-col>-->
<!--    </el-row>-->
<!--    </div>-->
    <div class="middle">
       <middle @sendcardvalue="linkorder"></middle>
       <NumPool ifshow="true" @sendValue="linkorder"></NumPool>
    </div>
<lower></lower>
  </div>
</template>


<script>

import NumPool from './numpool';
import lower from './middlelower';
import middle from './Middle'




    export default {

        data() {

            return {
                cardvalue:"",
                numvalue:'',
                HOT:"热销卡品",
                // menu: [
                //     {
                //     name: "特色号码"
                // },
                //     {
                //         name: "热销推荐"
                //     }, {
                //         name: "业务链接"
                //     }, {
                //         name: "特惠活动"
                //     }, {
                //         name: "手机专场"
                //     },
                //     {
                //         name: "5G体验"
                //     },
                //     {
                //         name: '火爆卡品',
                //         // property: 1,
                //         // subMenu: [{name: "腾讯王卡"}, {name: "冰淇淋卡"}, {name: "流量王卡"}]
                //     }],
                num:[]
            }

        },
        methods:{
            linkorder(item){
                this.$router.push({name:'order',params:{
                        serialNumber:item[1],
                        actionName:item[2],
                        productName:item[0]}})
            }
            },
        components:{
            NumPool,
            lower,
            middle
        }
    }

</script>


<style scoped>
  *{
    margin:0 auto;
  }
  div.content{
    background-color:#F7F7F7 ;
  }
  .upper .el-col{
    border-bottom:1px solid #ff6600;
  }
.upper .el-col:hover{
   cursor: pointer;
   color: #ff6600;
 }
  #app > div > section > div:nth-child(2) > div.upper > div >div{
    margin-top: 45px;
    padding: 10px 0px !important;
    font-size: 16px;
    border-bottom: 1px solid orange;
  }
  .upper .el-row {
    margin: 0 100px !important;
    line-height: 14px;
    color: #333333;
    font-size: 14px;
  }
  .el-row .submenu{
    display: none;
  }
  .el-row .el-col:hover .submenu{
    display: flex;
    flex-flow: column;
    position: absolute;
    margin-left: 20px;
    border: 1px solid orange;
  }
  .el-row div span{
    line-height: 20px;
    font-size: 14px;
  }

  .el-row .el-col{
    text-align: center;
    padding:10px;
  }
  .middle{
    display: flex;
    width: 1200px;
    flex-flow: row;
    justify-content:center;
    border-top: 20px solid white;
  }
  #app .el-dialog__header{
    text-align: center;
  }
  #app .el-dialog__body{
    padding-top: 0px !important;
  }
  #app .el-dialog__body input,.selectnum  .el-input{
    text-align: center;
    width: 110px;
    height: 26px;
  }

  #app .el-dialog__body span i{
    position: relative;
    margin-top: 5px;
  }
  /*.selectnum  .el-input{*/
  /* width: 110px;*/
  /*}*/
  .selectcard>span,.selectnum>span{
    margin-right: 10px;
    line-height: 26px;
    font-size:18px ;
    margin-bottom: 20px;
  }
</style>
