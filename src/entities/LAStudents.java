package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LAStudents {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private String studentName;
	@ManyToOne
	private LAClasses clst;
	public LAStudents(String studentName, LAClasses clst) {
		super();
		this.studentName = studentName;
		this.clst = clst;
	}
	public LAStudents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public LAClasses getClst() {
		return clst;
	}
	public void setClst(LAClasses clst) {
		this.clst = clst;
	}
	@Override
	public String toString() {
		return "LAStudents [studentId=" + studentId + ", studentName=" + studentName + ", clst=" + clst + "]";
	}
	
	

	}


