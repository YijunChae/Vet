package kr.ac.kopo.medical.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.medical.vo.TreatmentScheduleVO;
import kr.ac.kopo.util.ConnectionFactory;

public class ScheduleDAO {

	/**
	 *		UserDAO
	 */
	
	
	// 0. 중복예약방지
	public boolean isTimeSlotTaken(String vetName, Timestamp reservationTime) throws SQLException {
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from vet_schedule where vetName = ? and scheduleDate = ? ");
		) {
			pstmt.setString(1, vetName);
			pstmt.setTimestamp(2, reservationTime);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0;
			}

			return false;
		}
	}
	
	
	// 1. 진료예약
	public void insertSchedule(TreatmentScheduleVO ts) {
		
		String prefix = "TS";
		String scheduleId = "";
		StringBuilder sql = new StringBuilder();
		sql.append("insert into vet_schedule ");
		sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			Statement stmt = conn.createStatement();
		) { 
			// 시퀀스(seq_vet_schedule_id) 값 가져오기
			ResultSet rs = stmt.executeQuery("select seq_vet_schedule_id.nextval from dual");
			// scheduleId 만들기
			if(rs.next()) {
				int seq = rs.getInt(1);
				scheduleId = prefix + seq;
			}
			// 예약일시 Timestamp형으로 변환하기
			String strDatetime = ts.getScheduleDate();
			Timestamp sqlDatetime = Timestamp.valueOf(strDatetime);
			// 필드 설정
			pstmt.setString(1, scheduleId);
			pstmt.setString(2, ts.getAnimalId());
			pstmt.setString(3, ts.getAnimalName());
			pstmt.setString(4, ts.getDemand());
			pstmt.setString(5, ts.getVetId());
			pstmt.setString(6, ts.getVetName());
			pstmt.setTimestamp(7, sqlDatetime);
			pstmt.setString(8, ts.getReservationStatus());

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}	// end of insertSchedule()

	public List<TreatmentScheduleVO> selectSchedule(String userId) {
		
		List<TreatmentScheduleVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select scheduleId, animalId, animalName, demand, vetId, vetName ");
		sql.append("	, to_char(scheduleDate, 'yyyy-mm-dd hh24:mi:ss') scheduleDate ");
		sql.append("	, reservationStatus ");
		sql.append(" from vet_schedule ");
		sql.append(" where animalId = ? ");
		
		try(
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt
				= conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			   String scheduleId		= rs.getString(1); 		
			   String animalId			= rs.getString(2); 		
			   String animalName		= rs.getString(3); 		
			   String demand			= rs.getString(4);			
			   String vetId				= rs.getString(5);	 		
			   String vetName			= rs.getString(6);			
			   String scheduleDate		= rs.getString(7); 	
			   String reservationStatus	= rs.getString(8);
			   
			   TreatmentScheduleVO ts 
			   		= new TreatmentScheduleVO(scheduleId, animalId, animalName, demand, vetId, vetName, scheduleDate, reservationStatus);
			   list.add(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}	// end of selectSchedule()

	
	// 3. 진료일정 변경
	public void updateSchedule(TreatmentScheduleVO ts) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update vet_schedule ");
		sql.append("	set scheduleDate = ? ");
		sql.append("	, reservationStatus = ? ");
		sql.append(" where scheduleId = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, ts.getScheduleDate());
			pstmt.setString(2, "예약변경 요청");
			pstmt.setString(3, ts.getScheduleId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	// end of updateSchedule()

	
	// 4. 진료예약 취소
	public void deleteReservation(String scheduleId) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from vet_schedule ");
		sql.append(" where scheduleId = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, scheduleId);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	// end of deleteReservation()

	
	
	
	
	
	/**
	 * 	AdminDAO
	 */
	
	
	// 1. 진료일정 전체 조회
	public List<TreatmentScheduleVO> selectAllSchedule() {
		
		List<TreatmentScheduleVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select scheduleId, animalId, animalName, demand, vetId, vetName ");
		sql.append("	, to_char(scheduleDate, 'yyyy-mm-dd hh24:mi:ss') scheduleDate ");
		sql.append("	, reservationStatus ");
		sql.append(" from vet_schedule ");
		sql.append(" order by scheduleId ");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String scheduleId 		 = rs.getString(1);
				String animalId			 = rs.getString(2); 			
				String animalName		 = rs.getString(3); 			
				String demand			 = rs.getString(4);				
				String vetId			 = rs.getString(5);	 			
				String vetName			 = rs.getString(6);				
				String scheduleDate		 = rs.getString(7); 		
				String reservationStatus = rs.getString(8);
				
				TreatmentScheduleVO ts = new TreatmentScheduleVO(scheduleId, animalId, animalName, demand, vetId, vetName, scheduleDate, reservationStatus);
				list.add(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}	// end of selectAllSchedule()

	
	// 2. 수의사별 진료일정 조회
	public List<TreatmentScheduleVO> selectTask(String veterinaryName) {
		
		List<TreatmentScheduleVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select scheduleId, animalId, animalName, demand, vetId, vetName ");
		sql.append("	, to_char(scheduleDate, 'yyyy-mm-dd hh24:mi:ss') scheduleDate ");
		sql.append("	, reservationStatus ");
		sql.append(" from vet_schedule ");
		sql.append(" where vetName = ? ");
		
		try(
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt
				= conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, veterinaryName);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			   String scheduleId		= rs.getString(1); 		
			   String animalId			= rs.getString(2); 		
			   String animalName		= rs.getString(3); 		
			   String demand			= rs.getString(4);			
			   String vetId				= rs.getString(5);	 		
			   String vetName			= rs.getString(6);			
			   String scheduleDate		= rs.getString(7); 	
			   String reservationStatus	= rs.getString(8);
			   
			   TreatmentScheduleVO ts 
			   		= new TreatmentScheduleVO(scheduleId, animalId, animalName, demand, vetId, vetName, scheduleDate, reservationStatus);
			   list.add(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;		
		
	}	// end of selectTask()

	
	// 3. 예약관리
	public void confirmSchedule(TreatmentScheduleVO ts) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update vet_schedule ");
		sql.append(" set vetId = ? ");
		sql.append("	, reservationStatus = ? ");
		sql.append(" where scheduleId = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, ts.getVetId());
			pstmt.setString(2, ts.getReservationStatus());
			pstmt.setString(3, ts.getScheduleId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	// end of confirmSchedule()


	
	
	
	
	
	
	
	
	
	

}
