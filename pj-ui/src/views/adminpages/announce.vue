<template>
<div>
    <el-input v-model="announce" type="textarea" :rows="15" placeholder="请输入内容"></el-input>
     <span slot="footer" class="dialog-footer">
        <el-button @click="handledialogcancel">取 消</el-button>
        <el-button type="primary" @click="handledialogconfim">发 布</el-button>
    </span>
</div>
</template>
<script>
import {pushannouncement} from '@/api/adminapi/pushannouncement'
    export default {
    data() {
      return {
        announce:''
      };
    },
    created(){
      
    },
    methods: {    
      handledialogcancel(){
        this.announce = '';
      },
      handledialogconfim(){
        pushannouncement(sessionStorage.getItem("user-token",this.announce)).then(response => {
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
      }    
    },
    components: {  }
  }

</script>

