package com.sebas.taller.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productmodelillustration database table.
 * 
 */
@Embeddable
public class ProductmodelillustrationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productmodelid;

	@Column(insertable=false, updatable=false)
	private Integer illustrationid;

	public ProductmodelillustrationPK() {
	}
	public Integer getProductmodelid() {
		return this.productmodelid;
	}
	public void setProductmodelid(Integer productmodelid) {
		this.productmodelid = productmodelid;
	}
	public Integer getIllustrationid() {
		return this.illustrationid;
	}
	public void setIllustrationid(Integer illustrationid) {
		this.illustrationid = illustrationid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductmodelillustrationPK)) {
			return false;
		}
		ProductmodelillustrationPK castOther = (ProductmodelillustrationPK)other;
		return 
			this.productmodelid.equals(castOther.productmodelid)
			&& this.illustrationid.equals(castOther.illustrationid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productmodelid.hashCode();
		hash = hash * prime + this.illustrationid.hashCode();
		
		return hash;
	}
}