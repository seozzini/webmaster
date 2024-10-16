package boards;

import java.util.List;
import java.util.Scanner;

public class BoardMain {
	static Scanner sc = new Scanner(System.in);
	static Member member = null;

	public static void main(String[] args) {

		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("////////////////////        Developer Board       //////////////////////////");
		System.out.println("////////////////////////////////////////////////////////////////////////////");

		while (true) {
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1.회원가입\n2.로그인\n3.종료");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("선택> ");
			String select = sc.nextLine();
			switch (select) {
			case "1":
				processMemberJoin();
				break;
			case "2":
				processLogin();
				break;
			case "3":
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("올바르지 않은 메뉴번호입니다.");
				break;
			}

			if ("3".equals(select)) {
				break;
			}
		}
		sc.close();
	}// end of main

	// 회원가입
	static void processMemberJoin() {
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                               회원가입");
		System.out.println("----------------------------------------------------------------------------");
		MemberDao mdao = MemberDao.getInstance();

		String id = null;
		while (true) {
			System.out.print("아이디>");
			String tempId = sc.nextLine();
			Member mb = mdao.CheckMember(tempId);
			if (mb == null) {
				id = tempId;
				break;
			} else {
				System.out.println("이미 동일 아이디가 사용 중입니다. 다른 아이디를 사용하세요.");
			}
		}
		String pw = null;
		while (true) {
			System.out.print("비밀번호>");
			String firstPw = sc.nextLine();

			System.out.print("비밀번호 확인>");
			String secondPw = sc.nextLine();

			if (firstPw.equals(secondPw)) {
				pw = firstPw;
				break;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println();
			}
		}

		String nickName = null;
		while (true) {
			System.out.print("닉네임>");
			String tempNickName = sc.nextLine();
			if (mdao.checkNickName(tempNickName) < 1) {
				nickName = tempNickName;
				break;
			} else {
				System.out.println("이미 동일 닉네임이 사용 중입니다. 다른 닉네임을 사용하세요.");
				System.out.println();
			}
		}

		System.out.print("이름>");
		String name = sc.nextLine();

		System.out.print("전화번호>");
		String phoneNo = sc.nextLine();

//		System.out.print("권한(1:관리자, 2:사용자)>");	//권한은 default 사용자("2")임.
		String rights = "2";

		Member regMb = new Member(id, pw, nickName, name, phoneNo, null, rights);
		int nrow = mdao.insert(regMb);

		if (nrow == 0) {
			System.out.println("등록이 실패했습니다.");
			System.out.println();
		} else {
			System.out.println("회원 정보가 등록되었습니다.");
			System.out.println();
		}
	}

	// 로그인
	static void processLogin() {
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                               로그인");
		System.out.println("----------------------------------------------------------------------------");
		MemberDao mdao = MemberDao.getInstance();

		while (true) {
			System.out.print("아이디>");
			String tempId = sc.nextLine();
			System.out.print("비밀번호>");
			String tempPw = sc.nextLine();

			Member mb = mdao.CheckMember(tempId);
			if (mb != null) {
				if (tempPw.equals(mb.getPw())) {
					member = mb;
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					System.out.println();
				}
			} else {
				System.out.println("등록된 회원이 없습니다. 아이디와 비밀번호를 다시 입력하세요.");
				System.out.println();
			}
		}
		System.out.println();
		System.out.println(member.getNickName() + "님 환영합니다.");

		while (true) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                               메인페이지");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1.공지사항\n2.인기글(top 5)\n3.회원 게시판\n4.익명 게시판\n5.로그아웃");
			System.out.print("선택>");

