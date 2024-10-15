package chap06;

public class MemberMain {

	public static void main(String[] args) { //교재 pp252-253
		// 객체 생성
		Member member = new Member(); //Member 타입의 변수는 Member Class 에 들어있는 필드, 메소드를 가질 수 있는 아이다.
									  //member 라는 참조변수는 힙영역에 있는 id,name,age,password 를 가진 객체를 가리키는 주소를 가짐.
		                              //new 는 힙영역에 해당 공간을 만들어 준다, member 객체가 *번지에 만들어지고 그 안에 필드값이 있다.
		
		Member member2 = new Member("홍길동", "hong");
		
		// 필드값 읽기
		System.out.println("회원이름: "+ member.name);
		System.out.println("회원아이디: "+ member.id);
		System.out.println("회원비밀번호: "+ member.password);
		System.out.println("회원나이: "+ member.age);
		
		System.out.println();
		
		System.out.println("회원이름: "+ member2.name);
		System.out.println("회원아이디: "+ member2.id);
		System.out.println("회원비밀번호: "+ member2.password);
		System.out.println("회원나이: "+ member2.age);
		
		System.out.println();
		
		// 필드값 변경
		member.name="최하얀";
		member.age=23;
		System.out.println("회원이름: "+member.name);
		System.out.println("회원나이: "+member.age);

	}

}
