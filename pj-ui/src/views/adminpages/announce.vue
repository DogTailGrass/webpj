<template>
<div>
    <el-input v-model="title" type="textarea" :rows="1" placeholder="请输入标题"></el-input>
    <br>
    <el-input v-model="announce" type="textarea" :rows="8" placeholder="详细内容"></el-input>
    
    <div class="block">
      <el-date-picker
        v-model="select_date"
        type="datetime"
        placeholder="选择发布日期"
        default-time="12:00:00"
        :picker-options="pickerOptions"
        @change="selctdate">
      </el-date-picker>
    </div>

    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="publish_now">确认发布</el-button>
    </span>
</div>
</template>
<script>
import {pushannouncement} from '@/api/adminapi/pushannouncement'
    export default {
    data() {
      return {
        value1:'',
        title:'',
        announce:'',
        select_date:'',
        pickerOptions: {
          disabledDate(date){
            let zero=new Date().setHours(0, 0, 0, 0);
            if(date.getTime()<zero){
              return true;
            }
            return false;
          }
        },
      };
    },
    created(){
      
    },
    methods: {    
      handledialogcancel(){
        this.announce = '';
      },
      publish_now(){
        let time1 = new Date(this.select_date);
        let time2 = Date.parse(time1)/1000;
        console.log(time1);
        console.log(time2);
        pushannouncement(sessionStorage.getItem("user-id"),this.announce,time2).then(response => {
          const res = response.data;
          if(res.flag){
            console.log("success");
          }
      })
      .catch(() => {
        localStorage.setItem("announce",this.announce);
        console.log("fail");
        alert("发布成功");
      });
      },
      selctdate(val){
      //  console.log(this.select_date);
      //  console.log(val);
      },
    },
    components: {  }
  }

</script>

