import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: () => import('@/components/Login/HelloWorld')
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/components/Login/Login')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('@/components/Login/Register')
    },
    {
      path: '/index',
      name: 'Index',
      component: () => import('@/components/Index/Index')
    }
  ]
})
