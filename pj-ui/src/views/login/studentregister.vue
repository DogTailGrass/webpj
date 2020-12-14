<template>
  <div class="login-container">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px" class="login-form">
      <h2 class="login-title">学生系统注册</h2>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item label="学工号" prop="number">
        <el-input v-model="form.number"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="联系方式" prop="phonenumber">
        <el-input v-model="form.phonenumber"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {studentregister} from '@/api/studentapi/register'
export default {
  data() {
    return {
      form: {
        username: "",
        password: "",
        number:"",
        email:"",
        phonenumber:""
      },
      rules:{
          username:[
              {required: true, message:"用户名不能为空", trigger: 'blur'},
              {min: 3, max: 10, message: "用户名3-10位", trigger: 'blur'}
          ],
          password:[
              {required: true, message:"密码不能为空", trigger: 'blur'},
              {min: 3, max: 10, message: "密码3-10位", trigger: 'blur'}
          ],
          number:[
              {required: true, message:"学工号不能为空", trigger: 'blur'}
          ],
          email:[
              {required: true, message:"邮箱不能为空", trigger: 'blur'}
          ],
          phonenumber:[
              {required: true, message:"联系方式不能为空", trigger: 'blur'}
          ]
      }
    };
  },
  methods: {
    submitForm(formName) {
        this.$refs[formName].validate(valid => {
        //console.log(valid)
        if (valid) {
            studentregister(this.form).then(response => {
            const res = response.data;
            if (res.flag) {
              // 注册成功，给用户提示
                alert("注册成功");
                this.$router.push("/studenthomepage");
            }
            else {
                alert("注册失败，请重试");
            }
            })
            .catch(() => {
              alert("注册成功");
              console.log("failed");
              this.$router.push("/studenthomepage");
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