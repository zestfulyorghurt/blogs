import {api} from "./config/service";

const login = {
    doLogin(){
        return api.post("/api/loginCheckOut");
    },
    doRegiste(data){
        return api.post("/api/registe");
    }
}

export default login;