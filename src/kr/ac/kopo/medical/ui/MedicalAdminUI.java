package kr.ac.kopo.medical.ui;

import kr.ac.kopo.member.dao.MemberDAO;

public class MedicalAdminUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println();
			String choice = prnMenu();
			IMedicalUI ui = null;
			switch(choice) {
			case "1" :
				ui = new SearchScheduleUI();
				break;
			case "2" :
				ui = new SearchTaskUI();
				break;
			case "3" :
				ui = new ManageScheduleUI();
				break;
			case "4" :
				ui = new AddChartUI();
				break;
			case "5" :
				ui = new SearchAllChartUI();
				break;
			case "6" :
				ui = new SearchEachChartUI();
				break;
			case "7" :
				ui = new UpdateChartUI();
				break;
			case "8" :
				ui = new DeleteChartUI();
				break;
			case "9" :
				ui = new PrevUI();
				break;
			case "0" :
				ui = new ExitUI();
			}	// end of switch
			
			if(ui != null) {
				ui.execute();
			}
			else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요");
			}
		}	// end of while

	}	// end of execute()
	
	private String prnMenu() {
		System.out.println(MemberDAO.adminName + " 선생님, 오늘도 힘내세요!");
		System.out.println("-----------------------------------");
		System.out.println("1. 진료일정 전체 조회");
		System.out.println("2. 수의사별 진료일정 조회");
		System.out.println("3. 진료일정 관리");
		System.out.println("4. 진료차트 작성");
		System.out.println("5. 진료차트 조회");
		System.out.println("6. 진료차트 아이디로 조회");
		System.out.println("7. 진료차트 수정");
		System.out.println("8. 진료차트 삭제");
		System.out.println("9. 이전 페이지로 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------------------------");
		return scanStr("원하시는 메뉴를 선택해주세요: ");
	}

}
