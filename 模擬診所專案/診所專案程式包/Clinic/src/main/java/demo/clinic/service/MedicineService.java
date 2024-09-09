package demo.clinic.service;

import java.util.List;

import demo.clinic.model.MedicineDto;

public interface MedicineService {
	
	MedicineDto findByMedIdOrMedName(String info);
	List<MedicineDto> findAll();
	boolean deleteById(String medId);
	MedicineDto createAndUpdate(MedicineDto dto);
}
