import axios from 'axios'
import router from '../router'
import { Message } from 'element-ui'


axios.interceptors.response.use(function(response){
    
    //如果用户没有登录，会跳转到登录界面
    if(response.data.data.id === "noLogin"){

        router.push("/login")

        Message.error({
            message: "当前会话已经结束"
        })

    }else{
        console.log("登录")
    }


},function(error){

})



