<template>
    <div style="background-color: #EBEBEB;min-height:800px">
        <div style="width:100%;background-color: #636363; overflow: hidden">
            <span class="demonstration" style="float:left;padding-top:10px;color:white;margin-left:1%">
                学生系统
            </span>
            <span class="demonstration" style="float:left;padding-top:10px;color:white;margin-left:10%">
                当前时间:{{time}}
            </span>
            <span class="demonstration" style="float:right;padding-top:10px;margin-right:1%">
                <el-dropdown trigger="click">
                  <span class="el-dropdown-link" style="color:white">
                    个人中心
                  <i class="el-icon-caret-bottom el-icon--right"></i>
                  </span>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="changePassword">修改密码</el-dropdown-item>
                    <el-dropdown-item @click.native="handlelogout">退出登录</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
            </span>
        </div>
        
        <div style="margin-top:5px">
            <el-row :gutter="10">
                <el-col :xs="4" :sm="4" :md="4" :lg="4">
                    <div>
                        <el-menu default-active="0" class="el-menu-vertical-demo" style="min-height:800px" 
                        @select="handleSelect">
                            <router-link to="/studenthomepage/studentreport">
                                <el-menu-item index="1"><i class="el-icon-message"></i>每日信息上报</el-menu-item>
                            </router-link>
                            <router-link to="/studenthomepage/personalinfo">
                                <el-menu-item index="2"><i class="el-icon-menu"></i>修改个人信息</el-menu-item>
                            </router-link>
                            <router-link to="/studenthomepage/viewannouncement">
                                <el-menu-item index="3"><i class="el-icon-setting"></i>查看公告</el-menu-item>
                            </router-link>
                        </el-menu>
                    </div>
                </el-col>
                <el-col :xs="20" :sm="20" :md="20" :lg="20">
                    <div>
                        <div style="border: 1px solid #A6A6A6; border-radius:6px; padding:5px; margin:2px; background-color: white">
                            <el-breadcrumb separator="/">
                                <el-breadcrumb-item v-for="item in breadcrumbItems" :key="item.id">{{item}}</el-breadcrumb-item>
                            </el-breadcrumb>
                        </div>
                    </div>
                    <div style="margin-top:10px">
                        <router-view></router-view>
                    </div>
                </el-col>
            </el-row>
        </div>

        <el-dialog title="最新公告" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true" :show-close="true" :center="true">
            <el-input v-model="announce" type="textarea" :rows="15"></el-input>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click.native="handledialogconfim">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script type="text/ecmascript-6">
import {get_newest_announcement} from '@/api/studentapi/getannouncement'
export default {
    data(){
        return {
            searchCriteria: '',
            breadcrumbItems: ['学生系统'],
            dialogVisible:false,
            announce:'',
            time:new Date()
        }
    },
    created(){
        get_newest_announcement(sessionStorage.getItem("user-id")).then(response => {
            const res = response.data;
            if(res.flag){
                this.dialogVisible = true;
                //添加判断逻辑，显示第一条公告
                this.announce = res.announce;
                //this.$router.push("/studenthomepage/viewannouncement");     
            }
        })
        .catch(() => {
            this.dialogVisible = true;
            this.announce = '门前大桥下';
            console.log("fail");
            
        });
        
    },
    mounted(){
        let _this = this; // 声明一个变量指向Vue实例this，保证作用域一致
        this.timer = setInterval(() => {
        let today=new Date();
        let h=today.getHours();
        let m=today.getMinutes();
        let s=today.getSeconds();
        // add a zero in front of numbers<10
        m=this.checkTime(m);
        s=this.checkTime(s);
        _this.time = h+":"+m+":"+s; // 修改数据date
        }, 1000);
    },
    methods:{
        handleIconClick(ev) {
            console.log(ev);
        },
        handleSelect(key,Keypath){
            switch(key){
                case '1':
                    this.breadcrumbItems  = ['学生系统->每日信息上报']
                    break;
                case '2':
                    this.breadcrumbItems  = ['学生系统->修改个人信息']
                    break;
                case '3':
                    this.breadcrumbItems  = ['学生系统->查看公告']
                    break;
            }
        },
        handlelogout(){
            console.log("handlelogout");
            this.$router.push("/studentlogin");
        },
        handledialogconfim(){
            this.dialogVisible = false;
            //this.$router.push("/studenthomepage/firstpage"); 
        },
        checkTime(i){
            if (i<10) {
                i="0" + i
            }
            return i
        },
        changePassword(){
            this.breadcrumbItems  = ['学生系统->修改密码']
            this.$router.push("/studenthomepage/changepassword");     

        },
    },
    beforeDestroy() {
        if (this.timer) {
        clearInterval(this.timer); // 在Vue实例销毁前，清除我们的定时器
        }
    }
}
</script>