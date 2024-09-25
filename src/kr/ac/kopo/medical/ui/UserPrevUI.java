package kr.ac.kopo.medical.ui;

import kr.ac.kopo.vet.ui.VetUserUI;

public class UserPrevUI extends ScheduleBaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("이전 페이지로 이동합니다.");
		VetUserUI ui = new VetUserUI();
		ui.execute();

	}

}
