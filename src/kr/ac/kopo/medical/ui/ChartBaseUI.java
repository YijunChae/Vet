package kr.ac.kopo.medical.ui;

import java.util.Scanner;

import kr.ac.kopo.medical.service.ChartService;

public abstract class ChartBaseUI implements IMedicalUI {

	private Scanner sc;
	protected ChartService service;
	
	public ChartBaseUI() {
		sc = new Scanner(System.in);
		service = new ChartService();
	}
	
	protected String scanStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
	protected int scanInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	}

}
