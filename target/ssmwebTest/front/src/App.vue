<template>
  <div id="app">
<!--    <Menu/>-->
    <router-view></router-view>
  </div>
</template>

<script>
import Menu from './components/menu.vue'

export default {
  name: 'App',
  components: {
    Menu
  }
}
</script>

<style>
#app {

}
</style>
