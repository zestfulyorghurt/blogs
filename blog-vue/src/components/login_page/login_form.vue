<template>
  <div id="login_form">
    <div class="form_class">
      
      <!-- 登录界面的登录logo -->
      <div class="form_class2" style="height: 100px">
        <img src="@/assets/csdn_copy_logo.jpg" draggable="false"/>
      </div>
      <!-- 输入用户名 -->
      <div class="form_class2">
        <input
          v-model="userName"
          id="userName"
          placeholder="用户名"
          class="input_class"
        />
      </div>
      <!-- 输入用户密码 -->
      <div class="form_class2">
        <input
          v-model="password"
          type="password"
          id="password"
          placeholder="密码"
          class="input_class"
        />
      </div>
      <!-- 登录或注册按钮 -->
      <div class="button_group">
        <button class="button_style" @click="login">登录</button>
        <button class="button_style">注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",

  data() {
    return {
      message: "localhost:8080",
      userName: "",
      password: "",
    }
  },
  methods: {
    //登录方法
    login() {
      console.log("----用户进行登录----")
      // 用户信息封装
      const user = { userName: this.userName, password: this.password }
      //调用登录api
      this.$axios({
        method: "post",
        data: user,
        url: "http://localhost:8086/login",
      }).then((resp) => {
        console.log(resp)
        if (resp.data.message === "success") {
          console.log("----用户登陆成功----")
          //对画面进行对应的渲染
          loginSuccessViewRender()
          //请求成功后在request的请求头中设置token
          loginSuccessRequestSetting()
          //TODO跳转界面需要进行重新封装
          //跳转博客的主界面，隐式的携带数据
          this.$router.push({
            name: "blog",
            params: { id: "2", heard_img: true },
          })
        }
        // else {
        //   //使用element-ui中的message消息弹窗提示登陆失败
        //   //如果返回的信息不为success的话，就说明登录失败
        //   Message.error({
        //     //设置弹窗提示消息
        //     message: resp.data.data.message,

        //     //设置弹出提示时间
        //     duration: 800,
        //   });
        // }
      })
    },
    //用户登录成功后对画面进行渲染
    loginSuccessViewRender() {
          //将登录标签隐藏，显示用户头像
          window.sessionStorage.setItem("is_login", true)
          //用户登录时创建的令牌，存在本地，只有用户注销时才会清楚本地的令牌
          window.sessionStorage.setItem("token", resp.data.data.token)
    },
    //用户登陆成功后把返回值的token设置到request请求头中
    loginSuccessRequestSetting(){
          // 如果登陆成功，将token令牌放到请求头中，每次访问都需要去请验证token
          //这是axios的请求拦截器，每次请求都将token令牌放在request请求头中进行携带
          axios.interceptors.request.use((config) => {
            //获取前端存储在session中的令牌
            let token = sessionStorage.getItem("token")
            //如果token不为空，将token以key-value的形式放在请求头中{Authorization: token}
            if (token) {
              config.headers.Authorization = token
            }
            return config
          })
    }
  },
}
</script>

<style>
*{
  user-select: none;
}
/* body {
    text-align: center;  
} */

.button_style {
  width: 80px;
  height: 30px;
  border: 1px solid red;
  color: red;
  background: white;
  margin-left: 10px;
  outline: none;
  transition: background 0.5s;
}

.button_style:hover {
  background: red;
  color: white;
}

#login_form {
  margin: 0px auto;
  margin-top: 200px;
  width: 500px;
  border: 1px solid #e6e6eb;
  border-radius: 10px;
  /* 设置div阴影 */
  box-shadow: 5px 5px 5px #f0f0f0;
}

.form_class {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.form_class2 {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.button_group {
  display: flex;
  margin-bottom: 10px;
  flex-direction: row;
  justify-content: center;
}

.input_class {
  padding-left: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
  width: 300px;
  height: 30px;
  border: 1px solid #e6e6eb;
  border-radius: 10px;
  transition: border 0.5s;
}

.input_class:focus {
  outline: none;
  border: 1px solid red;
}


</style>
