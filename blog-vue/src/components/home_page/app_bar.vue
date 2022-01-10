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
                  <div style="display: flex; flex-direction: column">
                    <div
                      :class="{
                        user_nickname: user_logo,
                        un_user_nickname: !user_logo,
                      }"
                    >
                      <span style="margin-top: 5px; margin-bottom: 5px">{{
                        user_nickname
                      }}</span>
                    </div>
                    <div
                      :class="{
                        user_nickname: user_logo,
                        un_user_nickname: !user_logo,
                      }"
                      style="border-bottom: 1px solid gainsboro"
                    >
                      <svg
                        t="1641792505969"
                        class="icon"
                        viewBox="0 0 1024 1024"
                        version="1.1"
                        xmlns="http://www.w3.org/2000/svg"
                        p-id="2169"
                        width="25"
                        height="25"
                      >
                        <path
                          d="M897 47 122 47c-28.667 0-53.167 10-73.5 30S18 121.333 18 150l0 724c0 28.667 10.167 53 30.5 73s44.833 30 73.5 30l775 0c28.667 0 53-10 73-30s30-44.333 30-73L1000 150c0-18.667-4.5-36-13.5-52S965 69.5 949 60.5 915.667 47 897 47zM949 874c0 9.333-2.333 18-7 26s-11 14.333-19 19-16.667 7-26 7L122 926c-14.667 0-27-5.167-37-15.5S70 888 70 874L70 150c0-9.333 2.333-18 7-26s11-14.167 19-18.5 16.667-6.5 26-6.5l775 0c9.333 0 18 2.167 26 6.5s14.333 10.5 19 18.5 7 16.667 7 26L949 874zM256 678 138 377c-1.333-5.333-2-11.667-2-19 1.333-24 14.667-37.333 40-40 16 1.333 28 10.333 36 27l85 224 82-224c10-18 22.667-27 38-27 25.333 2.667 39.333 16 42 40-1.333 7.333-2.667 13.667-4 19L337 678c-10 18.667-23.333 28-40 28C277 706 263.333 696.667 256 678zM480 668 480 360c0-26.667 13.333-40.667 40-42 25.333 1.333 38.667 15.333 40 42l0 308c-1.333 25.333-14.667 38-40 38C493.333 706 480 693.333 480 668zM609 668 609 365c0-26.667 13.333-40.667 40-42l97 0c85.333 5.333 131 48 137 128-6 80-51 123-135 129l-59 0 0 88c-2 25.333-15.333 38-40 38C622.333 706 609 693.333 609 668zM689 394l0 114 54 0c34-1.333 52.333-20.333 55-57-2.667-35.333-21-54.333-55-57L689 394z"
                          p-id="2170"
                          fill="gainsboro"
                        ></path>
                      </svg>
                    </div>
                  </div>

                  <!-- 显示粉丝，关注，获赞 -->
                  <div
                    :class="{
                      able: user_logo,
                      unable: !user_logo,
                    }"
                  >
                    <div style="display: flex; flex-direction: row">
                      <div style="width: 34%; text-align: center">
                        <h4>12</h4>
                      </div>
                      <div style="width: 32%; text-align: center">
                        <h4>45</h4>
                      </div>
                      <div style="width: 34%; text-align: center">
                        <h4>78</h4>
                      </div>
                    </div>
                    <div style="display: flex; flex-direction: row">
                      <div style="width: 34%; text-align: center; color: grey">
                        <span>粉丝</span>
                      </div>
                      <div style="width: 32%; text-align: center; color: grey">
                        <span>关注</span>
                      </div>
                      <div style="width: 34%; text-align: center; color: grey">
                        <span>获赞</span>
                      </div>
                    </div>
                  </div>

                  <!-- 自定义功能 -->
                  <div
                    style="margin-top: 10px"
                    :class="{
                      able: user_logo,
                      unable: !user_logo,
                    }"
                  >
                    <div style="display: flex; flex-direction: column">
                      <div
                        class="changeColor"
                        style="display: flex; flex-direction: row"
                      >
                        <span
                          style="
                            width: 200px;
                            margin-left: 5px;
                            margin-right: 5px;
                            margin-top: 10px;
                            margin-bottom: 10px;
                            text-align: center;
                          "
                          >个人中心</span
                        >
                      </div>
                      <div
                        class="changeColor"
                        style="display: flex; flex-direction: row"
                      >
                        <span
                          style="
                            width: 200px;
                            margin-left: 5px;
                            margin-right: 5px;
                            margin-top: 10px;
                            margin-bottom: 10px;
                            text-align: center;
                          "
                          >学习中心</span
                        >
                      </div>
                      <div
                        class="changeColor"
                        style="display: flex; flex-direction: row"
                      >
                        <span
                          style="
                            width: 200px;
                            margin-left: 5px;
                            margin-right: 5px;
                            margin-top: 10px;
                            margin-bottom: 10px;
                            text-align: center;
                          "
                          >收藏中心</span
                        >
                      </div>
                      <div
                        class="changeColor"
                        style="display: flex; flex-direction: row"
                      >
                        <span
                          style="
                            width: 200px;
                            margin-left: 5px;
                            margin-right: 5px;
                            margin-top: 10px;
                            margin-bottom: 10px;
                            text-align: center;
                          "
                          >创作中心</span
                        >
                      </div>
                      <div
                        class="changeColor"
                        style="display: flex; flex-direction: row"
                      >
                        <span
                          style="
                            width: 200px;
                            margin-left: 5px;
                            margin-right: 5px;
                            margin-top: 10px;
                            margin-bottom: 10px;
                            text-align: center;
                          "
                          >账号管理</span
                        >
                      </div>

                      <div
                        @click="logout()"
                        class="changeColor"
                        style="display: flex; flex-direction: row"
                      >
                        <span
                          style="
                            width: 200px;
                            margin-left: 5px;
                            margin-right: 5px;
                            margin-top: 10px;
                            margin-bottom: 10px;
                            text-align: center;
                          "
                          >退出登录</span
                        >
                      </div>
                    </div>
                  </div>
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
import { Alert } from "element-ui"
let data = [
  "博客",
  "课程",
  "开发者商城",
  "问答",
  "社区",
  "插件",
  "认证",
  "开源"
];
let data2 = ["会员中心", "收藏", "动态", "消息"];

let user = { userName: "zhang", password: "pasword" };

export default {
  name: "app_bar",
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

.changeColor:hover {
  background: #e6e6eb;

  cursor: pointer;
}

.able {
  display: block;
}
.unable {
  display: none;
}

.user_nickname {
  display: block;

  height: 30px;

  text-align: center;
}

.un_user_nickname {
  display: none;
}

.activity {
  background: red;
  width: 210px;
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
