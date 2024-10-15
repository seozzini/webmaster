package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		
		//run-run configuration-arguments
//		String args1 = args[0];
//		System.out.println(args1); //숫자도 문자로 받아옴 계산에 쓰려면 int로 바꿔야함
//		
//		int args2 = Integer.parseInt(args[0]);
//		System.out.println(args2 + 100);
				
		// 배열을 생성
		// 배열을 이용하는 방법
		int[] scores = { 83, 90, 87 };

		System.out.println("scores[0]" + scores[0]);
		System.out.println("scores[1]" + scores[1]);
		System.out.println("scores[2]" + scores[2]);

		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합 :" + sum);
		double avg = (double) sum / scores.length;
		System.out.printf("평균 :%.2f", avg);

		System.out.println();
		
		
		// 배열에 1에서 100까지의 임의의 수(random()) 10개를 저장
		// 배열의 합과 평균(소수 첫째자리까지 나타냄)
		// 최대값, 최소값을 구하세요
		// 배열생성
		int[] ranArr = new int[10]; // 초기값 10개의 방에 0으로 세팅
//		int[] ranArr2 = {10,20,30};
		for (int i = 0; i < ranArr.length; i++) {
			ranArr[i] += (int) (Math.random() * 100) + 1;
		}

		System.out.println(ranArr); // 16진수로 된 배열의 주소가 나옴
		System.out.println(Arrays.toString(ranArr)); // 자바의 클래스를 활용

		System.out.println();
		// 배열 이용해서 합, 평균, 최대, 최소값 구하는 루틴은 따로(두 부분으로 나눠서)
		sum = 0;
		avg = 0;
		int max = 0;
		int min = 100; // 0넣으면 0이 출력될 수 있음 주의
		System.out.print("ranArr 배열 :");
		for (int i = 0; i < ranArr.length; i++) {
			System.out.print(ranArr[i] + " ");
			sum += ranArr[i];
			if (max < ranArr[i])
				max = ranArr[i];
			if (min > ranArr[i])
				min = ranArr[i];

		}
		avg = (double)sum / ranArr.length;
		System.out.println("\n배열의 합:" + sum);
		System.out.printf("배열의 평균:%.1f",avg);
		System.out.println("\n배열의 최대값:" + max);
		System.out.println("배열의 최소값:" + min);
		System.out.printf("sum = %d, avg = %.1f, max = %d, min = %d",sum,avg,max,min ); //가독성좋음
	}// main end

}// class end
