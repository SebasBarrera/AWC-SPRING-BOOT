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
 * The persistent class for the phonenumbertype database table.
 *
 */
@Entity
@NamedQuery(name = "Phonenumbertype.findAll", query = "SELECT p FROM Phonenumbertype p")
public class Phonenumbertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PHONENUMBERTYPE_PHONENUMBERTYPEID_GENERATOR", allocationSize = 1, sequenceName = "PHONENUMBERTYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONENUMBERTYPE_PHONENUMBERTYPEID_GENERATOR")
	private Integer phonenumbertypeid;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to Personphone
	@OneToMany(mappedBy = "phonenumbertype")
	private List<Personphone> personphones;

	public Phonenumbertype() {
	}

	public Personphone addPersonphone(Personphone personphone) {
		getPersonphones().add(personphone);
		personphone.setPhonenumbertype(this);

		return personphone;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Personphone> getPersonphones() {
		return this.personphones;
	}

	public Integer getPhonenumbertypeid() {
		return this.phonenumbertypeid;
	}

	public Personphone removePersonphone(Personphone personphone) {
		getPersonphones().remove(personphone);
		personphone.setPhonenumbertype(null);

		return personphone;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonphones(List<Personphone> personphones) {
		this.personphones = personphones;
	}

	public void setPhonenumbertypeid(Integer phonenumbertypeid) {
		this.phonenumbertypeid = phonenumbertypeid;
	}

}