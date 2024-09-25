package kr.ac.kopo.vet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.member.vo.AdminVO;
import kr.ac.kopo.member.vo.UserVO;
import kr.ac.kopo.util.ConnectionFactory;

public class VetDAO {

	/**
	 * VetUser
	 * @return
	 */
	public UserVO selectMyInfo(String userId) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, pw, name, breed, gender, age, protector, phone ");
		sql.append(" from vet_user ");
		sql.append(" where id = ? ");
		
		try(
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				String breed = rs.getString(5);
				String gender  = rs.getString(6);
				int age = rs.getInt(7);
				String protector = rs.getString(8);
				String phone = rs.getString(9);
				
				UserVO user = new UserVO(no, id, pw, name, breed, gender, age, protector, phone);
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return null;
	}
	
	
	// 비밀번호 수정
	public void updatePw(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("update vet_user ");
		sql.append("   set pw = ? ");
		sql.append(" where id = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
		
	// 본인 확인
	public boolean verify(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append(" from vet_user ");
		sql.append(" where id = ? and pw = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	// 회원 탈퇴
	public void delete(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from vet_user ");
		sql.append(" where id = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * VetAdmin
	 * @return
	 */
	public List<UserVO> selectAll() {
		
		List<UserVO> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, name, breed, gender, age, protector, phone ");
		sql.append(" from vet_user ");
		sql.append(" order by no ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				String breed = rs.getString(4);
				String gender  = rs.getString(5);
				int age = rs.getInt(6);
				String protector = rs.getString(7);
				String phone = rs.getString(8);
				
				UserVO user = new UserVO(no, id, name, breed, gender, age, protector, phone);
				list.add(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public UserVO selectById(String idf) {
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, name, breed, gender, age, protector, phone ");
		sql.append("  from vet_user ");
		sql.append(" where id = ? ");
		
		try(
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, idf);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				String breed = rs.getString(4);
				String gender  = rs.getString(5);
				int age = rs.getInt(6);
				String protector = rs.getString(7);
				String phone = rs.getString(8);
				
				UserVO user = new UserVO(no, id, name, breed, gender, age, protector, phone);
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;		
	}
















}
