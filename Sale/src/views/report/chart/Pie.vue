<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
  import echarts from 'echarts'
  require('echarts/theme/macarons') // echarts theme
  import resize from './mixins/resize'

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
      pdata:Array,
      title:String,
    subtitle:String
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
        let items=[];
        for (let i=0;i<this.pdata.length;i++){
          items.push(this.pdata[i].name)
        }
//        console.log(items);
        this.chart.setOption({
          backgroundColor: '#044161',
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          title: {
            text: '全省Top4销售量',
            x: 'center',
            top: '0',
            textStyle: {
              color: '#fff',
              fontSize: '14'
            }},
          legend: {
            left: 'center',
            bottom: '10',
            data: items,
            textStyle:{
              color:"#fff"
            }
          },

          series: [
            {
              name: '销售量',
              type: 'pie',
              roseType: 'radius',
              radius: [15, 90],
              center: ['50%', '45%'],
              data: this.pdata,
              animationEasing: 'cubicInOut',
              animationDuration: 2600
            }
          ]
        })
      }
    }
  }
</script>
