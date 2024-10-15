package chap06;

public class StudentExamMain {

	public static void main(String[] args) {
		// 객체 생성
		/* 교수님 답안
		 Student[] students = new Student[5]
		 
		 students[0]=new Student("홍길동",80,90,88);
		 students[1]=new Student("성춘향",100,87,99);
		 students[2]=new Student("이몽룡",60,70,80);
		 students[3]=new Student("아무개",30,50,66);
		 students[4]=new Student("거시기",100,100,100);
		 
		 Student[] student ={
		 new Student("홍길동",80,90,88),
		 new Student("성춘향",100,87,99),
		 new Student("이몽룡",60,70,80),
		 new Student("아무개",30,50,66),
		 new Student("거시기",100,100,100),
		 }
		 
		 for(Student student : students){
		 System.out.printf("%s : %4d : %4d : %4d : %4d : %6.2f : %s\n"
		 				, student.name, student.kor, student.eng, student.math, student.sum(),student.avg(),student.grade());
		 */
		String[] stuArr = {
				"배서진","박주현","표하연","김민진","권나윤" 
		};
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t");
		for(int i=0;i<5;i++) {
			int kor=(int)(Math.random()*100);
			int eng=(int)(Math.random()*100);
			int math=(int)(Math.random()*100);
			StudentExam stu1 = new StudentExam(i+1, stuArr[i], kor, eng, math);	
			
			
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",
					stu1.stuNum,stu1.name,stu1.kor,stu1.eng,stu1.math,stu1.sum(),stu1.avg(),stu1.grade());
		}
		
		
		/*
		StudentExam stu1 = new StudentExam(240927, "홍길동", 80, 90, 88);
		StudentExam stu2 = new StudentExam(240928, "성춘향", 100, 87, 99);
		StudentExam stu3 = new StudentExam(240929, "이몽룡", 60, 70, 80);
		StudentExam stu4 = new StudentExam(240930, "아무개", 30, 50, 66);
		StudentExam stu5 = new StudentExam(241001, "거시기", 100, 100, 300);
		
		System.out.printf("%s : %d : %d : %d : %d : %.2f : %s",
				stu1.name,stu1.kor,stu1.eng,stu1.math,stu1.sum(),stu1.avg(),stu1.grade());
				*/
	}//main end

}//class end
