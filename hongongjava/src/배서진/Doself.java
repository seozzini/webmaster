package 배서진;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		// 1. 윤년 계산 프로그램
		Scanner sc = new Scanner(System.in);

		System.out.print("##년도 입력 : ");
		int year = Integer.parseInt(sc.nextLine());

		if ((year % 4 == 0) && (year % 100 != 0)) {
			System.out.println(year + "년은 윤년입니다.");
		} else if (year % 400 == 0) {
			System.out.println(year + "년은 윤년입니다.");
		} else {
			System.out.println(year + "년은 평년입니다.");
		}

		// 2. 동전 교환 프로그램
		System.out.print("##교환할 금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		int moneyFirst = money;
		System.out.println("500원 짜리 : " + money / 500 + "개");
		money %= 500;
		System.out.println("100원 짜리 : " + money / 100 + "개");
		money %= 100;
		System.out.println("50원 짜리 : " + money / 50 + "개");
		money %= 50;
		System.out.println("10원 짜리 : " + money / 10 + "개");
		money %= 10;
		System.out.println("교환 금액 : " + (moneyFirst - money) + "원");
		System.out.println("남은 금액 : " + money + "원");

		// 3. 숫자 추측 게임
		// 1에서 100까지의 수를 발생시키고 어떤 수인지 알아맞추기
		int ranNum = (int) (Math.random() * 100) + 1;
		System.out.println(ranNum);
		boolean run = true;
		while (run) {
			System.out.print("숫자 입력 : ");
			int su = Integer.parseInt(sc.nextLine());
			if (ranNum > su) {
				System.out.println("up하세요!!");
			} else if (ranNum == su) {
				System.out.println("축하합니다!!");
				run = false;
			} else {
				System.out.println("down하세요!!");
			}
		}

		// 4.구구단 프로그램

		for (int dan = 2; dan <= 9; dan++) {
			System.out.printf("  %d단\t", dan);
		}
		System.out.println();
		int i = 1;
		int j = 0;
		for (i = 1; i <= 9; i++) {
			for (j = 2; j <= 9; j++) {
				System.out.printf("%dx%d=%2d\t", j, i, j * i);
			}
			System.out.println();
		}

		System.out.println();
		// 5.섭씨-화씨 온도 변환 프로그램
		run = true;
		while (run) {
			System.out.println("---------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("---------------------");
			System.out.print("▶번호 선택 : ");
			int selNo = Integer.parseInt(sc.nextLine());
			switch (selNo) {
			case 1:
				System.out.print("▶화씨 온도 입력 : ");
				double ondo = Double.parseDouble(sc.nextLine());
				double ondoC = 5.0 / 9.0 * (ondo - 32);
				System.out.printf("섭씨온도 =%.6f\n", ondoC);
				break;
			case 2:
				System.out.print("▶섭씨 온도 입력 : ");
				ondo = Double.parseDouble(sc.nextLine());
				double ondoF = 9.0 / 5.0 * ondo + 32;
				System.out.printf("화씨 온도 =%.6f\n", ondoF);
				break;
			case 3:
				System.out.println("program end");
				run = false;
				break;
			}
		}

		System.out.println();

		// 6. 가위,바위,보 게임 프로그램

		run = true;
		while (run) {
			System.out.print("##가위바위보 : ");
			int my = Integer.parseInt(sc.nextLine());
			int com = (int) (Math.random() * 2);

			if (my > 2) {
				System.out.println("game over");
				run = false;
				break;
			}

			if (my == com) {
				System.out.printf("사람 %d, 컴 %d 비겼음 \n", my, com);
			} else if ((my + 1) % 3 == com) {
				System.out.printf("사람 %d, 컴 %d 컴 승리 \n", my, com);
			} else {
				System.out.printf("사람 %d, 컴 %d 사람 승리 \n", my, com);
			}
		}

		// 문제7
		// 3,6,9 게임 프로그램
		// 1~50까지 3,6,9가 들어가는 숫자마다 3,6,9가 들어가 있는 개수만큼 "♥" 출력하는 프로그램 작성

		String heart = "";
		for (i = 1; i <= 50; i++) {
			if ((i % 10 != 0) && (i % 10 % 3 == 0)) {
				heart += "♥";
			}

			if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
				heart += "♥";
			}

			if (heart.equals("")) {
				heart += i;
			}
			System.out.printf("%s\t ", heart);
			if (i % 10 == 0) {
				System.out.println();
			}
			heart = "";

		}

		sc.close();
	} // main end
}// class end
