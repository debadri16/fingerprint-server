package stcet.group2020.fpr.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "attendance", indexes = {
@Index(columnList = "course_id")
})
public class Attendance{
	
	@EmbeddedId
	private AttendanceId id = new AttendanceId();

    private int attendance_count;

	public AttendanceId getId() {
		return this.id;
	}

	public void setId(AttendanceId id) {
		this.id = id;
	}

	public int getAttendance_count() {
		return attendance_count;
	}

	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}
}
