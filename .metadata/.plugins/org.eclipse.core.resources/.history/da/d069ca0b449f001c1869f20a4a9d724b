package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the salespersonquotahistory database table.
 * 
 */
@Embeddable
public class SalespersonquotahistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date quotadate;

	public SalespersonquotahistoryPK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public java.util.Date getQuotadate() {
		return this.quotadate;
	}
	public void setQuotadate(java.util.Date quotadate) {
		this.quotadate = quotadate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalespersonquotahistoryPK)) {
			return false;
		}
		SalespersonquotahistoryPK castOther = (SalespersonquotahistoryPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.quotadate.equals(castOther.quotadate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.quotadate.hashCode();
		
		return hash;
	}
}