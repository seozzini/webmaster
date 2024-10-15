package chap06;

public class NewCar {
	//필드
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	private int maxSpeed = 350;
	private int speed;
	private int gas;
	private boolean gasState;
	private boolean stop;
	
	//생성자
	
	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}

	public boolean isGasState() { //boolean일때는 앞에 is가 붙음
		return gasState;
	}

	public void setGasState(boolean gasState) {
		this.gasState = gasState;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getGas() {
		return gas;
	}

	public void setSpeed(int speed) {
		if(speed<0) {
			this.speed = 0;
			return;
		}
		this.speed = speed;
	}

	//메소드
	void setGas(int gas) {
		this.gas = gas;
	}
	
	int getSpeed() {
		return speed;
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("엥꼬");
			return false;
		}
		System.out.println("gas가 있습니다");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다. (gas잔량: "+gas+")");
				gas--;
			}else {
				System.out.println("멈춥니다. (gas잔량: "+gas+")");
				return; //메소드 실행 종료
			}
		}
	}
	
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	void run2() {
		for(int i=0; i<=50; i += 10) {
			speed = i;
			System.out.println("달립니다. (시속 : "+speed+"km/h)");			
		}
	}
}