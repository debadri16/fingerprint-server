package stcet.group2020.fpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.StudentCourse;
import stcet.group2020.fpr.repository.interfaces.CourseReport;
import stcet.group2020.fpr.repository.interfaces.StudentMinutiae;
import stcet.group2020.fpr.repository.interfaces.StudentReport;

public interface StudentCourseRepository extends CrudRepository<StudentCourse, String> {

	@Query("SELECT sc as StudentCourse FROM StudentCourse sc WHERE sc.id.course_id = :course_id AND sc.id.student_reg_no = :reg_no")
	public StudentCourse findAttendance(@Param("reg_no") String student_reg_no, @Param("course_id") String course_id);
	
	@Modifying
	@Transactional
    @Query("UPDATE StudentCourse sc SET sc.attendance_count = sc.attendance_count + 1 WHERE sc.id.student_reg_no = :student_reg_no AND sc.id.course_id = :course_id")
    int updateAttendance(@Param("student_reg_no") String student_reg_no, @Param("course_id") String course_id);

	@Query("SELECT s.reg_no AS reg_no, s.minutiae AS minutiae FROM Student s, StudentCourse sc WHERE sc.id.course_id = :course_id AND sc.id.student_reg_no = s.reg_no")
	List<StudentMinutiae> getStudentMinutiaeByCourseId(@Param("course_id")String course_id);
	
	@Query("SELECT c.id AS id, c.name AS name, sc.attendance_count as attendance_count, c.totalClasses AS totalClasses FROM StudentCourse sc, Course c, Student s WHERE sc.id.student_reg_no = :student_reg_no AND s.reg_no = :student_reg_no AND c.id = sc.id.course_id")
	List<StudentReport> getReportByStudent(@Param("student_reg_no")String student_reg_no);
	
	@Query("SELECT s.reg_no AS reg_no, s.name as name, sc.attendance_count as attendance_count FROM StudentCourse sc, Course c, Student s WHERE sc.id.course_id = :course_id AND s.reg_no = sc.id.student_reg_no AND c.id = :course_id")
	List<CourseReport> getReportByCourse(@Param("course_id")String course_id);

}
