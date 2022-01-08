<template>
  <div id="app_bar">
    <!-- csdn网站的导航栏 -->
    <div id="toolbarBox" style="min-height: 48px">
      <div id="csdn-toolbar">
        <div class="navigation_bar">
          <div class="toolbar-container-left">
            <div class="logoStyle">
              <a href="http://localhost:8080/#/">
                <img
                  title="CSDN首页"
                  src="@/assets/csdn_copy_logo.jpg"
                  class="logoStyleImg"
                />
              </a>
            </div>
            <ul class="csdn_toolbar_ul">
              <li class="li_style" v-for="(item, index) in data" :key="index">
                <a class="li_style_a" :href="message">
                  {{ item }}
                </a>
              </li>
            </ul>
          </div>

          <div class="toolbar-container-middle">
            <div style="height: 40px">
              <div class="sousuo_div">
                <input class="input_select" />
                <button class="sousuo_button">
                  <li class="sousuo_button_li"></li>
                  <span class="sousuo_button_span">搜索</span>
                </button>
              </div>
            </div>
          </div>

          <div class="toolbar-container-right">
            <div class="head_portrait">
              <a :href="message">
                <span
                  style="height: 48px; line-height: 48px"
                  v-bind:class="{ hidden: heard_img }"
                  >登录</span
                >
              </a>
              <div @mouseover="test()" @mouseout="test()">
                <img
                  class="onHover"
                  src="@/assets/logo.png"
                  v-bind:class="{
                    hidden: !heard_img,
                    onHover_change: user_logo,
                  }"
                />
                <div
                  style="
                    display: flex;
                    flex-direction: column;
                    background: white;
                    box-shadow: 5px 5px 5px #f0f0f0;
                  "
                  :class="{ activity: user_logo, unactivity: !user_logo }"
                >

                <!-- 显示用户昵称和用户角色 -->
                <div style="display:flex;flex-direction: column;">
                  <div style="height:25px;border:1px solid red"></div>
                  <div style="height:25px;border:1px solid red"></div>
                </div>

                <!-- 显示粉丝，关注，获赞 -->
                <div></div>

                <!-- 自定义功能 -->
                <div></div>

                <!-- 退出登录 -->
                <div></div>


                </div>
              </div>
            </div>

            <ul class="csdn_toolbar_ul">
              <li class="li_style" v-for="(item, index) in data2" :key="index">
                <a class="li_style_a" :href="message">
                  {{ item }}
                </a>
              </li>
            </ul>
            <button class="create">创作</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Message } from "element-ui";
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
  name: "App",
  data() {
    const heard_img = window.sessionStorage.getItem("is_login");
    console.log(heard_img);
    return {
      message: "http://localhost:8080/#/login",
      messageTest: "http://localhost:8080/#/test",
      data: data,
      data2: data2,
      heard_img: heard_img,
      user_logo: false,
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
  },
};
</script>

<style>
* {
  padding: 0px;

  margin: 0px;
}

.activity {
  background: red;
  width: 210px;
  height: 450px;
  margin-left: -80px;
  margin-top: -10px;
  border-radius: 5px;
  display: block;
}

.create {
  color: white;
  height: 36px;
  width: 96px;
  margin-top: 6px;
  background: #fc5531;
  border: none;
}

.sousuo_button_span {
  color: white;
}

.sousuo_button_li {
  float: left;
  color: white;
}

.sousuo_div {
  width: 850px;
  margin-left: 50px;
  margin-top: 8px;
}

.sousuo_button {
  background: #fc5531;
  border: none;
  height: 34px;
  width: 82px;
  border-top-right-radius: 15px;
  border-bottom-right-radius: 15px;
  margin-left: -7px;
}

.input_select {
  padding-left: 10px;
  width: 720px;
  height: 30px;
  border: 1px solid #e6e6eb;
  border-top-left-radius: 13px;
  border-bottom-left-radius: 13px;
  background: #f5f6f7;
}

.head_portrait {
  float: left;
  width: 48px;
  height: 48px;
}

.onHover {
  border: 1px solid #f5f6f7;
  width: 30px;
  height: 30px;
  border-radius: 30px;
  margin-top: 9px;
  margin-left: 9px;
  margin-bottom: 9px;
  margin-right: 9px;
  background: white;
  transition: transform 0.25s;
}

/* onHover_change {
  transform: scale(1.6, 1.6);
  border:1px solid red;
} */

.onHover_change:hover {
  transform: scale(1.6, 1.6);
}

.csdn_toolbar_ul {
  float: left;
  margin-left: 6px;
  height: 48px;
}

.logoStyleImg {
  width: 82px;
  height: 46px;
  margin-top: 2px;
}

.logoStyle {
  width: 82px;
  height: 48px;
  float: left;
}

#csdn-toolbar {
  position: relative;
  top: 0px;
  left: 0px;
  width: 100%;
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
  /* 设置div阴影 */
  box-shadow: 2px 3px 4px #f0f0f0;
  /* 设置背景颜色 */
  background: #ffffff;
}

/* 导航栏容器 */
.navigation_bar {
  /* 设置为弹性布局 */
  display: flex;
  /* 设置弹性布局为行排列 */
  flex-direction: row;
  height: 48px;
  width: 1855px;
  margin-left: 24px;
}

.toolbar-container-left {
  position: relative;
  height: 48px;
  width: 514px;
}

.li_style:hover {
  background: #f0f0f5;
}

.li_style {
  float: left;
  /* 将li标签的小原点去掉 */
  list-style-type: none;
  height: 48px;
  /* 设置鼠标悬停时为手指 */
  cursor: pointer;
}

.li_style_a {
  color: black;
  text-decoration: none;
  height: 48px;
  line-height: 48px;
  display: block;
  font-size: 14px;
  margin-left: 9px;
  margin-right: 9px;
}

.toolbar-container-middle {
  width: 950px;
  height: 48px;
}

.toolbar-container-right {
  width: 395px;
  height: 48px;
}

.hidden {
  display: none;
}
</style>
