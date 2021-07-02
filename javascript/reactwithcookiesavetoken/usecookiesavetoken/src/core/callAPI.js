
import { axiosInstance } from "axios";

export const loginAPI = (data) => {
    try{
        let {data} = await axiosInstance.post("/login",data);
        console.log(data);
        // save cookie

    }catch (error){
        console.log(error.response);
        return error.response;
    }

}