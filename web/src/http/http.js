import axios from "axios";

const Axios = axios.create({
    baseURL: '/api',
    timeout: 30000
})

/**
 * 请求拦截配置
 */
Axios.interceptors.request.use(config => {
    // 设置token,cookie等
    return config;
}, error => {
    console.log('error ', error.message)
    return Promise.reject(error.message)
})

/**
 * 响应拦截配置
 */
Axios.interceptors.response.use(response => {

    return response.data
}, error => {
    // 统一错误处理

    return Promise.reject(error.data || error)
})

export default Axios;
