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
 * The persistent class for the countryregion database table.
 *
 */
@Entity
@NamedQuery(name = "Countryregion.findAll", query = "SELECT c FROM Countryregion c")
public class Countryregion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COUNTRYREGION_COUNTRYREGIONCODE_GENERATOR", allocationSize = 1, sequenceName = "COUNTRYREGION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRYREGION_COUNTRYREGIONCODE_GENERATOR")
	private Integer countryregionid;
	
	private String countryregioncode;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to Stateprovince
	@OneToMany(mappedBy = "countryregion")
	private List<Stateprovince> stateprovinces;

	public Countryregion() {
	}

	public Stateprovince addStateprovince(Stateprovince stateprovince) {
		getStateprovinces().add(stateprovince);
		stateprovince.setCountryregion(this);

		return stateprovince;
	}

	public Integer getCountryregionid() {
		return this.countryregionid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Stateprovince> getStateprovinces() {
		return this.stateprovinces;
	}

	public Stateprovince removeStateprovince(Stateprovince stateprovince) {
		getStateprovinces().remove(stateprovince);
		stateprovince.setCountryregion(null);

		return stateprovince;
	}

	public void setCountryregionid(Integer countryregionid) {
		this.countryregionid = countryregionid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStateprovinces(List<Stateprovince> stateprovinces) {
		this.stateprovinces = stateprovinces;
	}

	public String getCountryregioncode() {
		return countryregioncode;
	}

	public void setCountryregioncode(String countryregioncode) {
		this.countryregioncode = countryregioncode;
	}

}