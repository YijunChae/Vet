package kr.ac.kopo.vet.ui;

import kr.ac.kopo.medical.ui.MedicalAdminUI;

public class MyTreatmentUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("진료관리를 위한 서비스로 이동합니다.");
		MedicalAdminUI ui = new MedicalAdminUI();
		ui.execute();

	}

}
