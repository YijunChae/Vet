package kr.ac.kopo.member.ui;

public class MemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println();
			String choice = prnMenu();
			IMemberUI ui = null;
			switch(choice) {
			case "1" :
				ui = new UserLoginUI();
				break;
			case "2" :
				ui = new AdminLoginUI();
				break;
			case "3" :
				ui = new JoinUI();
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
		} // while
		
	} // execute()
	
	private String prnMenu() {
		System.out.println("환영합니다. 서비스 이용을 위해 로그인 해주세요.");
		System.out.println("-----------------------------------");
		System.out.println("1. USER 로그인");
		System.out.println("2. ADMIN 로그인");
		System.out.println("3. 회원가입");
		System.out.println("0. 종료");
		System.out.println("-----------------------------------");
		return scanStr("원하시는 메뉴를 선택해주세요 : ");
	}

}
