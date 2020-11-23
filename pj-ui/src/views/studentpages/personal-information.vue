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
</div>
</template>
<script>
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
      
    },
    methods: {        
    },
    components: {  }
  }

</script>

