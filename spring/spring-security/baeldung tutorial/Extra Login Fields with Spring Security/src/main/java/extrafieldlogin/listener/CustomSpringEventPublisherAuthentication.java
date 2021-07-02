package extrafieldlogin.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;


public class CustomSpringEventPublisherAuthentication implements AuthenticationEventPublisher, ApplicationEventPublisherAware {
	
	ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		this.applicationEventPublisher.publishEvent(new AuthenticationSuccessEvent(authentication));
	}

	@Override
	public void publishAuthenticationFailure(org.springframework.security.core.AuthenticationException exception,
			Authentication authentication) {
		this.applicationEventPublisher.publishEvent(new AuthenticationFailureBadCredentialsEvent(authentication, exception));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher =  applicationEventPublisher;
	}
}
