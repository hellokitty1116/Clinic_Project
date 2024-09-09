package demo.clinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.clinic.model.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, String>{
	
}
