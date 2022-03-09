package com.sebas.taller.model.prod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the workorderrouting database table.
 *
 */
@Entity
@NamedQuery(name = "Workorderrouting.findAll", query = "SELECT w FROM Workorderrouting w")
public class Workorderrouting implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkorderroutingPK id;

	private BigDecimal actualcost;

	private Timestamp actualenddate;

	private BigDecimal actualresourcehrs;

	private Timestamp actualstartdate;

	private Timestamp modifieddate;

	private BigDecimal plannedcost;

	private Timestamp scheduledenddate;

	private Timestamp scheduledstartdate;

	// bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name = "locationid", insertable = false, updatable = false)
	private Location location;

	// bi-directional many-to-one association to Workorder
	@ManyToOne
	@JoinColumn(name = "workorderid", insertable = false, updatable = false)
	private Workorder workorder;

	public Workorderrouting() {
	}

	public BigDecimal getActualcost() {
		return this.actualcost;
	}

	public Timestamp getActualenddate() {
		return this.actualenddate;
	}

	public BigDecimal getActualresourcehrs() {
		return this.actualresourcehrs;
	}

	public Timestamp getActualstartdate() {
		return this.actualstartdate;
	}

	public WorkorderroutingPK getId() {
		return this.id;
	}

	public Location getLocation() {
		return this.location;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public BigDecimal getPlannedcost() {
		return this.plannedcost;
	}

	public Timestamp getScheduledenddate() {
		return this.scheduledenddate;
	}

	public Timestamp getScheduledstartdate() {
		return this.scheduledstartdate;
	}

	public Workorder getWorkorder() {
		return this.workorder;
	}

	public void setActualcost(BigDecimal actualcost) {
		this.actualcost = actualcost;
	}

	public void setActualenddate(Timestamp actualenddate) {
		this.actualenddate = actualenddate;
	}

	public void setActualresourcehrs(BigDecimal actualresourcehrs) {
		this.actualresourcehrs = actualresourcehrs;
	}

	public void setActualstartdate(Timestamp actualstartdate) {
		this.actualstartdate = actualstartdate;
	}

	public void setId(WorkorderroutingPK id) {
		this.id = id;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPlannedcost(BigDecimal plannedcost) {
		this.plannedcost = plannedcost;
	}

	public void setScheduledenddate(Timestamp scheduledenddate) {
		this.scheduledenddate = scheduledenddate;
	}

	public void setScheduledstartdate(Timestamp scheduledstartdate) {
		this.scheduledstartdate = scheduledstartdate;
	}

	public void setWorkorder(Workorder workorder) {
		this.workorder = workorder;
	}

}