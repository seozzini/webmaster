package chap10;

public class ExeptionMain {

	public static void main(String[] args) {
		// 예외처리
		try {
			Class clazz = Class.forName("java.lang.String");
			System.out.println(clazz);
		} catch (ClassNotFoundException e) {
			System.out.println("class를 찾지 못했습니다.");
		}
		
		try {
//			String strNum = "a123";
			String strNum = "123";
			int num = Integer.parseInt(strNum);
			System.out.println(num);
		} catch (Exception e) {//임의로 넣을땐 최상위인 Exception 호출
//			e.printStackTrace();
			System.out.println("변경 못함");
		}

	}// main end

}// class end
