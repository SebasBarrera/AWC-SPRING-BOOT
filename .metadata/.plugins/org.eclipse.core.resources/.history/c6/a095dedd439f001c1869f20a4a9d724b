package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the productcosthistory database table.
 *
 */
@Entity
@NamedQuery(name = "Productcosthistory.findAll", query = "SELECT p FROM Productcosthistory p")
public class Productcosthistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductcosthistoryPK id;

	private Timestamp enddate;

	private Timestamp modifieddate;

	private BigDecimal standardcost;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	private Product product;

	public Productcosthistory() {
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public ProductcosthistoryPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Product getProduct() {
		return this.product;
	}

	public BigDecimal getStandardcost() {
		return this.standardcost;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public void setId(ProductcosthistoryPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStandardcost(BigDecimal standardcost) {
		this.standardcost = standardcost;
	}

}