package stcet.group2020.fpr.repository;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
