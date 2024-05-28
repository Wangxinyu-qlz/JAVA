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
    <!--点击新增触发add方法-->
    <div style="margin: 10px 5px">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button>其他</el-button>
    </div>
    <!--搜索框-->
    <div style="margin: 10px 5px">
      <!--v-model:双向数据绑定-->
      <el-input v-model="search" style="width: 30%" placeholder="请输入关键字"/>
      <el-button style="margin-left: 10px" type="primary">查询</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 90%">
      <el-table-column
          prop="id"
          label="ID"
          sortable>
      </el-table-column>
      <el-table-column
          prop="name"
          label="家居名">
      </el-table-column>
      <el-table-column
          prop="maker"
          label="厂家">
      </el-table-column>

      <el-table-column
          prop="price"
          label="价格">
      </el-table-column>

      <el-table-column
          prop="sales"
          label="销量">
      </el-table-column>

      <el-table-column
          prop="stock"
          label="库存">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="120">
        <!--将当前行数据传递给handleEdit-->
        <template #default="scope">
          <el-button type="text" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除？" @confirm="handleDel(scope.row.id)">
            <template #reference>
              <el-button size="small" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--
    el-dialog ：v-model="dialogVisible"对话框和dialogVisible变量双向绑定，控制是否提示对话框
    el-form :model="form" 表示表单，数据和form数据变量双向绑定
    el-input v-model="form.name" 表示表单的input空间，名字为name 需要和后台的JavaBean属性一致
    前端中，对象的属性可以动态生成
    -->
    <el-dialog title="提示" v-model="dialogVisible" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="家居名">
          <el-input v-model="form.name" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="厂商">
          <el-input v-model="form.maker" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="form.price" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="销量">
          <el-input v-model="form.sales" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="库存">
          <el-input v-model="form.stock" style="width: 80%"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button>
        </span>
      </template>
    </el-dialog>


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
//导入request
import request from "@/utils/request";

export default {
  name: "HomeView",
  components: {},
  data() {
    return {
      dialogVisible: false,//提示框可见设置为false
      form: {},//定义一个空表单
      search: "",
      tableData: [

      ]
    }
  },
  created() {
    this.list();//调用显示家具信息
  },
  methods: {
    add() {
      // 显示对话框
      this.dialogVisible = true;
      // 清空上次填写的数据
      this.form = {};
    },
    save() {//将request
      //修改和添加都是同一个save方法
      // console.log(this.form.id);
      if (this.form.id) {//修改
        request.put("/api/update", this.form).then(res => {
          if (res.code === 200) {
            //提示成功
            this.$message(
                {
                  type: "success",
                  message: "更新成功",
                }
            )
          } else {
            //提示失败
            this.$message(
                {
                  type: "error",
                  message: "更新失败",
                }
            )
          }
          //关闭对话框
          this.dialogVisible = false;
          this.list();//刷新数据
        })
      } else {
        // 请求的地址 + 携带的数据
        request.post("/api/save", this.form).then(res => {
          // console.log("res-", res);
          this.dialogVisible = false;
          this.list();//刷新列表
        })
      }
      // TODO 如果放在这里，ajax是异步执行，res => 是回调机制
      // TODO 可能会等不到数据更新，就会执行这里，关闭弹窗，刷新列表，导致不会页面更新
      // this.dialogVisible = false;
      // this.list();//刷新列表

    },
    //list方法，请求返回家具信息 打开页面自动触发
    list() {
      // request.js 统一拦截处理 res ==> response.data
      request.get("/api/furns").then(res => {
        // console.log(res);
        // res.data.extend.furnList 由返回的res的数据结构决定
        this.tableData = res.extend.furnList;//绑定
      })
    },
    handleEdit(row) {
      // console.log(row);
      //将数据绑定到对话框的form
      // 方法1
      // this.form = JSON.parse(JSON.stringify(row));
      // 方法2
      request.get("/api/find/" + row.id).then(res => {
        this.form = res.extend.furn;
      })
      this.dialogVisible = true;
    },
    handleDel(id) {
      request.delete("/api/del/" + id).then(res => {
        if (res.code === 200) {
          this.$message(
              {
                type: "success",
                message: res.message,
              }
          )
        } else {
          this.$message(
              {
                type: "error",
                message: res.message,
              }
          )
        }
        //刷新页面数据
        this.list();
      })
    }

  }
}
</script>
