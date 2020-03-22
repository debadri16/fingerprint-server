package stcet.group2020.fpr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping(params = "batchNo")
	public List<Student> getStudentByBatchNo(@RequestParam("batchNo")int batchNo){
		return studentRepository.findByBatchNo(batchNo);
	}

	@GetMapping(params = {"batchNo", "deptId"})
	public List<Student> getStudentByBatchNo(@RequestParam("batchNo")int batchNo, @RequestParam("deptId")int deptId){
		return studentRepository.findByBatchNoAndDeptId(batchNo, deptId);
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@PutMapping(params = {"regNo", "deptId"})
	public int editDepartment(@RequestParam("regNo") String regNo, @RequestParam("deptId") int deptId){
		return studentRepository.editDepartment(regNo, deptId);
	}

	@DeleteMapping(params = "regNo")
	public void deleteStudent(@RequestParam("regNo") String regNo) {
		studentRepository.deleteById(regNo);
	}

	@DeleteMapping(params = "batchNo")
	public void deleteBatch(@RequestParam("batchNo") int batchNo) {
		studentRepository.deleteByBatchNo(batchNo);
	}
	
}
