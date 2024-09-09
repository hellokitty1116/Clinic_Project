package demo.clinic.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the medicine database table.
 * 
 */
@Entity
public class Medicine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String medId;

	private String indications;

	private String medName;

	private String medType;

	private int quantity;

	//bi-directional many-to-one association to Prescription
	@JsonManagedReference
	@OneToMany(mappedBy="medicine")
	private List<Prescription> prescriptions;

	public Medicine() {
	}

	public String getMedId() {
		return this.medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public String getIndications() {
		return this.indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public String getMedName() {
		return this.medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getMedType() {
		return this.medType;
	}

	public void setMedType(String medType) {
		this.medType = medType;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setMedicine(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setMedicine(null);

		return prescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(indications, medId, medName, medType, prescriptions, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicine other = (Medicine) obj;
		return Objects.equals(indications, other.indications) && Objects.equals(medId, other.medId)
				&& Objects.equals(medName, other.medName) && Objects.equals(medType, other.medType)
				&& Objects.equals(prescriptions, other.prescriptions) && quantity == other.quantity;
	}

}