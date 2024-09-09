package demo.clinic.model.view;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/**
 * The persistent class for the medicinelogview database table.
 * 
 */
@Entity
public class Medicinelogview implements Serializable {
	private static final long serialVersionUID = 1L;

	private String appointmentCode;

	private String indications;

	private int medDay;

	private String medName;

	private String medType;
	
	@Id
	private String preCode;

	public Medicinelogview() {
	}

	public String getAppointmentCode() {
		return this.appointmentCode;
	}

	public void setAppointmentCode(String appointmentCode) {
		this.appointmentCode = appointmentCode;
	}

	public String getIndications() {
		return this.indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public int getMedDay() {
		return this.medDay;
	}

	public void setMedDay(int medDay) {
		this.medDay = medDay;
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

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentCode, indications, medDay, medName, medType, preCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicinelogview other = (Medicinelogview) obj;
		return Objects.equals(appointmentCode, other.appointmentCode) && Objects.equals(indications, other.indications)
				&& medDay == other.medDay && Objects.equals(medName, other.medName)
				&& Objects.equals(medType, other.medType) && Objects.equals(preCode, other.preCode);
	}

	
}