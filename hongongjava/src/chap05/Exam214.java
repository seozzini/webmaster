package chap05;

public class Exam214 {

	public static void main(String[] args) {
		// 2차원 배열
		int[][] scores = { 
				{ 10, 20, 30 },
				{ 40, 50, 60 } 
		};
		
//		for(int i=0; i<scores.length;i++){//length 는 행의수
//			for(int j=0; j<scores[i].length;j++) {
//				System.out.print(scores[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int[] row: scores) {
			for(int j : row) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		//2*3 배열을 선언
		//1에서 10까지 무작위 수를 입력하세요
		//같은 수 입력 가능
		
		int[][] nums = new int[2][3];

		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums[i].length;j++) {
				nums[i][j] = (int) (Math.random() * 10) + 1;
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
		
		//향상된 for 문
		int[] su = {10,200,30,40,-50,777,555};
		
		//배열의 합, 최대값, 최소값
		//향상된 for 문을 이용
		int sum = 0;
		int max = Integer.MIN_VALUE; //int 값 중에 최소값
		int min = Integer.MAX_VALUE; //int 값 중에 최대값
		for(int ele : su) {
			sum += ele;
			if(ele<min) min = ele ;
			if(ele>max) max = ele ;
		}
		System.out.printf("sum= %d max= %d min= %d",sum,max,min);
		
	}// main end
		

}// class end
