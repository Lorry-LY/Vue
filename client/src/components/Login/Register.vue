<template>
  <div class="modal-body index-news-list">
    <div class="logo">
      <img src="src/assets/logo.png"><br>
    </div>
    <div class="form-group">
      昵称： <input class="form-control required" type="text" v-model="RegisterForm.name" placeholder="请输入用户名"/>
      <div class="tip">

      </div>
    </div>
    <div class="form-group">
      用户名： <input class="form-control required" type="text" v-model="RegisterForm.adminName" placeholder="请输入密码"/>
      <div class="tip">
        <div class="tip">
          <div v-show="isExistsName">该用户名已经被使用过</div>
        </div>
      </div>
    </div>
    <div class="form-group">
      密码： <input class="form-control required" type="password" v-model="RegisterForm.password" placeholder="请输入密码"/>
      <div class="tip">
        <div v-show="1===0">密码太简单</div>
      </div>
    </div>
    <div class="form-group">
      确认密码： <input class="form-control required" type="password" v-model="RegisterForm.password2" placeholder="请输入密码"/>
      <div class="tip">
        <div v-show="isSamePassword">两次密码不一样</div>
      </div>
    </div>
    <div class="form-group">
      手机号： <input class="form-control required" type="text" v-model="RegisterForm.phone" placeholder="请输入密码"/>
      <div class="tip">
        <div v-show="isExistsPhone">该手机已经存在账号</div>
      </div>
    </div>
    <div class="form-group">
      邮箱： <input class="form-control required" type="text" v-model="RegisterForm.e_mail" placeholder="请输入密码"/>
      <div class="tip">
        <div v-show="isExistsEmail">该邮箱已经存在账号</div>
      </div>
    </div>
    <button class="btn btn-primary" v-on:click="register">注册</button>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      RegisterForm: {
        name: '',
        adminName: '',
        password: '',
        password2: '',
        phone: '',
        e_mail: ''
      }
    }
  },
  methods: {
    register () {
      this.$axios.post('/client/register', {
        'name': this.RegisterForm.name,
        'adminName': this.RegisterForm.adminName,
        'passwd': this.RegisterForm.password,
        'phone': this.RegisterForm.phone,
        'e_mail': this.RegisterForm.e_mail
      }).then(res => {
        this.$router.push({
          name: 'Login', params: {data: res.data.message.data.adminName}})
        console.log(res.data.message)
      })
    }
  },
  computed: {
    isExistsName () {
      return true
    },
    isExistsPhone () {
      return true
    },
    isExistsEmail () {
      return true
    },
    isSamePassword () {
      return this.RegisterForm.password !== this.RegisterForm.password2
    }
  }
}
</script>

<style scoped>
.form-group {
  width: 500px;
  margin: 5px 40vmin;
  text-align: right;
}

.form-group .form-control {
  height: 40px;
  font-size: 15px;
}

.logo {
  width: 500px;
  margin: 5px auto;
  text-align: center;
}

.btn-primary {
  background-color: #2e9993;
  border: 0px solid transparent;
  width: 300px;
  height: 50px;
  font-size: 24px;
  font-family: STKaiti;
}

.tip {
  display: inline-block;
  width: 200px;
  text-align: left;
  color: #fe2516;
}
</style>
