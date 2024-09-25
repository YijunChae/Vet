package kr.ac.kopo.member.ui;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.AdminVO;
import kr.ac.kopo.member.vo.UserVO;
import kr.ac.kopo.vet.ui.VetAdminUI;
import kr.ac.kopo.vet.ui.VetUserUI;

public class AdminLoginUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		int chance = 0;
		
		while(chance < 4) {
			if(chance == 3) {
				System.out.println("로그인을 3회 실패했습니다. 관리자 권한을 넘보지 마세요.");
				IMemberUI ui = new ExitUI();
				ui.execute();
			}
			System.out.println("-----------------------------------");
			System.out.println("\t < ADMIN 로그인 > \t");
			System.out.println("-----------------------------------");
			
			String id = scanStr("아이디를 입력해주세요: ");
			String pw = scanStr("비밀번호를 입력해주세요: ");
			
			AdminVO admin = new AdminVO();
			
			if(!MemberDAO.isAdmin && !MemberDAO.isUser) {			
				admin = service.accessAdmin(id, pw);
			} else {
				System.out.println("다른 관리자가 접속 중입니다. 잠시 후 다시 시도해주세요.");
			}
			
			if(MemberDAO.isAdmin) {
				System.out.println('[' + admin.getVet() + "]" + '(' + admin.getGrade() + ") 님 어서 일합시다!");
				break;
			} else {
				chance++;
				System.out.println("로그인 실패! 아이디와 비밀번호를 다시 확인해주세요");
				System.out.println(3-chance + "회 남았습니다.");
			}
		}
		
		if(MemberDAO.isAdmin) {			
			VetAdminUI ui = new VetAdminUI();
			ui.execute();
		}
		

	}

}
