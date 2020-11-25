<template>
    <div class="sidebar">
        <el-menu :show-timeout="200" :default-active="$route.path" :collapse="isCollapse"
            mode="vertical" background-color="#304156" text-color="#bfcbd9" active-text-color="#409EFF" router>
             <template v-for="(item,index) in routes" v-if="!item.hidden" >
                 <!-- 一级菜单 -->
                <el-menu-item :index="item.path"> 
                    <span slot="title">{{item.name}}</span>
                </el-menu-item>
                <!-- 二级菜单 -->
                <el-submenu :index="index+''">
                    <template slot="title">
                        <span>{{item.name}}</span>
                    </template>
                    <el-menu-item v-for="child in item.children" :index="child.path" v-if="!child.hidden"  :key="child.path">
                        <span>{{child.name}}</span>
                    </el-menu-item>
                </el-submenu>
             </template>
       </el-menu>
    </div>
</template>
<script>
export default {
    data(){
        return {
            isCollapse: false
        }
    },
    computed:{
        routes() {
            return this.$router.options.routes
            console.log(routes)
        },
    },
}
</script>
