<template>
  <div>
    <div> 
      <h1>当前还有{{notsubmitedcount}}个同学没有上报，请及时处理。<br>点击相应的扇区查看人员名单</h1>
    </div>
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
import { export2Excel } from '@/utils/excel.js'
import Pie from '@/components/pie'
import Form from '@/components/notsubmitedform'
export default {
  data() {
    return {
      notsubmitedcount:'0',
      date:'',
      showtable:false,
      shownotsubmit:false,
      showsubmit:false,
      nowDate: '',
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
      this.select_date = new Date(this.nowDate);
      //this.select_date = this.nowDate;
      //console.log("selectdate:",this.select_date);
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
      this.nowDate = `${year}/${month}/${day}`;
    },
    getcurrentData() {
      this.getcurrenttime();
      getReportInfo().then(response => {
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
      })
      .catch(() => {
        console.log("failed");
        //this.issubmited = false;
        //this.$router.push("/pieview");
      });

      this.piedata = new Object();
      this.piedata.hassubmited = 46;
      this.piedata.notsubmited = 32;
      this.notsubmitedcount = this.piedata.notsubmited;
    },
    getotherData() {
      this.getcurrenttime();
      //获取指定日期数据
      getReportInfo().then(response => {
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
      })
      .catch(() => {
        console.log("failed");
      });      
      this.piedata = new Object();
      this.piedata.hassubmited = 35;
      this.piedata.notsubmited = 32;
    },
    selctdate(val){      
      let date = new Date(val);
      let year = date.getFullYear(); // 年
      let month = date.getMonth() + 1; // 月
      let day = date.getDate(); // 日
      let Date1 = `${year}/${month}/${day}`;
      this.date = this.select_date / 1000
      console.log(this.date);
      this.getotherData();
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