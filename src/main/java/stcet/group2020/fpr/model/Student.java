package stcet.group2020.fpr.model;

import org.hibernate.validator.constraints.Length;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	private String reg_no;
	
	@NotNull
	private String name;
	
	@NotNull
	private String department;
	
	@NotNull
	@Length(min=536, max=536)
	private String minutiae;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
}
