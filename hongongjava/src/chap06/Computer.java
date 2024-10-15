package chap06;

public class Computer { // 교재 p.275
	// 필드

	// 생성자

	// 메소드
	int sum1(int[] values) { // 리턴타입은 int, sum1이라는 이름의 메소드,메소드 매개변수를 배열로 선언
		int sum = 0;
		for (int i = 0; i < values.length; i++) { // 0번방부터 배열의 길이-1까지 index++
			sum += values[i]; // 변수 sum 에 0부터 끝까지 더해서 넣음
		}
		return sum; // 리턴문 안적으면 계속 빨간줄
	}

	int sum2(int... values) { // ...은 펼침연산자로 배열,값 목록을 받아서 배열로 리턴
		int sum = 0;
		for (int num : values) { // 향상된 for문: num은 배열인덱스가 아니라 값임. 단순히 값을 가져와서 쓸때는 이거씀
			sum += num;
		}
		return sum;
	}

}
