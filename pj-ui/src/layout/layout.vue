<template>
  <el-container>
      <SideBar></SideBar>
      <el-main>
          <template>
              <AppMain></AppMain>
          </template>
      </el-main>
  </el-container>
</template>

<script>
import SideBar from '@/layout/sidebar/sidebar'
import AppMain from '@/layout/appmain'
export default {
    data(){
        return {

        }
    },
    components:{SideBar,AppMain}
}
</script>