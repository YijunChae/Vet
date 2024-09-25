package kr.ac.kopo.vet.ui;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.UserVO;

public class ModifyPwUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String id = MemberDAO.userId;
		String prePw = scanStr("현재 사용 중인 비밀번호를 입력해주세요: ");
		String newPw;
		
		while(true) {
			newPw = scanStr("변경하실 비밀번호를 입력해주세요: ");
			String valPw = scanStr("다시 한 번 입력해주세요: ");
			if(newPw.equals(valPw)) {
				break;
			}
		}
		
		UserVO user = new UserVO();
		user.setId(id);
		user.setPw(newPw);
		
		service.modifyPw(user);
		
		System.out.println("비밀번호 수정이 완료되었습니다");

	}

}
