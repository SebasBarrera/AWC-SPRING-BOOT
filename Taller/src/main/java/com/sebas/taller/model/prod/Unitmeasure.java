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
 * The persistent class for the unitmeasure database table.
 *
 */
@Entity
@NamedQuery(name = "Unitmeasure.findAll", query = "SELECT u FROM Unitmeasure u")
public class Unitmeasure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "UNITMEASURE_UNITMEASURECODE_GENERATOR", allocationSize = 1, sequenceName = "UNITMEASURE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNITMEASURE_UNITMEASURECODE_GENERATOR")
	private String unitmeasurecode;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to Billofmaterial
	@OneToMany(mappedBy = "unitmeasure")
	private List<Billofmaterial> billofmaterials;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "unitmeasure1")
	private List<Product> products1;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "unitmeasure2")
	private List<Product> products2;

	public Unitmeasure() {
	}

	public Billofmaterial addBillofmaterial(Billofmaterial billofmaterial) {
		getBillofmaterials().add(billofmaterial);
		billofmaterial.setUnitmeasure(this);

		return billofmaterial;
	}

	public Product addProducts1(Product products1) {
		getProducts1().add(products1);
		products1.setUnitmeasure1(this);

		return products1;
	}

	public Product addProducts2(Product products2) {
		getProducts2().add(products2);
		products2.setUnitmeasure2(this);

		return products2;
	}

	public List<Billofmaterial> getBillofmaterials() {
		return this.billofmaterials;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Product> getProducts1() {
		return this.products1;
	}

	public List<Product> getProducts2() {
		return this.products2;
	}

	public String getUnitmeasurecode() {
		return this.unitmeasurecode;
	}

	public Billofmaterial removeBillofmaterial(Billofmaterial billofmaterial) {
		getBillofmaterials().remove(billofmaterial);
		billofmaterial.setUnitmeasure(null);

		return billofmaterial;
	}

	public Product removeProducts1(Product products1) {
		getProducts1().remove(products1);
		products1.setUnitmeasure1(null);

		return products1;
	}

	public Product removeProducts2(Product products2) {
		getProducts2().remove(products2);
		products2.setUnitmeasure2(null);

		return products2;
	}

	public void setBillofmaterials(List<Billofmaterial> billofmaterials) {
		this.billofmaterials = billofmaterials;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducts1(List<Product> products1) {
		this.products1 = products1;
	}

	public void setProducts2(List<Product> products2) {
		this.products2 = products2;
	}

	public void setUnitmeasurecode(String unitmeasurecode) {
		this.unitmeasurecode = unitmeasurecode;
	}

}