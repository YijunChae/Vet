package kr.ac.kopo.medical.ui;

import java.util.Scanner;

import kr.ac.kopo.medical.service.ScheduleService;

public abstract class ScheduleBaseUI implements IMedicalUI {

	private Scanner sc;
	protected ScheduleService service;
	
	public ScheduleBaseUI() {
		sc = new Scanner(System.in);
		service = new ScheduleService();
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
