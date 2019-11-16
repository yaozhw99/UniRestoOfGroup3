<template>
  <div>

    <div>
      <card ></card>
    </div>
    <div class="class-container pie-container" style="height: 300px;width: 100%">
      <pie :pdata="data1"  height="300px"></pie>
      <pie :pdata="data2"  height="300px"></pie>
      <SmallBar :pdata="data3"  height="300px"></SmallBar>
    </div>
    <div class="map-container">
      <e-map @getCity="showcity" ref="mapcity" style="height: 500px;width: 49%"></e-map>
<map-table :data="Tabdata" :columns="ProColumns" :city="curCity" style="background: #044161; height: 500px;width: 50%;margin-left: 10px"></map-table>
    </div>


    <div class="showdiv"></div>
  <div class="class-container" style="height: 500px;width: 100%">
    <Chart></Chart>
  </div>
    <div class="showdiv"></div>
    <div class="map-container" >
      <Map></Map>
    </div>
  </div>
</template>

<script>
  import Chart from './Barchart.vue'
  import Pie from './Pie.vue'
  import Map from './Map.vue'
  import SmallBar from './SmallBar.vue'
  import EMap from './EMap.vue'
  import Card from './Card.vue'
  import MapTable from './MapTable.vue'
  import Mock from 'mockjs'
  import {fetchList,getList} from '@/api/report'
// let bjldata=Mock.mock({"data|21":["count|5000-9000":5001]})


  export default {
    name: 'chart',
    components: { Chart , Pie, Map,SmallBar,EMap,Card,MapTable},
    data() {
      return {
//        bjl:bjldata.data(),
//        wopai:[],
//        dixiao:[],
//        liulw:[],
        curCity:'广州市',
        ProColumns: {
          Brand:'品牌',
          saleBy:'销售量',
          saleLj:'销售累计',
          activeBy:'激活量',
          activeLj:'激活累计'
        },
        Tabdata:[],
        resdata:[],
        title1:"各类产品销售情况",
        subtitle1:"",
        title2:"当月销售进度情况",
        subtitle2:"",
        data1:[
          {value:335, name:'冰激凌'},
          {value:310, name:'沃派'},
          {value:234, name:'低消'},
          {value:135, name:'流量王'}
        ],
        data2:[
          {value:1000, name:'已售卡'},
          {value:500, name:'未签收卡'},
          {value:300, name:'未激活卡'},
          {value:135, name:'已激活卡'}
        ],
        data3:[
          {city:"东莞",sale:
            [
              {value:121, name:'冰激凌'},
          {value:233, name:'沃派'},
          {value:244, name:'低消'},
          {value:301, name:'流量王'}
        ]},
      {city:"广州",sale:
        [
          {value:455, name:'冰激凌'},
        {value:422, name:'沃派'},
        {value:555, name:'低消'},
        {value:644, name:'流量王'}
      ]},
      {city:"深圳",sale:
        [
          {value:405, name:'冰激凌'},
        {value:333, name:'沃派'},
        {value:370, name:'低消'},
        {value:234, name:'流量王'}
      ]},
      {city:"佛山",sale:
        [
          {value:335, name:'冰激凌'},
        {value:310, name:'沃派'},
        {value:234, name:'低消'},
        {value:135, name:'流量王'}
      ]}
        ],
      }
  },
    methods:{
      showcity(value){
        this.curCity=value;
//        console.log(this.curCity)
        console.log(this.resdata);
          for(let i=0;i<this.resdata.length;i++)
        {

          if (this.resdata[i].city==value){
            this.Tabdata=this.resdata[i].sale;
          }
        }
        console.log(this.Tabdata)
      }
    },
    mounted(){
      fetchList().then(res=>{
//        console.log(res);

      for(let i=0;i<res.data.length;i++)
      {
        if (res.data[i].city=="广州市"){
          this.Tabdata=res.data[i].sale;
          this.resdata=res.data;
        }
      }
    })
    }
  }
</script>

<style scoped>
  .chart-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  }
  .pie-container{
    margin-bottom: 10px;
    margin-top: 10px;
    display: flex;
    width: 100%;
  }
  .pie-container pie,.pie-container SmallBar{
    flex: 0 0 30% ;
    margin-left: 10px;
  }
  .showdiv{
    height: 10px;
    background: #344b58;
  }
  .map-container{
    margin-bottom: 10px ;
    display: flex;
  }
</style>
