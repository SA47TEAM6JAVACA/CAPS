package sg.iss.CAPS_TEAM6.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sid;

	private String firstmiddlename;

	private String lastname;

	private String semail;

	private String spassword;

	//bi-directional many-to-one association to StudentCourse
	@OneToMany(mappedBy="student")
	private List<StudentCourse> studentCourses;

	public Student() {
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFirstmiddlename() {
		return this.firstmiddlename;
	}

	public void setFirstmiddlename(String firstmiddlename) {
		this.firstmiddlename = firstmiddlename;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSemail() {
		return this.semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public List<StudentCourse> getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public StudentCourse addStudentCours(StudentCourse studentCours) {
		getStudentCourses().add(studentCours);
		studentCours.setStudent(this);

		return studentCours;
	}

	public StudentCourse removeStudentCours(StudentCourse studentCours) {
		getStudentCourses().remove(studentCours);
		studentCours.setStudent(null);

		return studentCours;
	}

}