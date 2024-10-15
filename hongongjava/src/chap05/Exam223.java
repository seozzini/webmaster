package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		// 확인문제 6번
		// if 문 -> switch 문으로 바꿔 만들기

		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");

			System.out.print("선택>");
			int selNo = sc.nextInt();

			switch (selNo) {
			case 1:
				System.out.print("학생수>");
				studentNum = sc.nextInt();
				break;
			case 2:
				scores = new int[studentNum];
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]>", i);
					scores[i] = sc.nextInt();
				}
				break;
			case 3:
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]>%S\n", i, scores[i]);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				double avg = 0;
				for (int i = 0; i < scores.length; i++) {
					if (max < scores[i])
						max = scores[i];
					sum += scores[i];
				}
				avg = (double) sum / scores.length;
				System.out.println("최고 점수:" + max);
				System.out.println("평균 점수:" + avg);
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("잘못된 값이 입력되었습니다.");

			}// switch end
		} // while end
		
		sc.close();

	}// main end

}// class end
