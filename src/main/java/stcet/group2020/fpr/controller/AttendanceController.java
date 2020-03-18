package stcet.group2020.fpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.repository.AttendanceRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	@PutMapping(params = {"regNo", "classId"})
	public int addAttendance(@RequestParam("regNo") String regNo, @RequestParam("classId") long classId){
		return attendanceRepository.addAttendance(regNo, classId);
	}

}
