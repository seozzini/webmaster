package chap06;

public class MemberService {
	//필드
	
	//생성자
	
	//메소드
	boolean login(String id,String password) {
		if(id.equals("hong")&&password.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}//class end
