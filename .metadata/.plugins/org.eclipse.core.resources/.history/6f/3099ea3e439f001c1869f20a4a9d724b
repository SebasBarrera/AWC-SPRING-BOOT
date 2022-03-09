package co.edu.icesi.dev.uccareapp.transport.model.hr;

import java.io.Serializable;
import java.sql.Time;
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
 * The persistent class for the shift database table.
 *
 */
@Entity
@NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s")
public class Shift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SHIFT_SHIFTID_GENERATOR", allocationSize = 1, sequenceName = "SHIFT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIFT_SHIFTID_GENERATOR")
	private Integer shiftid;

	private Time endtime;

	private Timestamp modifieddate;

	private String name;

	private Time starttime;

	// bi-directional many-to-one association to Employeedepartmenthistory
	@OneToMany(mappedBy = "shift")
	private List<Employeedepartmenthistory> employeedepartmenthistories;

	public Shift() {
	}

	public Employeedepartmenthistory addEmployeedepartmenthistory(Employeedepartmenthistory employeedepartmenthistory) {
		getEmployeedepartmenthistories().add(employeedepartmenthistory);
		employeedepartmenthistory.setShift(this);

		return employeedepartmenthistory;
	}

	public List<Employeedepartmenthistory> getEmployeedepartmenthistories() {
		return this.employeedepartmenthistories;
	}

	public Time getEndtime() {
		return this.endtime;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getShiftid() {
		return this.shiftid;
	}

	public Time getStarttime() {
		return this.starttime;
	}

	public Employeedepartmenthistory removeEmployeedepartmenthistory(
			Employeedepartmenthistory employeedepartmenthistory) {
		getEmployeedepartmenthistories().remove(employeedepartmenthistory);
		employeedepartmenthistory.setShift(null);

		return employeedepartmenthistory;
	}

	public void setEmployeedepartmenthistories(List<Employeedepartmenthistory> employeedepartmenthistories) {
		this.employeedepartmenthistories = employeedepartmenthistories;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShiftid(Integer shiftid) {
		this.shiftid = shiftid;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

}