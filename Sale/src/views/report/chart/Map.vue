<template>
     
  <div class="chart-container" >
    <div ref="chart" style="height: 100%;width: 100%">

    </div>
  </div>
</template>
<script>
  import echarts from 'echarts'
  import resize from './mixins/resize'
  import bmap from 'echarts/extension/bmap/bmap';

  export default {
    mixins: [resize],
    data() {
      return {
        chart:null
      }
    },
    mounted(){

      var data = [
        {name: '云浮', value: 240},
        {name: '梅州', value: 250},
        {name: '汕尾', value: 260},
        {name: '潮州', value: 260},
        {name: '汕头', value: 320},
        {name: '湛江', value: 330},
        {name: '揭阳', value: 340},
        {name: '东莞', value: 360},
        {name: '河源', value: 360},
        {name: '惠州', value: 370},
        {name: '韶关', value: 380},
        {name: '广州', value: 380},
        {name: '清远', value: 390},
        {name: '中山', value: 390},
        {name: '深圳', value: 410},
        {name: '佛山', value: 440},
        {name: '江门', value: 450},
        {name: '肇庆', value: 460},
        {name: '茂名', value: 200},
        {name: '阳江', value: 270}
      ];

      var geoCoordMap = {
        '云浮':[112.02,22.93],
        '梅州':[116.1,24.55],
        '汕尾':[115.37,22.78],
        '潮州':[116.63,23.68],
        '汕头':[116.69,23.39],
        '湛江':[110.35,21.27],
        '揭阳':[116.35,23.55],
        '东莞':[113.75,23.04],
        '河源':[114.68,23.73],
        '惠州':[114.4,23.09],
        '韶关':[113.62,24.84],
        '广州':[113.23,23.16],
        '深圳':[114.07,22.62],
        '珠海':[113.52,22.3],
        '佛山':[113.11,23.05],
        '江门':[113.06,22.61],
        '肇庆':[112.44,23.05],
        '茂名':[110.88,21.68],
        '阳江':[111.95,21.85]
      };

      var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
          var geoCoord = geoCoordMap[data[i].name];
          if (geoCoord) {
            res.push({
              name: data[i].name,
              value: geoCoord.concat(data[i].value)
            });
          }
        }
        console.log(res)
        return res;
      };

      function renderItem(params, api) {

        var coords = [];
        var points = [];
        for (var i = 0; i < coords.length; i++) {
          points.push(api.coord(coords[i]));
        }
        var color = api.visual('color');

        return {
          type: 'polygon',
          shape: {
            points: echarts.graphic.clipPointsByRect(points, {
              x: params.coordSys.x,
              y: params.coordSys.y,
              width: params.coordSys.width,
              height: params.coordSys.height
            })
          },
          style: api.style({
            fill: color,
            stroke: echarts.color.lift(color)
          })
        };
      }

      this.chart=echarts.init(this.$refs.chart);
      this.chart.setOption(
        {
//          backgroundColor: '#344b58',
          title: {
            text: '全省用户分布',
            left: 'center',
            top:10,
            textStyle: {
              color: '#fff',
              fontSize:22
            }
          },
          tooltip : {
            trigger: 'item'
          }
          ,
          bmap: {
            center: [113.29,22.72],
            zoom: 9,
//            roam: true,
            mapStyle: {
              styleJson: [
                {
                  "featureType": "water",
                  "elementType": "all",
                  "stylers": {
                    "color": "#044161!important"
                  }
                }
                  ,
                  {
                      "featureType": "land",
                      "elementType": "all",
                      "stylers": {
                          "color": "#004981"
                      }
                  },
                  {
                      "featureType": "boundary",
                      "elementType": "geometry",
                      "stylers": {
                          "color": "#064f85"
                      }
                  },
                  {
                      "featureType": "railway",
                      "elementType": "all",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "highway",
                      "elementType": "geometry",
                      "stylers": {
                          "color": "#004981"
                      }
                  },
                  {
                      "featureType": "highway",
                      "elementType": "geometry.fill",
                      "stylers": {
                          "color": "#005b96",
                          "lightness": 1
                      }
                  },
                  {
                      "featureType": "highway",
                      "elementType": "labels",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "arterial",
                      "elementType": "geometry",
                      "stylers": {
                          "color": "#004981"
                      }
                  },
                  {
                      "featureType": "arterial",
                      "elementType": "geometry.fill",
                      "stylers": {
                          "color": "#00508b"
                      }
                  },
                  {
                      "featureType": "poi",
                      "elementType": "all",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "green",
                      "elementType": "all",
                      "stylers": {
                          "color": "#056197",
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "subway",
                      "elementType": "all",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "manmade",
                      "elementType": "all",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "local",
                      "elementType": "all",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "arterial",
                      "elementType": "labels",
                      "stylers": {
                          "visibility": "off"
                      }
                  },
                  {
                      "featureType": "boundary",
                      "elementType": "geometry.fill",
                      "stylers": {
                          "color": "#029fd4"
                      }
                  },
                  {
                      "featureType": "building",
                      "elementType": "all",
                      "stylers": {
                          "color": "#1a5787"
                      }
                  },
                  {
                      "featureType": "label",
                      "elementType": "all",
                      "stylers": {
                          "visibility": "off"
                      }
                  }
              ]
            }
          }
          ,
          series : [
            {
              name: 'count',
              type: 'scatter',
              coordinateSystem: 'bmap',
              data: convertData(data),
              symbolSize: function (val) {
                return val[2]/10;
              },
              label: {
                normal: {
                  formatter: '{b}',
                  position: 'right',
                  show: false
                },
                emphasis: {
                  show: true
                }
              },
              itemStyle: {
                normal: {
                  color: '#ddb926'
                }
              }
            },
            {
              name: '当天销售',
              type: 'effectScatter',
              coordinateSystem: 'bmap',
              data: convertData(data.sort(function (a, b) {
                return b.value - a.value;
              })),
              symbolSize: function (val) {
                return val[2]/10;
              },
              showEffectOn: 'emphasis',
              rippleEffect: {
                brushType: 'stroke'
              },
              hoverAnimation: true,
              label: {
                normal: {
                  formatter: '{b}',
                  position: 'right',
                  show: true
                }
              },
              itemStyle: {
                normal: {
                  color: '#f4e925',
                  shadowBlur: 10,
                  shadowColor: '#333'
                }
              },
              zlevel: 1
            },
            {
              type: 'custom',
              coordinateSystem: 'bmap',
              renderItem: renderItem,
              itemStyle: {
                normal: {
                  opacity: 0.5
                }
              },
              animation: false,
              silent: true,
              data: [0],
              z: -10
            }
          ]
        }
      )
    }
  }
</script>
<style >
  .chart-container{
    /*position: relative;*/
    width: 80%;
    /*height: calc(100vh - 84px);*/
    height: 200px;
  }
</style>
