package demo.clinic.service;

import java.util.List;
import java.util.Map;

import demo.clinic.model.PatientDto;

public interface PatientService {
	
	boolean createPatient(PatientDto pat);
	Map<String, String> loginPatient(String patId, String patPhone);
	List<PatientDto> findAll();
	PatientDto findById(String patId);
	boolean deleteById(String patId);
	boolean createAndUpdate(PatientDto pat);
}
