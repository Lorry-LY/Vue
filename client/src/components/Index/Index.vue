<template>
  <div>
    <app-main />
    <app-navbar />
  </div>
</template>

<script>
import AppMain from './AppMain/index.vue'
import AppNavbar from './AppNavbar/index.vue'
export default {
  components: {
    AppMain,
    AppNavbar
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
.navbar {
  position: absolute;
  width: 15%;
  top: 0;
  left: 0px;
  background-color: rgb(182, 243, 39);
  height: 100%;
}

.main {
  position: absolute;
  top: 0;
  left: 15%;
  padding: 10px;
  background-color: pink;
  width: 85%;
  height: 100%;
}
</style>
