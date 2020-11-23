<template>
<div>
    <i>今日是否咳嗽乏力？</i>
    <el-select v-model="value" placeholder="请选择" @change="handlecough">
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
        handlecough(vaule){
            sessionStorage.setItem("iscough",vaule);
        }
    }
  }
</script>