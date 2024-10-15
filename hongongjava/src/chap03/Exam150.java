package chap03;

import java.util.Scanner;

public class Exam150 {

	public static void main(String[] args) {
		
		// 문제1
		//컴파일 에러가 발생하는 위치와 이유 설명
		byte b = 5;
		b = (byte)-b; // 부호 연산시 int 타입으로 변경됨
		int result = 10 / b;
		System.out.println(result);
		
		// 문제2
		//다음 코드를 실행했을 때 출력 결과는 무엇입니까? 31
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);
		
		// 문제3
		//while(!stop)
				
		// 문제4
		int pencils = 534;
		int students = 30;
		
		//학생 1명이 가지는 연필 개수
		int pencilPerStudent = pencils / students;
		System.out.println(pencilPerStudent);
		
		//남은 연필 개수
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
		
		// 문제5
		// 출력 결과 5로 기대했는데, 4가 출력된 이유는?
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1 / var2; //연산하면 타입 int 됨 5/2 = int 2
		int var4 = (int) (var3 * var2);
		System.out.println(var4);
		
		// 문제6
		//십의 자리 이하를 버리는 코드 -->다시풀기
		int value = 356;
		System.out.println(value/100*100);
		
		// 문제7
		//출력 결과가 "10%입니다"를 기대했는데, "10%가 아닙니다"로 나온 이유? 
		float var11 = 10f;
		float var22 = var11/100;
		if(var22 == 0.1f) {  //0.1 뒤에 f를 붙이지 않아서
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		// 문제8
		//사다리꼴의 넓이가 정확히 소수 자릿수가 나오게 하기
		int lengthTop = 5;
		int lenthBottom = 10;
		int height = 7;
		double area = (double)1/2*(lengthTop+lenthBottom)*height;
		System.out.println(area);
		
		// 문제9
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 수 >");
		Double su1 = Double.parseDouble(scanner.nextLine());
		
		System.out.print("두 번째 수 >");
		Double su2 = Double.parseDouble(scanner.nextLine());
		
		System.out.println("첫 번째 수: "+(double)su1);
		System.out.println("두 번째 수: "+(double)su2);
		System.out.println("-------------");
		if(!(su2 == 0)||!(su2 == 0.0)){
		System.out.println("결과:" + (double)su1/(double)su2);
		} else {
			System.out.println("결과: 무한대");
		}
		

		
		//문제10
		//반지름이 10인 원의 넓이, 올바른 결과가 나오도록 코드를 수정
		int var111 = 10;
		int var222 = 3;
		int var333 = 14;
		double var444 = var111 * var111 * Double.parseDouble(var222+ "." + var333);
		System.out.println("원의 넓이:"+ (int)var444);
				
		//문제11
		//아이디가 "java"이고, 패스워드가 12345라면 "로그인 성공" 출력 / 아니면 "로그인 실패"
		
		System.out.print("아이디: ");
		String name = scanner.nextLine();
		
		System.out.println("패스워드: ");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")){
			if(password == 12345) {
			System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패: 패스워드가 틀림");
			} 
			}else {
				System.out.println("로그인 실패: 아이디 존재하지 않음");
			}	
		
		scanner.close();

		//문제12
		//연산식의 출력 결과
		int xx=10;
		int yy=5;
		System.out.println((xx > 7)&&(yy <= 5)); //true
		System.out.println((xx % 3 == 2)||(y%2 != 1)); //false
		
		//문제13
		//대입 연산자(=)와 산술연산자(+,-,*,/)로 구성된 실행문을 대입 연산자 하나로 구성된 실행문으로 변경
		int value1 = 0;
		value1 = value1 + 10; //value1 += 10
		value1 = value1 - 10; //value1 -= 10
		value1 = value1 * 10; //value1 *= 10
		value1 = value1 / 10; //value1 /= 10
		
		//문제14
		//코드 출력 결과?
		int score = 85;
		String result2 = (!(score>90)) ? "가" : "나";
		System.out.println(result2); //"가"
		
		

	} //main end

}//class end
