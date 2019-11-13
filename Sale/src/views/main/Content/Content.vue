<template>   
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
      <el-col :span="3" v-for="(item,idx) in menu" :key="idx" :class="item.property?'complex':'normal'">{{item.name}}
        <div class="submenu" v-if="item.property"><span  v-for="p in item.subMenu" >{{p.name}}</span></div>
      </el-col>
      <el-col :span="3">登陆后台管理</el-col>
    </el-row>
    </div>
    <div class="middle">
      <div class="card">
        <div class="hotdecration"><i class="el-icon-star-off"></i><i class="el-icon-star-off"></i>{{HOT}}<i class="el-icon-star-off"></i><i class="el-icon-star-off"></i></div>
        <div  v-for="(item,idx) in card" :key="idx" :class="item.ifhot?'hot':'normal'">
          <img :src="item.src">
        </div>
      </div>
      <div class="num">
        <div class="numtitle" >靓号任选 <span @click="changeNum()">换一批<i class="el-icon-refresh"></i></span> </div>
        <div class="numpool">
          <el-row>
            <el-col :span="12" v-for="(item,idx) in num"  :key="idx">{{item.phonenum.replace(/(.{3})(.{4})(.{4})/g, "$1 $2 $3")}}</el-col>
          </el-row>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import {Numpool} from '../../../api/numpool';

    export default {

        data() {

            return {
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
                menu: [{
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
                card:[{ifhot:1,
                    name:"腾讯王卡",
                    src:require("../../../icons/MainPageImg/card_txwk.png")
                },{name:"阿里宝卡",
                    src:require("../../../icons/MainPageImg/card_ali.jpg")
                },{name:"冰淇淋卡",
                    src:require("../../../icons/MainPageImg/card_bql.png")
                }],
                num:[]
            }

        },
        methods:{
            changeNum() {
                Numpool().then(res => {
                    this.num = res.data.num;
                    console.log(this.num);
                }).catch(err => console.log(err));
            }
            },
        created() {
            this.changeNum()
        }
    }

</script>


<style>

  .el-carousel img {
    width: 100%;
  }

  .upper .el-row {
    border-bottom:1px solid orange !important;
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
.middle .num{
  border: orange solid 1px;
  width: 400px;
  height: 389px;
  margin-top: 20px;
  padding: 0;
}
.middle .num .numtitle{
  padding: 10px 40px;
  text-align: center;
  background-color: orange;
  color: white;
  font-weight: 300;
  line-height: 30px;
  font-size: 30px;
  position: relative;
}
.middle .num .numtitle span{
  font-size: 13px;
  position: absolute;
  right: 10px;
  bottom: 5px;
}
  .middle .num .numtitle span:hover{
    cursor: pointer;
  }
  .numpool .el-row{
    margin:  0  !important;
    padding: 0;
  }
  .numpool .el-row .el-col:nth-child(2n+1){
    border-right: 1px solid gray;
  }
  .numpool .el-row .el-col:nth-child(4n),  .numpool .el-row .el-col:nth-child(4n-1){
    background-color: #e5e9f2;
  }
.numpool .el-row .el-col{
  font-size: 22px;
  letter-spacing: 1px;
  line-height: 22px;
}
  .el-col:hover{
    cursor: pointer;
    color: #ff6600;
  }
</style>
