package chap06;

public class StudentExam {
	//필드
	int stuNum;
	String name;
	int kor;
	int eng;
	int math;
	//생성자
	StudentExam(int stuNum,String name,int kor,int eng,int math ){
		this.stuNum=stuNum;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	//메소드
	int sum() {
		return kor+eng+math;
	}
	double avg() {
		double result = (double)sum()/3;
		return result;
	}
	String grade() {
		int avg1=(int)(avg()/10);
		String grade;
		switch(avg1) {
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F"; 
		}
		return grade;
	}
}
