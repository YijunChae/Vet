package kr.ac.kopo.vet.ui;

import java.util.Scanner;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.vet.service.VetService;

public abstract class BaseUI implements IVetUI {
	
	private Scanner sc;
	protected VetService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		service = new VetService();
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
