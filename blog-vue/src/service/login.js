import {api} from "./config/service";

const login = {
    doLogin(data){
        console.log(data);
        return api.post("/api/loginCheckOut",data);
    },
    doRegiste(data){
        console.log(data);
        return api.post("/api/registe",data);
    }
}

export default login;