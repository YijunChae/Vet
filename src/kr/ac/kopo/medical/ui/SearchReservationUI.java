package kr.ac.kopo.medical.ui;

import java.util.List;

import kr.ac.kopo.medical.vo.TreatmentScheduleVO;
import kr.ac.kopo.member.dao.MemberDAO;

public class SearchReservationUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		String userId = MemberDAO.userId;
		
		List<TreatmentScheduleVO> list = service.enquireSchedule(userId);
		
		// 문자열 포맷
		String leftAlignFormat = "| %-10s | %-20s | %-20s | %-20s | %-10s | %-20s | %-10s |%n";
		String reservationStatus = "승인대기";
		
		System.out.println("*------------*----------------------*----------------------*------------------------*------------*----------------------*-------------*");
		System.out.println("*    예약번호   *         동물 아이디     *          동물 이름      *          진료희망항목      *  수의사 이름  *       예약일자          *   예약상태    *");
		System.out.println("*------------*----------------------*----------------------*------------------------*------------*----------------------*-------------*");
		if(list.isEmpty()) {
			System.out.println("\t진료내역이 없습니다!");
		} else {
			for (TreatmentScheduleVO ts : list) {
				System.out.format(leftAlignFormat, ts.getScheduleId(), ts.getAnimalId(), ts.getAnimalName(), ts.getDemand(), ts.getVetName(), ts.getScheduleDate(), reservationStatus);
			}			
		}
		System.out.println("*------------*----------------------*----------------------*------------------------*------------*----------------------*--------------*");

	}

}
