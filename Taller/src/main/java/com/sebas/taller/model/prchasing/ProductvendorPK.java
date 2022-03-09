package com.sebas.taller.model.prchasing;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productvendor database table.
 * 
 */
@Embeddable
public class ProductvendorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	public ProductvendorPK() {
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductvendorPK)) {
			return false;
		}
		ProductvendorPK castOther = (ProductvendorPK)other;
		return 
			this.productid.equals(castOther.productid)
			&& this.businessentityid.equals(castOther.businessentityid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productid.hashCode();
		hash = hash * prime + this.businessentityid.hashCode();
		
		return hash;
	}
}