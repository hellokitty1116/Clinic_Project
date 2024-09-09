package demo.clinic.model;

public class AppointmentChange {
	
	public static AppointmentDto mapToDto(Appointment ap) {
		AppointmentDto dto = new AppointmentDto();
		dto.setPatient(ap.getPatient().getPatId());
		dto.setMedicalstaff(ap.getMedicalstaff().getStafCode());
		dto.setApDate(ap.getApDate());
		dto.setApTime(ap.getApTime());
		dto.setApCode(ap.getApCode());
		return dto;
	}
	
	
	public static Appointment mapToAppointment(AppointmentDto dto) {
		Patient patient = new Patient();
		patient.setPatId(dto.getPatient());
		
		Medicalstaff medicalstaff = new Medicalstaff();
		medicalstaff.setStafCode(dto.getMedicalstaff());
		
		Appointment ap = new Appointment();
		ap.setPatient(patient);
		ap.setMedicalstaff(medicalstaff);
		ap.setApDate(dto.getApDate());
		ap.setApTime(dto.getApTime());
		ap.setApCode(dto.getApCode());
		return ap;
	}
	
}
