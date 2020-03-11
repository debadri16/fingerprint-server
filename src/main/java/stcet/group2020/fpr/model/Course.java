package stcet.group2020.fpr.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	private String id;

	@NotNull
	private String name;
	
	@NotNull
	@Column(name = "deptId")
	private int deptId;

	@ManyToOne
    @MapsId("deptId")
    @JoinColumn(name = "deptId")
    Department department;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@JsonIgnore
	public void setDepartment(Department department) {
		this.department = department;
	}

	@JsonIgnore
	public Department getDepartment() {
		return department;
	}	
	@NotNull
	private int totalClasses;
	
	@NotNull
	private int sem;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    Set<StudentCourse> studentCourse;
	
	
	public int getTotalClasses() {
		return totalClasses;
	}

	public void setTotalClasses(int totalClasses) {
		this.totalClasses = totalClasses;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
