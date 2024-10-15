package chap06;

public class NewCarMain {

	public static void main(String[] args) {
		// 객체 생성
		NewCar myCar = new NewCar();
		
		//필드값 읽기
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색깔 : " + myCar.color);
		System.out.println("최고속도 : " + myCar.getMaxSpeed());
		System.out.println("현재속도 : " + myCar.getSpeed());
		
		//필드값 변경
		myCar.color = "흰색";
		myCar.setSpeed(60);
		System.out.println("수정된 색깔 : " + myCar.color);
		System.out.println("수정된 속도 : " + myCar.getSpeed());
		
		//교재 p279
		myCar.setGas(5);
		
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}else {
			System.out.println("gas를 주입하세요.");
		}
		
		//교재 p284
		myCar.keyTurnOn();
		myCar.run2();
		
		int speed =  myCar.getSpeed();
		System.out.println("현재 속도 : "+speed+"Km/h");
		
		
		//교재 p327
		myCar.setSpeed(-50);
		System.out.println(myCar.getSpeed());
		
		myCar.setSpeed(60);
		if(!myCar.isStop()) { //기본 false, !붙이면 true
			myCar.setStop(true);
		}
		System.out.println(myCar.getSpeed());
	}
}
