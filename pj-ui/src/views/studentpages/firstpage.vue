<template>
    <div>
        <el-input v-model="comment" type="textarea" autosize></el-input>
    </div>
</template>
<script>
import {getannouncement} from '@/api/studentapi/getannouncement'
export default {
    data() {
        return {
            comment:'欢迎使用本系统，如有建议，请联系管理员反馈'
        };
    },
    created(){
    },
    methods:{
    }
  }

</script>

