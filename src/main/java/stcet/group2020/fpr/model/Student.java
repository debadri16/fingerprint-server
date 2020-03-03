package stcet.group2020.fpr.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue()
	private long reg_no;
	
	@NotNull
	private String name;
	
	@NotNull
	private String department;
	
	@NotNull
	private String minutiae;

	@OneToMany(mappedBy = "student")
    private Set<Attendance> attendance; 
	
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

	public long getReg_no() {
		return reg_no;
	}

	public void setReg_no(long reg_no) {
		this.reg_no = reg_no;
	}
}
