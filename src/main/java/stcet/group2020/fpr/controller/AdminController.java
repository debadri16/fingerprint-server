package stcet.group2020.fpr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Admin;
import stcet.group2020.fpr.repository.AdminRepository;
import stcet.group2020.fpr.repository.interfaces.AdminMinutiae;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/{id}")
	public Optional<Admin> getAdmin(@PathVariable long id) {
		return adminRepository.findById(id);
	}
	
	@GetMapping("/AllMinutiae")
	public ResponseEntity<List<AdminMinutiae>> getAllMinutiae(){
		return ResponseEntity.status(HttpStatus.OK).body(adminRepository.findAdminMinutiae());
	}
	
	@PostMapping
	public boolean add(@RequestBody Admin admin) {
		if(adminRepository.save(admin) != null)
			return true;
		return false;
		
	}
}
