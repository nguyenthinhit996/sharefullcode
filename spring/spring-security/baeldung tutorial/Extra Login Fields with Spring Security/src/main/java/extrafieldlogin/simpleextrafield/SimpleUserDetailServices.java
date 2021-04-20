package extrafieldlogin.simpleextrafield;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import extrafieldlogin.repo.SimpleUserRepository;

@Service
public class SimpleUserDetailServices implements UserDetailsService {

	private SimpleUserRepository userRepository;

	public SimpleUserDetailServices(SimpleUserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String[] usernameAndDomain = StringUtils.split(username, String.valueOf(Character.LINE_SEPARATOR));
		if (usernameAndDomain == null || usernameAndDomain.length != 2) {
			throw new UsernameNotFoundException("Username and domain must be provided");
		}
		
		User user = userRepository.findUser(usernameAndDomain[0], usernameAndDomain[1]);
		if(user ==  null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

}
