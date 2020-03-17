package stcet.group2020.fpr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseNo", updatable = false, nullable = false)
	private long courseNo;
	
	@NotNull
	private String courseId;

	private String groupId;
	
	@NotNull
	private String name;
	
	@NotNull
	private int deptId;
	
	@NotNull
	private int totalClasses;
	
	@NotNull
	private int sem;

	//getter setters
	public long getCourseNo() {
		return courseNo;
	}
	
	public void setCourseNo(long courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getTotalClasses() {
		return totalClasses;
	}

	public void setTotalClasses(int totalClasses) {
		this.totalClasses = totalClasses;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}	
}
