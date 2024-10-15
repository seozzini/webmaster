package chap01;

import java.util.Scanner;

public class Scanner118 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strin;
		//문자열
		System.out.print("문자열 입력 > ");
		strin = sc.nextLine();
		System.out.println("입력 받은 문자열 : "+strin);
		if(strin == "q") {
			System.out.println("q입력됨");
		} else {
			System.out.println("같지 않음");
		}
		
		if(strin.equals("q")){
			System.out.println("q 입력 됨");
		} else {
			System.out.println("같지 않음");
		}
		
		//숫자
		System.out.print("숫자 입력 > ");
		int valInt = sc.nextInt();
		System.out.println("입력 숫자 : "+valInt);
		strin = sc.nextLine(); // int로 받았으면 공백을 넣던지, Integer로 변환
		
		System.out.print("숫자 입력 > ");
		valInt = Integer.parseInt(sc.nextLine());
		System.out.print("입력 받은 숫자 + 100 : " + (valInt + 100));
		
		sc.close(); //자원 사용후 반납

	}

}
