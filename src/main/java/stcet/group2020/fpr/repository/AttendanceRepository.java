package stcet.group2020.fpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.Attendance;
import stcet.group2020.fpr.repository.interfaces.CourseReport;
import stcet.group2020.fpr.repository.interfaces.StudentAttendanceByClass;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Attendance a SET a.present = true WHERE a.regNo = ?1 AND a.classId = ?2")
    int addAttendance(@Param("regNo") String regNo, @Param("classId") long classId);
    
    @Query("SELECT c.date as date,c.classId as classId, a.present as present FROM Attendance a, Classes c WHERE c.courseId = ?1 AND a.classId = c.classId AND a.regNo = ?2")
    public List<CourseReport> getPresentList(Long courseId, String regNo);
    
    @Query("SELECT a.regNo as regNo, s.name as name, a.present as present FROM Attendance a, Student s WHERE a.classId = ?1 AND a.regNo = s.regNo")
    public List<StudentAttendanceByClass> getStudentsByClassId(Long classId);
}
