package demo.clinic.model;

public class PatientChange {
	
	public static PatientDto mapToDto(Patient patient) {
		PatientDto dto = new PatientDto();
		dto.setPatId(patient.getPatId());
		dto.setPatName(patient.getPatName());
		dto.setPatPhone(patient.getPatPhone());
		dto.setPatGender(patient.getPatGender());
		dto.setPatBirth(patient.getPatBirth());
		return dto;
	}
	
	
	public static Patient mapToPatient(PatientDto dto) {
		Patient pat = new Patient();
		pat.setPatId(dto.getPatId());
		pat.setPatName(dto.getPatName());
		pat.setPatPhone(dto.getPatPhone());
		pat.setPatGender(dto.getPatGender());
		pat.setPatBirth(dto.getPatBirth());
		return pat;
	}
	
}
