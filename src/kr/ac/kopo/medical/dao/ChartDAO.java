package kr.ac.kopo.medical.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.medical.vo.MedicalChartVO;
import kr.ac.kopo.util.ConnectionFactory;

public class ChartDAO {

	/**
	 * 	Admin DAO
	 */
	
	
	// 1. 차트 작성
	public void insertChart(MedicalChartVO chart) {
		
		String prefix = "MC";
		String chartId = "";
		StringBuilder sql = new StringBuilder();
		sql.append("insert into vet_chart ");
		sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			Statement stmt = conn.createStatement();
		) { 
			// 시퀀스(seq_vet_chart_id) 값 가져오기
			ResultSet rs = stmt.executeQuery("select seq_vet_chart_id.nextval from dual ");
			// chartId 만들기
			if(rs.next()) {
				int seq = rs.getInt(1);
				chartId = prefix + seq;
			}
			// 진료일시 Timestamp형으로 변환하기
			String strDatetime = chart.getTreatDate();
			Timestamp sqlDatetime = Timestamp.valueOf(strDatetime);
			// 필드 설정
			pstmt.setString(1, chartId);
			pstmt.setString(2, chart.getAnimalId());
			pstmt.setString(3, chart.getAnimalName());
			pstmt.setString(4, chart.getVetId());
			pstmt.setString(5, chart.getVetName());
			pstmt.setTimestamp(6, sqlDatetime);
			pstmt.setString(7, chart.getDiagnosis());
			pstmt.setString(8, chart.getTreatment());

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}	// end of insertChart

	
	// 2. 전체 차트 조회 
	public List<MedicalChartVO> selectAllChart() {
		
		List<MedicalChartVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select chartId, animalId, animalName, vetId, vetName ");
		sql.append("	, to_char(treatDate, 'yyyy-mm-dd hh24:mi:ss') treatDate ");
		sql.append("	, diagnosis, treatment ");
		sql.append(" from vet_chart ");
		sql.append(" order by chartId ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String chartId = rs.getString(1);
				String animalId = rs.getString(2);
				String animalName = rs.getString(3);
				String vetId = rs.getString(4);
				String vetName = rs.getString(5);
				String treatDate = rs.getString(6);
				String diagnosis = rs.getString(7);
				String treatment = rs.getString(8);
				
				MedicalChartVO chart = new MedicalChartVO(chartId, animalId, animalName, vetId, vetName, treatDate, diagnosis, treatment);
				list.add(chart);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}	// end of selectAllChart()


	// 3. 동물 아이디로 차트 조회
	public List<MedicalChartVO> selectEachChart(String animalIdf) {
		
		List<MedicalChartVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select chartId, animalId, animalName, vetId, vetName ");
		sql.append("	, to_char(treatDate, 'yyyy-mm-dd hh24:mi:ss') treatDate ");
		sql.append("	, diagnosis, treatment ");
		sql.append(" from vet_chart ");
		sql.append(" where animalId = ? ");
		sql.append(" order by chartId ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, animalIdf);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String chartId = rs.getString(1);
				String animalId = rs.getString(2);
				String animalName = rs.getString(3);
				String vetId = rs.getString(4);
				String vetName = rs.getString(5);
				String treatDate = rs.getString(6);
				String diagnosis = rs.getString(7);
				String treatment = rs.getString(8);
				
				MedicalChartVO chart = new MedicalChartVO(chartId, animalId, animalName, vetId, vetName, treatDate, diagnosis, treatment);
				list.add(chart);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}	//  end of selectEachChart()


	// 4. 차트 수정
	public void updateChart(MedicalChartVO chart) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update vet_chart ");
		sql.append("	set diagnosis = ? ");
		sql.append("	, treatment = ? ");
		sql.append(" where chartId = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, chart.getDiagnosis());
			pstmt.setString(2, chart.getTreatment());
			pstmt.setString(3, chart.getChartId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}	// end of updateChart()


	// 5. 차트 삭제
	public void removeChart(String chartId) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from vet_chart ");
		sql.append(" where chartId = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, chartId);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}	// end of removeChart()

}
















