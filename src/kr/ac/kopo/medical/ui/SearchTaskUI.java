package kr.ac.kopo.medical.ui;

import java.util.List;

import kr.ac.kopo.medical.vo.TreatmentScheduleVO;

public class SearchTaskUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		String vetName = scanStr("수의사님의 성함을 입력해주세요: ");
		
		List<TreatmentScheduleVO> list = service.enquireTask(vetName);
		
		// 화면 출력
		String leftAlignFormat = "| %-10s | %-20s | %-20s | %-30s | %-20s | %-10s | %-20s | %-10s |%n";
		
		System.out.println("*------------*----------------------*----------------------*--------------------------------*----------------------*------------*----------------------*------------*");
		System.out.println("*    예약번호   *         동물 아이디     *          동물 이름      *             진료희망항목           *      수의사 아이디       *  수의사 이름  *       예약일자          *    예약상태   *");
		System.out.println("*------------*----------------------*----------------------*--------------------------------*----------------------*------------*----------------------*------------*");
		if(list.isEmpty()) {
			System.out.println("\t진료일정이 없습니다!");
		} else {
			for (TreatmentScheduleVO ts : list) {
				System.out.format(leftAlignFormat, ts.getScheduleId(), ts.getAnimalId(), ts.getAnimalName(), ts.getDemand(), ts.getVetId(), ts.getVetName(), ts.getScheduleDate(), ts.getReservationStatus());
			}			
		}
		System.out.println("*------------*----------------------*----------------------*--------------------------------*----------------------*------------*----------------------*------------*");		
	}

}
