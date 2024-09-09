package demo.clinic.service;

import java.util.List;
import java.util.Map;

import demo.clinic.model.MedicalstaffDto;


public interface MedicalstaffService {
	
	List<Map<String, String>> findByStafJobTitle(String stafJobTitle);
	Map<String, String> loginStaff(MedicalstaffDto dto);
	List<MedicalstaffDto> findAll();
	MedicalstaffDto findById(String stafCode);
	boolean deleteById(String stafCode);
	boolean createAndUpdate(MedicalstaffDto dto);
}
