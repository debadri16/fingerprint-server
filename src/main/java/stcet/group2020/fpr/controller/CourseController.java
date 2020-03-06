package stcet.group2020.fpr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.model.Course;
import stcet.group2020.fpr.repository.CourseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/{id}")
	public Optional<Course> getCourse(@PathVariable long id){
		return courseRepository.findById(id);
	}
	
	@GetMapping("/{department}/{sem}")
	public List<Course> getCourseByDeptSem(@PathVariable String department,@PathVariable int sem){
		return courseRepository.findByDepartmentAndSem(department, sem);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable long id) {
		courseRepository.deleteById(id);
	}
	
	@PostMapping
	public boolean addStudent(@RequestBody Course course) {
		if(courseRepository.save(course) != null)
			return true;
		return false;
	}
}
