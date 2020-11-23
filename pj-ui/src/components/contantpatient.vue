<template>
<div>
    <i>今日是否接触确诊/疑似人群？</i>
    <el-select v-model="value" placeholder="请选择" @change="handlecontantpatinent">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
    </el-select>
</div>
</template>
<script>
  export default {
    data() {
      return {
        options: [{
          value: '1',
          label: '是'
        }, {
          value: '0',
          label: '否'
        }],
        value: ''
      };
    },
    methods: {
        handlecontantpatinent(vaule){
            sessionStorage.setItem("iscontantpatient",vaule);
        }
    }
  }
</script>