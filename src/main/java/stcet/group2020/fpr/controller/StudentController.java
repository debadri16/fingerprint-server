package stcet.group2020.fpr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Department;
import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.repository.DepartmentRepository;
import stcet.group2020.fpr.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
		
	@GetMapping(params = "reg_no")
	public Optional<Student> getStudent(@RequestParam("reg_no") String reg_no){
		return studentRepository.findById(reg_no);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		Department department = departmentRepository.findById(student.getDeptId()).get();
		student.setDepartment(department);
		return studentRepository.save(student);
	}
}
