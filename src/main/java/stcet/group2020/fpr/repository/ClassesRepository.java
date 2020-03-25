package stcet.group2020.fpr.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Classes;

public interface ClassesRepository extends CrudRepository<Classes, Long> {
	
	public List<Classes> findByCourseId(Long courseId);
	public Optional<Classes> findOneByCourseIdAndDate(Long courseId, LocalDate date);
	public List<Classes> findByCourseIdOrderByDate(Long courseId);
	
}
