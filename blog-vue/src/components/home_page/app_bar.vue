<template>
  <div id="app_bar">
    <!-- csdn网站的导航栏 -->
    <div id="toolbarBox" style="min-height: 48px">
      <div>
        <div class="flex_row_center">
          
          <!-- 网页logo -->
          <div class="logoStyle">
            <a href="http://localhost:8080/#/">
              <img
                title="CSDN首页"
                src="@/assets/csdn_copy_logo.jpg"
                class="logoStyleImg"
              />
            </a>
          </div>

          <!-- 网站导航栏 -->
          <ul class="flex_row">
            <li class="li_style" v-for="(item, index) in data" :key="index">
              <a class="li_style_a" :href="message">
                {{ item }}
              </a>
            </li>
          </ul>

          <!-- 网站搜索栏 -->
          <div class="flex_colum_center">
            <div>
              <input class="input_select" />
              <button class="sousuo_button">
                <li class="sousuo_button_li"></li>
                <span class="sousuo_button_span">搜索</span>
              </button>
            </div>
          </div>
        
        </div>
      </div>
    </div>
  </div>
</template>

<script>
let data = [
  "博客",
  "课程",
  "开发者商城",
  "问答",
  "社区",
  "插件",
  "认证",
  "开源",
];
let data2 = ["会员中心", "收藏", "动态", "消息"];

let user = { userName: "zhang", password: "pasword" };

export default {
  name: "app_bar",
  data() {
    const heard_img = window.sessionStorage.getItem("。");
    console.log(heard_img);
    return {
      message: "http://localhost:8080/#/login",
      messageTest: "http://localhost:8080/#/test",
      data: data,
      data2: data2,
      heard_img: heard_img,
      user_logo: false,
      user_nickname: "zhangyi",
    };
  },
  methods: {
    login() {
      axios.post("http://localhost:8086/test", user).then((resp) => {
        console.log("788");
        console.log(resp);
        window.sessionStorage.clear();
        location.reload();
      });
    },
    test() {
      this.user_logo = !this.user_logo;
    },
    logout() {
      alert("用户已注销");
      window.sessionStorage.clear();
      location.reload();
      // Message.info({
      //   //设置弹窗提示消息
      //   message: "1233",

      //   //设置弹出提示时间
      //   duration: 1000,
      // });
    },
  },
};
</script>

<style>
* {
  padding: 0px;

  margin: 0px;
}

/* 水平排列 */
.flex_row {
  display: flex;
  flex-direction: row;
}

/* 竖排列 */
.flex_colum {
  display: flex;
  flex-direction: column;
}

/* 水平居中 */
.flex_row_center {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

/* 垂直居中 */
.flex_colum_center {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.changeColor:hover {
  background: #e6e6eb;
  cursor: pointer;
}

.sousuo_button_span {
  color: white;
}

.sousuo_button_li {
  float: left;
  color: white;
}


.sousuo_button {
  background: #fc5531;
  outline: none;
  border: none;
  height: 34px;
  width: 75px;
  border-top-right-radius: 15px;
  border-bottom-right-radius: 15px;
  margin-left: -7px;
}

.input_select {
  padding-left: 10px;
  width: 520px;
  height: 30px;
  border: 1px solid #e6e6eb;
  border-top-left-radius: 13px;
  border-bottom-left-radius: 13px;
  background: #f5f6f7;
}

.logoStyleImg {
  width: 82px;
  height: 46px;
}

.logoStyle {
  width: 82px;
  height: 48px;
}

.input_select:focus {
  outline: none;
  border: 1px solid red;
}

body {
  /* 设置body的颜色 */
  background: #fafafa;
}

#toolbarBox {
  position: fixed;
  top: 0px;
  width: 100%;
  box-shadow: 2px 3px 4px #f0f0f0;
  background: #ffffff;
}


.li_style:hover {
  background: #f0f0f5;
}

.li_style {
  /* 将li标签的小原点去掉 */
  list-style-type: none;
  /* 设置鼠标悬停时为手指 */
  cursor: pointer;
}

.li_style_a {
  color: black;
  text-decoration: none;
  line-height: 48px;
  display: block;
  font-size: 14px;
  margin-left: 9px;
  margin-right: 9px;
}
</style>
