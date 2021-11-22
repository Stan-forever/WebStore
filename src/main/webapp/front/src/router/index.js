import Vue from 'vue'
import VueRouter from "vue-router";
const Login = () => import('../components/login')
const Menu = () => import('../components/menu')
const Provider = () => import('../components/provider')
const User = () => import('../components/user')
const Password = () => import('../components/password')
const Echarts = () => import('../components/echarts')
Vue.use(VueRouter)
const routes = [
    {
        path: '',
        redirect: '/login'
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/menu',
        component: Menu
    },
    {
        path: '/provider',
        component: Provider
    },
    {
        path: '/user',
        component: User
    },
    {
        path: '/password',
        component: Password
    },
    {
        path: '/echarts',
        component: Echarts
    },
]
const router = new VueRouter({
    routes,
    mode: 'history'
})
export default router