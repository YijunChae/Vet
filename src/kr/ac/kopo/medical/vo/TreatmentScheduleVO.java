package kr.ac.kopo.medical.vo;

public class TreatmentScheduleVO {

	// 1. 멤버변수
    private String scheduleId; 			// 1. 스케줄 아이디(PK)
    private String animalId; 			// 2. 동물 아이디(FK)
    private String animalName; 			// 3. 동물 이름
    private String demand;				// 4. 진료 희망 항목
    private String vetId;	 			// 5. 수의사 아이디(FK)
    private String vetName;				// 6. 수의사 이름
    private String scheduleDate; 		// 7. 예약일자
    private String reservationStatus; 	// 8. 예약상태
    
	

    
    // 2. 기본생성자
    public TreatmentScheduleVO() {
		super();
		// TODO Auto-generated constructor stub
	}

    // 3-1. 모든 매개변수를 가지는 생성자
	public TreatmentScheduleVO(String scheduleId, String animalId, String animalName, String demand, String vetId,
			String vetName, String scheduleDate, String reservationStatus) {
		super();
		this.scheduleId = scheduleId;
		this.animalId = animalId;
		this.animalName = animalName;
		this.demand = demand;
		this.vetId = vetId;
		this.vetName = vetName;
		this.scheduleDate = scheduleDate;
		this.reservationStatus = reservationStatus;
	}

	
	// 3-2. 사용자 입력이 필요한 매개변수만을 가지는 생성자
	public TreatmentScheduleVO(String animalId, String animalName, String demand, String vetName, String scheduleDate) {
		super();
		this.animalId = animalId;
		this.animalName = animalName;
		this.demand = demand;
		this.vetName = vetName;
		this.scheduleDate = scheduleDate;
	}

	
	// 4. Getter/Setter
	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public String getVetId() {
		return vetId;
	}

	public void setVetId(String vetId) {
		this.vetId = vetId;
	}

	public String getVetName() {
		return vetName;
	}

	public void setVetName(String vetName) {
		this.vetName = vetName;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	// 5. toString() 오버라이드
	@Override
	public String toString() {
		return "TreatmentScheduleVO [scheduleId=" + scheduleId + ", animalId=" + animalId + ", animalName=" + animalName
				+ ", demand=" + demand + ", vetId=" + vetId + ", vetName=" + vetName + ", scheduleDate=" + scheduleDate
				+ ", reservationStatus=" + reservationStatus + "]";
	}
    
}
