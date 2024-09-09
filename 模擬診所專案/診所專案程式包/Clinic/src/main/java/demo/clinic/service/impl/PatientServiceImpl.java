package demo.clinic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.clinic.dao.PatientDao;
import demo.clinic.model.Patient;
import demo.clinic.model.PatientChange;
import demo.clinic.model.PatientDto;
import demo.clinic.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;
	
	
	@Override
	public boolean createPatient(PatientDto pat) {
		Patient patient = patientDao.findById(pat.getPatId()).orElse(null);
		if(patient == null) {
			patientDao.save(PatientChange.mapToPatient(pat));
			return true;
		} else {
			return false;
		}
	}


	@Override
	public Map<String, String> loginPatient(String patId, String patPhone) {
		Patient patient = patientDao.findById(patId).orElse(null);
		Map<String, String> res = new HashMap<>();
		
		if(patient != null && patient.getPatPhone().equals(patPhone)) {
			// 帳號密碼正確
			res.put("patId", patient.getPatId());
			res.put("patName", patient.getPatName());
			res.put("status", "ok");
			
		} else if(patient != null && !patient.getPatPhone().equals(patPhone)) {
			// 密碼錯誤
			res.put("status", "error");
		} else {
			// 沒有帳號
			res.put("status", "nothing");
		}
		
		return res;
	}


	@Override
	public List<PatientDto> findAll() {
		List<Patient> patients = patientDao.findAll();
		List<PatientDto> dtos = new ArrayList<>();
		for(Patient p : patients) {
			dtos.add(PatientChange.mapToDto(p));
		}
		return dtos;
	}


	@Override
	public PatientDto findById(String patId) {
		Patient patient = patientDao.findById(patId).orElse(null);
		if(patient != null) {
			return PatientChange.mapToDto(patient);
		} else {
			return null;
		}
	}


	@Override
	public boolean deleteById(String patId) {
		try {
			patientDao.deleteById(patId);
			return true;
		} catch (Exception e) {
			System.out.println("deleteById ERROR: " + e.getMessage());
			return false;
		}
	}


	@Override
	public boolean createAndUpdate(PatientDto pat) {
		try {
			patientDao.save(PatientChange.mapToPatient(pat));
			return true;
		} catch (Exception e) {
			System.out.println("createAndUpdate ERROR: " + e.getMessage());
			return false;
		}
	}
	
	
}
