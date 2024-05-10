<!--<template>-->
<!--  &lt;!&ndash;这个文件可以用于布局界面-->
<!--  <router-view/>：路由指令，会将路由到的页面，展示/替换在<router-view/>-->
<!--  比如： url：http://localhost:8081/ 路由的path是/-->
<!--        url：http://localhost:8081/about 路由的path是/about &ndash;&gt;-->
<!--  <nav>-->
<!--    <router-link to="/">Home</router-link>-->
<!--    |-->
<!--    <router-link to="/about">About</router-link>-->
<!--  </nav>-->
<!--  <router-view/>-->
<!--</template>-->
<template>
  <div>
    <!--头部-->
    <Header/>
    <!--主体-->
    <div style="display: flex;">
      <!--侧边栏-->
      <Aside/>
      <!--内容区域 通过路由展示 默认路由到HomeView-->
      <router-view style="flex: 1;"/>
    </div>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Aside from '@/components/Aside.vue'
export default {
  name: "Layout",
  components: {
    Header,
    Aside
  }
}
</script>

<style>

</style>
