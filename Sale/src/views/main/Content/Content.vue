<template xmlns="http://www.w3.org/1999/html">   
  <div>
    <div class="shift">
        <el-carousel :interval="5000" arrow="always">
          <el-carousel-item v-for="item in shift" :key="item.id">
            <img :src="item.src">
          </el-carousel-item>
        </el-carousel>
    </div>
    <div class="upper">
    <el-row :gutter="50">
      <el-col :span="3" v-for="(item,idx) in menu" :key="idx" :class="item.property?'complex':'normal'"><i class="el-icon-star-on" style="color: orange;margin-right: 10px"></i>{{item.name}}<i class="el-icon-star-on" style="color: orange;margin-left: 10px"></i>
        <div class="submenu" v-if="item.property"><span  v-for="p in item.subMenu" >{{p.name}}</span></div>
      </el-col>
      <el-col :span="3"><i class="el-icon-star-on" style="color: orange;margin-right: 10px"></i>登陆后台<i class="el-icon-star-on" style="color: orange;margin-left: 10px"></i></el-col>
    </el-row>
    </div>
    <div class="middle">
      <div class="card">
        <div class="hotdecration"><i class="el-icon-star-off"></i><i class="el-icon-star-off"></i>{{HOT}}<i class="el-icon-star-off"></i><i class="el-icon-star-off"></i></div>
        <div  @click="linkorder([item.name,,])" v-for="(item,idx) in card" :key="idx" :class="item.ifhot?'hot':'normal'">
          <img :src="item.src">
        </div>
      </div>
       <NumPool ifshow="true" @sendValue="linkorder"></NumPool>
    </div>
<lower></lower>
  </div>
</template>


<script>

import NumPool from './numpool';
import lower from './middlelower'



    export default {

        data() {

            return {
                cardvalue:"",
                numvalue:'',
                HOT:"热销卡品",
                shift: [
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
                ],
                menu: [
                    {
                    name: "特色号码"
                },
                    {
                        name: "热销推荐"
                    }, {
                        name: "业务链接"
                    }, {
                        name: "特惠活动"
                    }, {
                        name: "手机专场"
                    },
                    {
                        name: "5G体验"
                    },
                    {
                        name: '火爆卡品',
                        // property: 1,
                        // subMenu: [{name: "腾讯王卡"}, {name: "冰淇淋卡"}, {name: "流量王卡"}]
                    }],
                card:[
                    {ifhot:1,
                    name:"腾讯王卡",
                    value:"txwk",
                    src:require("../../../icons/MainPageImg/card_txwk.png")
                },{name:"阿里宝卡",
                    value:"albk",
                    src:require("../../../icons/MainPageImg/card_ali.jpg")
                },{name:"冰淇淋卡",
                    value:"bqlk",
                    src:require("../../../icons/MainPageImg/card_bql.png")
                },
                ],
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
            lower
        }
    }

</script>


<style scoped>
  *{
    margin:0 auto;
  }
.shift{
  height: 265px;
}
.shift  .el-carousel img {
    width: 100%;
    height: 100%;
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
  }
.middle .card {
  margin-top: 10px;
  margin-right: 60px;
  position: relative;
  width: 580px;
  height: 390px;
}
.middle .card .hot{
  margin-top: 40px;
  float: left;
  width: 360px;
  height: 360px;
}

.middle .card .normal{
  float: right;
  width: 200px;
  height:200px;
}
.middle .card .hot:hover,.middle .card .normal:hover{
  transform: translateY(-1px);
  transition-duration: 1s;
  box-shadow: 2px 2px 3px 1px #aaaaaa;
  overflow: hidden;
}
.middle .card div img{
  width: 100%;
}
.middle .hotdecration{
  width: 360px;
  padding: 5px;
  position: absolute;
  margin-top: 10px;
  text-align: center;
  letter-spacing: 5px;
  height: 30px;
  background-color: orangered;
  color: white;
  font-style: italic;
  border-radius: 5px 5px 5px 10px/5px 5px 5px 5px;
  display: flex;
  justify-content: space-around;
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
