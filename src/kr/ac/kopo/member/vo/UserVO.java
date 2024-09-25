package kr.ac.kopo.member.vo;

/**
 * < 회원정보 VO >
 * @author Yijun
 * 1. 관리번호; 2. 아이디; 3. 패스워드; 반려동물(4. 이름; 5. 품종; 6. 성별; 7. 나이; 8. 보호자명; 9. 보호자 연락처;
 * int no; String id; String pw; String name; String breed; String gender; int age; String protector; String phone;
 */

public class UserVO {
	
	// 1. 멤버변수
	private int no;
	private String id;
	private String pw;
	private String name;
	private String breed;
	private String gender;
	private int age; 
	private String protector;
	private String phone;
	
	
	// 2. 기본생성자
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	// 3. 멤버변수 초기화 생성자
	public UserVO(int no, String id, String pw, String name, String breed, String gender, int age, String protector,
			String phone) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
		this.protector = protector;
		this.phone = phone;
	}
	
	// 3-2. 패스워드를 제외한 멤버변수 초기화 생성자
	public UserVO(int no, String id, String name, String breed, String gender, int age, String protector,
			String phone) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
		this.protector = protector;
		this.phone = phone;
	}


	// 4. Getter/Setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProtector() {
		return protector;
	}

	public void setProtector(String protector) {
		this.protector = protector;
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
		return "UserVO [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", breed=" + breed + ", gender="
				+ gender + ", age=" + age + ", protector=" + protector + ", phone=" + phone + "]";
	}
	
}
	
	
	
	
	
