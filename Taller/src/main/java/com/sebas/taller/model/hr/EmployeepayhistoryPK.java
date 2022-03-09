package com.sebas.taller.model.hr;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the employeepayhistory database table.
 * 
 */
@Embeddable
public class EmployeepayhistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date ratechangedate;

	public EmployeepayhistoryPK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public java.util.Date getRatechangedate() {
		return this.ratechangedate;
	}
	public void setRatechangedate(java.util.Date ratechangedate) {
		this.ratechangedate = ratechangedate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeepayhistoryPK)) {
			return false;
		}
		EmployeepayhistoryPK castOther = (EmployeepayhistoryPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.ratechangedate.equals(castOther.ratechangedate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.ratechangedate.hashCode();
		
		return hash;
	}
}