package com.sebas.taller.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productlistpricehistory database table.
 * 
 */
@Embeddable
public class ProductlistpricehistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date startdate;

	public ProductlistpricehistoryPK() {
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
		if (!(other instanceof ProductlistpricehistoryPK)) {
			return false;
		}
		ProductlistpricehistoryPK castOther = (ProductlistpricehistoryPK)other;
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