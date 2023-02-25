<template>
  <div id="top_line_value">
    <div class="container">
      <div class="title" id="title" v-html="title"></div>

      <div class="writer" id="writer">
        <div
          style="
            height: 30px;
            display: flex;
            flex-direction: row;
            margin-left: 40px;
          "
        >
          <a>{{ writer }}</a>

          <span style="margin-left: 30px">{{ create_time }}</span>

          <div style="margin-left: 30px; display: flex">
            <svg
              t="1641802021392"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="4164"
              width="20"
              height="20"
            >
              <path
                d="M1024 512c-93.44 180.224-287.744 303.872-512 303.872S93.44 692.224 0 512c93.44-180.224 287.744-303.872 512-303.872S930.56 331.776 1024 512zM512 698.112c110.08 0 199.168-85.248 199.168-190.464S622.08 317.184 512 317.184s-199.168 85.248-199.168 190.464S401.92 698.112 512 698.112z"
                p-id="4165"
                fill="#bfbfbf"
              ></path>
              <path
                d="M369.664 512c0 83.2 63.744 150.784 142.336 150.784S654.336 595.2 654.336 512 590.592 361.216 512 361.216 369.664 428.8 369.664 512z"
                p-id="4166"
                fill="#bfbfbf"
              ></path>
            </svg>
            <span style=""> {{ see_count }}</span>
          </div>

          <div style="margin-left: 30px; display: flex">
            <svg
              t="1641801963375"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="3081"
              width="20"
              height="20"
            >
              <path
                d="M335.008 916.629333c-35.914667 22.314667-82.88 10.773333-104.693333-25.557333a77.333333 77.333333 0 0 1-8.96-57.429333l46.485333-198.24a13.141333 13.141333 0 0 0-4.021333-12.864l-152.16-132.586667c-31.605333-27.52-35.253333-75.648-8.234667-107.733333a75.68 75.68 0 0 1 51.733333-26.752L354.848 339.2c4.352-0.362667 8.245333-3.232 10.026667-7.594667l76.938666-188.170666c16.032-39.2 60.618667-57.92 99.52-41.461334a76.309333 76.309333 0 0 1 40.832 41.461334l76.938667 188.16c1.781333 4.373333 5.674667 7.253333 10.026667 7.605333l199.712 16.277333c41.877333 3.413333 72.885333 40.458667 69.568 82.517334a76.938667 76.938667 0 0 1-26.08 51.978666l-152.16 132.586667c-3.541333 3.082667-5.141333 8.074667-4.021334 12.853333l46.485334 198.24c9.621333 41.013333-15.36 82.336-56.138667 92.224a75.285333 75.285333 0 0 1-57.525333-9.237333l-170.976-106.24a11.296 11.296 0 0 0-12.010667 0l-170.986667 106.24z"
                p-id="3082"
                fill="#bfbfbf"
              ></path>
            </svg>
            <span>{{ collect_count }}</span>
          </div>
        </div>
        <div
          style="
            height: 30px;
            display: flex;
            flex-direction: row;
            background: white;
          "
        >
          <div style="width: 98%; margin-left: 1%"></div>
        </div>
      </div>

      <article v-html="value" id="article"></article>
    </div>
  </div>
</template>

<script>
export default {
  name: "top_line_value",
  components: {
  },
  data() {
    return {
      message: "localhost:8080",
      app_bar_class: false,
      value:
        "<h4>新闻热点内容</h4><br/>455555555555555555555555555555555555555555555555555577777777777777777777777777777777777777777777777777777777777777777888888888888",
      title: "<h1>新闻热点</h1>",
      writer: "zhang",
      create_time: "nnnn-MM-dd HH:mm:ss",
      see_count: "4568",
      collect_count: "1234",
    };
  },
  methods: {
    login() {
      axios
        .post("http://localhost:8086/loginCheckOut", users)
        .then(function (resp) {
          console.log("788");
          data = resp;
          console.log(data);
        });
    },
  },
};
</script>

<style scoped>
.container {
  margin: 40px 40px;
}

#top_line_value {
  background: white;
  width: 60%;
  margin-left: 20%;
  margin-right: 20%;
  display: flex;
  flex-direction: column;
  box-shadow: 2px 3px 4px #f0f0f0;
}

/* .title {
  text-align: center;
} */

.writer {
  display: flex;

  flex-direction: column;

  height: 60px;

  background: #f5f5f5;

  border-radius: 10px;

  margin-top: 25px;
}

#article {
  margin-top: 25px;
  word-break: break-all;
  word-wrap: break-word;
  white-space: normal;
}
</style>
