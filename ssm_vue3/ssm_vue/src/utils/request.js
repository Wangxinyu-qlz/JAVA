//引入axios
import axios from 'axios';
//通过axios创建对象 request 用于发送请求到后端
const request = axios.create({
    timeout: 5000,
})

//request拦截器处理
//将请求做同意处理
//加入token Content-type等
request.interceptors.request.use(
    config => {
        config.headers['Content-Type'] = 'application/json;charset=UTF-8';
        return config;
    },
    error => {
        return Promise.reject(error);
    })

//导出request对象
export default request;


//response拦截器
//在调用接口响应后，统一处理返回结果
request.interceptors.response.use(
    response => {
        let res = response.data;
        //如果返回的是文件
        if (response.config.responseType === 'blob') {
            return res;
        }
        // String
        if (typeof res === 'string') {
            // 如果res不空，进行转换
            res = res ? JSON.parse(res) : res;
        }
        return res;
    },
    error => {
        console.log(error);
        return Promise.reject(error);
    }
)