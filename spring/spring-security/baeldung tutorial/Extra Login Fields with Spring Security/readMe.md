Prevent Brute Force Authentication Attempts with Spring Security
Sử dụng Event khi login nêu login nhiều lần số lần quy định sẽ log ip truy cập 24h trong cache

Tạo event 
Tạo custom Pulisher hoặc sử dụng DefaultAuthenticationEventPublisher
gắn pulisher vào AuthenticationManagerBuilder 

nếu sử dụng AuthenticationFilter thì nên lưu ý lúc set các failureHandler ... trong security config

