package demo.clinic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDto {
	
	private String patient;
	private String medicalstaff;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date apDate;
	
	private String apTime;
	private String apCode;

	public AppointmentDto() {

	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String  getMedicalstaff() {
		return medicalstaff;
	}

	public void setMedicalstaff(String  medicalstaff) {
		this.medicalstaff = medicalstaff;
	}

	public Date getApDate() {
		return apDate;
	}

	public void setApDate(Date apDate) {
		this.apDate = apDate;
	}

	public String getApTime() {
		return apTime;
	}

	public void setApTime(String apTime) {
		this.apTime = apTime;
	}

	public String getApCode() {
		return apCode;
	}

	public void setApCode(String apCode) {
		this.apCode = apCode;
	}
	
	
	
}
