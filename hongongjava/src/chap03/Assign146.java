package chap03;

public class Assign146 {

	public static void main(String[] args) {
		int result = 0;
		result += 10; // result = result + 10
		System.out.println("result= "+result);
		result -= 5;
		System.out.println("result= "+result);
		result *= 3;
		System.out.println("result= "+result);
		result /= 5;
		System.out.println("result= "+result);
		result %= 3;
		System.out.println("result= "+result);
		
		int su = 1;
		int su2 = 2;
		System.out.println("su & su2 = "+(su & su2));
		System.out.println("su | su2 = "+(su | su2));
		System.out.println("su ^ su2 = "+(su ^ su2));

	}//main end

}//class end
