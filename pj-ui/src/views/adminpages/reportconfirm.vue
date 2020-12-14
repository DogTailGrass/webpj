<template>
  <div>
    <div>
    <Form
      :ComponentData='tableData'>
    </Form>
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
import Form from '@/components/notsubmitedform'
export default {
  data() {
    return {
      nowDate: '',
      tableData: []
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
        let res = response.data;
        for(let i = 0;i<res.form.num;i++)
        {
          this.tableData[i] = new Object();
          this.tableData[i].date = this.nowDate;
          this.tableData[i].name = res.form.formdata[i].name;
          this.tableData[i].number = res.form.formdata[i].number;
        }

      });
      let num = 20;
      for(let i = 0;i<num;i++)
      {
        this.tableData[i] = new Object();
        this.tableData[i].date = this.nowDate;
        this.tableData[i].name = '郑海关';
        this.tableData[i].number = '20262010061';
      }
      
      
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