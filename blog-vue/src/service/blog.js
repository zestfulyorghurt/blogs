import {api} from "./config/service";

const blogs = 
{
    saveBlogs(data)
    {
        console.log(data)
        return api.post("",data)
    }
}

export default blogs