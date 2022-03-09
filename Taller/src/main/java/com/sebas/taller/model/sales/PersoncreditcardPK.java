package com.sebas.taller.model.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the personcreditcard database table.
 * 
 */
@Embeddable
public class PersoncreditcardPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	@Column(insertable=false, updatable=false)
	private Integer creditcardid;

	public PersoncreditcardPK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public Integer getCreditcardid() {
		return this.creditcardid;
	}
	public void setCreditcardid(Integer creditcardid) {
		this.creditcardid = creditcardid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersoncreditcardPK)) {
			return false;
		}
		PersoncreditcardPK castOther = (PersoncreditcardPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.creditcardid.equals(castOther.creditcardid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.creditcardid.hashCode();
		
		return hash;
	}
}