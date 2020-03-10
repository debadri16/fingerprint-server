package stcet.group2020.fpr.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {
	
	@Id
	@Column(name="id")
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String department;

    @NotNull
    @Length(min=536, max=536)
    private String minutiae;

    @NotNull
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
