package stcet.group2020.fpr.controller;

import java.util.List;
import java.util.Optional;

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

import stcet.group2020.fpr.model.Course;
import stcet.group2020.fpr.repository.CourseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("courses")
@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	
	@GetMapping(params = "courseId")
	public Optional<Course> getCourse(@RequestParam("courseId") Long courseId){
		return courseRepository.findById(courseId);
	}
	
	@GetMapping(params = {"deptId", "sem"})
	public List<Course> getCourseByDeptSem(@RequestParam("deptId") int deptId, @RequestParam("sem") int sem){
		return courseRepository.findByDeptIdAndSem(deptId, sem);
	}
	
	@GetMapping(params = {"courseCode", "groupNo"})
	public Optional<Course> getCourseByIdGroup(@RequestParam("courseCode") String courseCode, @RequestParam("groupNo") String groupNo){
		return courseRepository.findOneByCourseCodeAndGroupNo(courseCode, groupNo);
	}
	
	@GetMapping
	public List<Course> getAll() {
		return (List<Course>) courseRepository.findAllByOrderByName();
	}
	
	@DeleteMapping(params = "courseId")
	public void deleteCourse(@RequestParam("courseId") Long courseId) {
		courseRepository.deleteById(courseId);
	}
	
	
	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
}
