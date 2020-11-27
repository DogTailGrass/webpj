<template>
<div>
    <el-input v-model="announce" type="textarea" :rows="15"></el-input>
</div>
</template>
<script>
import {getannouncement} from '@/api/studentapi/getannouncement'
    export default {
    data() {
      return {
        announce:'暂无通知'
      };
    },
    created(){
      getannouncement(sessionStorage.getItem("user-token")).then(response => {
        const res = response.data;
        if(res.flag){
          this.announce = res.announce;
        }
      })
      .catch(() => {
        this.announce = localStorage.getItem("announce");
        console.log("fail");
      });
    }
  }

</script>

