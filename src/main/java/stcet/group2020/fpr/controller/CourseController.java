package stcet.group2020.fpr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Course;
import stcet.group2020.fpr.repository.CourseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public Optional<Course> getCourse(@RequestParam("id") String id){
		return courseRepository.findById(id);
	}
	
	@GetMapping("byDeptSem")
	public List<Course> getCourseByDeptSem(@RequestParam("dept") String department, @RequestParam("sem") int sem){
		return courseRepository.findByDepartmentAndSem(department, sem);
	}
	
	@DeleteMapping
	public void deleteCourse(@RequestParam("id") String id) {
		courseRepository.deleteById(id);
	}
	
	
	@PostMapping
	public Course addStudent(@RequestBody Course course) {
		return courseRepository.save(course);
	}
}
