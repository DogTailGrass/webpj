<template>
  <div>
    <div class="block">
      <span class="demonstration">日期</span>
      <el-date-picker v-model="select_date" type="date" format="yyyy-M-d" :picker-options="pickerOptions"
        value-format="timestamp" placeholder="选择日期" @change="selctdate">
      </el-date-picker>

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
    
    <Pie 
      :ComponentData='piedata'
      @click_pie="click_pie">
    </Pie>
    <div class = "li" >
      <li v-if="showname1">{{date_y_m_d}}{{piedata.name1}}人数统计</li>
      <li v-if="showname2">{{date_y_m_d}}{{piedata.name2}}人数统计</li>
    </div>

    <div v-if="showtable">
    <Form
      :ComponentData='tableData'>
    </Form>
    <br>
    <el-button type="primary" @click="exportdate()">表格导出Excel</el-button>
    </div>
  
    <div class = "li" >
      <li>近一周{{piedata.name2}}人数变化趋势</li>
    </div>
    <ChartLine 
      :ComponentData='chartlinedata'>
    </ChartLine>
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')


import {getReportInfo} from '@/api/adminapi/getreportinfo'
import ChartLine from '@/components/chartline'
import Pie from '@/components/pie'
import Form from '@/components/notsubmitedform'
import { export2Excel } from '@/utils/excel.js'
export default {
  data() {
    return {
      select_date:'',  //时间选择框的绑定值
      date:'',   //Unix时间戳，传给后端的值
      showtable:false,
      showname1:false,
      showname2:false,
      date_y_m_d: '',  //页面显示

      chartlinedata:[],
      tableData: [],
      piedata:{
        hassubmited:0,
        notsubmited:0
      },
      options: [{value: '0', label: '未按时上报'}, 
                {value: '1', label: '不在上海本地'},
                {value: '2', label: '身体不适'},
                {value: '3', label: '处于中高风险地区'},
                {value: '4', label: '处于隔离期'},
              ],
      project:'0',
      pickerOptions: {
          disabledDate(date){
            let zero=new Date().setHours(0, 0, 0, 0);
            if(date.getTime()>=zero){
              return true;
            }
            return false;
          }
        },  
        columns:[{title:'日期',key:'date'},{title:'姓名',key:'name'},{title:'学工号',key:'number'}]
    };
  },
  created(){
      //this.getcurrenttime();
      this.select_date = new Date(this.getcurrenttime());
      this.date = this.select_date/1000;
      this.project = '0';
      this.getPjData();
  },
  mounted(){
    //this.getcurrentData();
  },
  methods:{
    getcurrenttime(){
      let date = new Date();
      let year = date.getFullYear(); // 年
      let month = date.getMonth() + 1; // 月
      let day = date.getDate(); // 日
      this.date_y_m_d = `${year}/${month}/${day}`;
      return date;
    },
    
    selctdate(val){      
      let selectdate = new Date(val);
      this.date = selectdate/1000;
      let year = selectdate.getFullYear(); // 年
      let month = selectdate.getMonth() + 1; // 月
      let day = selectdate.getDate(); // 日
      this.date_y_m_d = `${year}/${month}/${day}`;
    },
    click_pie(index){
      if(index === 0)
      {
        this.getname1table();
      }
      else if(index == 1)
      {
        this.getname2table();
      }
      this.showtable = true;
    },
    getname1table() {
        this.showname1=true;
        this.showname2=false;
        let num = 10;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].date = this.nowDate;
          tempdata[i].name = '郑海关';
          tempdata[i].number = '20262010061';
        }
        this.tableData = tempdata; 
    },
    getname2table(){
        this.showname2=true;
        this.showname1=false;
        let num = 10;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].date = this.nowDate;
          tempdata[i].name = '洪峰';
          tempdata[i].number = '20262010061';
        }
        this.tableData = tempdata;
    },
    handleprojectselect(){
      console.log(this.project);
    },

    //获取所选日期、项目数据
    getPjData() {
      //this.getcurrenttime();      
      console.log(this.date);
      console.log(this.date_y_m_d);
      getReportInfo(this.date,this.project).then(response => {
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
      })
      .catch(() => {
        console.log("failed");

      });
      this.piedata = new Object();
      switch (this.project)
      {
        case '0':
          this.piedata.title = `${this.date_y_m_d}未按时上报人数统计`;
          this.piedata.name1 = '已按时上报';
          this.piedata.name2 = '未按时上报';
          this.piedata.data1 = 40;
          this.piedata.data2 = 30;
          break;
        
        case '1':
          this.piedata.title = `${this.date_y_m_d}不在上海本地人数统计`;
          this.piedata.name1 = '在上海本地';
          this.piedata.name2 = '不在上海本地';
          this.piedata.data1 = 60;
          this.piedata.data2 = 10;
        break;

        case '2':
          this.piedata.title = `${this.date_y_m_d}身体不适人数统计`;
          this.piedata.name1 = '健康状况正常';
          this.piedata.name2 = '身体不适';
          this.piedata.data1 = 65;
          this.piedata.data2 = 5;
        break;

        case '3':
          this.piedata.title = `${this.date_y_m_d}处于中高风险地区人数统计`;
          this.piedata.name1 = '不在中高风险地区';
          this.piedata.name2 = '处于中高风险地区';
          this.piedata.data1 = 50;
          this.piedata.data2 = 20;
        break;

        case '4':
          this.piedata.title = `${this.date_y_m_d}处于隔离期人数统计`;
          this.piedata.name1 = '不在隔离期';
          this.piedata.name2 = '处于隔离期';
          this.piedata.data1 = 69;
          this.piedata.data2 = 11;
        break;
      }
      this.chartlinedata = new Array();
      this.chartlinedata[0] = 10;
      this.chartlinedata[1] = 20;
      this.chartlinedata[2] = 30;
      this.chartlinedata[3] = 15;
      this.chartlinedata[4] = 18;
      this.chartlinedata[5] = 50;
      this.chartlinedata[6] = 20;
    },
    serach(){
      this.showname1=false;
      this.showname2=false;
      this.showtable=false;
      this.getPjData();
    },
    exportdate(){
      if(this.showname1 === true)
        export2Excel(this.columns,this.tableData,`${this.date_y_m_d}${this.piedata.name1}名单`);
      else
        export2Excel(this.columns,this.tableData,`${this.date_y_m_d}${this.piedata.name2}名单`);
    }
  },
  components: { ChartLine,Pie,Form }
}
</script>

<style>
  .li{
    float:left
  }
</style>