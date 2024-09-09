package demo.clinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.clinic.model.Patient;

public interface PatientDao extends JpaRepository<Patient, String>{
	
}
