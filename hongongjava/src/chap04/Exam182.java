package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		// 확인문제
		// 문제4
		// 중첩 for 문 이용, (4*x) +(5*y) == 60의 모든 해를 구해서 (x,y) 형태로 출력
		// 단, x 와 y 는 10 이하의 자연수
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if((4*x) +(5*y) == 60) {
					System.out.printf("(%d,%d) ",x,y);
				}
			}//안 for
		}//바깥 for
		
		System.out.println();
		
		// 문제5
		// 별찍기1
		for(int i=1; i<=4; i++){
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}//안 for
			System.out.println();
		}//바깥 for
		
		//문제5-1
//		String stars = "";
//		for(int i=1; i<5; i++) {
//			stars += "*";
//			System.out.println(stars);
//		}
		
		// 문제6
		
		
		// 문제6-1
		// 별찍기2
//		String stars = "";
//		for(int i=1;i<5;i++) {
//			stars += "*";
//			System.out.printf("%4S\n",stars);
//		}
		
		//문제7
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			switch(selNo) {
			case 1: System.out.print("예금액> ");
			        int money = Integer.parseInt(sc.nextLine());
			        balance += money;
			        break;
			case 2: System.out.print("출금액> ");
					money=Integer.parseInt(sc.nextLine());
					//출금시 잔액 부족 체크
					//잔액이 부족하면 출금 불가, 출금가능액 표시
	        		if (balance<money) {
	        			System.out.println("잔액 부족");
	        			System.out.println("출금 불가");
	        			System.out.println("출금가능액: "+balance);
	        		} else {
	        			balance -= money;
	        		}
	        		break;
			case 3: System.out.println("잔고> "+balance);
					break;
    				
			case 4: run = false; break;
			default: System.out.print("잘못된 값이 입력되었습니다.");
			}
		}
		System.out.println("프로그램 종료");
		
		sc.close();

	}//main end

}//class end
