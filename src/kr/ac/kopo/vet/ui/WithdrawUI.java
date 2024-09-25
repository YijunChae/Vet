package kr.ac.kopo.vet.ui;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.UserVO;

public class WithdrawUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String id = MemberDAO.userId;
		String pw = scanStr("회원확인을 위해 패스워드를 입력해주세요: ");
		
		// 비밀번호를 제대로 입력했는지 확인하는 절차
		UserVO user = new UserVO();
		user.setId(id);
		user.setPw(pw);
		boolean isTrue = service.verifyInfo(user);
		
		// 탈퇴절차 개시
		if(isTrue) {
			service.deleteInfo(id);
		}
		
		System.out.println("회원탈퇴가 정상적으로 처리되었습니다. 성원에 감사드립니다.");
		LogoutUI ui = new LogoutUI();
		ui.execute();
	}

}
