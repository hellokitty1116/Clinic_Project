package demo.clinic.model;


public class PrescriptionDto {
	
	private String preCode;
	private String appointmentCode;
	private String medicineId;
	private int medDay;
	
	public PrescriptionDto() {

	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public String getAppointmentCode() {
		return appointmentCode;
	}

	public void setAppointmentCode(String appointmentCode) {
		this.appointmentCode = appointmentCode;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public int getMedDay() {
		return medDay;
	}

	public void setMedDay(int medDay) {
		this.medDay = medDay;
	}

	
}
