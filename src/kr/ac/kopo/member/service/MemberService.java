package kr.ac.kopo.member.service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.AdminVO;
import kr.ac.kopo.member.vo.UserVO;

public class MemberService {
	
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}

	public void addUser(UserVO user) {
		dao.insertUser(user);
	}

	public UserVO accessUser(String id, String pw) {
		UserVO user = new UserVO();
		user = dao.userLogin(id, pw);
		
		return user;
	}

	public AdminVO accessAdmin(String id, String pw) {
		AdminVO admin = new AdminVO();
		admin = dao.adminLogin(id, pw);
		
		return admin;
	}

}
