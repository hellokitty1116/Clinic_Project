package demo.clinic.model;

public class MedicalstaffChange {

	public static MedicalstaffDto mapToDto(Medicalstaff m) {
		MedicalstaffDto dto = new MedicalstaffDto();
		dto.setStafCode(m.getStafCode());
		dto.setStafId(m.getStafId());
		dto.setStafJobTitle(m.getStafJobTitle());
		dto.setStafName(m.getStafName());
		return dto;
	}
	
	public static Medicalstaff mapToMS(MedicalstaffDto dto) {
		Medicalstaff m = new Medicalstaff();
		m.setStafCode(dto.getStafCode());
		m.setStafId(dto.getStafId());
		m.setStafJobTitle(dto.getStafJobTitle());
		m.setStafName(dto.getStafName());
		return m;
	}
	
}
