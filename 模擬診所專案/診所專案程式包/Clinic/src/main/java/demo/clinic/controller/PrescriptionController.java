package demo.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.clinic.model.PrescriptionDto;
import demo.clinic.model.view.Medicinelogview;
import demo.clinic.service.PrescriptionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	
	@PostMapping
	public List<Medicinelogview> findByAppointmentCode(@RequestBody Medicinelogview mlv) {
		return prescriptionService.findByAppointmentCode(mlv.getAppointmentCode());
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createPre(@RequestBody PrescriptionDto pre) {
		PrescriptionDto result = prescriptionService.createPre(pre);
		if(result == null) {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletePre(@RequestBody PrescriptionDto pre) {
		boolean result = prescriptionService.deleteById(pre.getPreCode());
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		}
	}
	
}
