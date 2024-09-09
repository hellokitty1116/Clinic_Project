package demo.clinic.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


/**
 * The persistent class for the prescription database table.
 * 
 */
@Entity
public class Prescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String preCode;

	private int medDay;

	//bi-directional many-to-one association to Appointment
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="appointmentCode")
	private Appointment appointment;

	//bi-directional many-to-one association to Medicine
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="medicineId")
	private Medicine medicine;

	public Prescription() {
	}

	public String getPreCode() {
		return this.preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public int getMedDay() {
		return this.medDay;
	}

	public void setMedDay(int medDay) {
		this.medDay = medDay;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Medicine getMedicine() {
		return this.medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointment, medDay, medicine, preCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prescription other = (Prescription) obj;
		return Objects.equals(appointment, other.appointment) && medDay == other.medDay
				&& Objects.equals(medicine, other.medicine) && Objects.equals(preCode, other.preCode);
	}
	
}