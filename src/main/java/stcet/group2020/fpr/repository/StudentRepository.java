package stcet.group2020.fpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import stcet.group2020.fpr.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
    
    public List<Student> findByBatchNo(int batchNo);

    public List<Student> findByBatchNoAndDeptId(int batchNo, int deptId);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.deptId = ?2 WHERE s.regNo = ?1")
    public int editDepartment(@Param("regNo") String regNo, @Param("deptId") int deptId);

    @Modifying
    @Transactional
    public void deleteByBatchNo(int batchNo);
}
