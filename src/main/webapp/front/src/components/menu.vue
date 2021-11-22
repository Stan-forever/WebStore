<template>
  <div>
    <el-container>
      <el-header style="background-color: #409EFF">
        <i class="el-icon-shopping-cart-2" style="font-size:20px;color: white; margin-left: 50px; margin-right: 15px"></i>
        <span style="color: white; font-size: 20px">超市订单管理系统</span>
        <div style="float: right">
          <span style="color: white">您好！{{username}}欢迎您！</span>
          <el-button type="danger" size="small" @click="loginOut">退出登录</el-button>
        </div>
      </el-header>
      <el-container style="margin-top: 1px">
        <el-aside>
          <el-menu
              :default-active="$route.path"
              class="el-menu-vertical-demo"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
              style=" width: 200px"
              :style="menuHeight"
              router
          >
            <el-menu-item index="/menu" :class="{}">
              <i class="el-icon-s-order"></i>
              <span >订单管理</span>
            </el-menu-item>
            <el-menu-item index="/provider">
              <i class="el-icon-menu"></i>
              <span slot="title">供应商管理</span>
            </el-menu-item>
            <el-menu-item index="/user">
              <i class="el-icon-document"></i>
              <span slot="title">用户管理</span>
            </el-menu-item>
            <el-menu-item index="/password">
              <i class="el-icon-setting"></i>
              <span slot="title">密码修改</span>
            </el-menu-item>
            <el-menu-item index="/login">
              <i class="el-icon-setting"></i>
              <span slot="title">退出系统</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main style="">
          <slot name="first"><BillList></BillList></slot>
        </el-main>
      </el-container>
      <el-footer style="background-color: #409EFF; text-align: center; ">
        <span style="font-size: 20px; color: white;line-height: 60px">
          超市订单管理系统
        </span>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Cookies from 'js-cookie';
import BillList from '../components/billlist.vue'
  export default {
    name: 'Menu',
    props: {
      msg: String
    },
    components: {
      BillList
    },
    data() {
      return {
        menuHeight: {
          height: "",
        },
        activeColor: {
          backgroundColor: "#409EFF"
        },
        username: ''
      }
    },
    methods: {
      loginOut() {
        this.$router.push({path: '/login'})
      }
    },
    mounted() {
      this.username = Cookies.get('username');
      var docHeight = document.body.scrollHeight;
      this.menuHeight.height = docHeight - 20 + "px";
      console.log(this.menuHeight.height, "this.containerHeight.height")
    },
    created() {

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
  .el-menu{
    padding-top: 8px;
    height: 100vh;
  }
  .el-footer {
    height: 5vh;
  }
</style>
