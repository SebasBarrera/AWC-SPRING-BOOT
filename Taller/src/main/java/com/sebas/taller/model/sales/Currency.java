package com.sebas.taller.model.sales;

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
 * The persistent class for the currency database table.
 *
 */
@Entity
@NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CURRENCY_CURRENCYCODE_GENERATOR", allocationSize = 1, sequenceName = "CURRENCY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCY_CURRENCYCODE_GENERATOR")
	private String currencycode;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to Countryregioncurrency
	@OneToMany(mappedBy = "currency")
	private List<Countryregioncurrency> countryregioncurrencies;

	// bi-directional many-to-one association to Currencyrate
	@OneToMany(mappedBy = "currency1")
	private List<Currencyrate> currencyrates1;

	// bi-directional many-to-one association to Currencyrate
	@OneToMany(mappedBy = "currency2")
	private List<Currencyrate> currencyrates2;

	public Currency() {
	}

	public Countryregioncurrency addCountryregioncurrency(Countryregioncurrency countryregioncurrency) {
		getCountryregioncurrencies().add(countryregioncurrency);
		countryregioncurrency.setCurrency(this);

		return countryregioncurrency;
	}

	public Currencyrate addCurrencyrates1(Currencyrate currencyrates1) {
		getCurrencyrates1().add(currencyrates1);
		currencyrates1.setCurrency1(this);

		return currencyrates1;
	}

	public Currencyrate addCurrencyrates2(Currencyrate currencyrates2) {
		getCurrencyrates2().add(currencyrates2);
		currencyrates2.setCurrency2(this);

		return currencyrates2;
	}

	public List<Countryregioncurrency> getCountryregioncurrencies() {
		return this.countryregioncurrencies;
	}

	public String getCurrencycode() {
		return this.currencycode;
	}

	public List<Currencyrate> getCurrencyrates1() {
		return this.currencyrates1;
	}

	public List<Currencyrate> getCurrencyrates2() {
		return this.currencyrates2;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Countryregioncurrency removeCountryregioncurrency(Countryregioncurrency countryregioncurrency) {
		getCountryregioncurrencies().remove(countryregioncurrency);
		countryregioncurrency.setCurrency(null);

		return countryregioncurrency;
	}

	public Currencyrate removeCurrencyrates1(Currencyrate currencyrates1) {
		getCurrencyrates1().remove(currencyrates1);
		currencyrates1.setCurrency1(null);

		return currencyrates1;
	}

	public Currencyrate removeCurrencyrates2(Currencyrate currencyrates2) {
		getCurrencyrates2().remove(currencyrates2);
		currencyrates2.setCurrency2(null);

		return currencyrates2;
	}

	public void setCountryregioncurrencies(List<Countryregioncurrency> countryregioncurrencies) {
		this.countryregioncurrencies = countryregioncurrencies;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public void setCurrencyrates1(List<Currencyrate> currencyrates1) {
		this.currencyrates1 = currencyrates1;
	}

	public void setCurrencyrates2(List<Currencyrate> currencyrates2) {
		this.currencyrates2 = currencyrates2;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

}