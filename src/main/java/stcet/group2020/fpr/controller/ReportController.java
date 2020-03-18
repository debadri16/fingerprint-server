package stcet.group2020.fpr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
