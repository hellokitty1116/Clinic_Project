package demo.clinic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.clinic.model.view.Medicinelogview;

public interface MedicinelogviewDao extends JpaRepository<Medicinelogview, String> {
	
	List<Medicinelogview> findByAppointmentCode(String appointmentCode);
	
}
