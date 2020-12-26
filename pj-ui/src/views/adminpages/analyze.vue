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

    <div v-if="showpie">
    <Pie 
      :ComponentData='piedata'
      @click_pie="click_pie">
    </Pie>
    <div class = "li" >
      <li v-if="showname1">{{date_y_m_d}}{{piedata.name1}}人数统计(共{{tableData.length}}人)</li>
      <li v-if="showname2">{{date_y_m_d}}{{piedata.name2}}人数统计(共{{tableData.length}}人)</li>
    </div>
    </div>

    <div v-if="showtreblepie">
    <TreblePie 
      :ComponentData='treblepiedata'
      @click_pie="click_pie">
    </TreblePie>
    <div class = "li" >
      <li v-if="showname1">{{date_y_m_d}}  体温：{{treblepiedata.name1}}人数统计(共{{tableData.length}}人)</li>
      <li v-if="showname2">{{date_y_m_d}}  体温：{{treblepiedata.name2}}人数统计(共{{tableData.length}}人)</li>
      <li v-if="showname3">{{date_y_m_d}}  体温：{{treblepiedata.name3}}人数统计(共{{tableData.length}}人)</li>
    </div>
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
import TreblePie from '@/components/treblepie'
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
      showname3:false,
      showpie:false,
      showtreblepie:false,
      date_y_m_d: '',  //页面显示

      tableData: [],
      piedata:{
        hassubmited:0,
        notsubmited:0
      },
      treblepiedata:{
        normol:0,
        middle:0,
        high:0,
      },
      options: [{value: '0', label: '未按时上报(下午五点)'}, 
                {value: '1', label: '是否在校'},
                {value: '2', label: '体温状况'},
                {value: '3', label: '是否咳嗽乏力'},
                {value: '4', label: '是否与国内中高风险地区人员有较为密切的接触'},
                {value: '5', label: '是否处于隔离期'},
                {value: '6', label: '是否接触确诊/疑似人群'},
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
      else if(index === 1)
      {
        this.getname2table();
      }
      else if(index === 2)
      {
        this.getname3table();
      }
      this.showtable = true;
    },
    getname1table() {
        this.showname1=true;
        this.showname2=false;
        this.showname3=false;
        let num = 10;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].index = i+1;
          tempdata[i].date = this.date_y_m_d;
          tempdata[i].name = '郑海关';
          tempdata[i].number = '20262010061';
        }
        this.tableData = tempdata; 
    },
    getname2table(){
        this.showname2=true;
        this.showname1=false;
        this.showname3=false;
        let num = 10;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].index = i+1;
          tempdata[i].date = this.date_y_m_d;
          tempdata[i].name = '洪峰';
          tempdata[i].number = '20262010061';
        }
        this.tableData = tempdata;
    },
    getname3table(){
        this.showname2=false;
        this.showname1=false;
        this.showname3=true;
        let num = 10;
        let tempdata  = [];
        for(let i = 0;i<num;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].index = i+1;
          tempdata[i].date = this.date_y_m_d;
          tempdata[i].name = '洪峰02';
          tempdata[i].number = '20262010061';
        }
        this.tableData = tempdata;
    },
    handleprojectselect(){
      console.log(this.project);
    },

    //获取所选日期、项目数据
    getPjData() {
      [
                {value: '3', label: '体温状况'},
                {value: '4', label: '是否咳嗽乏力'},
                {value: '5', label: '是否与国内中高风险地区人员有较为密切的接触'},
                {value: '6', label: '是否处于隔离期'},
                {value: '7', label: '是否接触确诊/疑似人群'},
              ],
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
          this.showpie = true;
          this.showtreblepie = false;
          this.piedata.title = `${this.date_y_m_d}未按时上报人数统计`;
          this.piedata.name1 = '已按时上报';
          this.piedata.name2 = '未按时上报';
          this.piedata.data1 = 40;
          this.piedata.data2 = 30;
          break;

        case '1':
          this.showpie = true;
          this.showtreblepie = false;
          this.piedata.title = `${this.date_y_m_d}是否在校人数统计`;
          this.piedata.name1 = '在校';
          this.piedata.name2 = '不在校';
          this.piedata.data1 = 65;
          this.piedata.data2 = 5;
        break;

        case '2':
          this.showpie = false;
          this.showtreblepie = true;
          this.treblepiedata.title = `${this.date_y_m_d}是否发烧人数统计`;
          this.treblepiedata.name1 = '37.2度以下(体温正常)';
          this.treblepiedata.name2 = '37.8-38';
          this.treblepiedata.name3 = '38度以上';
          this.treblepiedata.data1 = 60;
          this.treblepiedata.data2 = 10;
          this.treblepiedata.data3 = 10;
        break;

        case '3':
          this.showpie = true;
          this.showtreblepie = false;
          this.piedata.title = `${this.date_y_m_d}是否咳嗽人数统计`;
          this.piedata.name1 = '咳嗽';
          this.piedata.name2 = '不咳嗽';
          this.piedata.data1 = 50;
          this.piedata.data2 = 20;
        break;

        case '4':
          this.showpie = true;
          this.showtreblepie = false;
          this.piedata.title = `${this.date_y_m_d}是否与国内中高风险地区人员有较为密切的接触人数统计`;
          this.piedata.name1 = '有密切接触';
          this.piedata.name2 = '无密切接触';
          this.piedata.data1 = 69;
          this.piedata.data2 = 11;
        break;

        case '5':
          this.showpie = true;
          this.showtreblepie = false;
          this.piedata.title = `${this.date_y_m_d}是否处在隔离期人数统计`;
          this.piedata.name1 = '在隔离期内';
          this.piedata.name2 = '不在在隔离期内';
          this.piedata.data1 = 61;
          this.piedata.data2 = 18;
        break;

        case '6':
          this.showpie = true;
          this.showtreblepie = false;
          this.piedata.title = `${this.date_y_m_d}是否接触确认/疑似病例人数统计`;
          this.piedata.name1 = '接触过';
          this.piedata.name2 = '没有接触过';
          this.piedata.data1 = 70;
          this.piedata.data2 = 3;
        break;
      }
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
      else if(this.showname2 === true)
        export2Excel(this.columns,this.tableData,`${this.date_y_m_d}${this.piedata.name2}名单`);
      else
        export2Excel(this.columns,this.tableData,`${this.date_y_m_d}${this.piedata.name3}名单`);
    }
  },
  components: { Pie,Form,TreblePie }
}
</script>

<style>
  .li{
    float:left
  }
</style>