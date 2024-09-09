package demo.clinic.service.impl;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.clinic.dao.AppointmentDao;
import demo.clinic.dao.AppointmentviewDao;
import demo.clinic.dao.PatientDao;
import demo.clinic.model.Appointment;
import demo.clinic.model.AppointmentChange;
import demo.clinic.model.AppointmentDto;
import demo.clinic.model.Patient;
import demo.clinic.model.view.Appointmentview;
import demo.clinic.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private AppointmentviewDao appointmentviewDao;
	
	@Autowired
	private PatientDao patientDao;
	
	
	public static String getNumber() {
		long randomNumber = (long) (1000000000L + Math.random() * 9000000000L);
		String apCode = Long.toString(randomNumber);
		return apCode;
	}

	@Override
	public boolean addAppointment(AppointmentDto dto) {
		Patient p = patientDao.findById(dto.getPatient()).orElse(null);
		if(p != null) {
			String apCode = "";
			
			do {
				apCode = getNumber();
				Appointment data = appointmentDao.findById(apCode).orElse(null);
				if(data == null) {break;}
			} while(true);
			
			Appointment ap = AppointmentChange.mapToAppointment(dto);
			ap.setApCode(apCode);
			ap.setStatus("ap");
			appointmentDao.save(ap);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByCode(String apCode) {
		try {
			appointmentDao.deleteById(apCode);
			return true;
		} catch (Exception e) {
			System.out.println("deleteByCode Error: " + e.getMessage());
			return false;
		}
	}

	@Override
	public List<Appointmentview> findByPatIdAndStatus(String patId, String status) {
		List<Appointmentview> data = appointmentviewDao.findByPatIdAndStatusOrderByApDateDesc(patId, status);
		if(data.size() > 0) {
			return data;
		} else {
			return null;
		}
	}

	@Override
	public List<Appointmentview> findByPatIdAndStatusNot(String patId, String status) {
		List<Appointmentview> data = appointmentviewDao.findByPatIdAndStatusNotOrderByStatusDesc(patId, status);
		if(data.size() > 0) {
			return data;
		} else {
			return null;
		}
	}

	@Override
	public List<Appointmentview> findByStafNameAndStatus(String stafName, String status) {
		List<Appointmentview> data = appointmentviewDao.findByStafNameAndStatusOrderByApDateDesc(stafName, status);
		if(data.size() > 0) {
			return data;
		} else {
			return null;
		}
	}

	@Override
	public List<Appointmentview> findByStafNameAndStatusNot(String stafName, String status) {
		List<Appointmentview> data = appointmentviewDao.findByStafNameAndStatusNotOrderByApDateDesc(stafName, status);
		if(data.size() > 0) {
			return data;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateStatus(String apCode) {
		Appointment appointment = appointmentDao.findById(apCode).orElse(null);
		if(appointment != null) {
			Date today = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(today);
			appointment.setStatus(formattedDate);
			appointmentDao.save(appointment);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Appointmentview> findByApDateAndPatId(String patId, Integer pageNo, Integer pageSize, String sortBy) {
	    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
	    
	    // 取得當前月份的第一天和最後一天
	    YearMonth currentMonth = YearMonth.now();
	    LocalDate startDate = currentMonth.atDay(1);
	    LocalDate endDate = currentMonth.atEndOfMonth();
	    
	    // 呼叫使用 LocalDate 的 DAO 方法
	    Page<Appointmentview> pagedResult = appointmentviewDao.findByApDateBetweenAndPatId(startDate, endDate, patId, paging);
	    
	    if (pagedResult.hasContent()) {
	        return pagedResult.getContent();
	    } else {
	        return new ArrayList<Appointmentview>();
	    }
	}
	
	
}
