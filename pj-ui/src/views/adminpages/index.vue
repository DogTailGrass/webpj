<template>
  <div>
    <div>
    <Form
      :ComponentData='tableData'>
    </Form>
    </div>
    <el-button type="primary" @click="exportdate()">表格导出</el-button>
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')
import { export2Excel } from '@/utils/excel.js'

import {getReportInfo} from '@/api/adminapi/getreportinfo'
import Form from '@/components/notsubmitedform'
export default {
  data() {
    return {
      nowDate: '',
      tableData: [],
      columns:[{title:'日期',key:'date'},{title:'姓名',key:'name'},{title:'学工号',key:'number'}]
    };
  },
  created(){
      this.getcurrentData();
  },
  mounted(){
    let date = new Date();
    let year = date.getFullYear(); // 年
    let month = date.getMonth() + 1; // 月
    let day = date.getDate(); // 日
    this.nowDate = `${year}/${month}/${day}`;
    console.log(this.nowDate);
  },
  methods:{
    getcurrentData() {
      getReportInfo(localStorage.getItem("user-token")).then(response => {
        let res = response.data;
        for(let i = 0;i<res.form.num;i++)
        {
          this.tableData[i] = new Object();
          this.tableData[i].date = this.nowDate;
          this.tableData[i].name = res.form.formdata[i].name;
          this.tableData[i].number = res.form.formdata[i].number;
        }
      })
      .catch(() => {
        console.log("failed");
        //打桩
       
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

      });
    },
    exportdate(){
      console.log("expertdate");
        export2Excel(this.columns,this.tableData);

    }
  },
  components: { Form }
}
</script>

<style>
  .li{
    float:left
  }
</style>