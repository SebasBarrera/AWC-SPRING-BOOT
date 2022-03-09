package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the countryregioncurrency database table.
 * 
 */
@Embeddable
public class CountryregioncurrencyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String countryregioncode;

	@Column(insertable=false, updatable=false)
	private String currencycode;

	public CountryregioncurrencyPK() {
	}
	public String getCountryregioncode() {
		return this.countryregioncode;
	}
	public void setCountryregioncode(String countryregioncode) {
		this.countryregioncode = countryregioncode;
	}
	public String getCurrencycode() {
		return this.currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CountryregioncurrencyPK)) {
			return false;
		}
		CountryregioncurrencyPK castOther = (CountryregioncurrencyPK)other;
		return 
			this.countryregioncode.equals(castOther.countryregioncode)
			&& this.currencycode.equals(castOther.currencycode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.countryregioncode.hashCode();
		hash = hash * prime + this.currencycode.hashCode();
		
		return hash;
	}
}