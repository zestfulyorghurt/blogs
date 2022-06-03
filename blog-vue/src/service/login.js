import {api} from "./config/service";

const login = {
    doLogin(data){
        console.log(data);
        return api.post("/api/loginCheckOut",data);
    },
    doRegiste(data){
        return api.post("/api/registe");
    }
}

export default login;