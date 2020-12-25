<template>
  <div>
    <div class="block">
      <span>选择查询项目</span>
      <el-select v-model="project" placeholder="请选择" @change="handleprojectselect">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
        <el-button type="primary" @click="serach">查询</el-button>
    </div>

  
    <div class = "li" >
      <li>近一周{{pjname}}人数变化趋势</li>
    </div>
    <ChartLine 
      :ComponentData='chartlinedata'
      :title='pjname'>
    </ChartLine>
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')


import {getTrend} from '@/api/adminapi/analyze'
import ChartLine from '@/components/chartline'
export default {
  data() {
    return {
      pjname:'',
      chartlinedata:[],
      options: [{value: '0', label: '未按时上报(下午五点)'}, 
                {value: '1', label: '是否有发烧症状'},
                {value: '2', label: '是否在校'},
                {value: '3', label: '体温状况'},
                {value: '4', label: '是否咳嗽乏力'},
                {value: '5', label: '是否与国内中高风险地区人员有较为密切的接触'},
                {value: '6', label: '是否处于隔离期'},
                {value: '7', label: '是否接触确诊/疑似人群'},
              ],
      project:'0',
    };
  },
  created(){
      //this.getcurrenttime();
      this.project = '0';
      this.getPjData();
  },
  mounted(){
    //this.getcurrentData();
  },
  methods:{ 
    //获取所选项目数据
    getPjData() {
      switch (this.project)
      {
        case '0':
          this.pjname = "未按时上报";
          this.chartlinedata = new Array();
        this.chartlinedata[0] = 10;
        this.chartlinedata[1] = 20;
        this.chartlinedata[2] = 30;
        this.chartlinedata[3] = 15;
        this.chartlinedata[4] = 18;
        this.chartlinedata[5] = 50;
        this.chartlinedata[6] = 20;
          break;
        
        case '1':
          this.pjname = '有发烧症状';
          this.chartlinedata = new Array();
            this.chartlinedata[0] = 10;
            this.chartlinedata[1] = 20;
            this.chartlinedata[2] = 15;
            this.chartlinedata[3] = 5;
            this.chartlinedata[4] = 24;
            this.chartlinedata[5] = 2;
            this.chartlinedata[6] = 17;
        break;

        case '2':
          this.pjname = '未在校';
           this.chartlinedata = new Array();
            this.chartlinedata[0] = 60;
            this.chartlinedata[1] = 55;
            this.chartlinedata[2] = 58;
            this.chartlinedata[3] = 12;
            this.chartlinedata[4] = 5;
            this.chartlinedata[5] = 50;
            this.chartlinedata[6] = 66;
        break;

        case '3':
          this.pjname = '体温异常';
        break;

        case '4':
          this.pjname = '咳嗽乏力';
        break;

        case '5':
          this.pjname = '与中高风险地区人员有接触';
          break;

          case '6':
          this.pjname = '处于隔离期';
          break;

          case '7':
          this.pjname = '与确认/疑似人员有接触';
          break;
      }
      this.chartlinedata = new Array();
            this.chartlinedata[0] = 60;
            this.chartlinedata[1] = 55;
            this.chartlinedata[2] = 58;
            this.chartlinedata[3] = 12;
            this.chartlinedata[4] = 5;
            this.chartlinedata[5] = 50;
            this.chartlinedata[6] = 66;
      console.log(this.pjname);
      getTrend(this.project).then(response => {
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
      })
      .catch(() => {
        console.log("failed");
      });
      
    },
    serach(){
      this.getPjData();
    },
    handleprojectselect(){
      console.log(this.project);
    },
  },
  components: { ChartLine }
}
</script>

<style>
  .li{
    float:left
  }
</style>