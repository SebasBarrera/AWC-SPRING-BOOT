package com.sebas.taller.model.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the salesorderheadersalesreason database table.
 * 
 */
@Embeddable
public class SalesorderheadersalesreasonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer salesorderid;

	@Column(insertable=false, updatable=false)
	private Integer salesreasonid;

	public SalesorderheadersalesreasonPK() {
	}
	public Integer getSalesorderid() {
		return this.salesorderid;
	}
	public void setSalesorderid(Integer salesorderid) {
		this.salesorderid = salesorderid;
	}
	public Integer getSalesreasonid() {
		return this.salesreasonid;
	}
	public void setSalesreasonid(Integer salesreasonid) {
		this.salesreasonid = salesreasonid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalesorderheadersalesreasonPK)) {
			return false;
		}
		SalesorderheadersalesreasonPK castOther = (SalesorderheadersalesreasonPK)other;
		return 
			this.salesorderid.equals(castOther.salesorderid)
			&& this.salesreasonid.equals(castOther.salesreasonid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.salesorderid.hashCode();
		hash = hash * prime + this.salesreasonid.hashCode();
		
		return hash;
	}
}