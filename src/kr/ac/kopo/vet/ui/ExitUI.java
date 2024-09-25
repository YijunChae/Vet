package kr.ac.kopo.vet.ui;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("프로그램을 종료합니다.\n");
		System.exit(0);
	}

}
