package kr.ac.kopo.medical.ui;

import kr.ac.kopo.member.dao.MemberDAO;

public class MedicalUserUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println();
			String choice = prnMenu();
			IMedicalUI ui = null;
			switch(choice) {
			case "1" :
				ui = new AddReservationUI();
				break;
			case "2" :
				ui = new SearchReservationUI(); 
				break;
			case "3" :
				ui = new UpdateReservationUI();
				break;
			case "4" :
				ui = new CancelReservationUI();
				break;
			case "5" :
				ui = new SearchMyChartUI();
				break;
			case "6" :
				ui = new PrevUI();
			case "0" :
				ui = new ExitUI();
			}	// end of switch_statement
			
			if(ui != null) {
				ui.execute();
			}
			else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요");
			}
		}	// end of while

	}	// end of execute()
	
	private String prnMenu() {
		System.out.println(MemberDAO.userId + "님, 친절히 모시겠습니다.");
		System.out.println("-----------------------------------");
		System.out.println("1. 진료예약");
		System.out.println("2. 진료예약 조회");
		System.out.println("3. 진료일정 변경");
		System.out.println("4. 진료예약 취소");
		System.out.println("5. 진료내역 조회");
		System.out.println("6. 이전 페이지로 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------------------------");
		return scanStr("원하시는 진료서비스를 선택해주세요: ");
	}

}
