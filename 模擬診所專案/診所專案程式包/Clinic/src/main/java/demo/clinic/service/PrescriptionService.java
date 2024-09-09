package demo.clinic.service;

import java.util.List;

import demo.clinic.model.PrescriptionDto;
import demo.clinic.model.view.Medicinelogview;

public interface PrescriptionService {
	
	List<Medicinelogview> findByAppointmentCode(String appointmentCode);
	PrescriptionDto createPre(PrescriptionDto p);
	boolean deleteById(String preCode);
}
