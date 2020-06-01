package stcet.group2020.fpr.repository.interfaces;

import java.time.LocalDate;

public interface CourseReport {
	LocalDate getDate();
	Long getClassId();
	Boolean getPresent();	
}
