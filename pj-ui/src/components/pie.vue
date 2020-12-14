<template>
  <div>
    <div class="pie">
        <div id="report" style="float:left;width: 100%;height: 300px;"> </div>
    </div>
    <div v-if="showsubmited">
    <Form
      :FormComponentData='tableData'>
    </Form>
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
    props:{
        ComponentData:{
            hassubmited:10,
            notsubmited:20
        }
    },
  data() {
    return {
      showsubmited:false,
      tableData: [],
      nowDate:''
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
    console.log(this.nowDate);
  },
  methods:{
    getsubmitData() {
        let num = 5;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          let tempobj = new Object();
          tempobj.date = this.nowDate;
          tempobj.name = '郑海关';
          tempobj.number = '20262010061';
          tempdata.push(tempobj);
        }
        this.tableData = tempdata;
        for(let i = 0;i<num;i++)
        {
          console.log(this.tableData[i]);
        }     
    },
    getunsubmitData(){
        let num = 5;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          let tempobj = new Object();
          tempobj.date = this.nowDate;
          tempobj.name = '阿关';
          tempobj.number = '19262010062';
          tempdata.push(tempobj);
        }
        this.tableData = tempdata;
        for(let i = 0;i<num;i++)
        {
          console.log(this.tableData[i]);
        }     
    },
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
      let _this=this;
      this.myChart.on('click', function (param) {
          var index = param.dataIndex;
          if(index === 0)
          {
            _this.showsubmited=false;
            alert(index);
            _this.getsubmitData();
            _this.showsubmited=true;
          }
          else if(index == 1)
          {
            _this.showsubmited=false;
            alert(index);
            _this.getunsubmitData();
            _this.showsubmited=true;
          }
          
      });
    }
  },
  components: { Form }
}
</script>
