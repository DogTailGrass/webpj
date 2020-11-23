<template>
<div>
    <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="textarea">
    </el-input>
    <br></br>
</div>
</template>
<script>
  export default {
    data() {
      return {
        textarea: ''
      };
    },
    methods: {
      
    }
  }
</script>