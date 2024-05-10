// 引入资源文件

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 引入全局样式
import '@/assets/css/global.css'
// 引入Element Plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 国际化，支持中文
import zhCn from 'element-plus/es/locale/lang/zh-cn'

// mount 挂载
const app = createApp(App)
app.use(store).use(router)
app.use(ElementPlus, {
  locale: zhCn,
})
app.mount('#app')
