<template>
  <div class="header">
    <a href="#">
      <img src="@/assets/logo.png" class="logo" alt="" />
      <span class="company">学员管理系统</span>
    </a>

    <el-dropdown trigger="click" @command="handleCommand">
      <span class="el-dropdown-link">
        下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item icon="el-icon-plus" command="a">黄金糕</el-dropdown-item>
        <el-dropdown-item icon="el-icon-circle-plus"  command="b">狮子头</el-dropdown-item>
        <!-- <el-dropdown-item icon="el-icon-circle-plus-outline">螺蛳粉</el-dropdown-item>
        <el-dropdown-item icon="el-icon-check">双皮奶</el-dropdown-item>
        <el-dropdown-item icon="el-icon-circle-check">蚵仔煎</el-dropdown-item> -->
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  methods: {
    handleCommand (command) {
      this.$message('click on item ' + command)
    }
  }
}
</script>

<style scoped>
.logo{
  vertical-align: middle;
  width: 30px;
  height: 30px;
  padding: 0 10px 0 50px;
}
.company{
  color:white;
}
a{
  text-decoration: none;
}
.el-dropdown{
  float: right;
  margin-right: 40px;
  cursor: pointer;
  color: white;
}
</style>
