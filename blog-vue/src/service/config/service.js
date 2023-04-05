    import axios from 'axios'
    
    import qs from 'qs' //引入qs，用来序列化post类型的数据，否则后端无法接收到数据

    //设置post请求头
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';

    //在跨域请求时，不会去携带用户凭证;返回的 response 里也会忽略 cookie zhangyi20220528不懂
    axios.defaults.withCredentials = false;

    //创建axios实例并设置默认超时时间为300m秒
    const instence = axios.create({
        timeout: 300000
    });


    // 设置请求发起前的拦截
    instence.interceptors.request.use((config) => {
        //这里可以做请求拦截 config.headers['X-Token'] = token
        if(localStorage.getItem("token") != null)
        {
            config.headers['Authorization'] = localStorage.getItem("token");  
        }
        console.log("请求拦截",config);
        return config;  
    },(error) => {
        //请求失败的处理
        console.log("请求失败");
        return Promise.reject();//zhangyi20220528不懂
    });

    //设置响应拦截
    instence.interceptors.response.use(response => {
        console.log("响应拦截",response);
        return response;
    }, error => {
        console.log('catch',error);
        return Promise.reject(error);
    });


    //按照请求对axios进行封装
    const api = {
        get(url,data){
            return instence.get(url,{params:data})
        },
        post(url,data){
            console.log(data)
            return instence.post(url,data)
        }    
    }

    export {api}