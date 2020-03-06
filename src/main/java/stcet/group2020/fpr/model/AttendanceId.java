package stcet.group2020.fpr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttendanceId implements Serializable{
	
	@Column(name = "course_id")
	Long course_id;
	
	@Column(name = "student_reg_no")
	Long student_reg_no;

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public Long getStudent_reg_no() {
		return student_reg_no;
	}

	public void setStudent_reg_no(Long student_reg_no) {
		this.student_reg_no = student_reg_no;
	}
	
}
