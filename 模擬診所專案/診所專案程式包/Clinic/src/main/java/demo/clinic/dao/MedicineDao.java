package demo.clinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.clinic.model.Medicine;


public interface MedicineDao extends JpaRepository<Medicine, String>{
	
	Medicine findByMedIdOrMedName(String medId, String medName);
	
}
