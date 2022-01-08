<template>
  <div id="news_context">
      <div class="bolg_list" v-for="(item,index) in data" :key="index">
    <div class="news_context_title">
      <span>
        <a style="title_a" href="#">
          <h4>今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板</h4>
        </a>
      </span>
    </div>
    <div class="news_context_context">
      <div class="news_context_context_img">
        <img src="@/assets/csdn_copy_logo.jpg" />
      </div>
      <div class="news_context_context_text">
        <div class="news_context_context_text_top">
          <span class="text">
            简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0 工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 | 李志信来源 | 阿里技术公众号作者介绍：李志信（github @laurencelizhixin），dubbo-go 3.0 负责人，Apache Dubbo PMC，来自阿里云中间件团队，从事 Go 语言中间件的研发和开源工作。于雨 （github
          </span>
        </div>
        <div class="news_context_context_text_bottom">
          <div class="like_ont_like">
            <div class="like">
              <div>
                <svg
                  t="1640658976040"
                  class="icon"
                  viewBox="0 0 1024 1024"
                  version="1.1"
                  xmlns="http://www.w3.org/2000/svg"
                  p-id="2069"
                  width="18"
                  height="18"
                >
                  <path
                    d="M259.60156269 433.88281277h-93.75000019a10.82812473 10.82812473 0 0 0-10.82812473 10.85156186v390.2812501c0 5.97656223 4.8515625 10.82812473 10.82812473 10.82812554h93.75000018V433.88281277z m64.9218749-3.3281249v415.2890624h447.09374982a10.82812473 10.82812473 0 0 0 10.80468759-10.82812554V830.74999963l86.484375-324.93749936a97.57031232 97.57031232 0 0 0-97.28906259-93.6093749h-181.12500028l7.54687574-38.71875064c5.15625018-26.62500009 11.32031277-45.28125027 11.32031195-81.56249946V247.53125009c0-53.7890625-43.6640625-71.78906223-97.35937482-71.78906222-53.67187518 0-97.35937481 17.99999973-97.35937481 71.78906222v44.43750028c0 50.85937463-28.42968741 82.03125037-84.49218732 133.42968732l-5.62500028 5.15625018z m447.09374982 480.32812463H165.82812537A75.89062491 75.89062491 0 0 1 90.125 835.01562473V444.73437463a75.89062491 75.89062491 0 0 1 75.70312537-75.8906249h129.515625c26.60156213-26.13281287 54.39843787-41.29687491 54.39843704-76.89843732V247.50781213C349.74218741 157.85937463 422.51562491 110.67968769 512 110.67968769s162.25781259 47.15624981 162.25781259 136.82812444v44.43750028c0 25.71093787-2.62500019 31.68750009-5.97656222 55.21874991h103.33593704c89.48437509 0 162.25781259 72.93749991 162.25781259 162.60937536v4.26562509l-86.6953125 325.78124936a75.91406287 75.91406287 0 0 1-75.56250009 71.06250037z"
                    fill="#8a8a8a"
                    p-id="2070"
                  ></path>
                </svg>
              </div>
              <div>
                <span style="margin-left: 10px">2 赞</span>
              </div>
            </div>
            <div class="not_like">
              <div>
                <svg
                  t="1640659026321"
                  class="icon"
                  viewBox="0 0 1024 1024"
                  version="1.1"
                  xmlns="http://www.w3.org/2000/svg"
                  p-id="3068"
                  width="14"
                  height="14"
                >
                  <path
                    d="M300 608.864V88h477.916c25.815 0 41.979 5.525 51.808 14.617 6.238 6.125 9.602 13.574 10.735 20.38l0.438 2.633 92.314 402.165 0.176 0.712c5.816 23.53 1.843 43.53-10.447 59.143-9.517 11.702-32.017 21.182-59.61 21.182H546.349l72.213 130.586c7.856 14.206 15.912 31.605 23.947 53.053 10.618 28.344 20.148 61.09 28.115 98.645 0.036 0.32-0.053 0.518-0.461 1.612-1.324 3.544-4.218 8.523-9.47 15.814C644.654 926.839 623.467 936 594.813 936c-18.135 0-28.537-4.288-37.618-12.874-8.405-7.946-14.718-17.855-25.561-39.254l-5.634-11.118-5.344-5.732c-0.433-0.72-0.918-1.551-1.444-2.474-1.787-3.135-7.986-14.904-10.1-18.652l0.01-0.006c-25.204-43.028-36.934-62.463-52.366-85.841-21.447-32.49-42.12-59.384-64.482-82.682-28.251-29.434-58.872-52.508-92.273-68.503z m-88-24.668a289.824 289.824 0 0 0-29.43-1.476H97.667c-6.617 0-8.667-2.052-8.667-8.768V96.256C89 90.049 91.054 88 97.667 88H212v496.196z m483.57 112.636h167.76c53.193 0 101.27-20.48 128.379-54.272 29.665-37.376 39.382-85.504 27.107-135.168l-91.552-398.848c-2.557-15.36-10.74-44.544-36.826-69.632C863.331 13.312 825.482 0 777.916 0H97.667C42.429 0 1 41.472 1 96.256v477.696c0 55.296 41.429 96.768 96.667 96.768h84.903c121.729 0 184.64 107.008 250.618 219.648 1.535 2.56 12.787 25.6 19.947 33.28C471.037 958.976 504.282 1024 594.811 1024c55.239 0 101.782-20.992 135.027-60.928 17.39-23.552 34.268-52.224 27.108-89.088-7.304-34.634-15.547-64.206-23.833-89.152l-37.543-88z"
                    p-id="3069"
                    fill="#707070"
                  ></path>
                </svg>
              </div>
              <div>
                <span style="margin-left: 10px">2 赞</span>
              </div>
            </div>
            <div class="wirter">
              <div>
                <span>会飞的鱼</span>
              </div>
              <div style="margin-left: 35px">...</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
  </div>
</template>

<script>
var data = [1,2,3,4,5,6]
export default {
  name: "news_context",
  data() {
    return {
        data:data
    };
  },
  methods: {
    reverseMessage: function () {
      console.log("qwqwq");
    },
  },
};
</script>

<style scoped>
#news_context {
  display: flex;
  flex-direction: column;
  margin-left: 200px;
  margin-right: 200px;
  margin-top: 48px;
  min-width: 1409px;
}

.news_context_title {
}
.title_a {
  text-decoration: none;
  color: black;
}

.news_context_context {
  display: flex;
  flex-direction: row;
  height: 100px;
  /* justify-content: center; */
  margin-top: 15px;
}

.news_context_context_img {
}

.news_context_context_text {
  display: flex;
  flex-direction: column;
  width: 850px;
}

.news_context_context_text_top {
}
.text {
  max-width: 100%;
  display: inline-block;
  overflow-wrap: break-word; /*  css3属性，当内容超过指定容器的边界时是否断行  */
  text-align: left;
  font-size: 16px;
  color: darkgray;
}

.news_context_context_text_bottom {
  display: flex;
  flex-direction: row;
}

.like_ont_like {
  display: flex;
  flex-direction: row;
  margin-top: 20px;
}

.like {
  display: flex;
  flex-direction: row;
  margin-right: 35px;
  background: ghostwhite;
  cursor: pointer;
}

.not_like {
  display: flex;
  flex-direction: row;
  margin-right: 35px;
  background: ghostwhite;
  cursor: pointer;
}

.wirter {
  display: flex;
  flex-direction: row;
  margin-right: 35px;
  background: ghostwhite;
  cursor: pointer;
}

.bolg_list{
    margin-top: 50px;
}
</style>