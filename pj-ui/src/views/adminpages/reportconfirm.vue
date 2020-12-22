<template>
  <div>
    <h1>当前还有{{notsubmitedcount}}个同学没有上报，请及时处理。<br>点击相应的扇区查看人员名单</h1>
    <Pie 
      :ComponentData='piedata'
      @click_pie="click_pie">
    </Pie>
    <div class = "li" >
      <li v-if="shownotsubmit">未按时上报人员名单</li>
      <li v-if="showsubmit">按时上报人员名单</li>
    </div>

    <div v-if="showtable">
    <Form
      :ComponentData='tableData'>
    </Form>
    <br>
    <el-button type="primary" @click="exportdate()">表格导出Excel</el-button>
    </div>
  
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')


import {getReportInfo} from '@/api/adminapi/getreportinfo'
import Pie from '@/components/pie'
import Form from '@/components/notsubmitedform'
import { export2Excel } from '@/utils/excel.js'
export default {
  data() {
    return {
      notsubmitedcount:'0',
      showtable:false,
      shownotsubmit:false,
      showsubmit:false,
      tableData: [],
      piedata:{
        hassubmited:0,
        notsubmited:0
      },
      columns:[{title:'日期',key:'date'},{title:'姓名',key:'name'},{title:'学工号',key:'number'}]
    };
  },
  created(){
      this.getcurrentData();
  },
  mounted(){
    //this.getcurrentData();
  },
  methods:{
    //获取当天的数据
    getcurrentData() {
      getReportInfo(sessionStorage.getItem("user_id")).then(response => {
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
      })
      .catch(() => {
        console.log("failed");
      });

      this.piedata = new Object();
      this.piedata.title = '已按时上报/未按时上报人数统计';
      this.piedata.name1 = '已按时上报';
      this.piedata.name2 = '未按时上报';
      this.piedata.data1 = 46;
      this.piedata.data2 = 32;
      this.notsubmitedcount = this.piedata.data2;
    },
   
    click_pie(index){
      if(index === 0)
      {
        this.getsubmitData();
      }
      else if(index == 1)
      {
        this.getunsubmitData();
      }
      this.showtable = true;
    },
    
    getsubmitData() {
        this.shownotsubmit=false;
        this.showsubmit=true;
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
    getunsubmitData(){
        this.showsubmit=false;
        this.shownotsubmit=true;
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
    exportdate(){
      console.log("expertdate");
      if(this.shownotsubmit === true)
        export2Excel(this.columns,this.tableData,'未按时上报人员名单');
      else
        export2Excel(this.columns,this.tableData,'已按时上报人员名单');
    }
  },
  components: { Pie,Form }
}
</script>

<style>
  .li{
    float:left
  }
</style>