<template>
  <div class="hello">
    <button>点击连接后台</button>
    <div style="height: 48px"></div>
  </div>
</template>

<script>
var data = null;

axios.get("http://localhost:8086/test").then(function (resp) {
  data = resp;
  console.log(resp);
});

export default {
  name: "blog",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      message: data,
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
.hello {
  /* position: relative; */
  margin-top: 48px;
  min-width: 1445px;
  border: 1px solid red;
}
</style>
