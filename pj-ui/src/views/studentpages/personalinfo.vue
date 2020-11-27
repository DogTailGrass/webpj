<template>
<div>
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item label="姓名" prop="personalname">
        <el-input v-model="form.personalname"></el-input>
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
    export default {
    data() {
      return {
        form: {
        personalname: '',
        addr: '',
        phonenumber:''
        }
      };
    },
    created(){
      this.form.personalname = sessionStorage.getItem("username");
      this.form.addr = sessionStorage.getItem("useraddr");
      this.form.phonenumber = sessionStorage.getItem("userphone");
    },
    methods: {    
      handledialogcancel(){
        this.form.personalname = sessionStorage.getItem("username");
        this.form.addr = sessionStorage.getItem("useraddr");
        this.form.phonenumber = sessionStorage.getItem("userphone");
      },
      handledialogconfim(){
        let personalinfo={};
        personalinfo.name = this.form.personalname;
        personalinfo.addr = this.form.addr;
        personalinfo.phonenumber = this.form.phonenumber;
        pushpersonalinfo(sessionStorage.getItem("user-token"),personalinfo).then(response => {
            const res = response.data;
            if(res.flag){
              alert("提交成功");
              sessionStorage.setItem("username",this.form.personalname);
              sessionStorage.setItem("useraddr",this.form.addr);
              sessionStorage.setItem("userphone",this.form.phonenumber);
            }
            //console.log(res, res.flag, res.data.token, res.message);
            })
            .catch(() => {
              console.log("failed");
              alert("提交失败");
              //打桩
              sessionStorage.setItem("username",this.form.personalname);
              sessionStorage.setItem("useraddr",this.form.addr);
              sessionStorage.setItem("userphone",this.form.phonenumber);
            });
      }    
    },
    components: {  }
  }

</script>

