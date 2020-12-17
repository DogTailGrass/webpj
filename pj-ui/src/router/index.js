import Vue from 'vue'
import Router from 'vue-router'
import StudentLogin from '@/views/login/studentlogin'
import StudentRegister from '@/views/login/studentregister'
import AdminLogin from '@/views/login/adminlogin'
import StudentReport from '@/views/studentpages/report'
import Pieview from '@/views/adminpages'
import PersonalInfo from '@/views/studentpages/personalinfo'
import StudentHomePage from '@/views/studentpages/homepage'
import AdminHomePage from '@/views/adminpages/homepage'
import Entrance from '@/views/login/entrance'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  routes: [
    {
      path: '/',
      name: 'entrance',   //路由名称
      component: Entrance //组件对象
    },
    {
      path: '/studentlogin',
      name: 'studentlogin',   //路由名称
      component: StudentLogin //组件对象
    },
    {
      path: '/studentregister',
      name: 'studentregister',   //路由名称
      component: StudentRegister //组件对象
    },
    {
      path: '/adminlogin',
      name: 'adminlogin',   //路由名称
      component: AdminLogin //组件对象
    },
    {
      path: '/personal-info',
      name: 'personal-info',   //路由名称
      component: PersonalInfo //组件对象
    },
    {
      path: '/studenthomepage',
      name: 'studenthomepage',   //路由名称
      component: StudentHomePage,
      children: [
        {
          path: 'studentreport',
          name: 'studentreport',
          component: () => import ('@/views/studentpages/report.vue')
        },
        {
          path: 'personalinfo',
          name: 'personalinfo',
          component: () => import ('@/views/studentpages/personalinfo.vue')
        },
        {
          path: 'viewannouncement',
          name: 'viewannouncement',
          component: () => import ('@/views/studentpages/announcement.vue')
        },
        {
          path: 'changepassword',
          name: 'changepassword',
          component: () => import ('@/views/studentpages/changepassword.vue')
        },
        {
          path: 'firstpage',
          name: 'firstpage',
          component: () => import ('@/views/studentpages/firstpage.vue')
        }
      ]
    },
    {
      path: '/adminhomepage',
      name: 'adminhomepage',   //路由名称
      //redirect:'index',      //设置默认路由
      component: AdminHomePage,
      children: [
        {
          path: 'reportconfirm',
          name: 'reportconfirm',
          component: () => import ('@/views/adminpages/reportconfirm.vue')
        },
        {
          path: 'analyze',
          name: 'analyze',
          component: () => import ('@/views/adminpages/analyze.vue')
        },
        {
          path: 'publishannounce',
          name: 'publishannounce',
          component: () => import ('@/views/adminpages/announce.vue')
        },
        {
          path: 'checkannounce',
          name: 'checkannounce',
          component: () => import ('@/views/adminpages/checkannouncement.vue')
        },
        {
          path: 'resetpassword',
          name: 'resetpassword',
          component: () => import ('@/views/adminpages/resetpassword.vue')
        },
        {
          path: 'resetstudentpassword',
          name: 'resetstudentpassword',
          component: () => import ('@/views/adminpages/resetstudentpassword.vue')
        }
      ]
    }
  ]
})
