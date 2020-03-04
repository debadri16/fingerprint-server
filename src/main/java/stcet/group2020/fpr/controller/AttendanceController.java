package stcet.group2020.fpr.controller;


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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("student")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
		
	@PostMapping("/addStudentCourse")
	public boolean addStudent(@RequestBody Attendance attendance) {
		attendance.setAttendance_count(0);
		if(attendanceRepository.save(attendance) != null)
			return true;
		return false;
	}
	
	@PutMapping("/addAttendance")
	public void addAttendance(@RequestParam long student_reg_no, @RequestParam long course_id) {
		attendanceRepository.updateAttendance(student_reg_no, course_id);
	}
}
