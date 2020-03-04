package stcet.group2020.fpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
		
	@PostMapping("/addStudent")
	public boolean addStudent(@RequestBody Student student) {
		if(studentRepository.save(student) != null)
			return true;
		return false;
	}
	
}
