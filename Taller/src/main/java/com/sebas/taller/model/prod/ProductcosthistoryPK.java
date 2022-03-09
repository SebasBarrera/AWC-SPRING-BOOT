package com.sebas.taller.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productcosthistory database table.
 * 
 */
@Embeddable
public class ProductcosthistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date startdate;

	public ProductcosthistoryPK() {
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public java.util.Date getStartdate() {
		return this.startdate;
	}
	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductcosthistoryPK)) {
			return false;
		}
		ProductcosthistoryPK castOther = (ProductcosthistoryPK)other;
		return 
			this.productid.equals(castOther.productid)
			&& this.startdate.equals(castOther.startdate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productid.hashCode();
		hash = hash * prime + this.startdate.hashCode();
		
		return hash;
	}
}