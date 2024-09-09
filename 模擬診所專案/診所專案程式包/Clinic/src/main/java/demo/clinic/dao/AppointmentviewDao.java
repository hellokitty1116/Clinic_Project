package demo.clinic.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import demo.clinic.model.view.Appointmentview;


public interface AppointmentviewDao extends JpaRepository<Appointmentview, String> {
	
	List<Appointmentview> findByPatIdAndStatusOrderByApDateDesc(String patId, String status);
	List<Appointmentview> findByPatIdAndStatusNotOrderByStatusDesc(String patId, String status);
	List<Appointmentview> findByStafNameAndStatusOrderByApDateDesc(String stafName, String status);
	List<Appointmentview> findByStafNameAndStatusNotOrderByApDateDesc(String stafName, String status);
	@Query("SELECT a FROM Appointmentview a WHERE a.apDate BETWEEN :startDate AND :endDate AND a.patId = :patId")
	Page<Appointmentview> findByApDateBetweenAndPatId(@Param("startDate") LocalDate startDate,
	                                                  @Param("endDate") LocalDate endDate,
	                                                  @Param("patId") String patId, 
	                                                  Pageable pageable);

}
