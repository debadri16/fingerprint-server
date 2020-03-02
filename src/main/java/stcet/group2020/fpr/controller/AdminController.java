package stcet.group2020.fpr.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Admin;
import stcet.group2020.fpr.repository.AdminRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@PostMapping("/add")
	public void add(@RequestBody Admin admin) {
		adminRepo.save(admin);
	}
	
	@GetMapping("/get")
    public ArrayList<Admin> get(){
        return (ArrayList<Admin>) adminRepo.findAll();
    }

}
