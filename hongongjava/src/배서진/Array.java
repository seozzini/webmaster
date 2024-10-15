package 배서진;

import java.util.Arrays;


public class Array {

	public static void main(String[] args) {
		// 2024.09.26 과제

		// 문제1
		// 1~100 난수 10개 배열 저장하기
		// 배열값,합계,최대,최소 출력
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] ranArr = new int[10];
		for (int i = 0; i < ranArr.length; i++) {
			ranArr[i] = (int) (Math.random() * 100) + 1;
			System.out.printf(ranArr[i] + " ");
			sum += ranArr[i];
			if (max < ranArr[i])
				max = ranArr[i];
			if (min > ranArr[i])
				min = ranArr[i];
		}
		System.out.println();
		System.out.printf("합계= %d,최대값= %d,최소값= %d", sum, max, min);

		System.out.println();
		System.out.println("----------------------------------------------------");

		// 문제2
		// 2차원 배열 출력
		int[][] arr = { { 1, 2, 3 }, { 1, 2 }, { 1 }, { 1, 2, 3 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("----------------------------------------------------");

		// 문제3
		// 현재 관객의 수 출력
		int count = 0;
		int[][] persons = new int[3][10];
		for (int i = 0; i < persons.length; i++) {
			for (int j = 0; j < persons[i].length; j++) {
				int ranNum = (int) (Math.random() * 2);
				persons[i][j] = ranNum;
				if (persons[i][j] == 1)
					count++;
				System.out.print(persons[i][j] + " ");
			}
			System.out.println();
		}
		System.out.printf("현재 관객수는 %d명", count);

		System.out.println();
		System.out.println("----------------------------------------------------");

		// 문제4
		// 학생별 평균 계산하기
		int[][] scores = new int[3][5];

		for (int i = 0; i < scores.length; i++) {
			int sum1 = 0;
			double avg = 0;
			for (int j = 0; j < scores[i].length; j++) {
				int ranNum = (int) (Math.random() * 51) + 50;
				scores[i][j] = ranNum;
				sum1 += scores[i][j];
			} // for-j
			avg = (double) sum1 / scores[i].length;
			System.out.printf("%d번 학생 평균 = %.1f\n", i + 1, avg);
		} // for-i
		System.out.println(Arrays.deepToString(scores));

		System.out.println("----------------------------------------------------");

		// 문제5
		// 카드를 랜덤하게 선택하여 화면에 출력
		String[] cards = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] nums = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		
		for (int i = 0; i < 5; i++) {
			 int cardNum = (int) (Math.random() * cards.length);
			 int numsNum = (int) (Math.random() * nums.length);

			System.out.println(cards[cardNum]+"의 "+nums[numsNum]);
			System.out.println();
		}

		System.out.println("----------------------------------------------------");

		// 문제6
		// 2차원 배열 만들기
		// 3*5 크기의 2차원 배열 생성하고 초기값은 0으로 초기화
		// 5개의 정수 1을 랜덤하게 배치
		// 최종 배열 출력
		int[][] arr1 = new int[3][5];
		
		for(int i=0;i<5;i++) {
			int num1= (int)(Math.random()*arr1.length);
			int num2= (int)(Math.random()*arr1[0].length);
			
			if(arr1[num1][num2]!=1) {
				arr1[num1][num2]=1;
			}else {
				i--;
			}
		}
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		

	}// main end

	
}// class end
