package demo.clinic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.clinic.model.MedicalstaffDto;
import demo.clinic.service.MedicalstaffService;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicalstaff")
public class MedicalstaffController {

	@Autowired
	private MedicalstaffService medicalstaffService;
	
	
	@GetMapping
	public List<Map<String, String>> findByStafJobTitle() {
		return medicalstaffService.findByStafJobTitle("D");
	}
	
	@PostMapping("/loginstaff")
	public Map<String, String> loginStaff(@RequestBody MedicalstaffDto dto) {
		return medicalstaffService.loginStaff(dto);
	}
	
	@GetMapping("/findall")
	public List<MedicalstaffDto> findAll() {
		return medicalstaffService.findAll();
	}
	
	@PostMapping("/findbyid/{stafCode}")
	public MedicalstaffDto findById(@PathVariable String stafCode) {
		return medicalstaffService.findById(stafCode);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestBody MedicalstaffDto dto) {
		boolean result = medicalstaffService.deleteById(dto.getStafCode());
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		}
	}
	
	@PostMapping("createandupdate")
	public ResponseEntity<String> createAndUpdate(@RequestBody MedicalstaffDto dto) {
		boolean result = medicalstaffService.createAndUpdate(dto);
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		}
	}
	
}
