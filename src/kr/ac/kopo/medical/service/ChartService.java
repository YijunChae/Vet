package kr.ac.kopo.medical.service;

import java.util.List;

import kr.ac.kopo.medical.dao.ChartDAO;
import kr.ac.kopo.medical.vo.MedicalChartVO;

public class ChartService {
	
	private ChartDAO dao;
	
	public ChartService() {
		dao = new ChartDAO();
	}

	/**
	 * 		AdminService
	 */
	
	
	// 1. 차트 작성
	public void addChart(MedicalChartVO chart) {
		dao.insertChart(chart);
	}

	
	// 2. 모든 차트 조회
	public List<MedicalChartVO> searchAllChart() {
		List<MedicalChartVO> list = dao.selectAllChart();
		return list;
	}

	
	// 3. 동물아이디로 차트 조회
	public List<MedicalChartVO> searchEachChart(String animalId) {
		List<MedicalChartVO> list = dao.selectEachChart(animalId);
		return list;
	}

	
	// 4. 차트 수정
	public void modifyChart(MedicalChartVO chart) {
		dao.updateChart(chart);
	}

	
	// 5. 차트 삭제
	public void deleteChart(String chartId) {
		dao.removeChart(chartId);
	}

}
