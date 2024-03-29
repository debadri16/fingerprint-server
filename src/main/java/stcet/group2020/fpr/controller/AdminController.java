package stcet.group2020.fpr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Admin;
import stcet.group2020.fpr.payload.response.AdminCngPass;
import stcet.group2020.fpr.payload.response.JwtResponse;
import stcet.group2020.fpr.payload.response.MessageResponse;
import stcet.group2020.fpr.repository.AdminRepository;
import stcet.group2020.fpr.security.jwt.JwtUtils;
import stcet.group2020.fpr.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("admins")
public class AdminController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping(params = "id")
	@PreAuthorize("hasRole('ROOT')")
	public Optional<Admin> getAdmin(@RequestParam("id") String id) {
		return adminRepository.findById(id);
	}
	
	@GetMapping
	public List<Admin> getAll() {
		return (List<Admin>) adminRepository.findAllByRole("ROLE_ADMIN");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Admin admin) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(admin.getAdminId(), admin.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		admin = adminRepository.findById(admin.getAdminId()).get();
		return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getUsername(),admin.getName(),admin.getDeptId()));
	}
	
	@PostMapping("/register")
	@PreAuthorize("hasRole('ROOT')")
	public ResponseEntity<?> add(@RequestBody Admin admin) {
		if (adminRepository.existsByAdminId(admin.getAdminId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Id " +admin.getAdminId() + " is already taken!"));
		}

		admin.setPassword(encoder.encode(admin.getPassword()));
		admin.setRole("ROLE_ADMIN");
		adminRepository.save(admin);

		return ResponseEntity.ok(new MessageResponse("Admin " + admin.getName() + " is registered successfully with id " + admin.getAdminId() ));
	}

	@PutMapping("/changePassword")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> changePassword(@RequestBody AdminCngPass admin){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(admin.getAdminId(), admin.getOldPassword()));

		adminRepository.changePassword(admin.getAdminId(), encoder.encode(admin.getNewPassword()));

		return ResponseEntity.ok(new MessageResponse("Password changed successfully with id: " + admin.getAdminId()));
	}

	@PostMapping("/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteAdmin(@RequestBody Admin admin){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(admin.getAdminId(), admin.getPassword()));

		adminRepository.deleteByAdminId(admin.getAdminId());
		return ResponseEntity.ok(new MessageResponse("Admin deleted successfully with id: " + admin.getAdminId()));
	}

	@PostMapping("/deleteById")
	@PreAuthorize("hasRole('ROOT')")
	public ResponseEntity<?> deleteAdminById(@RequestBody Admin admin){
		adminRepository.deleteByAdminId(admin.getAdminId());
		return ResponseEntity.ok(new MessageResponse("Admin deleted successfully with id: " + admin.getAdminId()));
	}
}
