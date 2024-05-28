const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
// 配置服务端口
module.exports = {
  devServer: {
    port: 10001, //启动端口
    proxy:{//解决跨域问题，设置代理
      '/api':{//设置拦截器  /api/save ==>  http://127.0.0.1:8080/ssm/save
        // localhost ==> 127.0.0.1 否则500 404
        // 最后有没有 / 都可
        target: 'http://127.0.0.1:8080/ssm',//代理的目标地址 /api 代替 http://127.0.0.1:8080/ssm/
        changeOrigin: true,//设置是否同源，浏览器允许跨域访问
        ws:true,
        pathRewrite: {//路径重写
          '^/api':''//选择忽略拦截器里面的单词
        }
      }
    }
  }
}
