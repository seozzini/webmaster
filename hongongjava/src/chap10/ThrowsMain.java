package chap10;

public class ThrowsMain {

	public static void main(String[] args){
		// 예외 떠넘기기
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("class 찾지 못함");
		}

	}

	private static void findClass() throws ClassNotFoundException { //떠넘길 수는 있는데 main 까지는 넘기지 말고 try/catch 해주기
		Class clazz = Class.forName("java.lang.Strig2");
		
	}

}
