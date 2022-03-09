package co.edu.icesi.dev.uccareapp.transport.model.prod;

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
 * The persistent class for the productdescription database table.
 *
 */
@Entity
@NamedQuery(name = "Productdescription.findAll", query = "SELECT p FROM Productdescription p")
public class Productdescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTDESCRIPTION_PRODUCTDESCRIPTIONID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTDESCRIPTION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTDESCRIPTION_PRODUCTDESCRIPTIONID_GENERATOR")
	private Integer productdescriptionid;

	private String description;

	private Timestamp modifieddate;

	private Integer rowguid;

	// bi-directional many-to-one association to
	// Productmodelproductdescriptionculture
	@OneToMany(mappedBy = "productdescription")
	private List<Productmodelproductdescriptionculture> productmodelproductdescriptioncultures;

	public Productdescription() {
	}

	public Productmodelproductdescriptionculture addProductmodelproductdescriptionculture(
			Productmodelproductdescriptionculture productmodelproductdescriptionculture) {
		getProductmodelproductdescriptioncultures().add(productmodelproductdescriptionculture);
		productmodelproductdescriptionculture.setProductdescription(this);

		return productmodelproductdescriptionculture;
	}

	public String getDescription() {
		return this.description;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getProductdescriptionid() {
		return this.productdescriptionid;
	}

	public List<Productmodelproductdescriptionculture> getProductmodelproductdescriptioncultures() {
		return this.productmodelproductdescriptioncultures;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Productmodelproductdescriptionculture removeProductmodelproductdescriptionculture(
			Productmodelproductdescriptionculture productmodelproductdescriptionculture) {
		getProductmodelproductdescriptioncultures().remove(productmodelproductdescriptionculture);
		productmodelproductdescriptionculture.setProductdescription(null);

		return productmodelproductdescriptionculture;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProductdescriptionid(Integer productdescriptionid) {
		this.productdescriptionid = productdescriptionid;
	}

	public void setProductmodelproductdescriptioncultures(
			List<Productmodelproductdescriptionculture> productmodelproductdescriptioncultures) {
		this.productmodelproductdescriptioncultures = productmodelproductdescriptioncultures;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}