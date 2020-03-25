package stcet.group2020.fpr.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.Attendance;
import stcet.group2020.fpr.repository.interfaces.StudentReport;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Attendance a SET a.present = true WHERE a.regNo = ?1 AND a.classId = ?2")
    int addAttendance(@Param("regNo") String regNo, @Param("classId") long classId);
    
    @Query("SELECT c.date as date, a.present as present FROM Attendance a, Classes c WHERE c.courseId = ?1 AND a.classId = c.classId AND a.regNo = ?2")
	public List<StudentReport> getPresentList(Long courseId, String regNo);
}
