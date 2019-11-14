<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
  import echarts from 'echarts'
  require('echarts/theme/macarons') // echarts theme
  import resize from './mixins/resize'

  const animationDuration = 6000

  export default {
    mixins: [resize],
    props: {
      className: {
        type: String,
        default: 'chart'
      },
      width: {
        type: String,
        default: '100%'
      },
      height: {
        type: String,
        default: '300px'
      },
      pdata:Array
    },
    data() {
      return {
        chart: null
      }
    },
    mounted() {
      this.$nextTick(() => {
        this.initChart()
    })
    },
    beforeDestroy() {
      if (!this.chart) {
        return
      }
      this.chart.dispose()
      this.chart = null
    },
    methods: {
      initChart() {
        this.chart = echarts.init(this.$el, 'macarons')
        let items_city=[];
        let items_name=[];
        items_name.push(this.pdata[0].sale[0].name);
        let items_value1=[];
        let items_value2=[];
        let items_value3=[];
        let items_value4=[];
        for (let i=0;i<this.pdata.length;i++)
        {
          items_city.push(this.pdata[i].city);
          for (let j=0;j<this.pdata[i].sale.length;j++)
          {
            if(i==0)
            items_value1.push(this.pdata[i].sale[j].value);
            if(i==1)
              items_value2.push(this.pdata[i].sale[j].value);
            if(i==2)
              items_value3.push(this.pdata[i].sale[j].value);
            if(i==3)
              items_value4.push(this.pdata[i].sale[j].value);
          }
        }
        this.chart.setOption({
//          backgroundColor: '#344b58',064f85
          backgroundColor: '#044161',
          title: {
            text: '全省Top4销售量',
            x: 'center',
            top: '0',
            textStyle: {
              color: '#fff',
              fontSize: '14'
            }},
          legend: {
            data: ['冰激凌','沃派','低消','流量王'],
            left: 'center',
            bottom: '10',
            textStyle:{
              color:"#fff"
            }
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          grid: {
            top: 30,
            left: '5%',
            right: '20%',
            bottom: '20%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: items_city,
            axisTick: {
              alignWithLabel: true
            }
          }],
          yAxis: [{
            type: 'value',
            axisTick: {
              show: false
            }
          }],
          series: [{
            name: '冰激凌',
            type: 'bar',
            stack: 'vistors',
            barWidth: '30%',
            data: items_value1,
            animationDuration
          }, {
            name: '沃派',
            type: 'bar',
            stack: 'vistors',
            barWidth: '30%',
            data: items_value2,
            animationDuration
          }, {
            name: '低消',
            type: 'bar',
            stack: 'vistors',
            barWidth: '30%',
            data: items_value3,
            animationDuration
          },
            {
              name: '流量王',
              type: 'bar',
              stack: 'vistors',
              barWidth: '30%',
              data: items_value4,
              animationDuration
            }]
        })
      }
    }
  }
</script>
