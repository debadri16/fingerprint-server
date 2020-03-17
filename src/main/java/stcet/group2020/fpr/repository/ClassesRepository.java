package stcet.group2020.fpr.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Classes;

public interface ClassesRepository extends CrudRepository<Classes, Long> {
	
	public List<Classes> findByCourseNo(Long courseNo);
	public Optional<Classes> findOneByCourseNoAndDate(Long courseNo, LocalDate date);
}
