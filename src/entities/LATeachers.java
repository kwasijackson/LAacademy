package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LATeachers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teacherId;
	private String teacherName;
	@OneToMany(mappedBy="teacher")
	private List<LASubjects> subject = new ArrayList<LASubjects>();
	
	public LATeachers() {
		super();
	}

	public LATeachers(String teacherName) {
		super();
		this.teacherName = teacherName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<LASubjects> getSubject() {
		return subject;
	}

	public void setSubject(List<LASubjects> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "LATeachers [teacherId=" + teacherId + ", teacherName=" + teacherName + "]";
	}



}
