package stcet.group2020.fpr.controller;

import java.util.Optional;

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
		
	@GetMapping("/{reg_no}")
	public Optional<Student> getStudent(long reg_no){
		return studentRepository.findById(reg_no);
	}
	
	@PostMapping
	public boolean addStudent(@RequestBody Student student) {
		if(studentRepository.save(student) != null)
			return true;
		return false;
	}
}
