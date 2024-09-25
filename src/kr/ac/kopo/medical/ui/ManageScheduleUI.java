package kr.ac.kopo.medical.ui;

import kr.ac.kopo.medical.vo.TreatmentScheduleVO;

public class ManageScheduleUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		String scheduleId = scanStr("관리할 예약번호를 입력해주세요: ");
		System.out.println("예약 관리 위한 정보를 입력해주세요!");
		System.out.println("-------------------------------------");
		String vetId = scanStr("선생님의 아이디를 입력해주세요: ");
		String reservationStatus = scanStr("예약승인여부를 입력해주세요[승인/반려/보류]: ");
		System.out.println("-------------------------------------");
		
		TreatmentScheduleVO ts = new TreatmentScheduleVO();
		ts.setScheduleId(scheduleId);
		ts.setVetId(vetId);
		ts.setReservationStatus(reservationStatus);
		
		service.approveSchedule(ts);
		
		System.out.println("처리완료되었습니다!");

	}

}
