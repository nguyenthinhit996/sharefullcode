package resouceserverwithgoogle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class ControllerNotRest {

	@GetMapping("/home")
	public String index() {
		return "index";
	}
	

	@GetMapping("/privacy")
	public String privacy() {
		return "privacy";
	}
	
	@GetMapping("/termsofservice")
	public String termsofservice() {
		return "termsofservice";
	}
}
