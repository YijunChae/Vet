package kr.ac.kopo;

import kr.ac.kopo.member.ui.MemberUI;

public class VetMain {
	
	public static void main(String[] args) {
		
		MemberUI ui = new MemberUI();
		try {
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
