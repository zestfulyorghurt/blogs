<template>
  <div id="app">
    <router-view />

    <router-view name="news" />

    <router-view name="news_context" />


  </div>
</template>

<script>

const users = {"userName":"zhangyi","password":"123456"};

export default {
  name: "App",
  data() {
    return {
      message: "localhost:8080",
      app_bar_class: false
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

<style>

.app_bar_class{
  display: none;
}


</style>
