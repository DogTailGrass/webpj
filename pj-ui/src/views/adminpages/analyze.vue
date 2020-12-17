<template>
  <div>
    <div class="block">
      <span class="demonstration">日期</span>
      <el-date-picker
        v-model="select_date"
        type="date"
        format="yyyy-M-d"
        value-format="timestamp"
        placeholder="选择日期"
        @change="selctdate">
      </el-date-picker>
      <span>选择查询项目</span>
      <el-select v-model="value" placeholder="请选择" @change="handlefever">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </div>
  <div>
    
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
    </div>
    <div class = "li" >
      <li>近一周未按时上报人数变化趋势</li>
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
export default {
  data() {
    return {
      select_date:'',
      date:'',
      showtable:false,
      shownotsubmit:false,
      showsubmit:false,
      nowDate: '',
      chartlinedata:[],
      tableData: [],
      piedata:{
        hassubmited:0,
        notsubmited:0
      },
      options: [{value: '1',label: '是'}, 
                {value: '0', label: '否'}
              ],     
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
      this.chartlinedata = new Array();
      this.chartlinedata[0] = 10;
      this.chartlinedata[1] = 20;
      this.chartlinedata[2] = 30;
      this.chartlinedata[3] = 15;
      this.chartlinedata[4] = 18;
      this.chartlinedata[5] = 50;
      this.chartlinedata[6] = 20;

      this.piedata = new Object();
      this.piedata.hassubmited = 46;
      this.piedata.notsubmited = 32;
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
        //this.issubmited = false;
        //this.$router.push("/pieview");
      });      
      this.chartlinedata = new Array();
      this.chartlinedata[0] = 50;
      this.chartlinedata[1] = 20;
      this.chartlinedata[2] = 30;
      this.chartlinedata[3] = 15;
      this.chartlinedata[4] = 18;
      this.chartlinedata[5] = 50;
      this.chartlinedata[6] = 20;
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
  },
  components: { ChartLine,Pie,Form }
}
</script>

<style>
  .li{
    float:left
  }
</style>