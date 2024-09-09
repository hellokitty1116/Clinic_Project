package demo.clinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.clinic.model.Prescription;

public interface PrescriptionDao extends JpaRepository<Prescription, String>{
	
}
