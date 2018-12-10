package sg.iss.CAPS_TEAM6.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the student_course database table.
 * 
 */
@Entity
@Table(name="student_course")
@NamedQuery(name="StudentCourse.findAll", query="SELECT s FROM StudentCourse s")
public class StudentCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int scid;

	private double attendence;

	@Temporal(TemporalType.DATE)
	@Column(name="enroll_date")
	private Date enrollDate;

	private double score;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="courseid")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="stuid")
	private Student student;

	public StudentCourse() {
	}

	public int getScid() {
		return this.scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public double getAttendence() {
		return this.attendence;
	}

	public void setAttendence(double attendence) {
		this.attendence = attendence;
	}

	public Date getEnrollDate() {
		return this.enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}