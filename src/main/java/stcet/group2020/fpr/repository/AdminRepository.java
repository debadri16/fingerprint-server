package stcet.group2020.fpr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
	
	public List<Admin> findAllByRole(String role);
	
	public Optional<Admin> findOneByAdminIdAndPassword(String adminId, String password);

	public Optional<Admin> findByAdminId(String adminId);

	Boolean existsByAdminId(String adminId);

	@Modifying
    @Transactional
    @Query("UPDATE Admin a SET a.password = ?2 WHERE a.adminId = ?1")
    public int changePassword(@Param("adminId") String adminId, @Param("newPassword") String newPassword);

    @Modifying
    @Transactional
    public void deleteByAdminId(String adminId);
}
