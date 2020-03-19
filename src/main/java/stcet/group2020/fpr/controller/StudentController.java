package stcet.group2020.fpr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> allStudent(){
		return (List<Student>)studentRepository.findAll();
	}

	@GetMapping(params = "regNo")
	public Optional<Student> getStudent(@RequestParam("regNo")String regNo){
		return studentRepository.findById(regNo);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
}
