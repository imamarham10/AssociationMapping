package org.jsp.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column(nullable=false, unique=true)
	private String batchCode;
	@Column(nullable=false)
	private String trainer;
	@Column(nullable=false)
	private String subject;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	@JoinTable(name = "batch_student", joinColumns = {@JoinColumn(name="batch_id")}, inverseJoinColumns = {@JoinColumn(name="std_id")})
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student>students;

	@Override
	public String toString() {
		return "Batch [id=" + id + ", batchCode=" + batchCode + ", trainer=" + trainer + ", subject=" + subject + "]";
	}
	
}
