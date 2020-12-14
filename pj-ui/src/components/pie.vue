<template>
  <div>
    <div class="pie">
        <div id="report" style="float:left;width: 100%;height: 300px;"> </div>
    </div> 
    <br></br>
    <br></br>
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
            hassubmited:10,
            notsubmited:20
        }
    },
  data() {
    return {
    };
  },
  created(){
  },
  mounted(){
    this.initData();
  },
  methods:{
    //初始化数据
    initData() {
      // 基于准备好的dom，初始化echarts实例
      this.myChart = echarts.init(document.getElementById('report'));
      // 绘制图表
      let option = {
          title : {
            text: '上报人数统计',//主标题
            subtext: '纯属虚构',//副标题
            x:'center',//x轴方向对齐方式
          },
          tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            orient: 'vertical',
            bottom: 'bottom',
            data: ['已上报','未上报']
          },
          series : [
            {
                name: '上报统计',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                  {value:this.ComponentData.hassubmited, name:'已上报'},
                  {value:this.ComponentData.notsubmited, name:'未上报'}
                ],
                itemStyle: {
                    emphasis: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
          ]
      };
      this.myChart.setOption(option);
    }
  }
}
</script>
