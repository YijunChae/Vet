package kr.ac.kopo.vet.service;

import java.util.List;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.UserVO;
import kr.ac.kopo.vet.dao.VetDAO;

public class VetService {
	
	private VetDAO dao;
	
	public VetService() {
		dao = new VetDAO();
	}
	
	/**
	 * VetUser
	 */
	// 개인정보 조회
	public UserVO searchMyInfo(String id) {
		UserVO user = dao.selectMyInfo(id);
		return user;
	}
	
	
	// 비밀번호 수정
	public void modifyPw(UserVO user) {
		dao.updatePw(user);
	}
	
	

	
	// 본인확인
	public boolean verifyInfo(UserVO user) {
		boolean isTrue = dao.verify(user);
		return isTrue;
	}

	
	// 회원탈퇴
	public void deleteInfo(String id) {
		dao.delete(id);
	}
	
	
	
	/**
	 * VetAdmin
	 * @return
	 */
	public List<UserVO> searchAllUsers() {
		List<UserVO> list = dao.selectAll();
		return list;
	}

	// 회원조회 By ID
	public UserVO searchUserByID(String id) {
		UserVO user = dao.selectById(id);
		return user;
	}


	












}
