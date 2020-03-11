package stcet.group2020.fpr.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	private String reg_no;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(name = "deptId")
	private int deptId;

	@ManyToOne
    @MapsId("deptId")
    @JoinColumn(name = "deptId")
    Department department;

	@NotNull
	@Length(min=536, max=536)
	private String minutiae;

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

	@OneToMany(mappedBy = "student")
    Set<StudentCourse> studentCourse;
	
	public String getMinutiae() {
		return minutiae;
	}

	public void setMinutiae(String minutiae) {
		this.minutiae = minutiae;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
}
