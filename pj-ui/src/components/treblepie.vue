<template>
  <div>
    <div class="pie">
        <div id="report" style="float:left;width: 100%;height: 300px;"> </div>
    </div>
    
  </div>
</template>

<script>
import Form from '@/components/notsubmitedform'
import {getReportInfo} from '@/api/adminapi/getreportinfo'
// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')

export default {
  props:['ComponentData'],
  data() {
    return {
      nowDate:'',
    };
  },
  created(){
  },
  mounted(){
    this.initData();
    let date = new Date();
    let year = date.getFullYear(); // 年
    let month = date.getMonth() + 1; // 月
    let day = date.getDate(); // 日
    this.nowDate = `${year}/${month}/${day}`;
    //console.log(this.nowDate);
  },
  methods:{
    //初始化数据
    initData() {
      // 基于准备好的dom，初始化echarts实例
      this.myChart = echarts.init(document.getElementById('report'));
      // 绘制图表
      let option = {
          title : {
            //text: '已上报/未上报人数统计',//主标题
            text: this.ComponentData.title,//主标题
            x:'center',//x轴方向对齐方式
          },
          tooltip : {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)"
          },
          //legend: {
          //  orient: 'vertical',
          //  bottom: 'bottom',
          //  data: [this.ComponentData.name1,this.ComponentData.name2]
          //},
          series : [
            {
                name: '饼状图',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                  {value:this.ComponentData.data1, name:this.ComponentData.name1},
                  {value:this.ComponentData.data2, name:this.ComponentData.name2},
                  {value:this.ComponentData.data3, name:this.ComponentData.name3},
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
      let _this=this;
      this.myChart.on('click', function (param) {
          var index = param.dataIndex;
          _this.click_pie(index);
          
      });
    },
    click_pie(index){
      this.$emit('click_pie', index)
    }
  },
  watch: {
    ComponentData(newValue, oldValue) {
        this.initData();
      }
  },
  components: { Form }
}
</script>