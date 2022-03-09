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
 * The persistent class for the culture database table.
 *
 */
@Entity
@NamedQuery(name = "Culture.findAll", query = "SELECT c FROM Culture c")
public class Culture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CULTURE_CULTUREID_GENERATOR", allocationSize = 1, sequenceName = "CULTURE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CULTURE_CULTUREID_GENERATOR")
	private String cultureid;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to
	// Productmodelproductdescriptionculture
	@OneToMany(mappedBy = "culture")
	private List<Productmodelproductdescriptionculture> productmodelproductdescriptioncultures;

	public Culture() {
	}

	public Productmodelproductdescriptionculture addProductmodelproductdescriptionculture(
			Productmodelproductdescriptionculture productmodelproductdescriptionculture) {
		getProductmodelproductdescriptioncultures().add(productmodelproductdescriptionculture);
		productmodelproductdescriptionculture.setCulture(this);

		return productmodelproductdescriptionculture;
	}

	public String getCultureid() {
		return this.cultureid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Productmodelproductdescriptionculture> getProductmodelproductdescriptioncultures() {
		return this.productmodelproductdescriptioncultures;
	}

	public Productmodelproductdescriptionculture removeProductmodelproductdescriptionculture(
			Productmodelproductdescriptionculture productmodelproductdescriptionculture) {
		getProductmodelproductdescriptioncultures().remove(productmodelproductdescriptionculture);
		productmodelproductdescriptionculture.setCulture(null);

		return productmodelproductdescriptionculture;
	}

	public void setCultureid(String cultureid) {
		this.cultureid = cultureid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductmodelproductdescriptioncultures(
			List<Productmodelproductdescriptionculture> productmodelproductdescriptioncultures) {
		this.productmodelproductdescriptioncultures = productmodelproductdescriptioncultures;
	}

}