package demo.clinic.model;

public class MedicineChange {

	public static MedicineDto mapToDto(Medicine m) {
		MedicineDto dto = new MedicineDto();
		dto.setMedId(m.getMedId());
		dto.setMedName(m.getMedName());
		dto.setMedType(m.getMedType());
		dto.setIndications(m.getIndications());
		dto.setQuantity(m.getQuantity());
		return dto;
	}
	
	
	public static Medicine mapToMedicine(MedicineDto dto) {
		Medicine m = new Medicine();
		m.setMedId(dto.getMedId());
		m.setMedName(dto.getMedName());
		m.setMedType(dto.getMedType());
		m.setIndications(dto.getIndications());
		m.setQuantity(dto.getQuantity());
		return m;
	}
}
