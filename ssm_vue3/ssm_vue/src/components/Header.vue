<script setup>

</script>

<template>
  <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc;
display: flex">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color:
dodgerblue">后台管理
    </div>
    <!--弹性布局，其他两个div占用300px，剩下的都给这个div-->
    <div style="flex: 1"></div>
    <el-dropdown>
    <span class="el-dropdown-link">
      我的下拉框
      <el-icon class="el-icon--right">
        <arrow-down />
      </el-icon>
    </span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item>个人信息</el-dropdown-item>
        <el-dropdown-item>退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
  </div>
</template>
<script>
export default {
  name: "Header"
}
</script>
<style scoped>

</style>