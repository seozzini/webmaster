package chap06;

public class Student {
	//필드(속성)
	String stNo; //= " "으로 값을 넣으면 모든 객체가 같은 값을 가지게 됨
	String name;
	
	//생성자(객체 생성)->객체의 속성 초기화 (객체를 만들기만 하고 리턴기능 없음. 이름이 클래스와 같다)
	Student(String stNo, String name){
		this.stNo = stNo; //받은 값은 객체 필드로 넣어줘야함/이름이 같으면 매개변수가 우선권 가짐(this는 만들어지는 객체 지칭)
		this.name = name;
	}
	
	//메소드(기능) :기능을 하게하고 값을 리턴받음
	void study() {
		System.out.println("공부합니다");
	}//void:리턴값없음, study 라는 메소드 ()괄호는 값은 받아들이지 않는다는뜻
}
