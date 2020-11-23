<template>
<div>
    <el-input type="textarea" :rows="2" placeholder="其他需要备注的信息" v-model="textarea">
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