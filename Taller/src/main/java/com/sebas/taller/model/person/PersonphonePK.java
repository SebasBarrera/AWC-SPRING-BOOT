package com.sebas.taller.model.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the personphone database table.
 * 
 */
@Embeddable
public class PersonphonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	private String phonenumber;

	@Column(insertable=false, updatable=false)
	private Integer phonenumbertypeid;

	public PersonphonePK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public String getPhonenumber() {
		return this.phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getPhonenumbertypeid() {
		return this.phonenumbertypeid;
	}
	public void setPhonenumbertypeid(Integer phonenumbertypeid) {
		this.phonenumbertypeid = phonenumbertypeid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonphonePK)) {
			return false;
		}
		PersonphonePK castOther = (PersonphonePK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.phonenumber.equals(castOther.phonenumber)
			&& this.phonenumbertypeid.equals(castOther.phonenumbertypeid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.phonenumber.hashCode();
		hash = hash * prime + this.phonenumbertypeid.hashCode();
		
		return hash;
	}
}