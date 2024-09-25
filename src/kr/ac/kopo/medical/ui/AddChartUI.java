package kr.ac.kopo.medical.ui;

import java.util.List;

import kr.ac.kopo.medical.vo.MedicalChartVO;

/**
 * < Add >
 * 	1. 멤버변수 입력받기
 * 	2. 1 넣어서 VO 생성
 * 	3. 2를 서비스에 전달
 * 	4. 메시지
 * @author juun
 *
 */

public class AddChartUI extends ChartBaseUI {

	@Override
	public void execute() throws Exception {
				
		String animalId		=	scanStr("동물 아이디: ");
		String animalName	=	scanStr("동물 이름: ");
		String vetId		=	scanStr("수의사 아이디: ");
		String vetName		=	scanStr("수의사 이름: ");
		String treatDate	=	scanStr("진료 일자: ");
		String diagnosis	=	scanStr("진단내역: ");
		String treatment	=	scanStr("처치내역: ");
		
		MedicalChartVO chart = new MedicalChartVO(animalId, animalName, vetId, vetName, treatDate, diagnosis, treatment);
		service.addChart(chart);
		
		System.out.println("차트 등록이 완료되었습니다.");
	}

}
