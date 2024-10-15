package 도서관리;

import java.util.Scanner;

public class BookMain {
	static Scanner sc = new Scanner(System.in);
	//MemberDao mdao = new MemberDao();
	static MemberDao mdao = MemberDao.getInstance(); //싱글턴방식
	static Member member = new Member(); //싱글턴방식
			
	public static void main(String[] args) {
	
		while(true) {
			System.out.print("아이디> ");
			String id = sc.nextLine();
			System.out.print("비밀번호> ");
			String pw = sc.nextLine();
			member = mdao.CheckMember(id, pw);
			
			if(member != null) {
				System.out.println(member.getMemberName()+"님 환영합니당");
				break;
			}else {
				System.out.println("일치하는 정보가 없습니다.");
			}
		}//end of 로그인체크
		
		//권한이 User => 도서관리 처리
		//권한이 Admin => 회원관리 처리
		if(member.getResponsibility().equals("User")) {
			bookManage();
		}else if(member.getResponsibility().equals("Admin")) {
//			memberManage();
		}
		
	}//end of main
	
	static void bookManage() { //도서관리
		BookDao dao = null;
		dao = new BookDao();
		boolean run = true;
		int cnt = 0;
		
		while(run) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서전체 조회 | 4.도서삭제 | 5.도서 정보 변경 | 6.프로그램 종료");
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("▶ 번호 선택 : ");
			int temp = sc.nextInt();
			sc.nextLine();
			
			switch(temp) {
				case 1:				
					
					System.out.print("도서명> ");
					String title = sc.nextLine();
					
					System.out.print("저자명> ");
					String writer = sc.nextLine();
					
					System.out.print("도서 가격> ");
					int price = Integer.parseInt(sc.nextLine());
					
					System.out.print("도서번호> ");
					String bnum = sc.nextLine();
					
					Book book = new Book(title, writer, price, bnum);
					cnt = dao.insert(book);
					
					if(cnt == 1) {
						System.out.println("추가 성공");
					}else {
						System.out.println("추가 실패");
					}
					
					System.out.println("결과 : 도서가 등록되었습니다.");
					break;
					
				case 2:		
					
					System.out.print("검색할 도서명> ");
					title = sc.nextLine();
					
					dao.select(title);
					/*
					Search search = new Search();
					search.setTitle(title);
					
					List<Book> list = dao.bookList(search);
					for(Book bk : list) {
						System.out.println(bk.toString());
					}
					*/
					break;
					
				case 3:				
					
					dao.list();
					break;
					
				case 4:
					
					System.out.print("삭제할 도서명> ");
					title = sc.nextLine();
					
					cnt = dao.delete(title);
					
					if(cnt == 1) {
						System.out.println("삭제 성공");
					}else {
						System.out.println("삭제 실패");
					}
					System.out.println("결과 : 도서가 삭제되었습니다.");
					break;
					
				case 5:
					
					System.out.print("변경대상 도서의 책번호> ");
					bnum = sc.nextLine();
					
					System.out.print("변경할 도서명> ");
					title = sc.nextLine();
					
					System.out.print("변경할 도서의 가격> ");
					price = Integer.parseInt(sc.nextLine());
					
					cnt = dao.update(bnum, title, price);
					
					if(cnt > 0) {
						System.out.println("수정 성공");
					}else {
						System.out.println("수정 실패");
					}
					System.out.println("결과 : 도서가 수정되었습니다.");
					break;
				
				case 6:
					run = false;
					sc.close();
					System.out.println("program end");
					
				default:
					System.out.println("잘못된 값이 입력되었습니다.");
			}
		}//end of while	
		
	}
	
	/*
	
	static void memberManage() { //회원관리
		boolean  = true;
		
		while(run) {
			
		}
		System.out.println("관리자 메뉴입니도오옹");
		List<Member> list = mdao.memberList();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("                                           회원목록");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("아이디\t| 비밀번호\t\t| 이름\t| 연락처\t\t| 등급\t| 생성일");
		for(Member member:list) {
			System.out.println(member.toString());
		}
		
	}
	
	*/
	
}
