package demo.clinic.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.clinic.model.AppointmentDto;
import demo.clinic.model.view.Appointmentview;
import demo.clinic.service.AppointmentService;


@CrossOrigin("*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addAppointment(@RequestBody AppointmentDto dto) {
		boolean result = appointmentService.addAppointment(dto);
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.OK);
		}
	}
	
	@PostMapping("/getbyid")
	public ResponseEntity<List<Appointmentview>> findByPatName(@RequestBody Appointmentview app) {
		List<Appointmentview> data = appointmentService.findByPatIdAndStatus(app.getPatId(), "ap");
		if(data == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}
	
	@PostMapping("/getbyid2")
	public ResponseEntity<List<Appointmentview>> findByPatName2(@RequestBody Appointmentview app) {
		List<Appointmentview> data = appointmentService.findByPatIdAndStatusNot(app.getPatId(), "ap");
		if(data == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAppointment(@RequestBody Appointmentview code) {
		boolean result = appointmentService.deleteByCode(code.getApCode());
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.OK);
		}
	}
	
	@PostMapping("/getbystafName")
	public ResponseEntity<List<Appointmentview>> findBystafName(@RequestBody Appointmentview app) {
		List<Appointmentview> data = appointmentService.findByStafNameAndStatus(app.getStafName(), "ap");
		if(data == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}
	
	@PostMapping("/getbystafName2")
	public ResponseEntity<List<Appointmentview>> findBystafName2(@RequestBody Appointmentview app) {
		List<Appointmentview> data = appointmentService.findByStafNameAndStatusNot(app.getStafName(), "ap");
		if(data == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}
	
	@PostMapping("/updatestatus")
	public ResponseEntity<String> updateStatus(@RequestBody AppointmentDto dto) {
		boolean result = appointmentService.updateStatus(dto.getApCode());
		if(result) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("error", HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping(value = "/aphistory/{patid}")
	public List<Appointmentview> findAppointmentsByPatIdAndDate(
	        @PathVariable("patid") String patid,
	        @RequestParam(defaultValue = "0") Integer pageNo,
	        @RequestParam(defaultValue = "5") Integer pageSize,
	        @RequestParam(defaultValue = "apDate") String sortBy) {
	    
	    List<Appointmentview> list = appointmentService.findByApDateAndPatId(patid, pageNo, pageSize, sortBy);
	    
	    if (!list.isEmpty()) {
	        return list;
	    } else {
	        return new ArrayList<>(); // 返回一個空的列表而不是 null
	    }
	}
}
