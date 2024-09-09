package demo.clinic.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String apCode;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date apDate;

	private String apTime;

	private String status;

	//bi-directional many-to-one association to Medicalstaff
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="medicalstafCode")
	private Medicalstaff medicalstaff;

	//bi-directional many-to-one association to Patient
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;

	//bi-directional many-to-one association to Prescription
	@JsonManagedReference
	@OneToMany(mappedBy="appointment")
	private List<Prescription> prescriptions;

	public Appointment() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Medicalstaff getMedicalstaff() {
		return this.medicalstaff;
	}

	public void setMedicalstaff(Medicalstaff medicalstaff) {
		this.medicalstaff = medicalstaff;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setAppointment(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setAppointment(null);

		return prescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apCode, apDate, apTime, medicalstaff, patient, prescriptions, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(apCode, other.apCode) && Objects.equals(apDate, other.apDate)
				&& Objects.equals(apTime, other.apTime) && Objects.equals(medicalstaff, other.medicalstaff)
				&& Objects.equals(patient, other.patient) && Objects.equals(prescriptions, other.prescriptions)
				&& Objects.equals(status, other.status);
	}

}