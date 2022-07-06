<template>
  <div class="navbar">
    <el-menu
      :router="true"
      :default-active="msg"
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="/home">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item>
      <el-menu-item index="/teacher">
        <i class="el-icon-apple"></i>
        <span slot="title">老师</span>
      </el-menu-item>
      <el-menu-item index="/students">
        <i class="el-icon-cloudy-and-sunny"></i>
        <span slot="title">学生</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  data () {
    return {
      msg: this.$route.path
    }
  }
}
</script>

<style>
</style>
