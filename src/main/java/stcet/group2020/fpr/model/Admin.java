package stcet.group2020.fpr.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {
	
	@Id
	@Column(name="id")
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(name = "dept_id")
	private int dept_id;

	@ManyToOne
    @MapsId("dept_id")
    @JoinColumn(name = "dept_id")
    Department department;

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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@JsonIgnore
	public Department getDepartment() {
		return department;
	}

	@JsonIgnore
	public void setDepartment(Department department) {
		this.department = department;
	}
}
