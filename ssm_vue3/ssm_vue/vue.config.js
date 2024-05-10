const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
// 配置服务端口
module.exports = {
  devServer: {
    port: 10000 //启动端口
  }
}
