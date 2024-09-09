package demo.clinic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientDto {
	
	private String patId;
	private String patPhone;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date patBirth;
	
	private String patGender;
	private String patName;
	
	public PatientDto() {

	}

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getPatPhone() {
		return patPhone;
	}

	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}

	public Date getPatBirth() {
		return patBirth;
	}

	public void setPatBirth(Date patBirth) {
		this.patBirth = patBirth;
	}

	public String getPatGender() {
		return patGender;
	}

	public void setPatGender(String patGender) {
		this.patGender = patGender;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}
	
	
}
