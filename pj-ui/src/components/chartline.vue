<template>
  <div>
    <br></br>
    <br></br>
    <div id="chartLineBox" style="float:left;width: 70%;height: 50vh;"> </div>
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')

export default {
    props:{
        ComponentData:{
            type: Array,
            default: function() {
            return [0, 0, 0, 0, 0, 0, 0]
            }
        }
    },
  data() {
    return {
    };
  },
  created(){
  },
  mounted(){
    this.drawchartline();
  },
  methods:{
    //初始化数据
    drawchartline(){
      this.chartLine = echarts.init(document.getElementById('chartLineBox'));
 
      // 指定图表的配置项和数据
      let option = {
        title : {
            text: '近一周未上报人数变化趋势',//主标题
            textStyle: {
                color: '#989898',
                fontStyle: 'normal',
                fontWeight: 'normal',
                fontSize: 20
            }
        },

        tooltip: {              //设置tip提示
            trigger: 'axis'
        },
          
        legend: {               //设置区分（哪条线属于什么）
          data:['未上报人数']
        },

        color: ['#FA6F53'],       //设置区分（每条线是什么颜色，和 legend 一一对应）
        
        xAxis: {                //设置x轴
          type: 'category',
          boundaryGap: false,     //坐标轴两边不留白
          data: ['1', '2', '3', '4', '5', '6', '7',],
          name: '日期',           //X轴 name
          nameTextStyle: {        //坐标轴名称的文字样式
              color: '#FA6F53',
              fontSize: 16,
              padding: [0, 0, 0, 20]
          },
          axisLine: {             //坐标轴轴线相关设置。
              lineStyle: {
                  color: '#FA6F53',
              }
          }
        },
        yAxis: {
          name: '人数',
          nameTextStyle: {
              color: '#FA6F53',
              fontSize: 16,
              padding: [0, 0, 10, 0]
          },
          axisLine: {
              lineStyle: {
                  color: '#FA6F53',
              }
          },
          type: 'value'
        },
        series: [
          {
            name: '未上报人数',
            data: this.ComponentData,
            type: 'line',
            lineStyle: {
                normal: {
                    color: '#FA6F53',
                }
            },
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      this.chartLine.setOption(option);
    }
  }
}
</script>