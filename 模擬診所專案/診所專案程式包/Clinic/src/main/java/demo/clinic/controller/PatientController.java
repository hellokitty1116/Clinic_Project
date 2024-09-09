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

import demo.clinic.model.PatientDto;
import demo.clinic.service.PatientService;

@CrossOrigin("*")
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/create")
	public ResponseEntity<String> createPatient(@RequestBody PatientDto pat) {
		boolean result = patientService.createPatient(pat);
		if(result) {
			return new ResponseEntity<>("註冊成功!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("失敗!已經註冊過了", HttpStatus.OK);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginPatient(@RequestBody PatientDto pat) {
		Map<String, String> result = patientService.loginPatient(pat.getPatId(), pat.getPatPhone());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping
	public List<PatientDto> findAll() {
		return patientService.findAll();
	}
	
	@PostMapping("/selectbyid/{patId}")
	public ResponseEntity<PatientDto> findById(@PathVariable String patId) {
		PatientDto result = patientService.findById(patId);
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestBody PatientDto pat) {
		boolean result = patientService.deleteById(pat.getPatId());
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		}
	}
	
	@PostMapping("/createandupdate")
	public ResponseEntity<String> createAndUpdate(@RequestBody PatientDto pat) {
		boolean result = patientService.createAndUpdate(pat);
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		}
	}
	
}
