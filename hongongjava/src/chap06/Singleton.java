package chap06;

public class Singleton {//정보은닉(어떻게 만든지 모름), 캡슐화(메소드만 열려있음)
	// 전체 프로그램에서 하나의 객체만 존재하게 하는 코딩 기법
	// 생성자 접근 불가, 필드 접근 불가
	// class 로 접근
	// 필드
	private static Singleton st = new Singleton(); //내가 만들어 자기타입으로 선언해서 저장/필드에 그냥 접근 불가
	String name = "홍길동";
	
	// 생성자
	private Singleton() {};
	
	// 메소드: 외부로 객체 전달
	static Singleton getInstance() {
		return st;
	}
}
