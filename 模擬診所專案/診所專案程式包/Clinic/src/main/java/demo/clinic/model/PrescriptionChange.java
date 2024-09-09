package demo.clinic.model;

public class PrescriptionChange {

	public static PrescriptionDto mapToDto(Prescription p) {
		PrescriptionDto dto = new PrescriptionDto();
		dto.setPreCode(p.getPreCode());
		dto.setAppointmentCode(p.getAppointment().getApCode());
		dto.setMedicineId(p.getMedicine().getMedId());
		dto.setMedDay(p.getMedDay());
		return dto;
	}
	
	public static Prescription mapToPrescription(PrescriptionDto dto) {
		Appointment appointment = new Appointment();
		appointment.setApCode(dto.getAppointmentCode());
		
		Medicine medicine = new Medicine();
		medicine.setMedId(dto.getMedicineId());
		
		Prescription p = new Prescription();
		p.setPreCode(dto.getPreCode());
		p.setAppointment(appointment);
		p.setMedicine(medicine);
		p.setMedDay(dto.getMedDay());
		return p;
	}
}
