<template>
<div>
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm"
      label-width="100px" class="demo-ruleForm">
      <el-form-item label="新密码" prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div v-if="checkpasssuccess">
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
    </div>
</div>
</template>
<script>
import {modifyPwd} from '@/api/studentapi/changepassword'
    export default {
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
          this.checkpasssuccess = true;
        }
      };
      return {
        ruleForm: {
          pass: '',
          checkPass: ''
        },
        checkpasssuccess:false,
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        }
      };
    },
    created(){
      if(sessionStorage.getItem("login_status") !== "1")
      {
          this.$router.push("/studentlogin");
          console.log("登录状态有错误");
          return;
      }
    },
    methods: {    
      submitForm(formName) {
          this.$refs[formName].validate((valid) => {
          if (valid) 
          {
            modifyPwd(sessionStorage.getItem("user_id"),this.ruleForm.pass).then(response => {
              const res = response.data;
              console.log(response);
              if(res.code === 200){
                  alert('修改成功!');
              }
            })
            .catch(() => {
                alert('修改失败!');
                console.log("fail");
            });
            
          } 
          else {
            console.log('error submit!!');
            return false;
          }
        });
      },
    }
  }
</script>