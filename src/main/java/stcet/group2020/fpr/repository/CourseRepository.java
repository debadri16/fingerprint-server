package stcet.group2020.fpr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	public List<Course> findByDeptIdAndSem(int deptId, int sem);
	public Optional<Course> findOneByCourseCodeAndGroupNo(String courseCode, String groupNo);
	public List<Course> findAllOrderByName();
}
