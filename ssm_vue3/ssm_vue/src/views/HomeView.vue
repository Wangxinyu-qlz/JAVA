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

<template xmlns:overflow="http://www.w3.org/1999/xhtml">
  <!--引入表格-->
  <div class="container">
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
      <el-button style="margin-left: 10px" type="primary" @click="list">检索</el-button>
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
      <el-form :model="form" :rules="rules" ref="form" label-width="120px">
        <el-form-item label="家居名" prop="name">
          <el-input v-model="form.name" style="width: 50%"></el-input>
          {{ serverValidErrors.name }}
        </el-form-item>
        <el-form-item label="厂商" prop="maker">
          <el-input v-model="form.maker" style="width: 50%"></el-input>
          {{ serverValidErrors.maker }}
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" style="width: 50%"></el-input>
          {{ serverValidErrors.price }}
        </el-form-item>
        <el-form-item label="销量" prop="sales">
          <el-input v-model="form.sales" style="width: 50%"></el-input>
          {{ serverValidErrors.sales }}
        </el-form-item>
        <el-form-item label="库存" prop="stock">
          <el-input v-model="form.stock" style="width: 50%"></el-input>
          {{ serverValidErrors.stock }}
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button>
        </span>
      </template>
    </el-dialog>

    <!--添加分页导航-->
    <div style="margin: 10px 0">
      <el-pagination
          @size-change="handlePageSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 15]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
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
      currentPage: 1,
      pageSize: 5,
      total: 10,
      dialogVisible: false,//提示框可见设置为false
      form: {},//定义一个空表单
      search: "",//检索条件，分页时，保留上次的信息
      tableData: [],
      //定义添加表单的校验规则
      rules: {
        name: [
          {required: true, message: '请输入称家居名', trigger: 'blur'}
        ],
        maker: [
          {required: true, message: '请输入称制造商', trigger: 'blur'}
        ],
        price: [
          {required: true, message: '请输入价格', trigger: 'blur'},
          {pattern: /^(([1-9]\d*)|(0))(\.\d+)?$/, message: '请输入数字', trigger: 'blur'}
        ],
        sales: [
          {required: true, message: '请输入销量', trigger: 'blur'},
          {pattern: /^(([1-9]\d*)|(0))$/, message: '请输入数字', trigger: 'blur'}
        ],
        stock: [
          {required: true, message: '请输入库存', trigger: 'blur'},
          {pattern: /^(([1-9]\d*)|(0))$/, message: '请输入数字', trigger: 'blur'}
        ]
      },
      serverValidErrors: {},
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
      if(this.$refs['form'] !== undefined) {
        this.$refs['form'].resetFields();//将添加验证提示消息清空
      }
      this.serverValidErrors = {};//清空错误信息
    },
    save() {
      //增加处理修改逻辑
      if (this.form.id) {
        request.put("/api/update", this.form).then(res => {
          if (res.code === 200) {//如果code 为200
            this.$message({ //弹出更新成功的消息框
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({//弹出更新失败信息
              type: "error",
              message: res.msg
            })
          }
          this.list() //刷新列表
          this.dialogVisible = false
        })
      } else {//添加
        //表单数据校验是否
        this.$refs['form'].validate((valid) => {
          // 将前端的校验放行，测试后端的结果
          // valid = true;
          if (valid) {
            //=======说明======
            //1. 将form 表单提交给/api/save 的接口
            //2. /api/save 等价http://localhost:10001/save
            //3. 如果成功，就进入then 方法
            //4. res 就是返回的信息
            //5. 查看Mysql 看看数据是否保存
            request.post("/api/save", this.form).then(res => {
              if (res.code === 200) {
                this.dialogVisible = false
                this.list()
              } else if (res.code === 400) {
                this.serverValidErrors.name = res.extend.errorMsg.name;
                this.serverValidErrors.sales = res.extend.errorMsg.sales;
                this.serverValidErrors.price = res.extend.errorMsg.price;
                this.serverValidErrors.maker = res.extend.errorMsg.maker;
                this.serverValidErrors.stock = res.extend.errorMsg.stock;
              }
            })
          } else {
            this.$message({//弹出更新失败信息
              type: "error",
              message: "验证失败，不提交"
            })
            return false
          }
        })
      }
    },
    //list方法，请求返回家具信息 打开页面自动触发
    list() {
      // request.js 统一拦截处理 res ==> response.data
      // request.get("/api/furns").then(res => {
      //   // console.log(res);
      //   // res.data.extend.furnList 由返回的res的数据结构决定
      //   this.tableData = res.extend.furnList;//绑定
      // })
      //   分页查询
      // request.get("/api/furnByPages", {
      //   params: {//请求携带的参数
      //     pageNum: this.currentPage,
      //     pageSize: this.pageSize,
      //   }
      // }).then(res => {//处理分页信息
      //   this.tableData = res.extend.pageInfo.list
      //   this.total = res.extend.pageInfo.total
      // })

      // 带条件的分页查询
      request.get("/api/furnByConditionPages", {
        params: {//请求携带的参数
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search,
        }
      }).then(res => {//处理分页信息
        this.tableData = res.extend.pageInfo.list
        this.total = res.extend.pageInfo.total
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
    },
    handleCurrentChange(pageNum) {//处理分页请求
      this.currentPage = pageNum;
      this.list()
    },
    handlePageSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.list()
    }

  }
}
</script>

<!--解决页面无法滚动或者难以滚动的问题-->
<style>
html, body {
  height: 100%;
  margin: 0;
  padding: 0;
}

.container {
  height: 100%;
  overflow-y: auto;
  padding: 10px;
}
</style>
