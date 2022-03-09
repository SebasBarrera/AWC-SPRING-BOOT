package com.sebas.taller.model.prod;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the productmodelproductdescriptionculture database
 * table.
 *
 */
@Entity
@NamedQuery(name = "Productmodelproductdescriptionculture.findAll", query = "SELECT p FROM Productmodelproductdescriptionculture p")
public class Productmodelproductdescriptionculture implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductmodelproductdescriptionculturePK id;

	private Timestamp modifieddate;

	// bi-directional many-to-one association to Culture
	@ManyToOne
	@JoinColumn(name = "cultureid", insertable = false, updatable = false)
	private Culture culture;

	// bi-directional many-to-one association to Productdescription
	@ManyToOne
	@JoinColumn(name = "productdescriptionid", insertable = false, updatable = false)
	private Productdescription productdescription;

	// bi-directional many-to-one association to Productmodel
	@ManyToOne
	@JoinColumn(name = "productmodelid", insertable = false, updatable = false)
	private Productmodel productmodel;

	public Productmodelproductdescriptionculture() {
	}

	public Culture getCulture() {
		return this.culture;
	}

	public ProductmodelproductdescriptionculturePK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Productdescription getProductdescription() {
		return this.productdescription;
	}

	public Productmodel getProductmodel() {
		return this.productmodel;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

	public void setId(ProductmodelproductdescriptionculturePK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProductdescription(Productdescription productdescription) {
		this.productdescription = productdescription;
	}

	public void setProductmodel(Productmodel productmodel) {
		this.productmodel = productmodel;
	}

}