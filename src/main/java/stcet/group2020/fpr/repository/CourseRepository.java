package stcet.group2020.fpr.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByDeptIdAndSem(int deptId, int sem);
}
