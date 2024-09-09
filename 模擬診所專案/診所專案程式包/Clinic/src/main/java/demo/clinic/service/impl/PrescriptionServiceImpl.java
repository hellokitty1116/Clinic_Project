package demo.clinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.clinic.dao.MedicinelogviewDao;
import demo.clinic.dao.PrescriptionDao;
import demo.clinic.model.Prescription;
import demo.clinic.model.PrescriptionChange;
import demo.clinic.model.PrescriptionDto;
import demo.clinic.model.view.Medicinelogview;
import demo.clinic.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Autowired
	private MedicinelogviewDao medicinelogviewDao;
	
	@Autowired
	private PrescriptionDao prescriptionDao;
	
	
	public static String getNumber() {
		long randomNumber = (long) (1000000000L + Math.random() * 9000000000L);
		String preCode = Long.toString(randomNumber);
		return preCode;
	}
	
	
	@Override
	public List<Medicinelogview> findByAppointmentCode(String appointmentCode) {
		return medicinelogviewDao.findByAppointmentCode(appointmentCode);
	}

	@Override
	public PrescriptionDto createPre(PrescriptionDto p) {
		String preCode = "";
		do {
			preCode = getNumber();
			Prescription data = prescriptionDao.findById(preCode).orElse(null);
			if(data == null) {break;}
		} while(true);
		
		try {
			p.setPreCode(preCode);
			Prescription pre = prescriptionDao.save(PrescriptionChange.mapToPrescription(p));
			return PrescriptionChange.mapToDto(pre);
		} catch (Exception e) {
			System.out.println("createPre ERROR: " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteById(String preCode) {
		try {
			prescriptionDao.deleteById(preCode);
			return true;
		} catch (Exception e) {
			System.out.println("deleteById ERROR: " + e.getMessage());
			return false;
		}
	}

	
}
