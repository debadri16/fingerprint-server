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
import stcet.group2020.fpr.model.Department;
import stcet.group2020.fpr.repository.CourseRepository;
import stcet.group2020.fpr.repository.DepartmentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public Optional<Course> getCourse(@RequestParam("id") String id){
		return courseRepository.findById(id);
	}
	
	@GetMapping("byDeptSem")
	public List<Course> getCourseByDeptSem(@RequestParam("deptId") int deptId, @RequestParam("sem") int sem){
		return courseRepository.findByDeptIdAndSem(deptId, sem);
	}
	
	@DeleteMapping
	public void deleteCourse(@RequestParam("id") String id) {
		courseRepository.deleteById(id);
	}
	
	
	@PostMapping
	public Course addStudent(@RequestBody Course course) {
		Department department = departmentRepository.findById(course.getDeptId()).get();
		course.setDepartment(department);
		return courseRepository.save(course);
	}
}
