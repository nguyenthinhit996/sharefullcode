import axios from 'axios'

export default axiosInstance = axios.create({
    baseURL:"http://localhost:8089/abc",
    timeout:30000,
    headers: {
        'Context-type':'application/json'
    }
});

 