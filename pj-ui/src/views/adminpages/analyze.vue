<template>
  <div>
    <Pie 
      :ComponentData='piedata'>
    </Pie>
    <div>
    <ChartLine 
      :ComponentData='chartlinedata'>
    </ChartLine>
    </div>
  </div>
</template>

<script>// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入饼状图组件
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')


import {getuserinfo} from '@/api/getinfo'
import ChartLine from '@/components/chartline'
import Pie from '@/components/pie'
export default {
  data() {
    return {
      nowDate: '',
      tableData: [],
      chartlinedata:[],
      piedata:{
        hassubmited:55,
        notsubmited:15
      }     
    };
  },
  created(){
    
      this.getcurrentData();
  },
  mounted(){
    //this.getcurrentData();
  },
  methods:{
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
      this.chartlinedata[0] = 10;
      this.chartlinedata[1] = 20;
      this.chartlinedata[2] = 30;
      this.chartlinedata[3] = 15;
      this.chartlinedata[4] = 18;
      this.chartlinedata[5] = 50;
      this.chartlinedata[6] = 20;
      
      console.log(this.nowDate);
    }
  },
  components: { ChartLine,Pie }
}
</script>

<style>
  .li{
    float:left
  }
</style>