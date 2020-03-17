package stcet.group2020.fpr.repository;


import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
	
	
}
