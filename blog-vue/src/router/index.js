import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'blog',
      components: {
        default:resolve=>require(['@/components/home_page/app_bar'],resolve),
        news:resolve=>require(['@/components/home_page/news'],resolve),
        news_context:resolve=>require(['@/components/home_page/news_context'],resolve),
        app_bar:resolve=>require(['@/components/home_page/app_bar'],resolve),
        category:resolve=>require(['@/components/home_page/category'],resolve)
      } 
    },{
      path: '/login',
      name: 'login',
      components: {
        default:resolve=>require(['@/components/login_page/login_form'],resolve)
      } 
    }
  ]
})





