package extrafieldlogin.repo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import extrafieldlogin.simpleextrafield.User;

@Repository
public class SimpleUserRepository {

	private PasswordEncoder passwordEncoderzzzz;

	public SimpleUserRepository(PasswordEncoder passwordEncoder) {
		this.passwordEncoderzzzz = passwordEncoder;
	}

	public User findUser(String username, String domain) {
		if (!StringUtils.hasLength(username)) {
			return null;
		} else {
			Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
//			User user = new User(username, domain, passwordEncoder.passwordEncoder("secret"), true, true, true, true,
//					authorities);
			User user = new User(username, domain, passwordEncoderzzzz.encode("secret"), true, true, true, true,
					authorities);
			return user;
		}
	}

}
