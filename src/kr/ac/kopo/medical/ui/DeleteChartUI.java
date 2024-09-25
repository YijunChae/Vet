package kr.ac.kopo.medical.ui;

public class DeleteChartUI extends ChartBaseUI {

	@Override
	public void execute() throws Exception {
		
		String chartId = scanStr("삭제할 차트 아이디를 입력해주세요: ");
		
		service.deleteChart(chartId);
		
		System.out.println("선택하신 차트가 정상적으로 삭제되었습니다!");

	}

}
