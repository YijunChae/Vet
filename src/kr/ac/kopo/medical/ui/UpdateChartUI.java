package kr.ac.kopo.medical.ui;

import kr.ac.kopo.medical.vo.MedicalChartVO;

public class UpdateChartUI extends ChartBaseUI {

	@Override
	public void execute() throws Exception {
		
		String chartId = scanStr("수정하시려는 차트의 차트아이디를 입력해주세요: ");
		String diagnosis = scanStr("수정할 진단내역을 입력해주세요: ");
		String treatment = scanStr("수정할 처치내역을 입력해주세요: ");
		
		MedicalChartVO chart = new MedicalChartVO();
		chart.setChartId(chartId);
		chart.setDiagnosis(diagnosis);
		chart.setTreatment(treatment);
		
		service.modifyChart(chart);
		
		System.out.println("차트 수정이 완료되었습니다.");

	}

}
