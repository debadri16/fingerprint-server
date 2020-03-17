package stcet.group2020.fpr.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "classes")
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classId", updatable = false, nullable = false)
	private long classId;

	@NotNull
	private long courseNo;
	
	private LocalDate date;

	
	//getter setters
	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}
	

	public long getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(long courseNo) {
		this.courseNo = courseNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	 
	//getter setters
	 
	 
}
