<template>
  <div :id="id" :class="className" :style="{height:height,width:width}" />
</template>

<script>
  import echarts from 'echarts'
  import resize from './mixins/resize'
  import Mock from 'mockjs';
  let databjl=Mock.mock({
    "data|21":["@integer(1000,8000)"]
  });
  let datawopai=Mock.mock({
    "data|21":["@integer(1000,20000)"]
  });
  let datadixiao=Mock.mock({
    "data|21":["@integer(3000,12000)"]
  });
  let datallw=Mock.mock({
    "data|21":["@integer(2000,6000)"]
  });
  export default {
    mixins: [resize],
    props: {
      className: {
        type: String,
        default: 'chart'
      },
      id: {
        type: String,
        default: 'chart'
      },
      width: {
        type: String,
        default: '100%'
      },
      height: {
        type: String,
        default: '500px'
      },
      bjl:[],
      wopai:[],
      dixiao:[],
      liulw:[]
    },
    data() {
      return {
        chart: null
      }
    },
    mounted() {
//      console.log(databjl.data)
      this.initChart()
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
        this.chart = echarts.init(document.getElementById(this.id))
        const xData = (function() {
          const data = ['广州市','深圳市','珠海市','汕头市','佛山市','韶关市','湛江市','肇庆市','江门市','茂名市','惠州市','梅州市','汕尾市','河源市','阳江市','清远市','东莞市','中山市','潮州市','揭阳市','云浮市']

          return data
        }())
        this.chart.setOption({
          backgroundColor: '#044161',
          title: {
            text: '全省本月产品销售情况',
            x: 'center',
            top: '10',
            textStyle: {
              color: '#fff',
              fontSize: '20'
            },
            subtextStyle: {
              color: '#90979c',
              fontSize: '16'
            }
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              textStyle: {
                color: '#fff'
              }
            }
          },
          grid: {
            left: '5%',
            right: '5%',
            borderWidth: 0,
            top: 20,
            bottom: 95,
            containLabel: true,
            textStyle: {
              color: '#fff'
            }
          },
          legend: {
            x: '70%',
            top: '10',
            textStyle: {
              color: '#90979c'
            },
            data: ['冰激凌','沃派','低消','流量王']
          },
          calculable: true,
          xAxis: [{
            type: 'category',
            axisLine: {
              lineStyle: {
                color: '#90979c'
              }
            },
            splitLine: {
              show: false
            },
            axisTick: {
              show: false
            },
            splitArea: {
              show: false
            },
            axisLabel: {
              interval: 0

            },
            data: xData
          }],
          yAxis: [{
            type: 'value',
            splitLine: {
              show: false
            },
            axisLine: {
              lineStyle: {
                color: '#90979c'
              }
            },
            axisTick: {
              show: false
            },
            axisLabel: {
              interval: 0
            },
            splitArea: {
              show: false
            }
          }],
          dataZoom: [{
            show: true,
            height: 30,
            xAxisIndex: [
              0
            ],
            bottom: 30,
            start: 10,
            end: 80,
            handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
            handleSize: '100%',
            handleStyle: {
              color: '#d3dee5'

            },
            textStyle: {
              color: '#fff' },
            borderColor: '#90979c'

          }, {
            type: 'inside',
            show: true,
            height: 15,
            start: 1,
            end: 35
          }],
          series: [
            {
              name: '冰激凌',
              type: 'bar',
              stack: 'total',
              barMaxWidth: 35,
              barGap: '10%',
              itemStyle: {
                normal: {
                  color: '#2EC7C9',
                  label: {
                    show: true,
                    textStyle: {
                      color: '#fff'
                    },
                    position: 'insideTop',
                    formatter(p) {
                      return p.value > 0 ? p.value : ''
                    }
                  }
                }
              },
//              data:[3000,2500,2000,1000,3000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000]
            data:databjl.data
            },

            {
              name: '沃派',
              type: 'bar',
              stack: 'total',
              itemStyle: {
                normal: {
                  color: '#B6A2DE',
                  barBorderRadius: 0,
                  label: {
                    show: true,
                    position: 'top',
                    formatter(p) {
                      return p.value > 0 ? p.value : ''
                    }
                  }
                }
              },
//              data: [3000,2500,1500,500,2500,500,500,500,500,500,600,500,700,601,500,701,602,500,702,603,500]
              data:datawopai.data
            },
            {
              name: '低消',
              type: 'bar',
              stack: 'total',
              symbolSize: 10,
              symbol: 'circle',
              itemStyle: {
                normal: {
                  color: '#5AB1EF',
                  barBorderRadius: 0,
                  label: {
                    show: true,
                    position: 'top',
                    formatter(p) {
                      return p.value > 0 ? p.value : ''
                    }
                  }
                }
              },
//              data: [3000,2500,2500,1500,3500,1500,1500,1500,1500,1500,1600,1500,1700,1601,1500,1701,1602,1500,1702,1603,1500]
              data:datadixiao.data
            },
            {
              name: '流量王',
              type: 'bar',
              stack: 'total',
              symbolSize: 10,
              symbol: 'circle',
              itemStyle: {
                normal: {
                  color: '#F4CA98',
                  barBorderRadius: 0,
                  label: {
                    show: true,
                    position: 'top',
                    formatter(p) {
                      return p.value > 0 ? p.value : ''
                    }
                  }
                }
              },
//              data: [3000,2500,1700,700,2700,700,700,700,700,700,800,700,900,801,700,901,802,700,902,803,700]
              data:datallw.data
            }
          ]
        })
      }
    }
  }
</script>
<style scoped>
  .chart{
    /*position: relative;*/
    width: 80%;
    /*height: calc(100vh - 84px);*/
    height: 200px;
  }
</style>
