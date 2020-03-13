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

import stcet.group2020.fpr.model.Course;
import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.model.StudentCourse;
import stcet.group2020.fpr.repository.CourseRepository;
import stcet.group2020.fpr.repository.StudentCourseRepository;
import stcet.group2020.fpr.repository.StudentRepository;
import stcet.group2020.fpr.repository.interfaces.StudentMinutiae;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("studentCourse")
public class StudentCourseController {
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;	
	
	@Autowired
	private CourseRepository courseRepository;	

	@Autowired
	private StudentRepository studentRepository;	

	@GetMapping("/studentMinutiae")
	public List<StudentMinutiae> getStudentMinutiaeByCourseId(@RequestParam("id") String course_id){
		return studentCourseRepository.getStudentMinutiaeByCourseId(course_id);
	}
	
	@PostMapping
	public boolean add(@RequestBody StudentCourse studentCourse) {
		Course course = courseRepository.findById(studentCourse.getId().getCourse_id()).get();
		studentCourse.setCourse(course);
		Student student = studentRepository.findById(studentCourse.getId().getStudent_reg_no()).get();
		studentCourse.setStudent(student);
		studentCourse.setAttendance_count(0);
		if( studentCourse.getStudent().getDeptId() == studentCourse.getCourse().getDeptId() ) {
			studentCourseRepository.save(studentCourse);
			return true;
		}
		else
			return false;
	}
	
	@GetMapping(params = {"reg_no", "course_id"})
	public StudentCourse getAttendance(@RequestParam("reg_no") String student_reg_no, @RequestParam("course_id") String course_id){
		return studentCourseRepository.findAttendance(student_reg_no, course_id);
	}
	
	@PutMapping("/attendance")
	public int addAttendance(@RequestParam("reg_no") String student_reg_no, @RequestParam("course_id") String course_id) {
		return studentCourseRepository.updateAttendance(student_reg_no, course_id);
	}
}
