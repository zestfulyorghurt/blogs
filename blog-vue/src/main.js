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
import api from "./service/api.js";

//将封装的接口挂载到vue原型上
Vue.prototype.$api = api;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})



