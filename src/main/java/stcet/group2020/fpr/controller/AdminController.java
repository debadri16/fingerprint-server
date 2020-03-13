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

import stcet.group2020.fpr.model.Admin;
import stcet.group2020.fpr.model.Department;
import stcet.group2020.fpr.repository.AdminRepository;
import stcet.group2020.fpr.repository.DepartmentRepository;
import stcet.group2020.fpr.repository.interfaces.AdminMinutiae;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("admins")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping(params = "id")
	public Optional<Admin> getAdmin(@RequestParam("id") String id) {
		return adminRepository.findById(id);
	}
	
	@GetMapping
	public List<Admin> getAll() {
		return (List<Admin>) adminRepository.findAll();
	}
	
	@GetMapping("/minutiae")
	public List<AdminMinutiae> getAllMinutiae(){
		return adminRepository.findAdminMinutiae();
	}
	
	@PostMapping
	public Admin add(@RequestBody Admin admin) {
		Department department = departmentRepository.findById(admin.getDept_id()).get();
		admin.setDepartment(department);
		return adminRepository.save(admin);
	}
}
