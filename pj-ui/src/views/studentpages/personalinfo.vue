<template>
<div>
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item label="姓名" prop="personalname">
        <el-input v-model="form.personalname" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="院系" prop="school">
        <el-input v-model="form.school" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="类别" prop="category">
        <el-input v-model="form.category" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-input v-model="form.type" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="辅导员姓名" prop="teacher_name">
        <el-input v-model="form.teacher_name" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="现居住地址" prop="addr">
        <el-input v-model="form.addr"></el-input>
      </el-form-item>
      <el-form-item label="联系方式" prop="phonenumber">
        <el-input v-model="form.phonenumber"></el-input>
      </el-form-item>
    </el-form>


     <span slot="footer" class="dialog-footer">
        <el-button @click="handledialogcancel">取 消</el-button>
        <el-button type="primary" @click="handledialogconfim">确 定</el-button>
    </span>
</div>
</template>
<script>
import {getinfo} from '@/api/studentapi/pushpersonalinfo'
import {modifyinfo} from '@/api/studentapi/pushpersonalinfo'
export default {
  data() {
    return {
      form: {
        personalname: '',
        school:'',
        category:'',
        type:'',
        addr: '',
        phonenumber:'',
        teacher_name:''
      }
    };
  },
  created(){
  },
  mounted(){
    if(sessionStorage.getItem("login_status") !== "1")
    {
        this.$router.push("/studentlogin");
        console.log("登录状态有错误");
    }
    else
    {
      this.getuserinfo();
    }
    
  },
  methods: {    
    getuserinfo(){
      getinfo(sessionStorage.getItem("user_id")).then(response => {
        console.log(response);
        let res = response.data;
        console.log(res.code);
        if (res.code === 200) {
          //alert("获取用户信息成功");
          //获取用户信息，填入表格并保存
          let resUser = res.data;
          //console.log(resUser);
          //this.form.personalname = resUser.username;
          this.form.personalname = sessionStorage.getItem("user_name");
          this.form.addr = resUser.address;
          this.form.phonenumber = resUser.mobile;
          this.form.school = resUser.department;
          this.form.category = resUser.degree;
          if(resUser.fullTime === 0)
            this.form.type = '非全日制';
          else
             this.form.type = '全日制';
          this.form.teacher_name = resUser.counselorName;
          //console.log(this.form);
          let objStr = JSON.stringify(this.form)
          sessionStorage.setItem("student_personalinfo", objStr);
          sessionStorage.setItem("personalinfo_loaded",1);
        } 
        else {
          alert("获取用户信息失败，请联系管理员");
        }
      })
      .catch(() => {
        alert("服务端没有响应，请联系管理员");
      });
    },
    handledialogcancel(){
      let temp = sessionStorage.getItem("student_personalinfo");
      let info = JSON.parse(temp);
      this.form = info;
      console.log(info.personalname);
    },
    handledialogconfim(){
      let temp = sessionStorage.getItem("student_personalinfo");
      let info = JSON.parse(temp);
      if(info.addr !== this.form.addr || info.phonenumber !== this.form.phonenumber)
      {
        let personalinfo=new Object();
        personalinfo.addr = this.form.addr;
        personalinfo.phonenumber = this.form.phonenumber;
        modifyinfo(sessionStorage.getItem("user_id"),personalinfo).then(response => {
          console.log(response);
          let res = response.data;
          if(res.code === 200){
            alert("提交成功");
            let objStr = JSON.stringify(this.form)
            sessionStorage.setItem("student_personalinfo", objStr);
          }
          else{
            alert("提交失败，请重试或联系管理员");
          }
          })
          .catch(() => {
            alert("提交失败，请重试或联系管理员");
          });
      }
      
    }    
  },
  components: {  }
}

</script>

