package kr.ac.kopo.vet.ui;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.ui.MemberUI;

public class LogoutUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		MemberUI ui = new MemberUI();
		
		if(MemberDAO.isUser) {
			MemberDAO.isUser = false;
		} else if(MemberDAO.isAdmin) {
			MemberDAO.isAdmin = false;
		}
		
		System.out.println("안전하게 로그아웃되었습니다.");
		ui.execute();

	}

}
