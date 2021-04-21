package extrafieldlogin.listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler  implements AuthenticationFailureHandler{

 
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String error = exception.getMessage();
		String url = "/login?error=true";
		if(error.contains("blocked")) {
			response.sendError(429,"blocked ip 24 h Too Many Requests");
		}else {
			super.getRedirectStrategy().sendRedirect(request, response,url);
		}
		
	}

}
