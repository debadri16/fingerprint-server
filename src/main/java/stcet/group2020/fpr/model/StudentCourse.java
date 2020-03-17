package stcet.group2020.fpr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "studentCourse", indexes = {
@Index(columnList = "courseNo")
})
public class StudentCourse{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scId", updatable = false, nullable = false)
	private long scId;
	
	@NotNull
	private long courseNo;
	
	@NotNull
	private String regNo;

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public long getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(long courseNo) {
		this.courseNo = courseNo;
	}

	public long getScId() {
		return scId;
	}

	@JsonIgnore
	public void setScId(long scId) {
		this.scId = scId;
	}
	
	
}
