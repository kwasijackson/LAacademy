package entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class LASubjects {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;
	private String subjectName;
	@ManyToOne(fetch=FetchType.EAGER)
		private LATeachers teacher ;

	@ManyToOne(fetch=FetchType.EAGER)
	private LAClasses clas;

	public LASubjects(String subjectName, LATeachers teacher, LAClasses clas) {
		super();
		this.subjectName = subjectName;
		this.teacher = teacher;
		this.clas = clas;
	}

	public LASubjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public LATeachers getTeacher() {
		return teacher;
	}

	public void setTeacher(LATeachers teacher) {
		this.teacher = teacher;
	}

	public LAClasses getClas() {
		return clas;
	}

	public void setClas(LAClasses clas) {
		this.clas = clas;
	}

	@Override
	public String toString() {
		return "LASubjects [subjectId=" + subjectId + ", subjectName=" + subjectName + ", teacher=" + teacher
				+ ", clas=" + clas + "]";
	}


}
