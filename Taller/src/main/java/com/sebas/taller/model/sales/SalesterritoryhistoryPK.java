package com.sebas.taller.model.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the salesterritoryhistory database table.
 * 
 */
@Embeddable
public class SalesterritoryhistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date startdate;

	@Column(insertable=false, updatable=false)
	private Integer territoryid;

	public SalesterritoryhistoryPK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public java.util.Date getStartdate() {
		return this.startdate;
	}
	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}
	public Integer getTerritoryid() {
		return this.territoryid;
	}
	public void setTerritoryid(Integer territoryid) {
		this.territoryid = territoryid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalesterritoryhistoryPK)) {
			return false;
		}
		SalesterritoryhistoryPK castOther = (SalesterritoryhistoryPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.startdate.equals(castOther.startdate)
			&& this.territoryid.equals(castOther.territoryid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.startdate.hashCode();
		hash = hash * prime + this.territoryid.hashCode();
		
		return hash;
	}
}