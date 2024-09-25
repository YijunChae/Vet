package kr.ac.kopo.vet.ui;

import kr.ac.kopo.medical.ui.MedicalUserUI;

public class MyClinicUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("진료서비스 제공을 위한 페이지로 이동합니다.");
		MedicalUserUI ui = new MedicalUserUI();
		ui.execute();

	}

}
