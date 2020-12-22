<template>
  <div class="login-container">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px" class="login-form">
      <h2 class="login-title">管理员系统</h2>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" show-password></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {adminlogin, getAdminInfo} from '@/api/adminapi/login'
export default {
  data() {
    return {
      form: {
        username: "",
        password: ""
      },
      rules:{
          username:[
              {required: true, message:"用户名不能为空", trigger: 'blur'},
              {min: 3, max: 10, message: "用户名3-10位", trigger: 'blur'}
          ],
          password:[
              {required: true, message:"密码不能为空", trigger: 'blur'},
              {min: 3, max: 10, message: "密码3-10位", trigger: 'blur'}
          ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
      //console.log(valid)
      if (valid) {
        adminlogin(this.form.username, this.form.password).then(response => {
        console.log(valid);
        const res = response.data;
        console.log(res, res.flag, res.data.token, res.message);
        if (res.flag) {
          // 验证成功，通过token获取用户信息
          getAdminInfo(res.data.token).then(response => {
            const res = response.data;
            if (res.flag) {
            // 验证成功，通过token获取用户信息
              getStudentInfo(res.token).then(response => {
              const resUser = response.data;
              if (resUser.flag) {
              //获取用户信息并保存
                sessionStorage.setItem("user-token", res.data.token);
                sessionStorage.setItem("useraddr",resUser.addr);
                sessionStorage.setItem("userphone",resUser.phone);
                sessionStorage.setItem("username", this.form.username);
              // 前往首页
              this.$router.push("/adminhomepage");
              } 
              else {
              // 使用elementui的消息提示
                this.$message({
                  message: resUser.message,
                  type: "warning"
                });
              }
              });
            }
          })
        }
        else {
            // 未通过，弹出警告
            // 使用elementui的消息提示
            this.$message({
            message: res.message,
            type: "warning"
            });
        }
        })
        .catch(() => {
          console.log("failed");
          //打桩
          sessionStorage.setItem("user-token", "admin");
          this.$router.push("/adminhomepage");
        });
      } 
      else {
        console.log('验证失败');
        return false;
      }
    });
       }
  }
};
</script>

<style acoped>
.login-form {
  width: 350px;
  margin: 160px auto; /* 上下间距160px，左右自动居中*/
  background-color: rgb(255, 255, 255, 0.8); /* 透明背景色 */
  padding: 30px;
  border-radius: 20px; /* 圆角 */
}

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