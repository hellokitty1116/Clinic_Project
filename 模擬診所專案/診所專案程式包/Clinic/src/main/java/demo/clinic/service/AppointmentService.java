package demo.clinic.service;

import java.util.List;

import demo.clinic.model.AppointmentDto;
import demo.clinic.model.view.Appointmentview;

public interface AppointmentService {

	boolean addAppointment(AppointmentDto dto);
	List<Appointmentview> findByPatIdAndStatus(String patId, String status);
	List<Appointmentview> findByPatIdAndStatusNot(String patId, String status);
	boolean deleteByCode(String apCode);
	List<Appointmentview> findByStafNameAndStatus(String stafName, String status);
	List<Appointmentview> findByStafNameAndStatusNot(String stafName, String status);
	boolean updateStatus(String apCode);
	List<Appointmentview> findByApDateAndPatId(String patId,Integer pageNo,Integer pageSize,String sortBy);

}
