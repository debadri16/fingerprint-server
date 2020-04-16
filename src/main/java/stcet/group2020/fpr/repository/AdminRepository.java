package stcet.group2020.fpr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
	
	public List<Admin> findAllByRole(String role);
	
	public Optional<Admin> findOneByAdminIdAndPassword(String adminId, String password);

	public Optional<Admin> findByAdminId(String adminId);

	Boolean existsByAdminId(String adminId);
}
