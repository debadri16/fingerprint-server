package stcet.group2020.fpr.repository;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Admin;
import stcet.group2020.fpr.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
