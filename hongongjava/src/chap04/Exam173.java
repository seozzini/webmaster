package chap04;

public class Exam173 {

	public static void main(String[] args) {
		//for 문
		// 50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수합 출력
		//3의 배수 갯수 출력
		int cnt = 0;
		int sum = 0;
		for(int i=50;i<=100;i++) {
			if(i % 3 == 0) {
				cnt++;
				sum += i;
				System.out.print(i+" ");
			} //if end
			
		} //for end
		System.out.println("\n3의 배수 갯수:"+cnt);
		System.out.println("50~100까지 3의 배수합:"+sum);
		
		
		//while 문
		//1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		//7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		
		//1번방식
//		int su = 0;
//		sum = 0;
//		while(sum < 300) {
//			su += 7;
//			sum += su;
//		}
//		System.out.println("7의 배수 = "+su);
//		System.out.println("7의 배수의 합 = "+sum);
//		
		//2번방식
//		int su = 0;
//		sum = 0;
//		while(true) {
//			su += 7;
//			sum += su;
//			if(sum >= 300) break;
//		}
//		System.out.println("7의 배수 = "+su);
//		System.out.println("7의 배수의 합 = "+sum);

		//3번방식
		int su = 0;
		sum = 0;
		while(true) {
			su++;
			if(su%7==0) {
				sum += su;
				if(sum >= 300) break;
			}
		}
		System.out.println("7의 배수 = "+su);
		System.out.println("7의 배수의 합 = "+sum);
		
		//중첩 for 문
		//구구단
		for (int m =2 ; m <=9; m++) {
			System.out.println("*** "+m+"단 ***");
			for(int n = 1; n<=9; n++) {
				System.out.printf("%d X %d = %d\n",m,n,m*n);
			}
		}
		
		System.out.println();
		
		System.out.println("***************************************************************");
		//구구단 프로그램
		for(int dan = 2 ; dan<=9; dan++) {
		System.out.printf("  %d단\t",dan);
		}
		System.out.println();
		for(int j=1;j<=9;j++) {
		for (int k=2;k<=9;k++) {
			System.out.printf("%dx%d=%2d\t",k,j,j*k);
		}
		System.out.println();
		}
	
	
	}//main end

}//class end
