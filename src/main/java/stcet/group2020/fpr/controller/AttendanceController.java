package stcet.group2020.fpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Attendance;
import stcet.group2020.fpr.repository.AttendanceRepository;
import stcet.group2020.fpr.repository.CourseRepository;
import stcet.group2020.fpr.repository.interfaces.CourseReport;
import stcet.group2020.fpr.repository.interfaces.StudentMinutiae;
import stcet.group2020.fpr.repository.interfaces.StudentReport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;	
	
	@GetMapping("/StudentMinutaeByCourseId")
	public List<StudentMinutiae> getStudentMinutiaeByCourseId(@RequestParam long course_id){
		return attendanceRepository.getStudentMinutiaeByCourseId(course_id);
	}
	
	@GetMapping("/ReportByStudent")
	public List<StudentReport> getReportByStudent(@RequestParam long student_reg_no){
		return attendanceRepository.getReportByStudent(student_reg_no);
	}
	
	@GetMapping("/ReportByCourse")
	public List<CourseReport> getReportByCourse(@RequestParam long course_id){
		return attendanceRepository.getReportByCourse(course_id);
	}
	
	@PostMapping("/StudentCourse")
	public boolean addStudent(@RequestBody Attendance attendance) {
		attendance.setAttendance_count(0);
		if(attendanceRepository.save(attendance) != null)
			return true;
		return false;
	}
	
	@PutMapping("/increment")
	public void addAttendance(@RequestParam long student_reg_no, @RequestParam long course_id) {
		attendanceRepository.updateAttendance(student_reg_no, course_id);
	}
}
