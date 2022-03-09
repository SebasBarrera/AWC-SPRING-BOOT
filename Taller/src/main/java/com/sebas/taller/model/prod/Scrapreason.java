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
 * The persistent class for the scrapreason database table.
 *
 */
@Entity
@NamedQuery(name = "Scrapreason.findAll", query = "SELECT s FROM Scrapreason s")
public class Scrapreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SCRAPREASON_SCRAPREASONID_GENERATOR", allocationSize = 1, sequenceName = "SCRAPREASON_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCRAPREASON_SCRAPREASONID_GENERATOR")
	private Integer scrapreasonid;

	private Timestamp modifieddate;

	private String name;

	// bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy = "scrapreason")
	private List<Workorder> workorders;

	public Scrapreason() {
	}

	public Workorder addWorkorder(Workorder workorder) {
		getWorkorders().add(workorder);
		workorder.setScrapreason(this);

		return workorder;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getScrapreasonid() {
		return this.scrapreasonid;
	}

	public List<Workorder> getWorkorders() {
		return this.workorders;
	}

	public Workorder removeWorkorder(Workorder workorder) {
		getWorkorders().remove(workorder);
		workorder.setScrapreason(null);

		return workorder;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScrapreasonid(Integer scrapreasonid) {
		this.scrapreasonid = scrapreasonid;
	}

	public void setWorkorders(List<Workorder> workorders) {
		this.workorders = workorders;
	}

}