package stcet.group2020.fpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stcet.group2020.fpr.repository.StudentCourseRepository;
import stcet.group2020.fpr.repository.interfaces.CourseReport;
import stcet.group2020.fpr.repository.interfaces.StudentReport;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("reports")
public class ReportController {
	
//	@Autowired
//	private StudentCourseRepository studentCourseRepository;	
	
//	@GetMapping(params = "reg_no")
//	public List<StudentReport> getReportByStudent(@RequestParam("reg_no") String student_reg_no){
//		return studentCourseRepository.getReportByStudent(student_reg_no);
//	}
//	
//	@GetMapping(params = "course_id")
//	public List<CourseReport> getReportByCourse(@RequestParam("course_id") String course_id){
//		return studentCourseRepository.getReportByCourse(course_id);
//	}
	
}
