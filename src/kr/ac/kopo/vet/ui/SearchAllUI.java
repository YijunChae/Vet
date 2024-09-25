package kr.ac.kopo.vet.ui;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.member.vo.UserVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String dataFormat1 = "%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n";
		List<UserVO> list = service.searchAllUsers();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(dataFormat1, "관리번호", "아이디", "동물이름", "품종", "성별", "나이", "보호자명", "보호자 연락처");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		if(list.isEmpty()) {
			System.out.println("\t회원가입한 고객이 없습니다!");
		} else {
			String dataFormat2 = "%-15d %-15s %-15s %-15s %-15s %-15d %-15s %-15s%n";
			for(UserVO user : list) {
				System.out.printf(dataFormat2, user.getNo(), user.getId(), user.getName(), user.getBreed(), 
						user.getGender(), user.getAge(), user.getProtector(), user.getPhone());
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
	}

}
