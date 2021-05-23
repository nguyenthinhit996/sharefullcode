package resourceserver.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthenticationServerClaims {

	
	@GetMapping("/info")
	Map<String, String> getUsernameWithOrigrantion(
			@AuthenticationPrincipal Jwt pricial) {

		if(pricial == null) {
			return Collections.singletonMap("No", "no");
		}
		Map<String, String> mapStr = new HashMap<String, String>();
		mapStr.put("user_name", pricial.getClaimAsString("preferred_username"));
		String origanzationStr = pricial.getClaim("organization");
		mapStr.put("organization", origanzationStr);
		return mapStr;
	}
}
