package 배서진;

import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selNo = 0;
		int num = 0;
		String accNo="";

		// 객체 생성
		Account[] accArr = new Account[100];
		boolean run = true;
		while (run) {

			System.out.println("------------------------------------------------");
			System.out.print("1.계좌 생성 | ");
			System.out.print("2.계좌 목록 | ");
			System.out.print("3.예금 | ");
			System.out.print("4.출금 | ");
			System.out.println("5.종료");
			System.out.println("------------------------------------------------");

			System.out.print("선택> ");
			selNo = sc.nextInt();
			sc.nextLine();
			
			switch (selNo) {
			case 1:
				System.out.println("---------");
				System.out.println("계좌생성");
				System.out.println("---------");
				
				System.out.print("계좌번호: ");
				String ano = sc.nextLine();
				System.out.print("계좌주: ");
				String owner = sc.nextLine();
				System.out.print("초기입금액: ");
				int balance = sc.nextInt();
				sc.nextLine();

				for (int i = num; i < accArr.length; i++) {
					if (accArr[i] == null) {
						accArr[i] = new Account(ano, owner, balance);
						System.out.println("결과: 계좌가 생성되었습니다.");
						num = i;
						break;
					} // if
				} // for-i
				break;

			case 2:
				System.out.println("---------");
				System.out.println("계좌목록");
				System.out.println("---------");
				
				for (Account ele : accArr) {
					if (ele != null) {
						System.out.printf("%s\t%s\t%d", ele.getAno(), ele.getOwner(), ele.getBalance());
						System.out.println();
					}//for
				}//if
				break;
				
			case 3:
				System.out.println("---------");
				System.out.println("예금");
				System.out.println("---------");
				
				System.out.print("계좌번호: ");
				accNo=sc.nextLine();
				System.out.print("예금액: ");
				int inMoney = Integer.parseInt(sc.nextLine());	
				
				for(Account ele:accArr) {
					if(ele.getAno().equals(accNo)) {
						ele.setBalance((ele.getBalance()+inMoney));
						break;
					}
					System.out.println();
				}
				
				break;
			case 4:
				System.out.println("-----");
				System.out.println("예금");
				System.out.println("-----");
				
				System.out.print("계좌번호> ");
				accNo = sc.nextLine();
				
				System.out.print("출금액> ");
				int outMoney = Integer.parseInt(sc.nextLine());	
				
				for(Account ele:accArr) {
					if(ele.getAno().equals(accNo)) {
						ele.setBalance((ele.getBalance()-outMoney));
						break;
					}
					System.out.println();
				}
				
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("잘못된 번호입니다.");


			}// switch end
		} // while end
		System.out.println("program end");
		sc.close();
	}// main end

}// class end
