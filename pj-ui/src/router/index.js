import Vue from 'vue'
import Router from 'vue-router'
import StudentLogin from '@/views/login/studentlogin'
import AdminLogin from '@/views/login/adminlogin'
import StudentReport from '@/views/studentpages/report'
import Pieview from '@/views/adminpages'
import PersonalInfo from '@/views/studentpages/personalinfo'
import StudentHomePage from '@/views/studentpages/homepage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/studentlogin',
      name: 'studentlogin',   //路由名称
      component: StudentLogin //组件对象
    },
    {
      path: '/adminlogin',
      name: 'adminlogin',   //路由名称
      component: AdminLogin //组件对象
    },
    
    {
      path: '/pieview',
      name: 'pieview',   //路由名称
      component: Pieview //组件对象
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
        }
      ]
    }
  ]
})
