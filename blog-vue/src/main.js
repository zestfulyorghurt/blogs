import Vue from 'vue'
import './plugins/axios'
import App from './App'
import router from './router'
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import './icons'

Vue.use(ElementUI);

// Vue.prototype.$http = axiosConfig

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})



