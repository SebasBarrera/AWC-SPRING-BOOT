package com.sebas.taller.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the specialoffer database table.
 *
 */
@Entity
@NamedQuery(name = "Specialoffer.findAll", query = "SELECT s FROM Specialoffer s")
public class Specialoffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SPECIALOFFER_SPECIALOFFERID_GENERATOR", allocationSize = 1, sequenceName = "SPECIALOFFER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPECIALOFFER_SPECIALOFFERID_GENERATOR")
	private Integer specialofferid;

	private String category;

	private String description;

	private BigDecimal discountpct;

	private Timestamp enddate;

	private Integer maxqty;

	private Integer minqty;

	private Timestamp modifieddate;

	private Integer rowguid;

	private Timestamp startdate;

	private String type;

	// bi-directional many-to-one association to Specialofferproduct
	@OneToMany(mappedBy = "specialoffer")
	private List<Specialofferproduct> specialofferproducts;

	public Specialoffer() {
	}

	public Specialofferproduct addSpecialofferproduct(Specialofferproduct specialofferproduct) {
		getSpecialofferproducts().add(specialofferproduct);
		specialofferproduct.setSpecialoffer(this);

		return specialofferproduct;
	}

	public String getCategory() {
		return this.category;
	}

	public String getDescription() {
		return this.description;
	}

	public BigDecimal getDiscountpct() {
		return this.discountpct;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public Integer getMaxqty() {
		return this.maxqty;
	}

	public Integer getMinqty() {
		return this.minqty;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getSpecialofferid() {
		return this.specialofferid;
	}

	public List<Specialofferproduct> getSpecialofferproducts() {
		return this.specialofferproducts;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public String getType() {
		return this.type;
	}

	public Specialofferproduct removeSpecialofferproduct(Specialofferproduct specialofferproduct) {
		getSpecialofferproducts().remove(specialofferproduct);
		specialofferproduct.setSpecialoffer(null);

		return specialofferproduct;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDiscountpct(BigDecimal discountpct) {
		this.discountpct = discountpct;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public void setMaxqty(Integer maxqty) {
		this.maxqty = maxqty;
	}

	public void setMinqty(Integer minqty) {
		this.minqty = minqty;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSpecialofferid(Integer specialofferid) {
		this.specialofferid = specialofferid;
	}

	public void setSpecialofferproducts(List<Specialofferproduct> specialofferproducts) {
		this.specialofferproducts = specialofferproducts;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public void setType(String type) {
		this.type = type;
	}

}