package stcet.group2020.fpr.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {
	
	@Id
	@NotNull
	private String adminId;
	
	@NotNull
	private String name;
	
	@NotNull
	private int deptId;

    @NotNull
    @Length(min=1, max=536)
    private String minutiae;

    //getter setters
    
    public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getMinutiae() {
		return minutiae;
	}

	public void setMinutiae(String minutiae) {
		this.minutiae = minutiae;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull
    private String password;

}
