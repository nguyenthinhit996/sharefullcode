package resouceserverwithgoogle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

	
	@GetMapping("/api")
	String indexResult() {
		return "this is value api of localhot ";
	}
}
