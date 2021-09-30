import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$axios = axios; // 이렇게 전역으로 선언해서 사용하는 것 같다.

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
