package stcet.group2020.fpr.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance  implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn
    private Course course;

	@Id
    @ManyToOne
    @JoinColumn
    private Student student;


    private int attendance_count;

	public int getAttendance_count() {
		return attendance_count;
	}

	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Attendance)) return false;
	    Attendance that = (Attendance) o;
	    return Objects.equals(student.getName(), that.student.getName()) &&
	            Objects.equals(course.getName(), that.course.getName()) &&
	            Objects.equals(attendance_count, that.attendance_count);
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(student.getName(), course.getName(), attendance_count);
	}
}
