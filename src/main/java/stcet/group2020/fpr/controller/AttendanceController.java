package stcet.group2020.fpr.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Attendance;
import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.repository.AttendanceRepository;
import stcet.group2020.fpr.repository.StudentCourseRepository;
import stcet.group2020.fpr.repository.interfaces.CourseReport;
import stcet.group2020.fpr.repository.interfaces.StudentAttendanceByClass;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("attendance")
@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private StudentCourseRepository studentCourseRepository;

	@GetMapping
	public List<Attendance> getAll() {
		return (List<Attendance>) attendanceRepository.findAll();
	}

	//short report
	@GetMapping(params = "classId")
	public List<StudentAttendanceByClass> getAllByClassId(@RequestParam("classId")Long classId){
		return attendanceRepository.getStudentsByClassId(classId);
	}

	//long report
	@GetMapping(params = "courseId")
	public List<Map<String,Object>> getStudents(@RequestParam("courseId") Long courseId){
		List<Map<String,Object>> studentsRes = new ArrayList<>();
		//all students under courseId
		List<Student> students = studentCourseRepository.getStudentByCourseId(courseId);
		//date time formatter
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/M/uu");
		for(Student student:students){
			//creating each student map
			Map<String, Object> studentRes = new HashMap<>();
			studentRes.put("regNo", student.getRegNo());
			studentRes.put("name", student.getName());
			//dates::present/absent
			List<CourseReport> presentList = attendanceRepository.getPresentList(courseId,student.getRegNo());
			for(CourseReport present: presentList){
				studentRes.put(present.getDate().format(formatters)+" - "+present.getClassId(),present.getPresent()?"P":"A");
			}
			studentsRes.add(studentRes);
		}
		return studentsRes;
	}

	@PutMapping(params = {"regNo", "classId"})
	public int addAttendance(@RequestParam("regNo") String regNo, @RequestParam("classId") Long classId){
		return attendanceRepository.addAttendance(regNo, classId);
	}

}
