package com.sebas.taller.model.sales;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the shoppingcartitem database table.
 * 
 */
@Entity
@NamedQuery(name="Shoppingcartitem.findAll", query="SELECT s FROM Shoppingcartitem s")
public class Shoppingcartitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPPINGCARTITEM_SHOPPINGCARTITEMID_GENERATOR",allocationSize = 1, sequenceName="SHOPPINGCARTITEM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPPINGCARTITEM_SHOPPINGCARTITEMID_GENERATOR")
	private Integer shoppingcartitemid;

	private Timestamp datecreated;

	private Timestamp modifieddate;

	private Integer productid;

	private Integer quantity;

	private String shoppingcartid;

	public Shoppingcartitem() {
	}

	public Integer getShoppingcartitemid() {
		return this.shoppingcartitemid;
	}

	public void setShoppingcartitemid(Integer shoppingcartitemid) {
		this.shoppingcartitemid = shoppingcartitemid;
	}

	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getShoppingcartid() {
		return this.shoppingcartid;
	}

	public void setShoppingcartid(String shoppingcartid) {
		this.shoppingcartid = shoppingcartid;
	}

}