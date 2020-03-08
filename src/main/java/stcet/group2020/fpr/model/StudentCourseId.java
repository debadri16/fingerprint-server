package stcet.group2020.fpr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCourseId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "course_id")
	String course_id;
	
	@Column(name = "student_reg_no")
	String student_reg_no;

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getStudent_reg_no() {
		return student_reg_no;
	}

	public void setStudent_reg_no(String student_reg_no) {
		this.student_reg_no = student_reg_no;
	}
	
}
