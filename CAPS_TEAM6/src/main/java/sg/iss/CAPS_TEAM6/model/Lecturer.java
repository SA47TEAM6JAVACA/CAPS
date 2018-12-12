package sg.iss.CAPS_TEAM6.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lecturer database table.
 * 
 */
@Entity
@NamedQuery(name="Lecturer.findAll", query="SELECT l FROM Lecturer l")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int lid;

	private String firstmiddlename;

	private String lastname;

	private String lemail;

	private String lpassword;

	//bi-directional many-to-many association to Course
	@ManyToMany
	@JoinTable(
		name="lecturer_course"
		, joinColumns={
			@JoinColumn(name="lecturerid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="course_id")
			}
		)
	
	
	private List<Course> courses;

	public Lecturer() {
	}

	public int getLid() {
		return this.lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
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

	public String getLemail() {
		return this.lemail;
	}

	public void setLemail(String lemail) {
		this.lemail = lemail;
	}

	public String getLpassword() {
		return this.lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}