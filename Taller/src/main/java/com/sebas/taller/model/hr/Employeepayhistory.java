package com.sebas.taller.model.hr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the employeepayhistory database table.
 *
 */
@Entity
@NamedQuery(name = "Employeepayhistory.findAll", query = "SELECT e FROM Employeepayhistory e")
public class Employeepayhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeepayhistoryPK id;

	private Timestamp modifieddate;

	private Integer payfrequency;

	private BigDecimal rate;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Employee employee;

	public Employeepayhistory() {
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public EmployeepayhistoryPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getPayfrequency() {
		return this.payfrequency;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(EmployeepayhistoryPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPayfrequency(Integer payfrequency) {
		this.payfrequency = payfrequency;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}