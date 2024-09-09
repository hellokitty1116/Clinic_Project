package demo.clinic.model.view;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the appointmentview database table.
 * 
 */
@Entity
public class Appointmentview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String apCode;

	@Temporal(TemporalType.DATE)
	private Date apDate;

	private String apTime;
	
	private String patId;

	private String patName;

	private String stafName;

	private String status;

	public Appointmentview() {
	}

	public String getApCode() {
		return this.apCode;
	}

	public void setApCode(String apCode) {
		this.apCode = apCode;
	}

	public Date getApDate() {
		return this.apDate;
	}

	public void setApDate(Date apDate) {
		this.apDate = apDate;
	}

	public String getApTime() {
		return this.apTime;
	}

	public void setApTime(String apTime) {
		this.apTime = apTime;
	}

	public String getPatId() {
		return this.patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getPatName() {
		return this.patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getStafName() {
		return this.stafName;
	}

	public void setStafName(String stafName) {
		this.stafName = stafName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apCode, apDate, apTime, patId, patName, stafName, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointmentview other = (Appointmentview) obj;
		return Objects.equals(apCode, other.apCode) && Objects.equals(apDate, other.apDate)
				&& Objects.equals(apTime, other.apTime) && Objects.equals(patId, other.patId)
				&& Objects.equals(patName, other.patName) && Objects.equals(stafName, other.stafName)
				&& Objects.equals(status, other.status);
	}
	
}