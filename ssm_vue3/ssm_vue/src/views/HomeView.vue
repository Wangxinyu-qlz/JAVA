<!--<template>-->
<!--  <div class="home">-->
<!--    &lt;!&ndash;主页面的大大的Vue图标&ndash;&gt;-->
<!--    <img alt="Vue logo" src="../assets/logo.png">-->
<!--    &lt;!&ndash;使用HelloWorld组件来自'@/components/HelloWorld.vue'-->
<!--    @ 代表 /src-->
<!--    msg="Welcome to Your Vue.js App" 给HelloWorld组件设置一个属性值（显示在前端）&ndash;&gt;-->
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--  </div>-->
<!--</template>-->

<template>
  <!--引入表格-->
  <div>
    <!--按钮和搜索框-->
    <!--左右上下边距设置-->
    <div style="margin: 10px 5px">
      <el-button type="primary">新增</el-button>
      <el-button>其他</el-button>
    </div>
    <!--搜索框-->
    <div style="margin: 10px 5px">
      <!--v-model:双向数据绑定-->
      <el-input v-model="search" style="width: 30%" placeholder="请输入关键字"/>
      <el-button style="margin-left: 10px" type="primary">查询</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 90%">
      <el-table-column sortable prop="date" label="日期"/>
      <el-table-column prop="name" label="名字"/>
      <el-table-column prop="address" label="地址"/>
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button type="text" @click="handleEdit(scope.row)">
            编辑
          </el-button>
          <el-button type="text">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
// 导出组件 在HomeView.vue可以使用HelloWorld组件
// export default {
//   name: 'HomeView',
//   components: {
//     HelloWorld
//   }
// }
export default {
  name: "HomeView",
  components: {},
  data() {
    return {
      search: "",
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  }
}
</script>
