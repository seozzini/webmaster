package chap06;

public class StudentMain {

	public static void main(String[] args) {
		// 클래스가 다르면, 객체 생성하여 사용해야함
		//객체 생성
		Student st1 = new Student("240901","강땡땡"); //new 뒤에는 생성자 써주기
		System.out.println(st1.stNo); //첫번째 학생 니 번호 몇번이고? 
		System.out.println(st1.name); //첫번째 학생 니 이름이 뭐고? 
		st1.study(); //너는 지금 뭐하니? 메소드 뒤에는 ()괄호 꼭넣기
		
		Student st2 = new Student("240902", "김땡땡");
		System.out.println(st2.stNo);
		System.out.println(st2.name);
		st2.study();

	}

}
