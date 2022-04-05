<template>
  <div id="news_context">
    <div
      class="bolg_list flex_row_center"
      v-for="(item, index) in data"
      :key="index"
    >
      <div style="width: 1050px">
        <!-- 博客简介标题 -->
        <div style="margin: 1em 0em 0em 0em">
          <span>
            <a href="#">
              <h4>{{ item.title }}</h4>
            </a>
          </span>
        </div>

        <!-- 博客简介内容 -->
        <div class="flex_row" style="margin: 1em 0em 0em 0em">
          <!-- 博客简介图片 -->
          <div style="margin: 1em 0em 0em 0em">
            <img src="@/assets/csdn_copy_logo.jpg" draggable="false" />
          </div>

          <!-- 博客简介内容，简介，作者，点赞 -->
          <div class="flex_colum" style="margin: 1em 0em 1em 1em; width: 890px">
            <!-- 简介 -->
            <div style="margin: 0em 0em 0em 1em">
              <span class="text">
                {{ item.context }}
              </span>
            </div>

            <div class="flex_row">
              <!-- 点赞 -->
              <div class="flex_row" style="cursor: pointer; margin-left: 1em">
                <div class="flex_colum_center">
                  <svg-icon
                    icon-class="like_off"
                    style="width: 1.5em; height: 1.2em"
                  ></svg-icon>
                </div>
                <div>
                  <span style="margin-left: 0.5em">{{ item.like }}</span>
                </div>
              </div>

              <!-- 点踩 -->
              <div class="flex_row" style="cursor: pointer; margin-left: 1em">
                <div class="flex_colum_center">
                  <svg-icon
                    icon-class="not_like_off"
                    style="width: 1em; height: 1em"
                  ></svg-icon>
                </div>
                <div>
                  <span style="margin-left: 0.5em">{{ item.not_like }}</span>
                </div>
              </div>

              <!-- 作者 -->
              <div class="flex_row" style="cursor: pointer; margin-left: 1em">
                <div>
                  <span>{{ item.write }}</span>
                </div>
                <div style="margin-left: 1em">...</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
var data = [
  {
    title: "今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板",
    context:
      "简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 |李志信来源 | 阿里技术公众号作者介绍：李志信（github@laurencelizhixin），dubbo-go 3.0 负责人，Apache DubboPMC，来自阿里云中间件团队，从事 Go语言中间件的研发和开源工作。于雨 （github",
    like: "5",
    not_like: "4",
    write: "会飞的鱼",
  },
  {
    title: "今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板",
    context:
      "简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 |李志信来源 | 阿里技术公众号作者介绍：李志信（github@laurencelizhixin），dubbo-go 3.0 负责人，Apache DubboPMC，来自阿里云中间件团队，从事 Go语言中间件的研发和开源工作。于雨 （github",
    like: "5",
    not_like: "4",
    write: "会飞的鱼",
  },
  {
    title: "今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板",
    context:
      "简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 |李志信来源 | 阿里技术公众号作者介绍：李志信（github@laurencelizhixin），dubbo-go 3.0 负责人，Apache DubboPMC，来自阿里云中间件团队，从事 Go语言中间件的研发和开源工作。于雨 （github",
    like: "5",
    not_like: "4",
    write: "会飞的鱼",
  },
  {
    title: "今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板",
    context:
      "简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 |李志信来源 | 阿里技术公众号作者介绍：李志信（github@laurencelizhixin），dubbo-go 3.0 负责人，Apache DubboPMC，来自阿里云中间件团队，从事 Go语言中间件的研发和开源工作。于雨 （github",
    like: "5",
    not_like: "4",
    write: "会飞的鱼",
  },
  {
    title: "今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板",
    context:
      "简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 |李志信来源 | 阿里技术公众号作者介绍：李志信（github@laurencelizhixin），dubbo-go 3.0 负责人，Apache DubboPMC，来自阿里云中间件团队，从事 Go语言中间件的研发和开源工作。于雨 （github",
    like: "5",
    not_like: "4",
    write: "会飞的鱼",
  },
  {
    title: "今天面了个腾讯拿38K出来的老表，让我见识到了基础的天花板",
    context:
      "简介：Dubbo-go 是常新的，每年都在不断进化。介绍 Dubbo-go 3.0工作之前，先回顾其过往 6 年的发展历程，以明晰未来的方向。作者 |李志信来源 | 阿里技术公众号作者介绍：李志信（github@laurencelizhixin），dubbo-go 3.0 负责人，Apache DubboPMC，来自阿里云中间件团队，从事 Go语言中间件的研发和开源工作。于雨 （github",
    like: "5",
    not_like: "4",
    write: "会飞的鱼",
  },
];
export default {
  name: "news_context",
  data() {
    return {
      data: data,
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

/* 整体位置布局 */
#news {
  margin-top: 80px;
  min-width: 1445px;
  user-select: none;
}

#news_context {
  display: flex;
  flex-direction: column;
  min-width: 1409px;
  user-select: none;
}

.text {
  max-width: 100%;
  display: inline-block;
  overflow-wrap: break-word; /*  css3属性，当内容超过指定容器的边界时是否断行  */
  text-align: left;
  font-size: 16px;
  color: darkgray;
}

.bolg_list {
  margin-top: 5em;
}

/* 去掉a标签的下划线 */
a {
  text-decoration: none;
}
</style>