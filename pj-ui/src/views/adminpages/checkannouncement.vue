<template>
<div>
  <el-table
    :data="tableData"
    border
    :fit='true' 
    :row-class-name="tableRowClassName"
    style="width: 100%">
    <el-table-column
      prop="idx"
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
        <el-button @click="handleClick(scope.row)" type="text" size="medium">查看</el-button>
        <el-button @click="open(scope.row)" type="text" size="medium">删除</el-button>
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
import {get_all_announcement} from '@/api/studentapi/getannouncement'
    export default {
    data() {
      return {
        tableData:[],
        dialogVisible:false,
        delete_confim_dialogVisible:false,
        delete_confim:false,
        announcement:'',
        publishtime:''
      };
    },
    created(){
      function add0(m){return m<10?'0'+m:m }
      get_all_announcement(sessionStorage.getItem("user-id")).then(response => {
        if(response.flag){
          let res = response.data;
          for(let i = 5;i<res;i++)
          {
            tempdata[i] = new Object();
            tempdata[i].idx = i+1;
            tempdata[i].title="紧急调查2";
            tempdata[i].publishdate = nowDate;
            tempdata[i].publishtime = time;
            tempdata[i].announcement="一行白鹭上青天";
          }
        this.tableData = tempdata;
          this.announce = res.announce;
        }
      })
      .catch(() => {
        let date = new Date(1608264000000);
        let year = date.getFullYear(); // 年
        let month = date.getMonth() + 1; // 月
        let day = date.getDate(); // 日
        let hour = date.getHours();
        let min = date.getMinutes();
        let sec = date.getSeconds();
        let nowDate = `${year}/${month}/${day}`;
        //let time =`${hour}:${min}:${sec}`;
        let time = add0(hour) + ':' + add0(min) + ':' + add0(sec);
        
        let tempdata  = [];
        for(let i = 0;i<5;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].idx = i+1;
          tempdata[i].title="紧急调查1";
          tempdata[i].publishdate = nowDate;
          tempdata[i].publishtime = time;
          tempdata[i].announcement="门前大桥下，游来一群鸭";
        }
        for(let i = 5;i<10;i++)
        {
          tempdata[i] = new Object();
          tempdata[i].idx = i+1;
          tempdata[i].title="紧急调查2";
          tempdata[i].publishdate = nowDate;
          tempdata[i].publishtime = time;
          tempdata[i].announcement="一行白鹭上青天";
        }
        this.tableData = tempdata;

        
      });
    },
    methods:{
        tableRowClassName({row, rowIndex}) {
            row.row_index = rowIndex + 1;
        },
      handleClick(row){
        console.log(row.row_index);
        this.dialogVisible = true;
        let idx = row.row_index - 1;
        this.announcement = this.tableData[idx].announcement;
      },
      handledelete(row){
        //删除一列数据
        let length = this.tableData.length;
        this.tableData.splice(row.row_index - 1,1);
        for(let i = row.row_index-1;i<length-1;i++)
        {
            console.log(this.tableData[i]);
            this.tableData[i].idx = i +1;
        }
      },
      handledialogconfim(){
        this.dialogVisible = false;
      },
      open(row) {
        this.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.handledelete(row);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      
    }
  }

</script>

