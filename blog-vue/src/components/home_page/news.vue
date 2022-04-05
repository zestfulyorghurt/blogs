<template>
  <div id="news">
    <div id="news-container" class="flex_row_center">
      
      <!-- 头条部分 -->
      <div class="flex_colum" style="width:450px">
        
        <!-- 头条标题 -->
        <div class="flex_row">

          <div class="flex_colum_center">
            <svg-icon icon-class="top_hot" style="width:2em;height:2em"></svg-icon>
          </div>
          
          <div class="flex_colum_center">
            <h4>头条</h4>
          </div>
        
        </div>

        <!-- 头条图片 --> 
        <div class="flex_row_center">
          <img
            src="@/assets/csdn_copy_logo.jpg"
            style="width:20em;height:10em"
            draggable="false"
          />
        </div>

        <!-- 头条标题 -->
        <div>
          <h4>
            <a :href="jump_url">{{ first_news.title }}</a>
          </h4>
        </div>

        <!-- 头条内容 -->
        <div class="hot_top_funt_style">
          {{ first_news.context }}
        </div>
      
      </div>



      <div class="flex_colum" style="width:300px" v-for="(item, index) in news_context" :key="index">

        <!-- 上下翻页 -->
        <div class="flex_row">
          <svg-icon icon-class="arrowhead_left_off" style="width:2em;height:2em"></svg-icon>
          <svg-icon icon-class="arrowhead_right_off" style="width:2em;height:2em"></svg-icon>
        </div>

        <!-- 热点新闻标题和简介 -->
        <div
          class="news_content"
          v-for="(item_in, index) in item"
          :key="index"
        >

          <!-- 热点新闻的标题 -->
          <div class="news_content_title">
            <h4>
              <a href="">{{ item_in.title }}</a>
            </h4>
          </div>

          <!-- 热点新闻的简介 -->
          <div class="news_content_text">
            {{ item_in.context }}
          </div>

        </div>
      </div>

    </div>
  </div>
</template>

<script>
var data = null;

var first_news = {"title":"杀不死Perl","context":"Perl迎来34岁生日。但生存还是死亡，似乎成了Perl绕不开的话题。"}

var news_context = [
 [
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
 ],
 [
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
 ]
];

// axios.get("http://localhost:8086/test").then(function (resp) {
//   data = resp;
//   console.log(resp);
// });

export default {
  name: "category",
  data() {
    return {
      message: data,
      first_news:first_news,
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

/* 整体位置布局 */
#news {
  margin-top: 80px;
  min-width: 1445px;
  user-select: none;
}

/* 头条内容简介字体样式 */
.hot_top_funt_style {
  font-size: 15px;
  color: silver;
}

/* 热点标题文字样式 */
.news_content {
  margin-top: 1em;
  margin-left: 1em;
}

/* 热点简介文字样式 */
.news_content_text {
  cursor: pointer;
  font-size: 1em;
  color: silver;
}

a { 
  text-decoration:none
} 


</style>
