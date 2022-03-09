package com.sebas.taller.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productinventory database table.
 * 
 */
@Embeddable
public class ProductinventoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	@Column(insertable=false, updatable=false)
	private Integer locationid;

	public ProductinventoryPK() {
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getLocationid() {
		return this.locationid;
	}
	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductinventoryPK)) {
			return false;
		}
		ProductinventoryPK castOther = (ProductinventoryPK)other;
		return 
			this.productid.equals(castOther.productid)
			&& this.locationid.equals(castOther.locationid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productid.hashCode();
		hash = hash * prime + this.locationid.hashCode();
		
		return hash;
	}
}