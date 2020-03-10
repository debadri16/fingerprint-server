package stcet.group2020.fpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Admin;
import stcet.group2020.fpr.repository.interfaces.AdminMinutiae;

public interface AdminRepository extends CrudRepository<Admin, String> {
	
	@Query("SELECT a.id as id, a.minutiae as minutiae FROM Admin a")
	List<AdminMinutiae> findAdminMinutiae();
	
}
