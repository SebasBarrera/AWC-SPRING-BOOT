package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the productdocument database table.
 *
 */
@Entity
@NamedQuery(name = "Productdocument.findAll", query = "SELECT p FROM Productdocument p")
public class Productdocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductdocumentPK id;

	private Timestamp modifieddate;

	// bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name = "documentnode", insertable = false, updatable = false)
	private Document document;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	private Product product;

	public Productdocument() {
	}

	public Document getDocument() {
		return this.document;
	}

	public ProductdocumentPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public void setId(ProductdocumentPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}