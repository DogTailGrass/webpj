<template>
  <div>
    <el-table
      :data="ComponentData"
      height="250"
      style="width: 100%">
      <el-table-column
        prop="index"
        label="序号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="date"
        label="日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="number"
        label="学工号">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  props:['ComponentData'],
  //  props:{
  //      ComponentData:{
  //          type: Array,
  //          default: function() {
  //          }
  //      }
  //  },
  data() {
    return {
    };
  },
  created(){
    //console.log("表格子组件");
    //console.log(this.ComponentData);
  },
  mounted(){
  },
  methods:{
  }
}
</script>

<style>
  .li{
    float:left
  }
</style>