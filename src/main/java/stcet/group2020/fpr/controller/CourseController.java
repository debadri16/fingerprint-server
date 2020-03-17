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
@RequestMapping("courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	
	@GetMapping(params = "courseNo")
	public Optional<Course> getCourse(@RequestParam("courseNo") Long courseNo){
		return courseRepository.findById(courseNo);
	}
	
	@GetMapping(params = {"deptId", "sem"})
	public List<Course> getCourseByDeptSem(@RequestParam("deptId") int deptId, @RequestParam("sem") int sem){
		return courseRepository.findByDeptIdAndSem(deptId, sem);
	}
	
	@GetMapping(params = {"courseId", "groupId"})
	public Optional<Course> getCourseByIdGroup(@RequestParam("courseId") String courseId, @RequestParam("groupId") String groupId){
		return courseRepository.findOneByCourseIdAndGroupId(courseId, groupId);
	}
	
	@GetMapping
	public List<Course> getAll() {
		return (List<Course>) courseRepository.findAll();
	}

	
	@DeleteMapping(params = "id")
	public void deleteCourse(@RequestParam("id") Long id) {
		courseRepository.deleteById(id);
	}
	
	
	@PostMapping
	public Course addStudent(@RequestBody Course course) {
		return courseRepository.save(course);
	}
}
