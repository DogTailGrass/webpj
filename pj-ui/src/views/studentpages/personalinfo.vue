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
import {pushpersonalinfo} from '@/api/studentapi/pushpersonalinfo'
import {studentlogin, getStudentInfo} from '@/api/studentapi/login'
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
    this.getuserinfo();
  },
  methods: {    
    getuserinfo(){
      getStudentInfo(sessionStorage.getItem("user_id")).then(response => {
        const resUser = response.data;
        if (resUser.flag) {
            //获取用户信息，填入表格并保存
            this.form.personalname = resUser.username;
            this.form.addr = resUser.address;
            this.form.phonenumber = resUser.mobile;
            this.form.school = resUser.school;
            this.form.category = resUser.category;
            this.form.type = resUser.type;
            this.form.teacher_name = resUser.teacher_name;
            let objStr = JSON.stringify(this.form)
            sessionStorage.setItem("student_personalinfo", objStr);
        } 
        else {
          alert("获取用户信息失败，请联系管理员");
        }
        })
        .catch(() => {
          //alert("获取用户信息失败，请联系管理员");
          //打桩代码
          this.form.personalname = '郑海关';
          this.form.addr = '杨浦区';
          this.form.phonenumber = '18761880125';
          this.form.school = '软件学院';
          this.form.category = '研究生';
          this.form.type = '非全日制';
          this.form.teacher_name = '廖炳辉';
          let objStr = JSON.stringify(this.form)
          sessionStorage.setItem("student_personalinfo", objStr);
        });
    },
    handledialogcancel(){
      let temp = sessionStorage.getItem("student_personalinfo");
      let info = JSON.parse(temp);
      this.form = info;
      console.log(info.personalname);
    },
    handledialogconfim(){
      let personalinfo=new Object();
      personalinfo.addr = this.form.addr;
      personalinfo.phonenumber = this.form.phonenumber;
      pushpersonalinfo(sessionStorage.getItem("user_id"),personalinfo).then(response => {
          const res = response.data;
          if(res.flag){
            alert("提交成功");
            let objStr = JSON.stringify(this.form)
            sessionStorage.setItem("student_personalinfo", objStr);
          }
          else{
            alert("提交失败，请重试或联系管理员");
          }
          //console.log(res, res.flag, res.data.token, res.message);
          })
          .catch(() => {
            alert("提交失败，请重试或联系管理员");
            //打桩
            let objStr = JSON.stringify(this.form)
            sessionStorage.setItem("student_personalinfo", objStr);
            let temp = sessionStorage.getItem("student_personalinfo");
            let info = JSON.parse(temp);
            this.form = info;
            console.log(info.addr);
          });
    }    
  },
  components: {  }
}

</script>