			String select = sc.nextLine();
			switch (select) {
			case "1": // 공지사항
				processNotifyBoard();
				break;
			case "2": // 인기글
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                인기글(Top5)");
				System.out.println("----------------------------------------------------------------------------");
				System.out.printf("%-5s|%-11s\t|%-11s\t|%-10s\t|%-3s\n", "글번호", "제목", "닉네임(아이디)", "날짜", "추천");
				BoardDao boardDao = new BoardDao();
				List<Board> list = boardDao.favoriteList();
				if (list == null || list.size() == 0) {
					System.out.println("인기글 목록이 없습니다.");
					System.out.println();
					break;
				}

				for (Board b : list) {
					if ("2".equals(b.getbNo())) {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(), "익명(익명)",
								b.getCreateDate(), b.getRecommendCnt());

					} else {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(),
								b.getWriterNickName() + "(" + b.getWriterId() + ")", b.getCreateDate(),
								b.getRecommendCnt());
					}
				}
				while (true) {
					System.out.println();
					System.out.println("상세 보기할 글번호를 입력하세요.(Ent:메뉴로 이동)");
					System.out.print("선택>");
					System.out.println();

					String selectDetail = sc.nextLine().trim();
					if ("".equals(selectDetail)) {
						break;
					} else {
						String boardKind = null;
						for (Board b : list) {
							if (selectDetail.equals(b.getNo())) {
								boardKind = b.getbNo();
							}
						}
						Board detailBoard = boardDao.select(selectDetail, boardKind);
						if (detailBoard == null) {
							System.out.println("[" + selectDetail + "]번의 게시글이 없습니다.");
							System.out.println();
						} else {
							System.out.println();
							System.out.println("번호  [" + detailBoard.getNo() + "]");
							System.out.println("ID [" + detailBoard.getWriterId() + "]");
							System.out.println("닉네임 [" + detailBoard.getWriterNickName() + "]");
							System.out.println("제목  [" + detailBoard.getTitle() + "]");
							System.out.println("내용  [" + detailBoard.getContent() + "]");
							System.out.println("작성일 [" + detailBoard.getCreateDate() + "]");
							if (detailBoard.getModifyDate() != null) {
								System.out.println("수정일 [" + detailBoard.getModifyDate() + "]");
							}
							if(RecommendsDao.getInstance().rcCnt(member.getId(), detailBoard.getNo()) >0) {
								System.out.println("<당신은 이 글을 추천하고 있습니다.>");
								System.out.println("");
							}else {
								System.out.println("");
								System.out.print("위 글을 추천하시겠습니까?(y:추천/Ent:취소)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							}
						}
					}
				}
				break;
			case "3": // 회원 게시판
				processBoard("1");
				break;
			case "4": // 익명 게시판
				processBoard("2");
				break;
			case "5": // 로그아웃
				break;
			default:
				System.out.println("올바르지 않은 메뉴번호입니다.");
				System.out.println();
				break;
			}
			if ("5".equals(select)) {
				break;
			}
		}
	}

	// 공지사항 보기
	static void processNotifyBoard() {
		String boardKind = "3";
		BoardDao boardDao = new BoardDao();
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                                공지사항");
		System.out.println("----------------------------------------------------------------------------");
		while (true) {
			List<Board> list = boardDao.list(boardKind);
			if (list == null || list.size() == 0) {
				System.out.println("등록된 공지사항이 없습니다.");
				System.out.println();
			} else {
				System.out.printf("%-5s|%-11s\t|%-15s\t|%-10s\t|%-3s\n", "글번호", "제목", "닉네임(아이디)", "날짜", "추천");
				for (Board b : list) {
					System.out.printf("%-6s|%-11s\t|%-15s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(),
							b.getWriterNickName() + "(" + b.getWriterId() + ")", b.getCreateDate(),
							b.getRecommendCnt());
				}
			}

			if ("1".equals(member.getResponsibility())) {
				System.out.println();
				System.out.println("1.공지사항 보기\n2.공지사항 작성\n3.공지사항 수정\n4.공지사항 삭제\n5.돌아가기");
			} else {
				System.out.println();
				System.out.println("1.공지사항 보기\n5.돌아가기");
			}
			System.out.print("선택>");
			String select = sc.nextLine();
			System.out.println();
			switch (select) {
			case "1": // 보기
				while (true) {
					System.out.println("상세 보기할 글번호를 입력하세요.(Ent:메뉴로 이동)");
					System.out.print("선택>");
					String selectDetail = sc.nextLine().trim();
					if ("".equals(selectDetail)) {
						break;
					} else {
						Board detailBoard = boardDao.select(selectDetail, boardKind);
						if (detailBoard == null) {
							System.out.println();
							System.out.println("[" + selectDetail + "]번의 공지 사항이 없습니다.");
						} else {
							System.out.println();
							System.out.println("번호  [" + detailBoard.getNo() + "]");
							System.out.println("ID [" + detailBoard.getWriterId() + "]");
							System.out.println("닉네임 [" + detailBoard.getWriterNickName() + "]");
							System.out.println("제목  [" + detailBoard.getTitle() + "]");
							System.out.println("내용  [" + detailBoard.getContent() + "]");
							System.out.println("작성일 [" + detailBoard.getCreateDate() + "]");
							if (detailBoard.getModifyDate() != null) {
								System.out.println("수정일 [" + detailBoard.getModifyDate() + "]");
							}
							
							
							if(RecommendsDao.getInstance().rcCnt(member.getId(), detailBoard.getNo()) >0) {
								System.out.println("<당신은 이 글을 추천하고 있습니다.>");
								System.out.println("");
							}else {
								System.out.println("");
								System.out.print("위 글을 추천하시겠습니까?(y:추천/Ent:취소)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							}
/*
							if (detailBoard.getRecommendCnt() == 0) {
								System.out.println("");
								System.out.print("위 글을 추천하시겠습니까?(y:추천/Ent:취소)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							} else {
								System.out.println("<당신은 이 글을 추천하고 있습니다.>");
								System.out.println("");
							}*/
						}
					}
				}
				break;
			case "2": // 작성
				if ("1".equals(member.getResponsibility()) == false) {
					System.out.println("시스템 관리자가 접근할 수 있는 메뉴입니다.");
					break;
				}
				System.out.print("공지사항 제목>");
				String title = sc.nextLine();
				System.out.print("공지사항 내용>");
				String content = sc.nextLine();
				Board board = new Board(null, member.getId(), member.getNickName(), title, content, null, null,
						boardKind, 0);
				int istRow = boardDao.insert(board);
				if (istRow > 0) {
					System.out.println("공지 사항이 등록되었습니다.");
				} else {
					System.out.println("공지 사항이 등록되지 않았습니다.");
				}
				break;
			case "3": // 수정
				if ("1".equals(member.getResponsibility()) == false) {
					System.out.println("시스템 관리자가 접근할 수 있는 메뉴입니다.");
					break;
				}
				System.out.print("공지사항 번호>");
				String uptNo = sc.nextLine();
				Board uptBoard = boardDao.select(uptNo, boardKind);
				if (uptBoard == null) {
					System.out.println("입력하신 번호로 등록된 공지사항이 없습니다.");
				} else {
					if ("2".equals(member.getResponsibility())
							&& member.getId().equals(uptBoard.getWriterId()) == false) {
						System.out.println("해당 글을 수정할 수 없습니다. 글 수정은 작성자가 할 수 있습니다.");
						break;
					}
					System.out.println("제목:" + uptBoard.getTitle());
					System.out.println("내용:" + uptBoard.getContent());

					System.out.print("수정할 제목을 입력하세요(Ent:취소)>");
					String uptTitle = sc.nextLine();
					if ("".equals(uptTitle) == false) {
						uptBoard.setTitle(uptTitle);
					}
					System.out.print("수정할 내용을 입력하세요(Ent:취소)>");
					String uptContent = sc.nextLine();
					if ("".equals(uptContent) == false) {
						uptBoard.setContent(uptContent);
					}
					if ("".equals(uptTitle) && "".equals(uptContent)) {
						System.out.println("수정 내용이 없습니다.");
						System.out.println();
					} else {
						int uptRow = boardDao.update(uptBoard);
						if (uptRow > 0) {
							System.out.println("[" + uptNo + "]번 공지 사항이 수정되었습니다.");
						} else {
							System.out.println("공지 사항이 수정되지 않았습니다.");
						}
						System.out.println();
					}
				}
				break;
			case "4": // 삭제
				if ("1".equals(member.getResponsibility()) == false) {
					System.out.println("시스템 관리자가 접근할 수 있는 메뉴입니다.");
					break;
				}
				System.out.print("공지사항 번호>");
				String delNo = sc.nextLine();
				int delRow = boardDao.delete(delNo, boardKind);
				if (delRow > 0) {
					System.out.println("[" + delNo + "]번 공지 사항이 삭제되었습니다.");
				} else {
					System.out.println("공지 사항이 삭제되지 않았습니다.");
				}
				break;
			case "5": // 돌아가기
				break;
			default:
				System.out.println("올바르지 않은 메뉴번호입니다.");
				break;
			}
			if ("5".equals(select)) {
				break;
			}
		}
	}

	// 게시판보기 (1.회원게시판 | 2.익명게시판 )
	static void processBoard(String boardKind) {
		String strBoardKind = null;
		if ("1".equals(boardKind)) {
			strBoardKind = "회원게시판";
		} else {
			strBoardKind = "익명게시판";
		}
		BoardDao boardDao = new BoardDao();

		while (true) {
			List<Board> list = boardDao.list(boardKind);
			if (list == null || list.size() == 0) {
				System.out.println("등록된 게시글이 없습니다.");
			}

			else {
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                " + strBoardKind);
				System.out.println("----------------------------------------------------------------------------");
				System.out.printf("%-5s|%-11s\t|%-11s\t|%-10s\t|%-3s\n", "글번호", "제목", "닉네임(아이디)", "날짜", "추천");
				for (Board b : list) {
					if ("1".equals(boardKind)) {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(),
								b.getWriterNickName() + "(" + b.getWriterId() + ")", b.getCreateDate(),
								b.getRecommendCnt());
					} else {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(), "익명(익명)",
								b.getCreateDate(), b.getRecommendCnt());
					}
				}
			}
			System.out.println();
			System.out.println("1.상세 보기 2.내용 작성 3.내용 수정 4.내용 삭제 5.돌아가기");
			System.out.print("선택>");
			String select = sc.nextLine();
			switch (select) {
			case "1": // 보기
				while (true) {
					System.out.println();
					System.out.println("상세 보기할 글번호를 입력하세요.(Ent:취소)");
					System.out.print("선택>");

					String selectDetail = sc.nextLine().trim();
					if ("".equals(selectDetail)) {
						break;
					} else {
						Board detailBoard = boardDao.select(selectDetail, boardKind);
						if (detailBoard == null) {
							System.out.println();
							System.out.println("[" + selectDetail + "]번의 게시글이 없습니다.");
						} else {
							System.out.println();
							System.out.println("번호  [" + detailBoard.getNo() + "]");
							if ("1".equals(boardKind)) {
								System.out.println("ID [" + detailBoard.getWriterId() + "]");
								System.out.println("닉네임 [" + detailBoard.getWriterNickName() + "]");
							} else {
								System.out.println();
								System.out.println("작성자 [익명]");
							}
							System.out.println("제목  [" + detailBoard.getTitle() + "]");
							System.out.println("내용  [" + detailBoard.getContent() + "]");
							System.out.println("작성일 [" + detailBoard.getCreateDate() + "]");
							if (detailBoard.getModifyDate() != null) {
								System.out.println("수정일 [" + detailBoard.getModifyDate() + "]");
							}

							/*
							System.out.println(member.getId());
							System.out.println(detailBoard.getNo());
							*/
							
							if(RecommendsDao.getInstance().rcCnt(member.getId(), detailBoard.getNo()) >0) {
								System.out.println("<당신은 이 글을 추천하고 있습니다.>");
								System.out.println("");
							}else {
								System.out.println("");
								System.out.print("위 글을 추천하시겠습니까?(y:추천/Ent:취소)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							}
							
							/*
							if (detailBoard.getRecommendCnt() == 0) {
								System.out.println("");
								System.out.print("위 글을 추천하시겠습니까?(y:추천/Ent:취소)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							} else {
								System.out.println("<당신은 이 글을 추천하고 있습니다.>");
								System.out.println("");
							}*/
						}
					}
				}
				break;
			case "2": // 작성
				System.out.print("게시글 제목>");
				String title = sc.nextLine();
				System.out.print("게시글 내용>");
				String content = sc.nextLine();
				Board board = null;
				if ("1".equals(boardKind)) {
					board = new Board(null, member.getId(), member.getNickName(), title, content, null, null, boardKind,
							0);
				} else {
					board = new Board(null, member.getId(), member.getNickName(), title, content, null, null, boardKind,
							0);
				}
				int istRow = boardDao.insert(board);
				if (istRow > 0) {
					System.out.println("게시글이 등록되었습니다.");
				} else {
					System.out.println("게시글이 등록되지 않았습니다.");
				}
				break;
			case "3": // 수정
				System.out.print("게시글 번호>");
				String uptNo = sc.nextLine();
				Board uptBoard = boardDao.select(uptNo, boardKind);
				if (uptBoard == null) {
					System.out.println("입력하신 번호로 등록된 게시글이 없습니다.");
				} else {
					if (member.getId().equals(uptBoard.getWriterId()) == false) {
						System.out.println("작성자가 다릅니다. 본인이 작성한 게시글만 수정 가능합니다.");
						break;
					}

					System.out.println("제목:" + uptBoard.getTitle());
					System.out.println("내용:" + uptBoard.getContent());

					System.out.print("수정할 제목을 입력하세요(Ent:취소)>");
					String uptTitle = sc.nextLine();
					if ("".equals(uptTitle) == false) {
						uptBoard.setTitle(uptTitle);
					}
					System.out.print("수정할 내용을 입력하세요(Ent:취소)>");
					String uptContent = sc.nextLine();
					if ("".equals(uptContent) == false) {
						uptBoard.setContent(uptContent);
					}
					if ("".equals(uptTitle) && "".equals(uptContent)) {
						System.out.println("수정 내용이 없습니다.");
					} else {
						int uptRow = boardDao.update(uptBoard);
						if (uptRow > 0) {
							System.out.println("[" + uptNo + "]번 게시글이 수정되었습니다.");
						} else {
							System.out.println("게시글이 수정되지 않았습니다.");
						}
					}
				}
				break;
			case "4": // 삭제
				System.out.print("게시글 번호>");
				String delNo = sc.nextLine();
				Board delBoard = boardDao.select(delNo, boardKind);
				if (delBoard == null) {
					System.out.println("삭제 가능한 게시글이 없습니다.");
					break;
				}

				if ("1".equals(member.getResponsibility()) == false
						&& member.getId().equals(delBoard.getWriterId()) == false) {
					System.out.println("작성자가 다릅니다. 본인이 작성한 게시글만 삭제 가능합니다.");
					break;
				}

				int delRow = boardDao.delete(delNo, boardKind);
				if (delRow > 0) {
					System.out.println("[" + delNo + "]번 게시글이 삭제되었습니다.");
				} else {
					System.out.println("게시글이 삭제되지 않았습니다.");
				}
				break;
			case "5": // 돌아가기
				System.out.println();
				break;
			default:
				System.out.println("올바르지 않은 메뉴번호입니다.");
				break;
			}
			if ("5".equals(select)) {
				break;
			}
		}
	}

}