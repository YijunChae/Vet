package kr.ac.kopo.medical.ui;

import kr.ac.kopo.vet.ui.VetAdminUI;

public class AdminPrevUI extends ChartBaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("이전 페이지로 이동합니다.");
		VetAdminUI ui = new VetAdminUI();
		ui.execute();

	}

}
