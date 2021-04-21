package extrafieldlogin.simpleextrafield;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import extrafieldlogin.repo.SimpleUserRepository;
import extrafieldlogin.services.LoginAttemptService;

@Service
public class SimpleUserDetailServices implements UserDetailsService {

	private SimpleUserRepository userRepository;

	public SimpleUserDetailServices(SimpleUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// attack prevent brute force
	@Autowired
	private LoginAttemptService loginAttemptService;

	@Autowired
	private HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// attack prevent brute force
		String ip = getClientIP();
		if (loginAttemptService.isBlocked(ip)) {
			throw new RuntimeException("blocked");
		}

		String[] usernameAndDomain = StringUtils.split(username, String.valueOf(Character.LINE_SEPARATOR));
		if (usernameAndDomain == null || usernameAndDomain.length != 2) {
			throw new UsernameNotFoundException("Username and domain must be provided");
		}

		User user = userRepository.findUser(usernameAndDomain[0], usernameAndDomain[1]);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

	private String getClientIP() {
		String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}
}
