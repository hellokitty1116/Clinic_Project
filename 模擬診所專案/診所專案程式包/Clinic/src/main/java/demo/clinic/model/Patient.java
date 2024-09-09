package demo.clinic.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String patId;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date patBirth;

	private String patGender;

	private String patName;

	private String patPhone;

	//bi-directional many-to-one association to Appointment
	@JsonManagedReference
	@OneToMany(mappedBy="patient")
	private List<Appointment> appointments;

	public Patient() {
	}

	public String getPatId() {
		return this.patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public Date getPatBirth() {
		return this.patBirth;
	}

	public void setPatBirth(Date patBirth) {
		this.patBirth = patBirth;
	}

	public String getPatGender() {
		return this.patGender;
	}

	public void setPatGender(String patGender) {
		this.patGender = patGender;
	}

	public String getPatName() {
		return this.patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatPhone() {
		return this.patPhone;
	}

	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setPatient(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setPatient(null);

		return appointment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointments, patBirth, patGender, patId, patName, patPhone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(appointments, other.appointments) && Objects.equals(patBirth, other.patBirth)
				&& Objects.equals(patGender, other.patGender) && Objects.equals(patId, other.patId)
				&& Objects.equals(patName, other.patName) && Objects.equals(patPhone, other.patPhone);
	}
	
}