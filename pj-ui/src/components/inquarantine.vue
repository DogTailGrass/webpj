<template>
<div>
    <i>是否处于隔离期？</i>
    <el-select v-model="value" placeholder="请选择" @change="handleinquarantine">
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
        handleinquarantine(vaule){
            sessionStorage.setItem("isinquarantine",vaule);
        }
    }
  }
</script>