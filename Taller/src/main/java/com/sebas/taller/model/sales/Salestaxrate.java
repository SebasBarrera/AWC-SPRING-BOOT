package com.sebas.taller.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sebas.taller.model.person.Stateprovince;

/**
 * The persistent class for the salestaxrate database table.
 *
 */
@Entity
@NamedQuery(name = "Salestaxrate.findAll", query = "SELECT s FROM Salestaxrate s")
public class Salestaxrate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SALESTAXRATE_SALESTAXRATEID_GENERATOR", allocationSize = 1, sequenceName = "SALESTAXRATE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESTAXRATE_SALESTAXRATEID_GENERATOR")
	private Integer salestaxrateid;

	private Timestamp modifieddate;

	@Size(min = 5, message = "Name must have at least 5 characters")
	private String name;

	private Integer rowguid;

	@ManyToOne
	@JoinColumn(name = "stateprovinceid")
	private Stateprovince stateprovince;

	@Min(0)
	private BigDecimal taxrate;

	private Integer taxtype;

	public Salestaxrate() {
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getSalestaxrateid() {
		return this.salestaxrateid;
	}

	
	public Stateprovince getStateprovince() {
		return this.stateprovince;
	}

	public BigDecimal getTaxrate() {
		return this.taxrate;
	}

	public Integer getTaxtype() {
		return this.taxtype;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSalestaxrateid(Integer salestaxrateid) {
		this.salestaxrateid = salestaxrateid;
	}

	public void setStateprovince(Stateprovince stateprovince) {
		this.stateprovince = stateprovince;
	}

	public void setTaxrate(BigDecimal taxrate) {
		this.taxrate = taxrate;
	}

	public void setTaxtype(Integer taxtype) {
		this.taxtype = taxtype;
	}

}