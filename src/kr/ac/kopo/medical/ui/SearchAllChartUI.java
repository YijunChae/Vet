package kr.ac.kopo.medical.ui;

import java.util.List;

import kr.ac.kopo.medical.vo.MedicalChartVO;
import kr.ac.kopo.medical.vo.TreatmentScheduleVO;

public class SearchAllChartUI extends ChartBaseUI {

	@Override
	public void execute() throws Exception {
		
		List<MedicalChartVO> list = service.searchAllChart();
		
		// 화면 출력
		// 문자열 포맷
		String leftAlignFormat1 = "| %-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-30s | %-30s |%n";
		
		System.out.println("*------------*----------------------*----------------------*----------------------*----------------------*----------------------*--------------------------------*--------------------------------*");
		System.out.println("*   차트 아이디 *        동물 아이디       *       동물 이름        *        수의사 아이디      *       수의사 이름       *          진료일자       *             진단내역             *              처치내역             *");
		System.out.println("*------------*----------------------*----------------------*----------------------*----------------------*----------------------*--------------------------------*--------------------------------*");
		if(list.isEmpty()) {
			System.out.println("\t차트내역이 없습니다!");
		} else {
			for (MedicalChartVO chart : list) {
				System.out.format(leftAlignFormat1, chart.getChartId(), chart.getAnimalId(), chart.getAnimalName(), chart.getVetId(), chart.getVetName(), chart.getTreatDate(), chart.getDiagnosis(), chart.getTreatment());
			}			
		}
		System.out.println("*------------*----------------------*----------------------*----------------------*----------------------*----------------------*--------------------------------*--------------------------------*");

	}
}
