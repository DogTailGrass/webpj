import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login'
import StudentReport from '@/views/studentpages'
import Pieview from '@/views/adminpages'
import PersonalInfo from '@/views/studentpages/personal-information'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',   //路由名称
      component: Login //组件对象
    },
    {
      path: '/login',
      name: 'login',   //路由名称
      component: Login //组件对象
    },
    {
      path: '/studentreport',
      name: 'studentreport',   //路由名称
      component: StudentReport //组件对象
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
    }
  ]
})
