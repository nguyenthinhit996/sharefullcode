package resourceserver.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/any/")
//@CrossOrigin(origins = "http://localhost:8089") 
public class AnyController {

	@GetMapping("/getString")
	public ResponseEntity<org.springframework.http.ResponseEntity.BodyBuilder> getAnyRequest() {
		org.springframework.http.ResponseEntity.BodyBuilder d =  ResponseEntity.accepted();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key1", "getAnyRequest success");
		d.body(map);
		return ResponseEntity.ok(d);
	}
	
}
