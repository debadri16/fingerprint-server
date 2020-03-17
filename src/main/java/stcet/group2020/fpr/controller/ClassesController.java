package stcet.group2020.fpr.controller;

import java.time.LocalDate;
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

import stcet.group2020.fpr.model.Classes;
import stcet.group2020.fpr.repository.ClassesRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("classes")
public class ClassesController {
	
	@Autowired
	private ClassesRepository classesRepository;

	
	@GetMapping(params = "classId")
	public Optional<Classes> getClass(@RequestParam("classId") Long classId){
		return classesRepository.findById(classId);
	}
	
	@GetMapping(params = "courseNo")
	public List<Classes> getByCourse(@RequestParam("courseNo") Long courseNo){
		return classesRepository.findByCourseNo(courseNo);
	}
	
	@GetMapping(params = {"courseNo", "date"} )
	public Optional<Classes> getByCourseDate(@RequestParam("courseNo") Long courseNo, @RequestParam("date") LocalDate date){
		return classesRepository.findOneByCourseNoAndDate(courseNo, date);
	}
	
	@PostMapping
	public Classes add(@RequestBody Classes classes) {
		LocalDate date = LocalDate.now();
		classes.setDate(date);
		return classesRepository.save(classes);
	}
}
