import { createRouter, createWebHistory } from 'vue-router'
import CreateView from '../views/CreateView.vue'
import ListView from '../views/ListView.vue'
import LoginView from '../views/LoginView.vue'
import SignupView from '../views/SignupView.vue'
import MyPageView from '../views/MyPageView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'list',
      component: ListView,
    },
    {
      path: '/create',
      name: 'create',
      component: CreateView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignupView,
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: MyPageView,
    }
  ]
})

export default router
