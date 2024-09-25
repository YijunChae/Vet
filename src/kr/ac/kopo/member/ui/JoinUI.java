package kr.ac.kopo.member.ui;

import kr.ac.kopo.member.vo.UserVO;

public class JoinUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("<\t 회원가입 페이지 \t>");
		int no = 0;
		String id = scanStr("아이디를 입력해주세요: ");
		String pw = scanStr("비밀번호를 입력해주세요: ");
		String name = scanStr("반려동물명을 입력해주세요: ");
		String breed = scanStr("품종을 입력해주세요[예) 개(셰퍼드)]: ");
		String gender = scanStr("성별을 입력해주세요[M/F]: ");
		int age = scanInt("나이를 입력해주세요[숫자만]: ");
		String protector = scanStr("보호자명을 입력해주세요: ");
		String phone = scanStr("보호자 연락처를 입력해주세요[-포함]: ");
		
		UserVO user = new UserVO(no, id, pw, name, breed, gender, age, protector, phone);
		service.addUser(user);
		
		System.out.println("회원가입이 완료되었습니다.");
	}

}
