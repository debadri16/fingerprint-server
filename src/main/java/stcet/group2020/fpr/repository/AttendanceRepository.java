package stcet.group2020.fpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.Attendance;
import stcet.group2020.fpr.repository.interfaces.CourseReport;
import stcet.group2020.fpr.repository.interfaces.StudentMinutiae;
import stcet.group2020.fpr.repository.interfaces.StudentReport;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

	@Modifying
	@Transactional
    @Query("UPDATE Attendance a SET a.attendance_count = a.attendance_count + 1 WHERE a.id.student_reg_no = :student_reg_no AND a.id.course_id = :course_id")
    int updateAttendance(@Param("student_reg_no") long student_reg_no, @Param("course_id") long course_id);

	@Query("SELECT s.reg_no AS reg_no, s.minutiae AS minutiae FROM Student s, Attendance a WHERE a.id.course_id = :course_id AND a.id.student_reg_no = s.reg_no")
	List<StudentMinutiae> getStudentMinutiaeByCourseId(@Param("course_id")long course_id);
	
	@Query("SELECT c.id AS id, c.name AS name, a.attendance_count as attendance_count, c.totalClasses AS totalClasses FROM Attendance a, Course c, Student s WHERE a.id.student_reg_no = :student_reg_no AND s.reg_no = :student_reg_no AND c.id = a.id.course_id")
	List<StudentReport> getReportByStudent(@Param("student_reg_no")long student_reg_no);
	
	@Query("SELECT s.reg_no AS reg_no, s.name as name, a.attendance_count as attendance_count FROM Attendance a, Course c, Student s WHERE a.id.course_id = :course_id AND s.reg_no = a.id.student_reg_no AND c.id = :course_id")
	List<CourseReport> getReportByCourse(@Param("course_id")long course_id);

}
