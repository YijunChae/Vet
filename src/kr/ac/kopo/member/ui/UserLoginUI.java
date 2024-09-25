package kr.ac.kopo.member.ui;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.UserVO;
import kr.ac.kopo.vet.ui.VetUserUI;

public class UserLoginUI extends BaseUI {
	
	@Override
	public void execute() throws Exception {
		
		int chance = 0;
		
		while(chance < 6) {
			if(chance == 5) {
				System.out.println("로그인을 5회 실패했습니다. 개인정보보호법을 준수합시다.");
				IMemberUI ui = new ExitUI();
				ui.execute();
			}
			System.out.println("-----------------------------------");
			System.out.println("\t < USER 로그인 > \t");
			System.out.println("-----------------------------------");
			
			String id = scanStr("아이디를 입력해주세요: ");
			String pw = scanStr("비밀번호를 입력해주세요: ");
			
			UserVO user = new UserVO();
			
			if(!MemberDAO.isUser && !MemberDAO.isAdmin) {			
				user = service.accessUser(id, pw);
			} else {
				System.out.println("다른 사용자가 접속 중입니다. 잠시 후 다시 시도해주세요.");
			}
			
			if(MemberDAO.isUser) {
				System.out.println('[' + user.getName() + "] 보호자 " + '[' + user.getProtector() + "] 님 환영합니다!");
				break;
			} else {
				chance++;
				System.out.println("로그인 실패! 아이디와 비밀번호를 다시 확인해주세요");
				System.out.println(5-chance + "회 남았습니다.");
			}
		}
		
		if(MemberDAO.isUser) {			
			VetUserUI ui = new VetUserUI();
			ui.execute();
		}
		

	}

}
