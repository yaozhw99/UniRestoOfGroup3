<template>
  <div style="background: #344b58">
    <div class="class-container pie-container" style="height: 300px;width: 100%">
      <pie :pdata="data1"  height="300px"></pie>
      <pie :pdata="data2"  height="300px"></pie>
      <SmallBar :pdata="data3"  height="300px"></SmallBar>
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

  export default {
    name: 'chart',
    components: { Chart , Pie, Map,SmallBar},
    data() {
      return {
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
    margin-top: 20px;
    /*padding-right: 20px;*/
    display: flex;
    width: 100%;
  }
  .pie-container pie,.pie-container SmallBar{
    flex: 0 0 30% ;
  }
  .showdiv{
    height: 10px;
    background: #344b58;
  }
  .map-container{
    margin: 20px auto;
  }
</style>
