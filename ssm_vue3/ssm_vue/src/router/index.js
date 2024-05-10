import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

// 用于配置路由
// path: '/' 路径
// component: HomeView 当访问http://localhost:8081/ 时，就路由到HomeView组件
// 将该组件的内容返回给<router-view/>
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
