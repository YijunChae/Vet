package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.member.vo.AdminVO;
import kr.ac.kopo.member.vo.UserVO;
import kr.ac.kopo.util.ConnectionFactory;

public class MemberDAO {
	
	public static boolean isUser = false;
	public static boolean isAdmin = false;
	public static String userId = null;
	public static String adminId = null;
	public static String userName = null;
	public static String adminName = null;
	
	/**
	 * User 로그인
	 * @param id
	 * @param pw
	 * @return
	 */
	public UserVO userLogin(String id, String pw) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append(" from vet_user ");
		sql.append(" where id = ? and pw = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				isUser = true;
				userId = id;
				int       no 	     = rs.getInt("no");
				String 	  idf        = rs.getString("id");
				String 	  pwd 	     = rs.getString("pw");
				String 	  name       = rs.getString("name");
				String 	  breed      = rs.getString("breed");
				String 	  gender     = rs.getString("gender");
				int       age        = rs.getInt("age");
				String 	  protector  = rs.getString("protector");
				String 	  phone      = rs.getString("phone");
				UserVO user = new UserVO(no, idf, pwd, name, breed, gender, age, protector, phone);
				userName = name;
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}    // userLogin()

	
	/**
	 * Admin 로그인
	 * @param id
	 * @param pw
	 * @return
	 */
	public AdminVO adminLogin(String id, String pw) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append(" from vet_admin ");
		sql.append(" where id = ? and pw = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				isAdmin = true;
				adminId = id;
				int       empNo 	 = rs.getInt("empNo");
				String 	  idf        = rs.getString("id");
				String 	  pwd 	     = rs.getString("pw");
				String 	  vet        = rs.getString("vet");
				String 	  grade      = rs.getString("grade");
				String 	  phone      = rs.getString("phone");
				AdminVO admin = new AdminVO(empNo, idf, pwd, vet, grade, phone);
				adminName = vet;
				return admin;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}    // adminLogin()
	
	
	/**
	 * User 회원가입
	 * @param user
	 */
	public void insertUser(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into vet_user ");
		sql.append(" values(seq_vet_user_no.nextval, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) { 
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getBreed());
			pstmt.setString(5, user.getGender());
			pstmt.setInt(6, user.getAge());
			pstmt.setString(7, user.getProtector());
			pstmt.setString(8, user.getPhone());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // insertUser()

}
