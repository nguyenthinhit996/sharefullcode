package extrafieldlogin.listener;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import extrafieldlogin.services.LoginAttemptService;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private LoginAttemptService loginAttemptService;

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		final String xfHeader = request.getHeader("X-Forwarded-For");
		System.out.println("xfHeader " + xfHeader);
		System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());

		if (xfHeader != null) {
			loginAttemptService.loadSuccess(xfHeader.split(",")[0]);
		} else {
			loginAttemptService.loadSuccess(request.getRemoteAddr());
		}
	}
}
