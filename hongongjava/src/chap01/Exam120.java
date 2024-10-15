package chap01;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
		// 문제1: 출력문 연습
		String name = "감자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %s-%s-%s\n",tel1,tel2,tel3);
		
		// 문제2: Scanner 이용1
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("첫 번째 수: ");
//		String StrNum1 = scanner.nextLine();
//		
//		System.out.println("두 번째 수: ");
//		String StrNum2 = scanner.nextLine();
//		
//		int num1 = Integer.parseInt(StrNum1);
//		int num2 = Integer.parseInt(StrNum2);
//		int result = num1 + num2;
//		System.out.println("덧셈 결과: " + result);
//
//		scanner.close();
		
		//문제3: Scanner 이용2
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 > ");
		String name2 = scanner.nextLine();

		System.out.print("주민번호 앞 6자리 > ");
		String juminNum = scanner.nextLine();
		
		System.out.print("전화번호('-'포함) > ");
		String tel4 = scanner.nextLine();

		
		System.out.println("1. 이름: "+name2);
		System.out.println("2. 주민번호 앞 6자리: "+juminNum);
		System.out.println("3. 전화번호: "+tel4);
		
		scanner.close();
		
		//두 수를 입력 받아서 큰 수 - 작은 수 (풀어보기)
		
	} // main end

} // class end
