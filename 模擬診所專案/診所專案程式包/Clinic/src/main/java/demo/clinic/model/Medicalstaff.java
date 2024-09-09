package demo.clinic.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the medicalstaff database table.
 * 
 */
@Entity
public class Medicalstaff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String stafCode;
	
	private String stafId;

	private String stafJobTitle;

	private String stafName;

	//bi-directional many-to-one association to Appointment
	@JsonManagedReference
	@OneToMany(mappedBy="medicalstaff")
	private List<Appointment> appointments;

	public Medicalstaff() {
	}

	public String getStafCode() {
		return this.stafCode;
	}

	public void setStafCode(String stafCode) {
		this.stafCode = stafCode;
	}

	public String getStafJobTitle() {
		return this.stafJobTitle;
	}

	public void setStafJobTitle(String stafJobTitle) {
		this.stafJobTitle = stafJobTitle;
	}

	public String getStafName() {
		return this.stafName;
	}

	public void setStafName(String stafName) {
		this.stafName = stafName;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setMedicalstaff(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setMedicalstaff(null);

		return appointment;
	}

	public String getStafId() {
		return stafId;
	}

	public void setStafId(String stafId) {
		this.stafId = stafId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointments, stafCode, stafId, stafJobTitle, stafName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicalstaff other = (Medicalstaff) obj;
		return Objects.equals(appointments, other.appointments) && Objects.equals(stafCode, other.stafCode)
				&& Objects.equals(stafId, other.stafId) && Objects.equals(stafJobTitle, other.stafJobTitle)
				&& Objects.equals(stafName, other.stafName);
	}
	
	
}