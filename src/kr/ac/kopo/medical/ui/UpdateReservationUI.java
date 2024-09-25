package kr.ac.kopo.medical.ui;

import kr.ac.kopo.medical.vo.TreatmentScheduleVO;

public class UpdateReservationUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		String scheduleId = scanStr("일정변경을 희망하는 예약번호를 입력해주세요: ");
		String scheduleDate = scanStr("변경을 희망하는 날짜를 입력해주세요: ");
		
		TreatmentScheduleVO ts = new TreatmentScheduleVO();
		ts.setScheduleId(scheduleId);
		ts.setScheduleDate(scheduleDate);
		
		service.modifySchedule(ts);
		
		System.out.println("예약일정 변경신청을 완료했습니다.");

	}

}
