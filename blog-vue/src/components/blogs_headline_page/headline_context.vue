<template>
  <div id="headline_context">
    <app_bar />
    <top_line_value style="margin-top:70px"/>
  </div>
</template>

<script>
import top_line_value from "./top_line_value.vue";

export default {
  name: "headline_context",
  components: {
    top_line_value
  },
  data() {
    return {
      message: "localhost:8080",
      app_bar_class: false,
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
</style>
