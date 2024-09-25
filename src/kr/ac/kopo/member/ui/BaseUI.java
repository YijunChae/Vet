package kr.ac.kopo.member.ui;

import java.util.Scanner;

import kr.ac.kopo.member.service.MemberService;

public abstract class BaseUI implements IMemberUI {
	
	private Scanner sc;
	protected MemberService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		service = new MemberService();
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
}
