package stcet.group2020.fpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
public class StudentCourseController {
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;	
	
	@Autowired
	private CourseRepository courseRepository;	

	@GetMapping
	public List<StudentCourse> getAll(){
		return (List<StudentCourse>) studentCourseRepository.findAll();
	}

	@GetMapping(path = "student", params = {"courseCode", "groupNo"})
	public List<Student> getStudentByCourse(@RequestParam("courseCode") String courseCode, @RequestParam("groupNo") String groupNo){
		long courseId = courseRepository.findOneByCourseCodeAndGroupNo(courseCode, groupNo).get().getCourseId();
		return studentCourseRepository.getStudentByCourseId(courseId);
	}
	
	@GetMapping(path = "student", params = "courseId")
	public List<Student> getStudentByCourseId(@RequestParam("courseId") long courseId){
		return studentCourseRepository.getStudentByCourseId(courseId);
	}
	
	@PostMapping
	public StudentCourse add(@RequestBody StudentCourse studentCourse) {
		return studentCourseRepository.save(studentCourse);
	}

	@PostMapping("list")
	public List<StudentCourse> add(@RequestBody List<StudentCourse> studentCourse) {
		return (List<StudentCourse>) studentCourseRepository.saveAll(studentCourse);
	}

	@DeleteMapping(params = {"courseId","regNo"})
	public void deleteStudentCourse(@RequestParam("courseId")long courseId, @RequestParam("regNo") String regNo) {
		studentCourseRepository.deleteByCourseIdAndRegNo(courseId,regNo);
	}
	
}
