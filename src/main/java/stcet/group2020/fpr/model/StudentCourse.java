package stcet.group2020.fpr.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "studentCourse", indexes = {
@Index(columnList = "course_id")
})
public class StudentCourse{
	
	@EmbeddedId
	private StudentCourseId id = new StudentCourseId();

	@ManyToOne
    @MapsId("student_reg_no")
    @JoinColumn(name = "student_reg_no")
    Student student;
 
    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    Course course;
    
	@JsonIgnore
    public Student getStudent() {
		return student;
	}

	@JsonIgnore

	public void setStudent(Student student) {
		this.student = student;
	}

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	@JsonIgnore
	public void setCourse(Course course) {
		this.course = course;
	}

	private int attendance_count;

    
	public StudentCourseId getId() {
		return this.id;
	}

	public void setId(StudentCourseId id) {
		this.id = id;
	}

	public int getAttendance_count() {
		return attendance_count;
	}

	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}
}
