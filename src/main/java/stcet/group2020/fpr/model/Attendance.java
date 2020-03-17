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
@Table(name = "attendace", indexes = {
@Index(columnList = "regNo")
})
public class Attendance{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendanceId", updatable = false, nullable = false)
	private long attendanceId;
	
	@NotNull
	private String regNo;
	
	@NotNull
	private long classId;

	@NotNull
	private boolean present;

	//getter setters
	
	public long getAttendanceId() {
		return attendanceId;
	}

	@JsonIgnore
	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}
