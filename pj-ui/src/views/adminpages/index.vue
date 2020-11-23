<template>
  <div>
    <div class="pie">
        <div id="pie1">
            <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
            <div id="report" style="float:left;width:100%;height: 300px"></div>
        </div>
    </div> 
    <div class = "li">
    <li>未上报人员名单</li>
    <br>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="date"
        label="日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="number"
        label="学工号">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
require('echarts/lib/chart/pie')
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')


import {getuserinfo} from '@/api/getinfo'
export default {
  data() {
    return {
      hassubmited:100,
      notsubmited:20,
      nowDate: '',
      tableData: []        
    };
  },
  created(){
    this.hassubmited = 50;
    this.notsubmited = 20;
  },
  mounted(){
    this.initData();
    this.getcurrentData();
  },
  methods:{
    //初始化数据
    initData() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('report'));
      // 绘制图表
      myChart.setOption({
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
                    {value:this.hassubmited, name:'已上报'},
                    {value:this.notsubmited, name:'未上报'}
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
      });
    },
    getcurrentData() {
      getuserinfo().then(response => {
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
      })
      .catch(() => {
        console.log("failed");
        //this.issubmited = false;
        //this.$router.push("/pieview");
      });
      let date = new Date();
      let year = date.getFullYear(); // 年
      let month = date.getMonth() + 1; // 月
      let day = date.getDate(); // 日
      this.nowDate = `${year}/${month}/${day}`;
      let num = 20;
      for(let i = 0;i<num;i++)
      {
        this.tableData[i] = new Object();
        this.tableData[i].date = this.nowDate;
        this.tableData[i].name = '郑海关';
        this.tableData[i].number = '20262010061';
      }
      console.log(this.nowDate);
    }
  }
}
</script>

<style>
  .li{
    float:left
  }
</style>