package stcet.group2020.fpr.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Attendance a SET a.present = 1 WHERE a.regNo = ?1 AND a.classId = ?2")
    int addAttendance(@Param("regNo") String regNo, @Param("classId") long classId);
	
}
