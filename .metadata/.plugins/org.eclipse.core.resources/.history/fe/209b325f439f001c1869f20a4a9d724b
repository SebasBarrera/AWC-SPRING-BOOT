package co.edu.icesi.dev.uccareapp.transport.model.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the emailaddress database table.
 * 
 */
@Embeddable
public class EmailaddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer businessentityid;

	private Integer emailaddressid;

	public EmailaddressPK() {
	}
	public Integer getBusinessentityid() {
		return this.businessentityid;
	}
	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}
	public Integer getEmailaddressid() {
		return this.emailaddressid;
	}
	public void setEmailaddressid(Integer emailaddressid) {
		this.emailaddressid = emailaddressid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmailaddressPK)) {
			return false;
		}
		EmailaddressPK castOther = (EmailaddressPK)other;
		return 
			this.businessentityid.equals(castOther.businessentityid)
			&& this.emailaddressid.equals(castOther.emailaddressid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessentityid.hashCode();
		hash = hash * prime + this.emailaddressid.hashCode();
		
		return hash;
	}
}