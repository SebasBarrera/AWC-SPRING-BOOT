package com.sebas.taller.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productmodelproductdescriptionculture database table.
 * 
 */
@Embeddable
public class ProductmodelproductdescriptionculturePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productmodelid;

	@Column(insertable=false, updatable=false)
	private Integer productdescriptionid;

	@Column(insertable=false, updatable=false)
	private String cultureid;

	public ProductmodelproductdescriptionculturePK() {
	}
	public Integer getProductmodelid() {
		return this.productmodelid;
	}
	public void setProductmodelid(Integer productmodelid) {
		this.productmodelid = productmodelid;
	}
	public Integer getProductdescriptionid() {
		return this.productdescriptionid;
	}
	public void setProductdescriptionid(Integer productdescriptionid) {
		this.productdescriptionid = productdescriptionid;
	}
	public String getCultureid() {
		return this.cultureid;
	}
	public void setCultureid(String cultureid) {
		this.cultureid = cultureid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductmodelproductdescriptionculturePK)) {
			return false;
		}
		ProductmodelproductdescriptionculturePK castOther = (ProductmodelproductdescriptionculturePK)other;
		return 
			this.productmodelid.equals(castOther.productmodelid)
			&& this.productdescriptionid.equals(castOther.productdescriptionid)
			&& this.cultureid.equals(castOther.cultureid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productmodelid.hashCode();
		hash = hash * prime + this.productdescriptionid.hashCode();
		hash = hash * prime + this.cultureid.hashCode();
		
		return hash;
	}
}