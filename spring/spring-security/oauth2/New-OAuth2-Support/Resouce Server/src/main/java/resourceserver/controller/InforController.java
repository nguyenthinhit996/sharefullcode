package resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8089") 
public class InforController {

	
	@GetMapping
	@RequestMapping("/infoserver")
	String getinforServer() {
		return "infoserver ... ";
	}
}
