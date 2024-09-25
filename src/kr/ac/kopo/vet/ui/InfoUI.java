package kr.ac.kopo.vet.ui;

import java.util.List;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.ui.UserLoginUI;
import kr.ac.kopo.member.vo.UserVO;

public class InfoUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String id = MemberDAO.userId;
		
		UserVO user = service.searchMyInfo(id);
		
		System.out.println("\t< 개인정보 조회>\t");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		String dataFormat1 = "%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n";
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(dataFormat1, "관리번호", "아이디", "패스워드", "동물이름", "품종", "성별", "나이", "보호자명", "보호자 연락처");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		String dataFormat2 = "%-15d %-15s %-15s %-15s %-15s %-15s %-15d %-15s %-15s%n";
		System.out.printf(dataFormat2, user.getNo(), user.getId(), user.getPw(), user.getName(), user.getBreed(), 
						user.getGender(), user.getAge(), user.getProtector(), user.getPhone());
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
	}

}
