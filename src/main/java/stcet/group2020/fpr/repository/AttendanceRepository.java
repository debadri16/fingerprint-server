package stcet.group2020.fpr.repository;

import org.springframework.data.repository.CrudRepository;

import stcet.group2020.fpr.model.Admin;

public interface AttendanceRepository extends CrudRepository<Admin, Long> {

}
