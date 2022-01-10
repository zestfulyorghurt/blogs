<template>
  <div id="news">
    <div id="news-container">
      <div class="lift_one_div">
        <div class="lift_one_div_title">
          <svg
            t="1640591805292"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="891"
            width="32"
            height="32"
          >
            <path
              d="M512 510.3104m-450.816 0a450.816 450.816 0 1 0 901.632 0 450.816 450.816 0 1 0-901.632 0Z"
              fill="#E9F4FF"
              p-id="892"
            ></path>
            <path
              d="M691.456 216.7296h-358.912c-41.9328 0-75.8784 33.9968-75.8784 75.8784v472.1664c0 28.5696 29.696 47.36 55.552 35.1744l167.168-78.8992c20.48-9.6768 44.2368-9.6768 64.7168-0.0512l167.7824 79.0016c25.8048 12.1344 55.5008-6.656 55.5008-35.2256V292.6592c0-41.9328-33.9968-75.9296-75.9296-75.9296z m-65.8944 341.6064H398.4384c-15.0016 0-27.136-12.1344-27.136-27.136 0-15.0016 12.1344-27.136 27.136-27.136h227.1232c15.0016 0 27.136 12.1344 27.136 27.136 0 15.0016-12.1344 27.136-27.136 27.136z m0-123.8528H398.4384c-15.0016 0-27.136-12.1344-27.136-27.136 0-15.0016 12.1344-27.136 27.136-27.136h227.1232c15.0016 0 27.136 12.1344 27.136 27.136 0 15.0016-12.1344 27.136-27.136 27.136z"
              fill="#2595E8"
              p-id="893"
            ></path>
            <path
              d="M767.3856 481.536V292.6592c0-41.9328-33.9968-75.8784-75.8784-75.8784H332.544c-41.9328 0-75.8784 33.9968-75.8784 75.8784v450.9696A451.56864 451.56864 0 0 0 353.28 754.0224c22.7328 0 45.0048-1.6896 66.816-4.9152l59.2896-28.0064c16.7936-7.936 35.6864-9.2672 53.248-4.1984 105.0624-45.6704 189.3888-130.1504 234.752-235.3664z m-141.824 76.8H398.4384c-15.0016 0-27.136-12.1344-27.136-27.136s12.1344-27.136 27.136-27.136h227.1232c15.0016 0 27.136 12.1344 27.136 27.136s-12.1344 27.136-27.136 27.136z m0-123.8528H398.4384c-15.0016 0-27.136-12.1344-27.136-27.136 0-15.0016 12.1344-27.136 27.136-27.136h227.1232c15.0016 0 27.136 12.1344 27.136 27.136 0 15.0016-12.1344 27.136-27.136 27.136z"
              fill="#3A9CED"
              p-id="894"
            ></path>
            <path
              d="M405.76 558.336h-7.3216c-15.0016 0-27.136-12.1344-27.136-27.136s12.1344-27.136 27.136-27.136h101.5808a454.7072 454.7072 0 0 0 73.8304-69.5808H398.4384c-15.0016 0-27.136-12.1344-27.136-27.136 0-15.0016 12.1344-27.136 27.136-27.136h214.9376a448.4352 448.4352 0 0 0 61.3376-163.4816H332.544c-41.9328 0-75.8784 33.9968-75.8784 75.8784v300.4416a446.86848 446.86848 0 0 0 149.0944-34.7136z"
              fill="#59ADF8"
              p-id="895"
            ></path>
            <path
              d="M502.4256 216.7808H332.544c-41.9328 0-75.8784 33.9968-75.8784 75.8784V412.16c103.3728-33.792 190.3616-103.936 245.76-195.3792z"
              fill="#6BC2FC"
              p-id="896"
            ></path>
          </svg>
          <h4 style="margin-top: 5px">头条</h4>
        </div>
        <div class="lift_one_div_img">
          <img
            src="@/assets/csdn_copy_logo.jpg"
            style="height: 150px; width: 350px"
          />
        </div>
        <div class="lift_one_div_news_title">
          <h4>
            <a :href="jump_url">{{ lift_one_div_news_title }}</a>
          </h4>
        </div>
        <div class="lift_one_div_news_context">
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

.lift_one_div {
  width: 450px;
  display: flex;
  flex-direction: column;
}

.lift_one_div_title {
  display: flex;
  flex-direction: row;
}

.lift_one_div_img {
  display: flex;
  justify-content: center;
}

.lift_one_div_news_title {
  margin-top: 20px;
}

.lift_one_div_news_context {
  margin-top: 10px;
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
