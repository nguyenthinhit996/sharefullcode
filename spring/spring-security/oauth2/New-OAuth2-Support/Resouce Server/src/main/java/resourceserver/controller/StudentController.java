package resourceserver.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import resourceserver.dao.DAOPOJO;
import resourceserver.dao.Student;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8089") 
public class StudentController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DAOPOJO dao;
	
	@GetMapping("/student")
	@ResponseStatus(code = HttpStatus.OK)
	List<Student> getAllStudent(){
		return dao.ls;
	}
	
	@PutMapping("/student")
	@ResponseStatus(code = HttpStatus.OK)
	Boolean editStudent(@RequestBody Student student) {
		LOG.info("get param from client: "+ student.getName());
		dao.editStudent(student);
		return Boolean.TRUE;
	}
	
	@PostMapping("/student")
	@ResponseStatus(code = HttpStatus.CREATED)
	List<Student> addStudent(@RequestBody Student student) {
		LOG.info("get param from client: "+ student.getName());
		return dao.addStudent(student);
	}
}
