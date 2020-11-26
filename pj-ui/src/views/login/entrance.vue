<template>
  <div class="login-container">
    <el-button type="primary" @click="studentlogin('form')">学生登录入口</el-button>
    <el-button type="primary" @click="adminlogin('form')">管理员登录入口</el-button>
  </div>
</template>
<script>
export default {
  data() {
    return {
    };
  },
  methods: {
    studentlogin() {
        this.$router.push("/studentlogin");        
    },
    adminlogin(){
        this.$router.push("/adminlogin");        
    }
 }
}
</script>

<style acoped>

/* 背景 */
.login-container {
  position: absolute;
  width: 100%;
  height: 100%;
}

/* 标题 */
.login-title {
  color: #303133;
  text-align: center;
}
</style> -->