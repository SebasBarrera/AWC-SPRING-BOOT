package com.sebas.taller.model.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the contacttype database table.
 *
 */
@Entity
@NamedQuery(name = "Contacttype.findAll", query = "SELECT c FROM Contacttype c")
public class Contacttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CONTACTTYPE_CONTACTTYPEID_GENERATOR", allocationSize = 1, sequenceName = "CONTACTTYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACTTYPE_CONTACTTYPEID_GENERATOR")
	private Integer contacttypeid;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to Businessentitycontact
	@OneToMany(mappedBy = "contacttype")
	private List<Businessentitycontact> businessentitycontacts;

	public Contacttype() {
	}

	public Businessentitycontact addBusinessentitycontact(Businessentitycontact businessentitycontact) {
		getBusinessentitycontacts().add(businessentitycontact);
		businessentitycontact.setContacttype(this);

		return businessentitycontact;
	}

	public List<Businessentitycontact> getBusinessentitycontacts() {
		return this.businessentitycontacts;
	}

	public Integer getContacttypeid() {
		return this.contacttypeid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Businessentitycontact removeBusinessentitycontact(Businessentitycontact businessentitycontact) {
		getBusinessentitycontacts().remove(businessentitycontact);
		businessentitycontact.setContacttype(null);

		return businessentitycontact;
	}

	public void setBusinessentitycontacts(List<Businessentitycontact> businessentitycontacts) {
		this.businessentitycontacts = businessentitycontacts;
	}

	public void setContacttypeid(Integer contacttypeid) {
		this.contacttypeid = contacttypeid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

}