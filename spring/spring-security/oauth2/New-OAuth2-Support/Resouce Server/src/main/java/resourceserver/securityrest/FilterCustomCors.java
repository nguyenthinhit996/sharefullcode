package resourceserver.securityrest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.GenericFilterBean;

public class FilterCustomCors extends GenericFilterBean{


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 
		if (!CorsUtils.isCorsRequest((HttpServletRequest) request)) {
			rejectRequest((HttpServletResponse) response);
			return ;
		}
		chain.doFilter(request, response);
	}
	
	void rejectRequest(HttpServletResponse response) throws IOException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().append("Invalid CORS request rrrrrrrrrr");
		response.flushBuffer();
	}
	 
}
