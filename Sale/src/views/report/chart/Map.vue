<template>
     
  <div class="chart-container" >
    <div ref="chart" style="height: 100%;width: 50%">

    </div>
  </div>
</template>
<script>
  import echarts from 'echarts'
  import resize from './mixins/resize'


  export default {
    mixins: [resize],
    data() {
      return {
        chart:null
      }
    },
    mounted(){

//      var data = [
//        {name: '云浮', value: 24},
//        {name: '梅州', value: 25},
//        {name: '汕尾', value: 26},
//        {name: '潮州', value: 26},
//        {name: '汕头', value: 32},
//        {name: '湛江', value: 33},
//        {name: '揭阳', value: 34},
//        {name: '东莞', value: 36},
//        {name: '河源', value: 36},
//        {name: '惠州', value: 37},
//        {name: '韶关', value: 38},
//        {name: '广州', value: 38},
//        {name: '清远', value: 39},
//        {name: '中山', value: 39},
//        {name: '深圳', value: 41},
//        {name: '佛山', value: 44},
//        {name: '江门', value: 45},
//        {name: '肇庆', value: 46},
//        {name: '茂名', value: 50},
//        {name: '阳江', value: 57}
//      ];
//
//      var geoCoordMap = {
//        '云浮':[112.02,22.93],
//        '梅州':[116.1,24.55],
//        '汕尾':[115.37,22.78],
//        '潮州':[116.63,23.68],
//        '汕头':[116.69,23.39],
//        '湛江':[110.35,21.27],
//        '揭阳':[116.35,23.55],
//        '东莞':[113.75,23.04],
//        '河源':[114.68,23.73],
//        '惠州':[114.4,23.09],
//        '韶关':[113.62,24.84],
//        '广州':[113.23,23.16],
//        '深圳':[114.07,22.62],
//        '珠海':[113.52,22.3],
//        '佛山':[113.11,23.05],
//        '江门':[113.06,22.61],
//        '肇庆':[112.44,23.05],
//        '茂名':[110.88,21.68],
//        '阳江':[111.95,21.85]
//      };
//
//      var convertData = function (data) {
//        var res = [];
//        for (var i = 0; i < data.length; i++) {
//          var geoCoord = geoCoordMap[data[i].name];
//          if (geoCoord) {
//            res.push({
//              name: data[i].name,
//              value: geoCoord.concat(data[i].value)
//            });
//          }
//        }
//        return res;
//      };
//
//      function renderItem(params, api) {
//        var coords = [
//[112.02,22.93],
//  [116.1,24.55],
//  [115.37,22.78],
//  [116.63,23.68],
//  [116.69,23.39],
//  [110.35,21.27],
//  [116.35,23.55],
//  [113.75,23.04],
//  [114.68,23.73],
//  [114.4,23.09],
//  [113.62,24.84],
//  [113.23,23.16],
//  [114.07,22.62],
//  [113.52,22.3],
//  [113.11,23.05],
//  [113.06,22.61],
//  [112.44,23.05],
//  [110.88,21.68],
//  [111.95,21.85]
//        ];
//        var points = [];
//        for (var i = 0; i < coords.length; i++) {
//          points.push(api.coord(coords[i]));
//        }
//        var color = api.visual('color');
//
//        return {
//          type: 'polygon',
//          shape: {
//            points: echarts.graphic.clipPointsByRect(points, {
//              x: params.coordSys.x,
//              y: params.coordSys.y,
//              width: params.coordSys.width,
//              height: params.coordSys.height
//            })
//          },
//          style: api.style({
//            fill: color,
//            stroke: echarts.color.lift(color)
//          })
//        };
//      }
      this.chart=echarts.init(this.$refs.chart);
      this.chart.setOption(
        {
          backgroundColor: '#344b58',
          title: {
            text: '全国主要城市空气质量',
            subtext: 'data from PM25.in',
            sublink: 'http://www.pm25.in',
            left: 'center',
            textStyle: {
              color: '#fff'
            }
          },
          tooltip : {
            trigger: 'item'
          }
//          ,
//          bmap: {
//            center: [113.23,23.16],
//            zoom: 8,
//            roam: true,
//            mapStyle: {
//              styleJson: [
//                {
//                  "featureType": "water",
//                  "elementType": "all",
//                  "stylers": {
//                    "color": "#044161"
//                  }
//                },
//                {
//                  "featureType": "land",
//                  "elementType": "all",
//                  "stylers": {
//                    "color": "#004981"
//                  }
//                },
//                {
//                  "featureType": "boundary",
//                  "elementType": "geometry",
//                  "stylers": {
//                    "color": "#064f85"
//                  }
//                },
//                {
//                  "featureType": "railway",
//                  "elementType": "all",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "highway",
//                  "elementType": "geometry",
//                  "stylers": {
//                    "color": "#004981"
//                  }
//                },
//                {
//                  "featureType": "highway",
//                  "elementType": "geometry.fill",
//                  "stylers": {
//                    "color": "#005b96",
//                    "lightness": 1
//                  }
//                },
//                {
//                  "featureType": "highway",
//                  "elementType": "labels",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "arterial",
//                  "elementType": "geometry",
//                  "stylers": {
//                    "color": "#004981"
//                  }
//                },
//                {
//                  "featureType": "arterial",
//                  "elementType": "geometry.fill",
//                  "stylers": {
//                    "color": "#00508b"
//                  }
//                },
//                {
//                  "featureType": "poi",
//                  "elementType": "all",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "green",
//                  "elementType": "all",
//                  "stylers": {
//                    "color": "#056197",
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "subway",
//                  "elementType": "all",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "manmade",
//                  "elementType": "all",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "local",
//                  "elementType": "all",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "arterial",
//                  "elementType": "labels",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                },
//                {
//                  "featureType": "boundary",
//                  "elementType": "geometry.fill",
//                  "stylers": {
//                    "color": "#029fd4"
//                  }
//                },
//                {
//                  "featureType": "building",
//                  "elementType": "all",
//                  "stylers": {
//                    "color": "#1a5787"
//                  }
//                },
//                {
//                  "featureType": "label",
//                  "elementType": "all",
//                  "stylers": {
//                    "visibility": "off"
//                  }
//                }
//              ]
//            }
//          },
//          series : [
//            {
//              name: 'pm2.5',
//              type: 'scatter',
//              coordinateSystem: 'bmap',
//              data: convertData(data),
//              symbolSize: function (val) {
//                return val[2] / 10;
//              },
//              label: {
//                normal: {
//                  formatter: '{b}',
//                  position: 'right',
//                  show: false
//                },
//                emphasis: {
//                  show: true
//                }
//              },
//              itemStyle: {
//                normal: {
//                  color: '#ddb926'
//                }
//              }
//            },
//            {
//              name: 'Top 5',
//              type: 'effectScatter',
//              coordinateSystem: 'bmap',
//              data: convertData(data.sort(function (a, b) {
//                return b.value - a.value;
//              }).slice(0, 6)),
//              symbolSize: function (val) {
//                return val[2] / 10;
//              },
//              showEffectOn: 'emphasis',
//              rippleEffect: {
//                brushType: 'stroke'
//              },
//              hoverAnimation: true,
//              label: {
//                normal: {
//                  formatter: '{b}',
//                  position: 'right',
//                  show: true
//                }
//              },
//              itemStyle: {
//                normal: {
//                  color: '#f4e925',
//                  shadowBlur: 10,
//                  shadowColor: '#333'
//                }
//              },
//              zlevel: 1
//            },
//            {
//              type: 'custom',
//              coordinateSystem: 'bmap',
//              renderItem: renderItem,
//              itemStyle: {
//                normal: {
//                  opacity: 0.5
//                }
//              },
//              animation: false,
//              silent: true,
//              data: [0],
//              z: -10
//            }
//          ]
        }
      )
    }
  }
</script>
<style >
  .chart-container{
    position: relative;
    width: 100%;
    height: calc(100vh - 84px);
  }
</style>
