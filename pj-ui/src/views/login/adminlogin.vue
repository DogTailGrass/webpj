<template>
  <div class="login-container">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px" class="login-form">
      <h2 class="login-title">管理员系统</h2>
      <el-form-item label="用户名" prop="userId">
        <el-input v-model="form.userId"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pwd">
        <el-input v-model="form.pwd" show-password></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {adminlogin} from '@/api/adminapi/login'
export default {
  data() {
    return {
      dialogVisible:false,
      form: {
        userId: "",
        pwd: ""
      },
      rules:{
          userId:[
              {required: true, message:"用户名不能为空", trigger: 'blur'}
          ],
          pwd:[
              {required: true, message:"密码不能为空", trigger: 'blur'}
          ]
      },
      resetpasswordform:{
        username: "",
        number: "",
        phone: "",
      },
      resetpasswordrules:{
        username:[
              {required: true, message:"用户名不能为空", trigger: 'blur'}
          ],
          number:[
              {required: true, message:"学工号不能为空", trigger: 'blur'},
          ],
          phone:[
              {required: true, message:"手机号不能为空", trigger: 'blur'},
          ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
      //console.log(valid)
      if (valid) {
        adminlogin(this.form.userId, this.form.pwd).then(response => {
          console.log(response);
          let res = response.data;
          console.log(res.code);
        if (res.code === 200) {
          // 验证成功，获取用户id
          //let res = response.data;
          sessionStorage.setItem("user_id", res.data.userId);
          sessionStorage.setItem("user_name", res.data.userName);
          this.$router.push("/adminhomepage");
          sessionStorage.setItem("login_status",1);
        }
        else{
            // 未通过，弹出警告
            alert("登录失败，请联系开发人员");
        }
        })
        .catch(() => {
          alert("failed");
          sessionStorage.setItem("login_status",1);
          this.$router.push("/adminhomepage");
          //console.log("failed");
          //打桩
          //sessionStorage.setItem("user_id", "123");              
          //this.$router.push("/studenthomepage");
        });
      } 
      else {
        console.log('验证失败');
        return false;
      }
      });
   },
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