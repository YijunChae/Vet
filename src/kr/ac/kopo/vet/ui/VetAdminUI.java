package kr.ac.kopo.vet.ui;

public class VetAdminUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println();
			String choice = prnMenu();
			IVetUI ui = null;
			switch(choice) {
			case "1" :
				ui = new MyTreatmentUI();
				break;
			case "2" :
				ui = new SearchOneUI();
				break;
			case "3" :
				ui = new SearchAllUI();
				break;
			case "4" :
				ui = new LogoutUI();
				break;
			case "0" :
				ui = new ExitUI();
			}    // switch
			
			if(ui != null) {
				ui.execute();
			}
			else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요");
			}
		}    // end of while
		
	}    // end of execute()
	
	private String prnMenu() {
		System.out.println("-----------------------------------");
		System.out.println("1. 진료관리");
		System.out.println("2. 회원아이디로 조회");
		System.out.println("3. 모든 회원 조회");
		System.out.println("4. 로그아웃");
		System.out.println("0. 종료");
		System.out.println("-----------------------------------");
		return scanStr("원하시는 메뉴를 선택해주세요: ");
	}

}
