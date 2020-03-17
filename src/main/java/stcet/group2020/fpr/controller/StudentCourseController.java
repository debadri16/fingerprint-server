package stcet.group2020.fpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Student;
import stcet.group2020.fpr.model.StudentCourse;
import stcet.group2020.fpr.repository.CourseRepository;
import stcet.group2020.fpr.repository.StudentCourseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("studentCourse")
public class StudentCourseController {
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;	
	
	@Autowired
	private CourseRepository courseRepository;	

	@GetMapping("/studentMinutiae")
	public List<Student> getStudentMinutiaeByCourse(@RequestParam("courseId") String courseId, @RequestParam("groupId") String groupId){
		long courseNo = courseRepository.findOneByCourseIdAndGroupId(courseId, groupId).get().getCourseNo();
		return studentCourseRepository.getStudentMinutiaeByCourseNo(courseNo);
	}
	
	@PostMapping
	public StudentCourse add(@RequestBody StudentCourse studentCourse) {
		return studentCourseRepository.save(studentCourse);
	}
	
}
