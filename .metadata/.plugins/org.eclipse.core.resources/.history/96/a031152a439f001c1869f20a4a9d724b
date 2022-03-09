package co.edu.icesi.dev.uccareapp.transport.model.hr;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the employeedepartmenthistory database table.
 * 
 */
@Embeddable
public class EmployeedepartmenthistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	@Temporal(TemporalType.DATE)
	private java.util.Date startdate;

	@Column(insertable=false, updatable=false)
	private Integer departmentid;

	@Column(insertable=false, updatable=false)
	private Integer shiftid;

	public EmployeedepartmenthistoryPK() {
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
	public Integer getDepartmentid() {
		return this.departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public Integer getShiftid() {
		return this.shiftid;
	}
	public void setShiftid(Integer shiftid) {
		this.shiftid = shiftid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeedepartmenthistoryPK)) {
			return false;
		}
		EmployeedepartmenthistoryPK castOther = (EmployeedepartmenthistoryPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.startdate.equals(castOther.startdate)
			&& this.departmentid.equals(castOther.departmentid)
			&& this.shiftid.equals(castOther.shiftid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.startdate.hashCode();
		hash = hash * prime + this.departmentid.hashCode();
		hash = hash * prime + this.shiftid.hashCode();
		
		return hash;
	}
}