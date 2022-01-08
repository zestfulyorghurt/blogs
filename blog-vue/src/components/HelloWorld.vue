<template>
  <div class="hello">
    <!-- <button @click="reverseMessage">连接后台</button>
    <h3>{{msg}}</h3> -->
  </div>
</template>

<script>

var data = null

axios.get('http://localhost:8086/test').then(function (resp) {
  data = resp
  console.log(resp)
})

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      message: data
    }
  },
  methods: {
    reverseMessage: function () {
      console.log(data)

      console.log(data.data)

      axios.get('http://localhost:8086/test').then(function (resp) {
        console.log(resp)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  /* position: relative; */
  margin-left: 100px;
  margin-top: 100px;
}
</style>
