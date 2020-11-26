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
      handledialogcancel(){
        this.form.personalname = '';
        this.form.addr = '';
        this.form.phonenumber = '';
        let obj = new Object();
        obj.form = this.form;
        obj.data = false;
        this.$emit('child-envent',obj);
      },
      handledialogconfim(){
        let obj = new Object();
        obj.form = this.form;
        obj.data = true;
        this.$emit('child-envent',obj);
      }    
    },
    components: {  }
  }

</script>

