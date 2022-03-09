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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the businessentity database table.
 *
 */
@Entity
@NamedQuery(name = "Businessentity.findAll", query = "SELECT b FROM Businessentity b")
public class Businessentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BUSINESSENTITY_BUSINESSENTITYID_GENERATOR", allocationSize = 1, sequenceName = "BUSINESSENTITY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUSINESSENTITY_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;

	private Timestamp modifieddate;

	private Integer rowguid;

	// bi-directional many-to-one association to Businessentityaddress
	@OneToMany(mappedBy = "businessentity")
	private List<Businessentityaddress> businessentityaddresses;

	// bi-directional many-to-one association to Businessentitycontact
	@OneToMany(mappedBy = "businessentity")
	private List<Businessentitycontact> businessentitycontacts;

	// bi-directional one-to-one association to Person
	@OneToOne(mappedBy = "businessentity")
	private Person person;

	public Businessentity() {
	}

	public Businessentityaddress addBusinessentityaddress(Businessentityaddress businessentityaddress) {
		getBusinessentityaddresses().add(businessentityaddress);
		businessentityaddress.setBusinessentity(this);

		return businessentityaddress;
	}

	public Businessentitycontact addBusinessentitycontact(Businessentitycontact businessentitycontact) {
		getBusinessentitycontacts().add(businessentitycontact);
		businessentitycontact.setBusinessentity(this);

		return businessentitycontact;
	}

	public List<Businessentityaddress> getBusinessentityaddresses() {
		return this.businessentityaddresses;
	}

	public List<Businessentitycontact> getBusinessentitycontacts() {
		return this.businessentitycontacts;
	}

	public Integer getBusinessentityid() {
		return this.businessentityid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Person getPerson() {
		return this.person;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Businessentityaddress removeBusinessentityaddress(Businessentityaddress businessentityaddress) {
		getBusinessentityaddresses().remove(businessentityaddress);
		businessentityaddress.setBusinessentity(null);

		return businessentityaddress;
	}

	public Businessentitycontact removeBusinessentitycontact(Businessentitycontact businessentitycontact) {
		getBusinessentitycontacts().remove(businessentitycontact);
		businessentitycontact.setBusinessentity(null);

		return businessentitycontact;
	}

	public void setBusinessentityaddresses(List<Businessentityaddress> businessentityaddresses) {
		this.businessentityaddresses = businessentityaddresses;
	}

	public void setBusinessentitycontacts(List<Businessentitycontact> businessentitycontacts) {
		this.businessentitycontacts = businessentitycontacts;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}