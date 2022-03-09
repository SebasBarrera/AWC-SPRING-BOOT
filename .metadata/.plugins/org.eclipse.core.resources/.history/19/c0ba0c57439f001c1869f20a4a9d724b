package co.edu.icesi.dev.uccareapp.transport.model.person;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the personphone database table.
 *
 */
@Entity
@NamedQuery(name = "Personphone.findAll", query = "SELECT p FROM Personphone p")
public class Personphone implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonphonePK id;

	private Timestamp modifieddate;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Person person;

	// bi-directional many-to-one association to Phonenumbertype
	@ManyToOne
	@JoinColumn(name = "phonenumbertypeid", insertable = false, updatable = false)
	private Phonenumbertype phonenumbertype;

	public Personphone() {
	}

	public PersonphonePK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Person getPerson() {
		return this.person;
	}

	public Phonenumbertype getPhonenumbertype() {
		return this.phonenumbertype;
	}

	public void setId(PersonphonePK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setPhonenumbertype(Phonenumbertype phonenumbertype) {
		this.phonenumbertype = phonenumbertype;
	}

}