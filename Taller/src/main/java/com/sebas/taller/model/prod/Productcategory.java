package com.sebas.taller.model.prod;

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
 * The persistent class for the productcategory database table.
 *
 */
@Entity
@NamedQuery(name = "Productcategory.findAll", query = "SELECT p FROM Productcategory p")
public class Productcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTCATEGORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTCATEGORY_PRODUCTCATEGORYID_GENERATOR")
	private Integer productcategoryid;

	private Timestamp modifieddate;

	private String name;

	private Integer rowguid;

	// bi-directional many-to-one association to Productsubcategory
	@OneToMany(mappedBy = "productcategory")
	private List<Productsubcategory> productsubcategories;

	public Productcategory() {
	}

	public Productsubcategory addProductsubcategory(Productsubcategory productsubcategory) {
		getProductsubcategories().add(productsubcategory);
		productsubcategory.setProductcategory(this);

		return productsubcategory;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getProductcategoryid() {
		return this.productcategoryid;
	}

	public List<Productsubcategory> getProductsubcategories() {
		return this.productsubcategories;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Productsubcategory removeProductsubcategory(Productsubcategory productsubcategory) {
		getProductsubcategories().remove(productsubcategory);
		productsubcategory.setProductcategory(null);

		return productsubcategory;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductcategoryid(Integer productcategoryid) {
		this.productcategoryid = productcategoryid;
	}

	public void setProductsubcategories(List<Productsubcategory> productsubcategories) {
		this.productsubcategories = productsubcategories;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}