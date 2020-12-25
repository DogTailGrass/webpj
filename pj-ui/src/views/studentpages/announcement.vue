<template>
<div>
  <el-table
    :data="tableData"
    border
    :fit='true' 
    style="width: 100%">
    <el-table-column
      prop="index"
      label="序号"
      width="50">
    </el-table-column>
    <el-table-column
      prop="title"
      label="公告标题"
      width="400">
    </el-table-column>
    <el-table-column
      prop="publishdate"
      label="发布日期"
      width="200">
    </el-table-column>
    <el-table-column
      prop="publishtime"
      label="发布时间"
      width="200">
    </el-table-column>
    <el-table-column
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog title="公告" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true" :show-close="true" :center="true">
      <el-input v-model="announcement" type="textarea" :rows="10"></el-input>
      <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click.native="handledialogconfim">确 定</el-button>
      </span>
  </el-dialog>
</div>
</template>
<script>
import {get_notice} from '@/api/studentapi/getannouncement'
    export default {
    data() {
      return {
        tableData:[],
        dialogVisible:false,
        announcement:'',
        publishtime:''
      };
    },
    created(){
      if(sessionStorage.getItem("login_status") !== "1")
      {
          this.$router.push("/studentlogin");
          console.log("登录状态有错误");
      }
      else
      {
        this.get_announce();
      }
    },
    methods:{
      get_announce(){
        get_notice().then(response => {
        const res = response.data;
        console.log(response);
        if(res.code === 200){
          let announce = res.data;
          let tempdata  = [];
          for(let i = 0;i<announce.length;i++)
          {
            tempdata[i] = new Object();
            tempdata[i].index = i + 1;
            tempdata[i].title=announce[i].title;
            let date = new Date(announce[i].validDate);
            let year = date.getFullYear(); // 年
            let month = date.getMonth() + 1; // 月
            let day = date.getDate(); // 日
            let hour = date.getHours();
            let min = date.getMinutes();
            let sec = date.getSeconds();
            let validDate = `${year}/${month}/${day}`;
            let time =`${hour}:${min}:${sec}`;
            tempdata[i].publishdate = validDate;
            tempdata[i].publishtime = time;
            tempdata[i].announcement=announce[i].content;
          }
          this.tableData = tempdata;
          sessionStorage.setItem("announce_loaded",1);
          let objStr = JSON.stringify(this.tableData)
          sessionStorage.setItem("announcement", objStr);
        }
        })
        .catch(() => {
          alert("服务器返回数据失败");
        });
      },
      handleClick(row){
        console.log(row.index);
        this.dialogVisible = true;
        let idx = row.index;
        console.log(this.tableData[idx-1]);
        this.announcement = this.tableData[idx-1].announcement;

      },
      handledialogconfim(){
        this.dialogVisible = false;
      }
    }
  }

</script>

