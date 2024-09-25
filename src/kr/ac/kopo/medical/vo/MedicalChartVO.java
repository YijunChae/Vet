package kr.ac.kopo.medical.vo;

import java.util.List;

public class MedicalChartVO {
	
	// 1. 멤버변수(8)
    private String chartId;			// 차트 아이디(PK)
    private String animalId; 		// 동물 아이디(FK)
    private String animalName;		// 동물 이름
    private String vetId;			// 수의사 아이디(FK)
    private String vetName;			// 수의사 이름
    private String treatDate; 		// 진료일자
    private String diagnosis; 		// 진단
    private String treatment; 		// 처치
    
    
    // 2. 기본 생성자
	public MedicalChartVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	// 3-1. 모든 멤버변수를 매개변수로 가지는 생성자
	public MedicalChartVO(String chartId, String animalId, String animalName, String vetId, String vetName,
			String treatDate, String diagnosis, String treatment) {
		super();
		this.chartId = chartId;
		this.animalId = animalId;
		this.animalName = animalName;
		this.vetId = vetId;
		this.vetName = vetName;
		this.treatDate = treatDate;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}

    
	// 3-2. 수의사의 작성이 필요한 멤버변수만을 매개변수로 가지는 생성자
	public MedicalChartVO(String animalId, String animalName, String vetId, String vetName, String treatDate,
			String diagnosis, String treatment) {
		super();
		this.animalId = animalId;
		this.animalName = animalName;
		this.vetId = vetId;
		this.vetName = vetName;
		this.treatDate = treatDate;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}

	
	// 4. Getter/Setter
	public String getChartId() {
		return chartId;
	}


	public void setChartId(String chartId) {
		this.chartId = chartId;
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


	public String getTreatDate() {
		return treatDate;
	}


	public void setTreatDate(String treatDate) {
		this.treatDate = treatDate;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public String getTreatment() {
		return treatment;
	}


	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}


	// 5. toString() 오버라이드
	@Override
	public String toString() {
		return "MedicalChartVO [chartId=" + chartId + ", animalId=" + animalId + ", animalName=" + animalName
				+ ", vetId=" + vetId + ", vetName=" + vetName + ", treatDate=" + treatDate + ", diagnosis=" + diagnosis
				+ ", treatment=" + treatment + "]";
	}
	
	
	
	
	
	
	
	
	
	
    


}
