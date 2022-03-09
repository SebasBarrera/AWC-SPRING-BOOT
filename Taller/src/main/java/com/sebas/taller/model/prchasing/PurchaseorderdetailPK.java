package com.sebas.taller.model.prchasing;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the purchaseorderdetail database table.
 * 
 */
@Embeddable
public class PurchaseorderdetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer purchaseorderid;

	private Integer purchaseorderdetailid;

	public PurchaseorderdetailPK() {
	}
	public Integer getPurchaseorderid() {
		return this.purchaseorderid;
	}
	public void setPurchaseorderid(Integer purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}
	public Integer getPurchaseorderdetailid() {
		return this.purchaseorderdetailid;
	}
	public void setPurchaseorderdetailid(Integer purchaseorderdetailid) {
		this.purchaseorderdetailid = purchaseorderdetailid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PurchaseorderdetailPK)) {
			return false;
		}
		PurchaseorderdetailPK castOther = (PurchaseorderdetailPK)other;
		return 
			this.purchaseorderid.equals(castOther.purchaseorderid)
			&& this.purchaseorderdetailid.equals(castOther.purchaseorderdetailid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.purchaseorderid.hashCode();
		hash = hash * prime + this.purchaseorderdetailid.hashCode();
		
		return hash;
	}
}