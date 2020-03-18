package stcet.group2020.fpr.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Attendance;
import stcet.group2020.fpr.model.Classes;
import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.repository.AttendanceRepository;
import stcet.group2020.fpr.repository.ClassesRepository;
import stcet.group2020.fpr.repository.StudentCourseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("classes")
public class ClassesController {
	
	@Autowired
	private ClassesRepository classesRepository;

	@Autowired
	private StudentCourseRepository studentCourseRepository;	

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	
	@GetMapping(params = "classId")
	public Optional<Classes> getClass(@RequestParam("classId") Long classId){
		return classesRepository.findById(classId);
	}
	
	@GetMapping(params = "courseId")
	public List<Classes> getByCourse(@RequestParam("courseId") Long courseId){
		return classesRepository.findByCourseId(courseId);
	}
	
	@GetMapping(params = {"courseId", "date"} )
	public Optional<Classes> getByCourseDate(@RequestParam("courseId") Long courseId, @RequestParam("date") LocalDate date){
		return classesRepository.findOneByCourseIdAndDate(courseId, date);
	}
	
	@PostMapping
	public Classes add(@RequestBody Classes classes) {
		//save class
		Classes classResponse = classesRepository.save(classes);
		//get all student regNos under classes.courseId
		List<Student> students = studentCourseRepository.getStudentByCourseId(classResponse.getCourseId());

		List<Attendance> attendances = new ArrayList<>();		
		
		//form the list of attendance
		for(Student student: students){
			Attendance attendance = new Attendance();
			attendance.setClassId(classResponse.getClassId());
			attendance.setPresent(false);
			attendance.setRegNo(student.getRegNo());
			attendances.add(attendance);
		}
		attendanceRepository.saveAll(attendances);

		LocalDate date = LocalDate.now();
		classes.setDate(date);
		return classResponse;
	}
}
