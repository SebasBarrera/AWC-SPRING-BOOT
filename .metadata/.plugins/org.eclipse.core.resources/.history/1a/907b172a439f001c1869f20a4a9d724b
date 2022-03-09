package co.edu.icesi.dev.uccareapp.transport.model.hr;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the jobcandidate database table.
 *
 */
@Entity
@NamedQuery(name = "Jobcandidate.findAll", query = "SELECT j FROM Jobcandidate j")
public class Jobcandidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "JOBCANDIDATE_JOBCANDIDATEID_GENERATOR", allocationSize = 1, sequenceName = "JOBCANDIDATE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOBCANDIDATE_JOBCANDIDATEID_GENERATOR")
	private Integer jobcandidateid;

	private Timestamp modifieddate;

	private String resume;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "businessentityid")
	private Employee employee;

	public Jobcandidate() {
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public Integer getJobcandidateid() {
		return this.jobcandidateid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getResume() {
		return this.resume;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setJobcandidateid(Integer jobcandidateid) {
		this.jobcandidateid = jobcandidateid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}