package kr.ac.kopo.medical.ui;

public class CancelReservationUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		String scheduleId = scanStr("취소할 예약번호를 입력해주세요: ");
		
		service.cancelReservation(scheduleId);
		
		System.out.println("예약이 취소되었습니다!");

	}

}
