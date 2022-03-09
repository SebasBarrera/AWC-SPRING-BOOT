package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the productproductphoto database table.
 *
 */
@Entity
@NamedQuery(name = "Productproductphoto.findAll", query = "SELECT p FROM Productproductphoto p")
public class Productproductphoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductproductphotoPK id;

	private Timestamp modifieddate;

	private String primaryphoto;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	private Product product;

	// bi-directional many-to-one association to Productphoto
	@ManyToOne
	@JoinColumn(name = "productphotoid", insertable = false, updatable = false)
	private Productphoto productphoto;

	public Productproductphoto() {
	}

	public ProductproductphotoPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getPrimaryPhoto() {
		return this.primaryphoto;
	}

	public Product getProduct() {
		return this.product;
	}

	public Productphoto getProductphoto() {
		return this.productphoto;
	}

	public void setId(ProductproductphotoPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPrimaryPhoto(String primaryphoto) {
		this.primaryphoto = primaryphoto;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductphoto(Productphoto productphoto) {
		this.productphoto = productphoto;
	}

}