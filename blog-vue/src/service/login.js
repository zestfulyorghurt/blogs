import {api} from "./config/service";

const login = {
    doLogin(data){
        console.log(data);
        return api.post("/api/login",data);
    },
    doRegiste(data){
        console.log(data);
        return api.post("/api/regist",data);
    }
}

export default login;