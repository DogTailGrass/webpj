<template>
<div>
  <el-table
    :data="tableData"
    border
    :fit='true' 
    :row-class-name="tableRowClassName"
    style="width: 100%">
    <el-table-column prop="idx" label="序号" width="50"></el-table-column>
    <el-table-column prop="name" label="学生姓名" width="200"></el-table-column>
    <el-table-column prop="number" label="学工号" width="200"></el-table-column>
    <el-table-column label="操作"  width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="medium">重置密码</el-button>
        <el-button @click="handledelete(scope.row)" type="text" size="medium">忽略</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog title="公告" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true" :show-close="true" :center="true">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm"
      label-width="100px" class="demo-ruleForm">
      <el-form-item label="新密码" prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</div>
</template>
<script>
import {pushpersonalinfo} from '@/api/studentapi/pushpersonalinfo'
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
        }
      };
      return {
        dialogVisible:false,
        tableData:[],
        ruleForm: {
          pass: '',
          checkPass: ''
        },
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
        //打桩
        let tempdata  = [];
        for(let i = 0;i<5;i++)
          {
            tempdata[i] = new Object();
            tempdata[i].idx = i+1;
            tempdata[i].name ="郑海关";
            tempdata[i].number = '20262010061';
          }
        this.tableData = tempdata;
    },
    methods: {    
      tableRowClassName({row, rowIndex}) {
            row.row_index = rowIndex + 1;
        },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleClick(row){
        console.log(row.row_index);
        this.dialogVisible = true;
        let idx = row.row_index - 1;
      },
      handledelete(row){
        alert("删除成功");
      },
    }
  }
</script>