package chap06;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		boolean run = true;
		Book[] books = null;//배열변수 초기화
		int bookCnt = 0;
		Scanner sc = new Scanner(System.in);
		

		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.print("1. 도서 수 | ");
			System.out.print("2. 도서 입력 |");
			System.out.print("3. 도서 목록 |");
			System.out.print("4. 도서 분석 |");
			System.out.println("5. 종료");
			System.out.println("-----------------------------------------------------");

			int selNo = sc.nextInt();
			sc.nextLine();
			switch (selNo) {
			case 1:
				System.out.print("도서 수 >");
				bookCnt = sc.nextInt();
				sc.nextLine();
				books = new Book[bookCnt];
				break;
			case 2:
				for (int i = 0; i < bookCnt; i++) {
					System.out.print((i + 1) + "번째 도서 입력\n");
					System.out.print("도서 제목 >");
					String bookTitle = sc.nextLine();
					
					System.out.print("도서 번호 >");
					String bookNum = sc.nextLine();
					
					System.out.print("도서 가격 >");
					int bookPrice = sc.nextInt();
					sc.nextLine();

					books[i] = new Book(bookTitle, bookNum, bookPrice);
				}
				break;
			case 3:
				for (Book book : books) {
					System.out.printf("%s\t%s\t%d\n", book.getBookNum(), book.getBookTitle(), book.getBookPrice());
				}
				break;
			case 4:
				int sum = 0;
				String title = null;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				
				for (Book book : books) {
					int p = book.getBookPrice();
					sum += p; // 합
					if (max < p) {
						max = p; // 최대값
						title = book.getBookTitle();
					}
					if (min > p) {
						min = p; // 최소값
					}
				}
				System.out.printf("합 = %d, 최대 가격 = %d, 최소 가격 = %d\n", sum, max, min);
				System.out.println("가장 비싼 책 :" + title);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");

			}// switch end
		} // while end

		sc.close();
		System.out.println("프로그램 종료");

	}// main end

}// class end
