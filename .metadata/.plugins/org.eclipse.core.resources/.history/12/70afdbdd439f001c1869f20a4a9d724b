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
 * The persistent class for the illustration database table.
 *
 */
@Entity
@NamedQuery(name = "Illustration.findAll", query = "SELECT i FROM Illustration i")
public class Illustration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ILLUSTRATION_ILLUSTRATIONID_GENERATOR", allocationSize = 1, sequenceName = "ILLUSTRATION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ILLUSTRATION_ILLUSTRATIONID_GENERATOR")
	private Integer illustrationid;

	private String diagram;

	private Timestamp modifieddate;

	// bi-directional many-to-one association to Productmodelillustration
	@OneToMany(mappedBy = "illustration")
	private List<Productmodelillustration> productmodelillustrations;

	public Illustration() {
	}

	public Productmodelillustration addProductmodelillustration(Productmodelillustration productmodelillustration) {
		getProductmodelillustrations().add(productmodelillustration);
		productmodelillustration.setIllustration(this);

		return productmodelillustration;
	}

	public String getDiagram() {
		return this.diagram;
	}

	public Integer getIllustrationid() {
		return this.illustrationid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public List<Productmodelillustration> getProductmodelillustrations() {
		return this.productmodelillustrations;
	}

	public Productmodelillustration removeProductmodelillustration(Productmodelillustration productmodelillustration) {
		getProductmodelillustrations().remove(productmodelillustration);
		productmodelillustration.setIllustration(null);

		return productmodelillustration;
	}

	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}

	public void setIllustrationid(Integer illustrationid) {
		this.illustrationid = illustrationid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProductmodelillustrations(List<Productmodelillustration> productmodelillustrations) {
		this.productmodelillustrations = productmodelillustrations;
	}

}