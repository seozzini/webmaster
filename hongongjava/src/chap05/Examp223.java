package chap05;

public class Examp223 {

	public static void main(String[] args) {
		// p.223 문제5
		// 중첩 for 문 활용하여 배열의 합과 평균 구하기
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				sum += array[i][j];
				count++;
			}
		}
		avg=(double)sum/count;

		System.out.println("sum: "+sum);
		System.out.println("avg: "+avg);
	}

}
