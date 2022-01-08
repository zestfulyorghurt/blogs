<template>
  <div id="category">
    <ul style="display: flex; flex-direction: row; justify-content: center">
      <li
        class="category_li_style"
        v-for="(item, index) in li_data"
        :key="index"
      >
        <a>
          {{ item }}
        </a>
      </li>
    </ul>
  </div>
</template>  

<script>
var data = null;

var li_data = ["java", "python", "#c", "数据库", "前端"];

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
#category {
  margin-top: 80px;
  min-width: 1445px;
}

.float_left {
  float: left;
}

.left_20 {
  margin-left: 20px;
}
.category_li_style {
  list-style: none;
  width: 100px;
  text-align: center;
  border: 1px solid white;
  cursor: pointer;
}
.category_li_style:hover {
  animation: shadow-change 0.8s;
  box-shadow: 2px 3px 4px gainsboro;
}

/* @keyframes shadow-change {
  0% {
    transform: scale(1, 1);
  }
  50% {
    transform: scale(1.2, 1.2);
  }
  100% {
    transform: scale(1, 1);
  }
} */
</style>
