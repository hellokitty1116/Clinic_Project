package demo.clinic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.clinic.model.Medicalstaff;

public interface MedicalstaffDao extends JpaRepository<Medicalstaff, String>{
	List<Medicalstaff> findByStafJobTitle(String stafJobTitle);
	Medicalstaff findByStafJobTitleAndStafCode(String stafJobTitle, String stafCode);
	
}
