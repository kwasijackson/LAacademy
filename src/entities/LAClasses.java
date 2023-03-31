package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LAClasses {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int classId ;
	private String className;
	@OneToMany(mappedBy="clas")
	private List<LASubjects> subject =new ArrayList<LASubjects>() ;
	@OneToMany(mappedBy="clst")
	private List<LAStudents> student =new ArrayList<LAStudents>() ;
	
	
	
	public LAClasses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LAClasses(String className) {
		super();
		this.className = className;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<LASubjects> getSubject() {
		return subject;
	}
	public void setSubject(List<LASubjects> subject) {
		this.subject = subject;
	}
	public List<LAStudents> getStudent() {
		return student;
	}
	public void setStudent(List<LAStudents> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return this.className ;
	}
	
	
	

}
