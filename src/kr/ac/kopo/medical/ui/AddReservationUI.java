package kr.ac.kopo.medical.ui;

import kr.ac.kopo.medical.vo.TreatmentScheduleVO;

public class AddReservationUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("<\t 진료예약 페이지 \t>");
	    String animalId = scanStr("회원아이디를 입력해주세요: "); 			
	    String animalName = scanStr("반려동물의 이름을 입력해주세요: "); 			
	    String demand = scanStr("진료를 희망하는 항목을 입력해주세요: ");				
	    String vetName = scanStr("진료받을 수의사님의 이름을 입력해주세요: ");	
	    System.out.println("진료는 평일 08:00~19:00, 30분 단위로 진행됩니다.");
	    String scheduleDate = scanStr("진료를 희망하는 날짜를 입력해주세요(yyyy-mm-dd hh24:mi:ss): "); 		

	    TreatmentScheduleVO ts = new TreatmentScheduleVO(animalId, animalName, demand, vetName, scheduleDate);
	    String result = service.addSchedule(ts);
	    
	    System.out.println(result);
	}

}
