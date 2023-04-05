import {api} from "./config/service";

const blogs = 
{
    saveBlogs(data)
    {
        console.log(data)
        return api.post("",data)
    },
    test()
    {
        return api.get("/api/Test","");
    }
}

export default blogs