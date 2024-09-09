package demo.clinic.controller;

import java.util.List;

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

import demo.clinic.model.MedicineDto;
import demo.clinic.service.MedicineService;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	
	@PostMapping("/select/{info}")
	public ResponseEntity<MedicineDto> findByIdOrName(@PathVariable("info") String info) {
		MedicineDto medicineDto =  medicineService.findByMedIdOrMedName(info);
		if(medicineDto == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(medicineDto, HttpStatus.OK);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<MedicineDto>> findAll() {
		List<MedicineDto> medicineDtos = medicineService.findAll();
		if(medicineDtos == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(medicineDtos, HttpStatus.OK);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestBody MedicineDto dto) {
		boolean result = medicineService.deleteById(dto.getMedId());
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.OK);
		}
	}
	
	@PostMapping("/createandupdate")
	public ResponseEntity<MedicineDto> createAndUpdate(@RequestBody MedicineDto dto) {
		MedicineDto result = medicineService.createAndUpdate(dto);
		if(result == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	
}
