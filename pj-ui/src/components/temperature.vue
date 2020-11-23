<template>
<div>
    <i>今日体温</i>
    <el-select v-model="value" placeholder="请选择" @change="handlefever">
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
          value: '0',
          label: '37.2度及以下（正常）'
        }, {
          value: '1',
          label: '37.3-38'
        },{
          value: '2',
          label: '38度以上'
        }],
        value: ''
      };
    },
    methods: {
        handlefever(vaule){
            sessionStorage.setItem("temperature",vaule);
        }
    }
  }
</script>