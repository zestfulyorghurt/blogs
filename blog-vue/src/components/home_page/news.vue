<template>
  <div id="news">
    <div id="news-container">
      
      <div class="flex_colum">
        <div class="flex_row">
          <div class="flex_colum_center">
            <svg-icon icon-class="top_hot" ></svg-icon>
          </div>
          <div class="flex_colum_center">
            <h4>头条</h4>
          </div>
        </div>

        <div class="flex_row_center">
          <img
            src="@/assets/csdn_copy_logo.jpg"
          />
        </div>

        <div>
          <h4>
            <a :href="jump_url">{{ lift_one_div_news_title }}</a>
          </h4>
        </div>

        <div class="hot_top_funt_style">
          {{ lift_one_div_news_context }}
        </div>
      
      </div>



      <div class="lift_two_div">
        <div class="paging">
          <p>
            <svg
              t="1640593592802"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="1985"
              width="16"
              height="16"
            >
              <path
                d="M729.6 931.2l-416-425.6 416-416c9.6-9.6 9.6-25.6 0-35.2-9.6-9.6-25.6-9.6-35.2 0l-432 435.2c-9.6 9.6-9.6 25.6 0 35.2l432 441.6c9.6 9.6 25.6 9.6 35.2 0C739.2 956.8 739.2 940.8 729.6 931.2z"
                p-id="1986"
              ></path>
            </svg>
          </p>
          <p>
            <svg
              t="1640593525633"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="1789"
              width="16"
              height="16"
            >
              <path
                d="M857.70558 495.009024 397.943314 27.513634c-7.132444-7.251148-18.794042-7.350408-26.048259-0.216941-7.253194 7.132444-7.350408 18.795065-0.216941 26.048259l446.952518 454.470749L365.856525 960.591855c-7.192819 7.192819-7.192819 18.85544 0 26.048259 3.596921 3.596921 8.311293 5.39487 13.024641 5.39487s9.42772-1.798972 13.024641-5.39487L857.596086 520.949836C864.747973 513.797949 864.796068 502.219239 857.70558 495.009024z"
                p-id="1790"
              ></path>
            </svg>
          </p>
        </div>
        <div
          class="news_content"
          v-for="(item, index) in news_context"
          :key="index"
        >
          <div class="news_content_title">
            <h4>
              <a href="">{{ item.title }}</a>
            </h4>
          </div>
          <div class="news_content_text">
            {{ item.context }}
          </div>
        </div>
      </div>

      <div class="lift_three_div">
        <div class="paging">
          <p>
            <svg
              t="1640593592802"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="1985"
              width="16"
              height="16"
            >
              <path
                d="M729.6 931.2l-416-425.6 416-416c9.6-9.6 9.6-25.6 0-35.2-9.6-9.6-25.6-9.6-35.2 0l-432 435.2c-9.6 9.6-9.6 25.6 0 35.2l432 441.6c9.6 9.6 25.6 9.6 35.2 0C739.2 956.8 739.2 940.8 729.6 931.2z"
                p-id="1986"
              ></path>
            </svg>
          </p>
          <p>
            <svg
              t="1640593525633"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="1789"
              width="16"
              height="16"
            >
              <path
                d="M857.70558 495.009024 397.943314 27.513634c-7.132444-7.251148-18.794042-7.350408-26.048259-0.216941-7.253194 7.132444-7.350408 18.795065-0.216941 26.048259l446.952518 454.470749L365.856525 960.591855c-7.192819 7.192819-7.192819 18.85544 0 26.048259 3.596921 3.596921 8.311293 5.39487 13.024641 5.39487s9.42772-1.798972 13.024641-5.39487L857.596086 520.949836C864.747973 513.797949 864.796068 502.219239 857.70558 495.009024z"
                p-id="1790"
              ></path>
            </svg>
          </p>
        </div>
        <div
          class="news_content"
          v-for="(item, index) in news_context"
          :key="index"
        >
          <div class="news_content_title">
            <h4>
              <a href="">{{ item.title }}</a>
            </h4>
          </div>
          <div class="news_content_text">
            {{ item.context }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
var data = null;

var li_data = ["java", "python", "#c", "数据库", "前端"];

var lift_one_div_news_title = "杀不死Perl";

var lift_one_div_news_context =
  "Perl迎来34岁生日。但生存还是死亡，似乎成了Perl绕不开的话题。";

var news_context = [
  {
    title: "JDK 18功能集被冻结",
    context: "英特尔Linux Vulkan驱动程序首席开发离",
  },
  {
    title: "开发者举报：苹果只收钱不办事！",
    context: "账号莫名被冻结，苹果至今未给出具体理",
  },
  { title: "2021 CSS年度报告出炉", context: "Bootstrap使用度最高" },
  { title: "苹果组建新团队研发无线芯片", context: "摆脱枷锁" },
];

// axios.get("http://localhost:8086/test").then(function (resp) {
//   data = resp;
//   console.log(resp);
// });

export default {
  name: "category",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      message: data,
      li_data: li_data,
      lift_one_div_news_title: lift_one_div_news_title,
      lift_one_div_news_context: lift_one_div_news_context,
      news_context: news_context,
      jump_url: "http://localhost:8080/#/headline"
    };
  },
  methods: {
    reverseMessage: function () {
      console.log(data);

      console.log(data.data);

      axios.get("http://localhost:8086/test").then(function (resp) {
        console.log(resp);
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

/* 水平排列 */
.flex_row{
  display: flex;
  flex-direction: row;
}

/* 竖排列 */
.flex_colum{
  display: flex;
  flex-direction: column;
}

/* 水平居中 */
.flex_row_center{
  display: flex;
  flex-direction: row;
  justify-content: center;
}

/* 垂直居中 */
.flex_colum_center{
  display: flex;
  flex-direction: column;
  justify-content: center;
}

#news {
  margin-top: 80px;
  min-width: 1445px;
}

#news-container {
  display: flex;
  justify-content: center;
  flex-direction: row;
  height: 300px;
}

/* 头条内容简介字体样式 */
.hot_top_funt_style {
  font-size: 15px;
  color: silver;
}

.lift_two_div {
  width: 300px;
  display: flex;
  flex-direction: column;
}

.paging {
  display: flex;
  flex-direction: row;
  justify-content: right;
}

.news_content {
  margin-top: 25px;
  margin-left: 15px;
}

.news_content_text {
  cursor: pointer;
  font-size: 15px;
  color: silver;
}

.lift_three_div {
  width: 300px;
  display: flex;
  flex-direction: column;
}
</style>
