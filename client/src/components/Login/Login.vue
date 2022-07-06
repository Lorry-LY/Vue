<template>
  <div class="modal-body index-news-list">
    <div class="form-group">
      <img src="src/assets/logo.png">
    </div>
    <div class="form-group">
      用户名:<input class="form-control required" type="text" v-model="loginForm.username" placeholder="请输入用户名"/>
    </div>
    <div class="form-group">
      密码： <input class="form-control required" type="password" v-model="loginForm.password" placeholder="请输入密码"/>
    </div>
    <button class="btn btn-primary" v-on:click="login">登录</button>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: this.$route.params.data,
        password: ''
      }
    }
  },
  methods: {
    login () {
      this.$axios({
        method: 'post',
        url: '/client/login',
        data: {
          text: this.loginForm.username,
          passwd: this.loginForm.password
        }
      }).then(res => {
        console.log(res)
      }).catch(function (error) {
        console.log(error)
      })
    }
  },
  watch: {
    'loginForm.username' (newValue) {
      console.log(newValue)
    }
  }
}
</script>

<style scoped>
.form-group {
  margin: 30px 0;
}

.form-group .form-control {
  height: 40px;
  font-size: 15px;
}

.btn-primary {
  background-color: #2e9993;
  border: 0px solid transparent;
  width: 400px;
  height: 50px;
  font-size: 24px;
  font-family: STKaiti;
}
</style>
