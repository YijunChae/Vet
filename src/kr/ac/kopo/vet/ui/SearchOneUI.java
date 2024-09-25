package kr.ac.kopo.vet.ui;

import kr.ac.kopo.member.vo.UserVO;

public class SearchOneUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String id = scanStr("검색하실 회원 아이디를 입력해주세요: ");
		
		UserVO user = service.searchUserByID(id);
		
		if(user != null) {
			String dataFormat1 = "%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n";
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf(dataFormat1, "관리번호", "아이디", "동물이름", "품종", "성별", "나이", "보호자명", "보호자 연락처");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			String dataFormat2 = "%-15d %-15s %-15s %-15s %-15s %-15d %-15s %-15s%n";
			System.out.printf(dataFormat2, user.getNo(), user.getId(), user.getName(), user.getBreed(), 
					user.getGender(), user.getAge(), user.getProtector(), user.getPhone());
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("회원 아이디[" + id + "]\t 와 일치하는 회원이 없습니다!");			
		}
	}
}
