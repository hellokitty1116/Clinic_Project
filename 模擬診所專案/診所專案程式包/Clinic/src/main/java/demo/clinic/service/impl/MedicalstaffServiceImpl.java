package demo.clinic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.clinic.dao.MedicalstaffDao;
import demo.clinic.model.Medicalstaff;
import demo.clinic.model.MedicalstaffChange;
import demo.clinic.model.MedicalstaffDto;
import demo.clinic.service.MedicalstaffService;

@Service
public class MedicalstaffServiceImpl implements MedicalstaffService{

	@Autowired
	private MedicalstaffDao medicalstaffDao;

	@Override
	public List<Map<String, String>> findByStafJobTitle(String stafJobTitle) {
		List<Medicalstaff> data = medicalstaffDao.findByStafJobTitle(stafJobTitle);
		List<Map<String, String>> doctors = new ArrayList<>();
		
		for(Medicalstaff m : data) {
			Map<String, String> temp = new HashMap<>();
			temp.put("stafCode", m.getStafCode());
			temp.put("stafName", m.getStafName());
			doctors.add(temp);
		}
		return doctors;
	}

	@Override
	public Map<String, String> loginStaff(MedicalstaffDto dto) {
		Medicalstaff m = medicalstaffDao.findByStafJobTitleAndStafCode(dto.getStafJobTitle(), dto.getStafCode());
		Map<String, String> res = new HashMap<>();
		
		if(m != null && m.getStafId().equals(dto.getStafId())) {
			// 編號和證號正確
			res.put("stafCode", m.getStafCode());
			res.put("stafName", m.getStafName());
			res.put("stafJobTitle", m.getStafJobTitle());
			res.put("status", "ok");
		} else if(m != null && !m.getStafId().equals(dto.getStafId())) {
			// 證號錯誤
			res.put("status", "error");
		} else {
			// 無此職員
			res.put("status", "nothing");
		}
		
		return res;
	}

	@Override
	public List<MedicalstaffDto> findAll() {
		List<Medicalstaff> datas = medicalstaffDao.findAll();
		List<MedicalstaffDto> dtos = new ArrayList<>();
		for(Medicalstaff m : datas) {
			if(m.getStafJobTitle().equals("A")) {
				continue;
			} else {
				dtos.add(MedicalstaffChange.mapToDto(m));
			}	
		}
		return dtos;
	}

	@Override
	public MedicalstaffDto findById(String stafCode) {
		Medicalstaff m = medicalstaffDao.findById(stafCode).orElse(null);
		if(m != null) {
			return MedicalstaffChange.mapToDto(m);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteById(String stafCode) {
		try {
			medicalstaffDao.deleteById(stafCode);
			return true;
		} catch (Exception e) {
			System.out.println("deleteById ERROR: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean createAndUpdate(MedicalstaffDto dto) {
		Medicalstaff m = medicalstaffDao.save(MedicalstaffChange.mapToMS(dto));
		if(m != null) {
			return true;
		} else {
			return false;
		}
	}
	

}
