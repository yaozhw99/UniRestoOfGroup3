<template>
  <div class="chart-container" ref="chart"></div>
</template>

<script>
  import echarts from 'echarts'
  // 行政区划地图
  import 'echarts/lib/chart/map';
  import resize from './mixins/resize'

  //需引入对应图表的js文件
  import 'echarts/map/js/world.js';
  import 'echarts/map/js/province/guangdong.js'

  export default {
    mixins: [resize],
    data() {
      return {
        chart: null,
        option:{}
      }
    },
    mounted(){
      this.chart = echarts.init(this.$refs.chart)

      let dataSet =[
        {
          "name": "广州市",
          "value": 1500003
        },
        {
          "name": "深圳市",
          "value": 800000
        },
        {
          "name": "珠海市",
          "value": 400000
        },
        {
          "name": "汕头市",
          "value": 100000
        },
        {
          "name": "佛山市",
          "value": 150000
        },
        {
          "name": "韶关市",
          "value": 80000
        },
        {
          "name": "湛江市",
          "value": 110000
        },
        {
          "name": "肇庆市",
          "value": 70000
        },
        {
          "name": "江门市",
          "value": 140000
        },
        {
          "name": "茂名市",
          "value": 90000
        },
        {
          "name": "惠州市",
          "value": 15000
        },
        {
          "name": "梅州市",
          "value": 60000
        },
        {
          "name": "汕尾市",
          "value": 23000
        },
        {
          "name": "河源市",
          "value": 50000
        },
        {
          "name": "阳江市",
          "value": 60000
        },
        {
          "name": "清远市",
          "value": 80000
        },
        {
          "name": "东莞市",
          "value": 150000
        },
        {
          "name": "中山市",
          "value": 200000
        },
        {
          "name": "潮州市",
          "value": 50000
        },
        {
          "name": "揭阳市",
          "value": 120000
        },
        {
          "name": "云浮市",
          "value": 150000
        }
      ]

      this.option={
        title: {
          text: '销售情况分布地图',
//          subtext: 'from United Nations, Total population, both sexes combined, as of 1 July (thousands)',
//          sublink: 'http://esa.un.org/wpp/Excel-Data/population.htm',
          left: 'center',
          top: 'top',
          textStyle: {
            color: '#fff',
            fontSize: '20'
          }
        },
        visualMap: {
          min: 0,
          max: 100000,
          type: 'continuous', //piecewise
          //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）
          calculable: true,
          //拖拽时，是否实时更新,如果为false则拖拽结束时，才更新视图
          realtime: false,
          text: ['High', 'Low'],
          left: 'left',
          top: 'center',
          inRange: {
            color: ['rgba(255,144,128,1)', 'rgba(0,191,183,1)', '#5AB1EF','#F4CA98']
          }
        },
        tooltip: {
          trigger: 'item',
          formatter(params) {
            var value = (params.value + '').split('.');
            value = value[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,') +
              '.' + value[1];
            return params.seriesName + '<br/>' + params.name + ' : ' + value;
          }
        },
        toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            dataView: {
              show: true,
              readOnly: false
            },
            restore: {
              show: true
            },
            saveAsImage: {
              show: true
            }
          }
        },
        series: [{
          name: '销售量总计',
          type: 'map',
          mapType: '广东',
          roam: false,
          itemStyle: {
            //高亮状态下标签样式
            emphasis: {
              label: {
                show: true
              }
            }
          },
          data: dataSet

        }]
      }

      this.chart.setOption(this.option);

      this.chart.on('click',(params)=>{
        console.log(params)
      switch(params.name){
        case '广州市':{
          this.$router.push("./table/SaleTable");
          break;
        }
      }
    });

//      setInterval(() => {
////      let option1=Object.assign({},this.option);
//        let option1 = JSON.parse(JSON.stringify(this.option));
//
//      for (var i = 0; i < option1.series[0].data.length; i++) {
//        option1.series[0].data[i].value= Math.round(Math.random() * 100000);
//      }
//
//      this.option=option1;
//      this.chart.setOption(this.option);
//    }
//    , 2000);
    }
  }
</script>

<style scoped>
  .chart-container{
    position: relative;
    width: 100%;
    height: calc(100vh - 84px);
  }
</style>
