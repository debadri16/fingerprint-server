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

import stcet.group2020.fpr.model.Department;
import stcet.group2020.fpr.repository.DepartmentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("departments")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping(params = "id")
	public Optional<Department> getDepartment(@RequestParam("id") int id) {
		return departmentRepository.findById(id);
	}
	
	@GetMapping
	public List<Department> getAll() {
		return (List<Department>) departmentRepository.findAll();
	}
	
	@PostMapping
	public Department add(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
}
