<template>
  <div class="hello">
    <img src="../assets/logo.png">
    <h1>{{ msg }}</h1>
    <div class="form-group">
      <router-link class="form-control" to="/login">登录</router-link>
    </div>
    <div class="form-group">
      <router-link class="form-control" to="/register">注册</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {
  margin: 0;
}

h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
  text-decoration-line: none;
}

.form-group {
  margin: 5px auto;
  width: 300px;
  text-align: center;
  height: 40px;
  line-height: 40px;
  background-color: #2e9993;
}

.form-group .form-control {
  display: block;
  height: 40px;
  font-size: 15px;
  color: aliceblue;
}
</style>
