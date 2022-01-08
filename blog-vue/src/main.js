// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import './plugins/axios'
import App from './App'
import category from './components/home_page/category'
import news from './components/home_page/news'
import news_context from './components/home_page/news_context'
import app_bar from './components/home_page/app_bar'
import router from './router'
import axiosConfig from './config/axiosConfig'
import axios from 'axios'
import { Message } from 'element-ui'
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

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



