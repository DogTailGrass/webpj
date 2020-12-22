<template>
  <div class="login-container">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px" class="login-form">
      <h2 class="login-title">学生系统</h2>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" show-password></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">登录</el-button>
        <el-button @click="handleforgetpassword()">忘记密码</el-button>
      </el-form-item>
    </el-form>

    <el-dialog title="申请重置密码" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true" :show-close="true" :center="true">
      <el-form :rules="resetpasswordrules" :model="resetpasswordform" label-width="80px">
      <el-form-item label="姓名" prop="username">
        <el-input v-model="resetpasswordform.username"></el-input>
      </el-form-item>
      <el-form-item label="学工号" prop="number">
        <el-input v-model="resetpasswordform.number"></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="resetpasswordform.phone"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click.native="resetpasswordcancel">取 消</el-button>
      <el-button type="primary" @click.native="applyresetpassword">确 定</el-button>
    </span>
  </el-dialog>
  </div>
</template>
<script>
import {studentlogin, getStudentInfo} from '@/api/studentapi/login'
export default {
  data() {
    return {
      dialogVisible:false,
      form: {
        username: "",
        password: ""
      },
      rules:{
          username:[
              {required: true, message:"用户名不能为空", trigger: 'blur'}
          ],
          password:[
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
        studentlogin(this.form.username, this.form.password).then(response => {
        if (response.flag) {
          // 验证成功，获取用户id
          let res = response.data;
          sessionStorage.setItem("user_id", res.user_id);
        }
        else {
            // 未通过，弹出警告
            alert("登录失败，请联系系统管理员");
        }
        })
        .catch(() => {
          console.log("failed");
          //打桩
          sessionStorage.setItem("user_id", "123");              
          this.$router.push("/studenthomepage");
        });
      } 
      else {
        console.log('验证失败');
        return false;
      }
      });
   },

    handleforgetpassword(){
      this.dialogVisible = true;
    },
    applyresetpassword(){
      console.log("applyresetpassword");
      this.dialogVisible = false;
    },
    resetpasswordcancel(){
      this.dialogVisible = false;
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