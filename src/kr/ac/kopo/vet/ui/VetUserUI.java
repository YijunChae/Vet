package kr.ac.kopo.vet.ui;

import kr.ac.kopo.member.dao.MemberDAO;

public class VetUserUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println();
			String choice = prnMenu();
			IVetUI ui = null;
			switch(choice) {
			case "1" :
				ui = new MyClinicUI();
				break;
			case "2" :
				ui = new InfoUI();
				break;
			case "3" :
				ui = new ModifyPwUI();
				break;
			case "4" :
				ui = new WithdrawUI();
				break;
			case "5" :
				ui = new LogoutUI();
				break;
			case "0" :
				ui = new ExitUI();
			}    // end of switch_statement
			
			if(ui != null) {
				ui.execute();
			}
			else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요");
			}
		}    // end of while
		
	}    // end of execute()
	
	private String prnMenu() {
		System.out.println(MemberDAO.userId + "님 안녕하세요");
		System.out.println("-----------------------------------");
		System.out.println("1. 진료서비스");
		System.out.println("2. 개인정보 조회");
		System.out.println("3. 패스워드 수정");
		System.out.println("4. 회원탈퇴");
		System.out.println("5. 로그아웃");
		System.out.println("0. 종료");
		System.out.println("-----------------------------------");
		return scanStr("원하시는 메뉴를 선택해주세요: ");
	}

}
