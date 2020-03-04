package stcet.group2020.fpr.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import stcet.group2020.fpr.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
	@Modifying
    @Query("UPDATE Attendance a SET a.attendance_count = a.attendance_count+1 where a.student_reg_no = :student_reg_no and a.course_id = :course_id")
    int updateAttendance(@Param("student_reg_no") long student_reg_no, @Param("course_id") long course_id);
}
