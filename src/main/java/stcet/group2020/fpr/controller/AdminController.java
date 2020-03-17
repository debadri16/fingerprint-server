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
import stcet.group2020.fpr.repository.AdminRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("admins")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping(params = "id")
	public Optional<Admin> getAdmin(@RequestParam("id") String id) {
		return adminRepository.findById(id);
	}
	
	@GetMapping
	public List<Admin> getAll() {
		return (List<Admin>) adminRepository.findAll();
	}
	
	@PostMapping
	public Admin add(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
}
