package stcet.group2020.fpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		
	@PostMapping("/addCourse")
	public boolean addStudent(@RequestBody Course course) {
		if(courseRepository.save(course) != null)
			return true;
		return false;
	}

}
