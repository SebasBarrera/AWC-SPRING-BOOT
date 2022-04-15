package com.sebas.taller.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@NotBlank(message = "Name can not be in blank")
	private String name;

	private Integer rowguid;

	@NotBlank(message = "State-Province can not be in blank")
	@Min(1)
	private Integer stateprovinceid;

	@Min(0)
	@NotBlank(message = "Tax rate can not be in blank")
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

	public Integer getStateprovinceid() {
		return this.stateprovinceid;
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

	public void setStateprovinceid(Integer stateprovinceid) {
		this.stateprovinceid = stateprovinceid;
	}

	public void setTaxrate(BigDecimal taxrate) {
		this.taxrate = taxrate;
	}

	public void setTaxtype(Integer taxtype) {
		this.taxtype = taxtype;
	}

}