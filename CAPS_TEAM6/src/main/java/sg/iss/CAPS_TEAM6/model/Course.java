package sg.iss.CAPS_TEAM6.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int cid;

	private String cname;

	private double credit;

	@Column(name="current_enrollno")
	private int currentEnrollno;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private double fee;

	private int room;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private int studentlimit;

	//bi-directional many-to-one association to StudentCourse
	@OneToMany(mappedBy="course")
	private List<StudentCourse> studentCourses;

	//bi-directional many-to-many association to Lecturer
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="courses")
	private List<Lecturer> lecturers;

	public Course() {
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public int getCurrentEnrollno() {
		return this.currentEnrollno;
	}

	public void setCurrentEnrollno(int currentEnrollno) {
		this.currentEnrollno = currentEnrollno;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public double getFee() {
		return this.fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getRoom() {
		return this.room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public int getStudentlimit() {
		return this.studentlimit;
	}

	public void setStudentlimit(int studentlimit) {
		this.studentlimit = studentlimit;
	}

	public List<StudentCourse> getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public StudentCourse addStudentCours(StudentCourse studentCours) {
		getStudentCourses().add(studentCours);
		studentCours.setCourse(this);

		return studentCours;
	}

	public StudentCourse removeStudentCours(StudentCourse studentCours) {
		getStudentCourses().remove(studentCours);
		studentCours.setCourse(null);

		return studentCours;
	}

	public List<Lecturer> getLecturers() {
		return this.lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

}