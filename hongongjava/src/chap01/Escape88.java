package chap01;

public class Escape88 {

	public static void main(String[] args) {
		System.out.println("번호\t이름\t직업");
		System.out.println("행 단위 출력\n");
		System.out.println("행 단위 출력\\n");
		System.out.println("우리는 \"개발자\"입니다");
		System.out.println("봄\\여름\\가을\\겨울");
		
		//p.91
		//예제에 시작합니다가 출력되도록 변경
		boolean stop = true;
		if(!stop) {
			System.out.println("중지합니다");
		} else {
			System.out.println("시작합니다");
		}
		
		//p.103
		//타입 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
//		byte byteValue3 = byteValue1 + byteValue2;
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
//		char charValue3 = charValue1 + charValue2;
		int intValue2 = charValue1 + charValue2;
	    System.out.println("유니코드="+intValue2);
	    System.out.println("출력문자=" + (char)intValue2);
		
	    
	    //p.106
	    //문자열 -> 숫자, 숫자 -> 문자열
	    
//	    int value1 = Integer.parseInt("10");
//	    double value2 = Double.parseDouble("3.14");
//	    boolean value3 = Boolean.parseBoolean("true");
//	    
//	    System.out.println("value1: " +(value1 + 100)); //앞의 값때문에 문자화 되지않게 괄호로 묶기
//	    System.out.println("value2: " +(value2 + 100));
//	    System.out.println("value3: " + value3);
	    
//	    String str1 = String.valueOf(10);
//	    String str2 = String.valueOf(3.14);
//	    String str3 = String.valueOf(true);
	    
//	    System.out.println("str1: " + (str1 + 100));
//	    System.out.println("str2: " + (str2 + 100));
//	    System.out.println("str3: " + str3);
//	    
	    //p.109
	    //확인문제5
	    //b 출력되도록 변경
	    char c1 = 'a';
	    char c2 = (char)(c1 + 1);
	    System.out.println(c2);
	    //b 의 코드값 출력
	    System.out.println((int)c2);

	    //확인문제6
//	    int x = 5;
//	    int y = 2;
//	    int result = x / y;
//	  System.out.println(result);
	  
	    //확인문제7
//	    int x = 5;
//	    int y = 2;
//	    double result =(double)x / y;
//	  System.out.println(result);
	  
	  //확인문제8
//	  double var1 = 3.5;
//	  double var2 = 2.7;
//	  int result = (int)(var1+var2);
//	  System.out.println(result);
	  
	  //확인문제9
	  long var1 = 2L;
	  float var2 = 1.8f;
	  double var3 = 2.5;
	  String var4 = "3.9";
	  int result = (int)var2 + (int)(var1 + var3 + Double.parseDouble(var4));
	  System.out.println(result);
	    
	  //확인문제10
	  String str1 = 2 + 3 + "" ;
	  String str2 = 2 + "" + 3;
	  String str3 = "" + 2 + 3;
	  System.out.println(str1); //5
	  System.out.println(str2); //23
	  System.out.println(str3);//23
	  
	  //확인문제11
//	  byte value = Byte.parseByte("10");
//	  int value = Integer.parseInt("1000");
//	  float value = Float.parseFloat("20.5");
//	  double value = Double.parseDouble("3.14159");
	  
	  
	} //end main

} //end class
