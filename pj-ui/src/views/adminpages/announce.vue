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
        
      }    
    },
    components: {  }
  }

</script>

