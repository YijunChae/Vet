package kr.ac.kopo.member.vo;

/**
 * < 관리자정보 VO >
 * @author Yijun
 * 1. 사번 2. 아이디, 3. 패스워드, 4. 이름, 5. 직위, 6. 연락처
 * int empNo; String id; String pw; String vet; String grade; String phone;
 */

public class AdminVO {
	
	// 1. 멤버변수
	private int empNo; 
	private String id; 
	private String pw; 
	private String vet; 
	private String grade; 
	private String phone;
	
	
	// 2. 기본생성자
	public AdminVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	// 3. 멤버변수 초기화 생성자
	public AdminVO(int empNo, String id, String pw, String vet, String grade, String phone) {
		super();
		this.empNo = empNo;
		this.id = id;
		this.pw = pw;
		this.vet = vet;
		this.grade = grade;
		this.phone = phone;
	}


	// 4. Getter/Setter
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getVet() {
		return vet;
	}

	public void setVet(String vet) {
		this.vet = vet;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	// 5. toString() 오버라이드
	@Override
	public String toString() {
		return "AdminVO [empNo=" + empNo + ", id=" + id + ", pw=" + pw + ", vet=" + vet + ", grade=" + grade
				+ ", phone=" + phone + "]";
	}
	
}
