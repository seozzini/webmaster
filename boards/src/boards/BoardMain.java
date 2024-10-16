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
			System.out.println("1.ȸ������\n2.�α���\n3.����");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("����> ");
			String select = sc.nextLine();
			switch (select) {
			case "1":
				processMemberJoin();
				break;
			case "2":
				processLogin();
				break;
			case "3":
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�ùٸ��� ���� �޴���ȣ�Դϴ�.");
				break;
			}

			if ("3".equals(select)) {
				break;
			}
		}
		sc.close();
	}// end of main

	// ȸ������
	static void processMemberJoin() {
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                               ȸ������");
		System.out.println("----------------------------------------------------------------------------");
		MemberDao mdao = MemberDao.getInstance();

		String id = null;
		while (true) {
			System.out.print("���̵�>");
			String tempId = sc.nextLine();
			Member mb = mdao.CheckMember(tempId);
			if (mb == null) {
				id = tempId;
				break;
			} else {
				System.out.println("�̹� ���� ���̵� ��� ���Դϴ�. �ٸ� ���̵� ����ϼ���.");
			}
		}
		String pw = null;
		while (true) {
			System.out.print("��й�ȣ>");
			String firstPw = sc.nextLine();

			System.out.print("��й�ȣ Ȯ��>");
			String secondPw = sc.nextLine();

			if (firstPw.equals(secondPw)) {
				pw = firstPw;
				break;
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
				System.out.println();
			}
		}

		String nickName = null;
		while (true) {
			System.out.print("�г���>");
			String tempNickName = sc.nextLine();
			if (mdao.checkNickName(tempNickName) < 1) {
				nickName = tempNickName;
				break;
			} else {
				System.out.println("�̹� ���� �г����� ��� ���Դϴ�. �ٸ� �г����� ����ϼ���.");
				System.out.println();
			}
		}

		System.out.print("�̸�>");
		String name = sc.nextLine();

		System.out.print("��ȭ��ȣ>");
		String phoneNo = sc.nextLine();

//		System.out.print("����(1:������, 2:�����)>");	//������ default �����("2")��.
		String rights = "2";

		Member regMb = new Member(id, pw, nickName, name, phoneNo, null, rights);
		int nrow = mdao.insert(regMb);

		if (nrow == 0) {
			System.out.println("����� �����߽��ϴ�.");
			System.out.println();
		} else {
			System.out.println("ȸ�� ������ ��ϵǾ����ϴ�.");
			System.out.println();
		}
	}

	// �α���
	static void processLogin() {
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                               �α���");
		System.out.println("----------------------------------------------------------------------------");
		MemberDao mdao = MemberDao.getInstance();

		while (true) {
			System.out.print("���̵�>");
			String tempId = sc.nextLine();
			System.out.print("��й�ȣ>");
			String tempPw = sc.nextLine();

			Member mb = mdao.CheckMember(tempId);
			if (mb != null) {
				if (tempPw.equals(mb.getPw())) {
					member = mb;
					break;
				} else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					System.out.println();
				}
			} else {
				System.out.println("��ϵ� ȸ���� �����ϴ�. ���̵�� ��й�ȣ�� �ٽ� �Է��ϼ���.");
				System.out.println();
			}
		}
		System.out.println();
		System.out.println(member.getNickName() + "�� ȯ���մϴ�.");

		while (true) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                               ����������");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1.��������\n2.�α��(top 5)\n3.ȸ�� �Խ���\n4.�͸� �Խ���\n5.�α׾ƿ�");
			System.out.print("����>");

			String select = sc.nextLine();
			switch (select) {
			case "1": // ��������
				processNotifyBoard();
				break;
			case "2": // �α��
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                �α��(Top5)");
				System.out.println("----------------------------------------------------------------------------");
				System.out.printf("%-5s|%-11s\t|%-11s\t|%-10s\t|%-3s\n", "�۹�ȣ", "����", "�г���(���̵�)", "��¥", "��õ");
				BoardDao boardDao = new BoardDao();
				List<Board> list = boardDao.favoriteList();
				if (list == null || list.size() == 0) {
					System.out.println("�α�� ����� �����ϴ�.");
					System.out.println();
					break;
				}

				for (Board b : list) {
					if ("2".equals(b.getbNo())) {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(), "�͸�(�͸�)",
								b.getCreateDate(), b.getRecommendCnt());

					} else {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(),
								b.getWriterNickName() + "(" + b.getWriterId() + ")", b.getCreateDate(),
								b.getRecommendCnt());
					}
				}
				while (true) {
					System.out.println();
					System.out.println("�� ������ �۹�ȣ�� �Է��ϼ���.(Ent:�޴��� �̵�)");
					System.out.print("����>");
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
							System.out.println("[" + selectDetail + "]���� �Խñ��� �����ϴ�.");
							System.out.println();
						} else {
							System.out.println();
							System.out.println("��ȣ  [" + detailBoard.getNo() + "]");
							System.out.println("ID [" + detailBoard.getWriterId() + "]");
							System.out.println("�г��� [" + detailBoard.getWriterNickName() + "]");
							System.out.println("����  [" + detailBoard.getTitle() + "]");
							System.out.println("����  [" + detailBoard.getContent() + "]");
							System.out.println("�ۼ��� [" + detailBoard.getCreateDate() + "]");
							if (detailBoard.getModifyDate() != null) {
								System.out.println("������ [" + detailBoard.getModifyDate() + "]");
							}
							if(RecommendsDao.getInstance().rcCnt(member.getId(), detailBoard.getNo()) >0) {
								System.out.println("<����� �� ���� ��õ�ϰ� �ֽ��ϴ�.>");
								System.out.println("");
							}else {
								System.out.println("");
								System.out.print("�� ���� ��õ�Ͻðڽ��ϱ�?(y:��õ/Ent:���)>");
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
			case "3": // ȸ�� �Խ���
				processBoard("1");
				break;
			case "4": // �͸� �Խ���
				processBoard("2");
				break;
			case "5": // �α׾ƿ�
				break;
			default:
				System.out.println("�ùٸ��� ���� �޴���ȣ�Դϴ�.");
				System.out.println();
				break;
			}
			if ("5".equals(select)) {
				break;
			}
		}
	}

	// �������� ����
	static void processNotifyBoard() {
		String boardKind = "3";
		BoardDao boardDao = new BoardDao();
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                                ��������");
		System.out.println("----------------------------------------------------------------------------");
		while (true) {
			List<Board> list = boardDao.list(boardKind);
			if (list == null || list.size() == 0) {
				System.out.println("��ϵ� ���������� �����ϴ�.");
				System.out.println();
			} else {
				System.out.printf("%-5s|%-11s\t|%-15s\t|%-10s\t|%-3s\n", "�۹�ȣ", "����", "�г���(���̵�)", "��¥", "��õ");
				for (Board b : list) {
					System.out.printf("%-6s|%-11s\t|%-15s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(),
							b.getWriterNickName() + "(" + b.getWriterId() + ")", b.getCreateDate(),
							b.getRecommendCnt());
				}
			}

			if ("1".equals(member.getResponsibility())) {
				System.out.println();
				System.out.println("1.�������� ����\n2.�������� �ۼ�\n3.�������� ����\n4.�������� ����\n5.���ư���");
			} else {
				System.out.println();
				System.out.println("1.�������� ����\n5.���ư���");
			}
			System.out.print("����>");
			String select = sc.nextLine();
			System.out.println();
			switch (select) {
			case "1": // ����
				while (true) {
					System.out.println("�� ������ �۹�ȣ�� �Է��ϼ���.(Ent:�޴��� �̵�)");
					System.out.print("����>");
					String selectDetail = sc.nextLine().trim();
					if ("".equals(selectDetail)) {
						break;
					} else {
						Board detailBoard = boardDao.select(selectDetail, boardKind);
						if (detailBoard == null) {
							System.out.println();
							System.out.println("[" + selectDetail + "]���� ���� ������ �����ϴ�.");
						} else {
							System.out.println();
							System.out.println("��ȣ  [" + detailBoard.getNo() + "]");
							System.out.println("ID [" + detailBoard.getWriterId() + "]");
							System.out.println("�г��� [" + detailBoard.getWriterNickName() + "]");
							System.out.println("����  [" + detailBoard.getTitle() + "]");
							System.out.println("����  [" + detailBoard.getContent() + "]");
							System.out.println("�ۼ��� [" + detailBoard.getCreateDate() + "]");
							if (detailBoard.getModifyDate() != null) {
								System.out.println("������ [" + detailBoard.getModifyDate() + "]");
							}
							
							
							if(RecommendsDao.getInstance().rcCnt(member.getId(), detailBoard.getNo()) >0) {
								System.out.println("<����� �� ���� ��õ�ϰ� �ֽ��ϴ�.>");
								System.out.println("");
							}else {
								System.out.println("");
								System.out.print("�� ���� ��õ�Ͻðڽ��ϱ�?(y:��õ/Ent:���)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							}
/*
							if (detailBoard.getRecommendCnt() == 0) {
								System.out.println("");
								System.out.print("�� ���� ��õ�Ͻðڽ��ϱ�?(y:��õ/Ent:���)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							} else {
								System.out.println("<����� �� ���� ��õ�ϰ� �ֽ��ϴ�.>");
								System.out.println("");
							}*/
						}
					}
				}
				break;
			case "2": // �ۼ�
				if ("1".equals(member.getResponsibility()) == false) {
					System.out.println("�ý��� �����ڰ� ������ �� �ִ� �޴��Դϴ�.");
					break;
				}
				System.out.print("�������� ����>");
				String title = sc.nextLine();
				System.out.print("�������� ����>");
				String content = sc.nextLine();
				Board board = new Board(null, member.getId(), member.getNickName(), title, content, null, null,
						boardKind, 0);
				int istRow = boardDao.insert(board);
				if (istRow > 0) {
					System.out.println("���� ������ ��ϵǾ����ϴ�.");
				} else {
					System.out.println("���� ������ ��ϵ��� �ʾҽ��ϴ�.");
				}
				break;
			case "3": // ����
				if ("1".equals(member.getResponsibility()) == false) {
					System.out.println("�ý��� �����ڰ� ������ �� �ִ� �޴��Դϴ�.");
					break;
				}
				System.out.print("�������� ��ȣ>");
				String uptNo = sc.nextLine();
				Board uptBoard = boardDao.select(uptNo, boardKind);
				if (uptBoard == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� ���������� �����ϴ�.");
				} else {
					if ("2".equals(member.getResponsibility())
							&& member.getId().equals(uptBoard.getWriterId()) == false) {
						System.out.println("�ش� ���� ������ �� �����ϴ�. �� ������ �ۼ��ڰ� �� �� �ֽ��ϴ�.");
						break;
					}
					System.out.println("����:" + uptBoard.getTitle());
					System.out.println("����:" + uptBoard.getContent());

					System.out.print("������ ������ �Է��ϼ���(Ent:���)>");
					String uptTitle = sc.nextLine();
					if ("".equals(uptTitle) == false) {
						uptBoard.setTitle(uptTitle);
					}
					System.out.print("������ ������ �Է��ϼ���(Ent:���)>");
					String uptContent = sc.nextLine();
					if ("".equals(uptContent) == false) {
						uptBoard.setContent(uptContent);
					}
					if ("".equals(uptTitle) && "".equals(uptContent)) {
						System.out.println("���� ������ �����ϴ�.");
						System.out.println();
					} else {
						int uptRow = boardDao.update(uptBoard);
						if (uptRow > 0) {
							System.out.println("[" + uptNo + "]�� ���� ������ �����Ǿ����ϴ�.");
						} else {
							System.out.println("���� ������ �������� �ʾҽ��ϴ�.");
						}
						System.out.println();
					}
				}
				break;
			case "4": // ����
				if ("1".equals(member.getResponsibility()) == false) {
					System.out.println("�ý��� �����ڰ� ������ �� �ִ� �޴��Դϴ�.");
					break;
				}
				System.out.print("�������� ��ȣ>");
				String delNo = sc.nextLine();
				int delRow = boardDao.delete(delNo, boardKind);
				if (delRow > 0) {
					System.out.println("[" + delNo + "]�� ���� ������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���� ������ �������� �ʾҽ��ϴ�.");
				}
				break;
			case "5": // ���ư���
				break;
			default:
				System.out.println("�ùٸ��� ���� �޴���ȣ�Դϴ�.");
				break;
			}
			if ("5".equals(select)) {
				break;
			}
		}
	}

	// �Խ��Ǻ��� (1.ȸ���Խ��� | 2.�͸�Խ��� )
	static void processBoard(String boardKind) {
		String strBoardKind = null;
		if ("1".equals(boardKind)) {
			strBoardKind = "ȸ���Խ���";
		} else {
			strBoardKind = "�͸�Խ���";
		}
		BoardDao boardDao = new BoardDao();

		while (true) {
			List<Board> list = boardDao.list(boardKind);
			if (list == null || list.size() == 0) {
				System.out.println("��ϵ� �Խñ��� �����ϴ�.");
			}

			else {
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                " + strBoardKind);
				System.out.println("----------------------------------------------------------------------------");
				System.out.printf("%-5s|%-11s\t|%-11s\t|%-10s\t|%-3s\n", "�۹�ȣ", "����", "�г���(���̵�)", "��¥", "��õ");
				for (Board b : list) {
					if ("1".equals(boardKind)) {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(),
								b.getWriterNickName() + "(" + b.getWriterId() + ")", b.getCreateDate(),
								b.getRecommendCnt());
					} else {
						System.out.printf("%-6s|%-11s\t|%-11s\t|%-10s\t|%-4s\n", b.getNo(), b.getTitle(), "�͸�(�͸�)",
								b.getCreateDate(), b.getRecommendCnt());
					}
				}
			}
			System.out.println();
			System.out.println("1.�� ���� 2.���� �ۼ� 3.���� ���� 4.���� ���� 5.���ư���");
			System.out.print("����>");
			String select = sc.nextLine();
			switch (select) {
			case "1": // ����
				while (true) {
					System.out.println();
					System.out.println("�� ������ �۹�ȣ�� �Է��ϼ���.(Ent:���)");
					System.out.print("����>");

					String selectDetail = sc.nextLine().trim();
					if ("".equals(selectDetail)) {
						break;
					} else {
						Board detailBoard = boardDao.select(selectDetail, boardKind);
						if (detailBoard == null) {
							System.out.println();
							System.out.println("[" + selectDetail + "]���� �Խñ��� �����ϴ�.");
						} else {
							System.out.println();
							System.out.println("��ȣ  [" + detailBoard.getNo() + "]");
							if ("1".equals(boardKind)) {
								System.out.println("ID [" + detailBoard.getWriterId() + "]");
								System.out.println("�г��� [" + detailBoard.getWriterNickName() + "]");
							} else {
								System.out.println();
								System.out.println("�ۼ��� [�͸�]");
							}
							System.out.println("����  [" + detailBoard.getTitle() + "]");
							System.out.println("����  [" + detailBoard.getContent() + "]");
							System.out.println("�ۼ��� [" + detailBoard.getCreateDate() + "]");
							if (detailBoard.getModifyDate() != null) {
								System.out.println("������ [" + detailBoard.getModifyDate() + "]");
							}

							/*
							System.out.println(member.getId());
							System.out.println(detailBoard.getNo());
							*/
							
							if(RecommendsDao.getInstance().rcCnt(member.getId(), detailBoard.getNo()) >0) {
								System.out.println("<����� �� ���� ��õ�ϰ� �ֽ��ϴ�.>");
								System.out.println("");
							}else {
								System.out.println("");
								System.out.print("�� ���� ��õ�Ͻðڽ��ϱ�?(y:��õ/Ent:���)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							}
							
							/*
							if (detailBoard.getRecommendCnt() == 0) {
								System.out.println("");
								System.out.print("�� ���� ��õ�Ͻðڽ��ϱ�?(y:��õ/Ent:���)>");
								String yn = sc.nextLine();
								if (yn.equalsIgnoreCase("y")) {
									
									RecommendsDao.getInstance()
											.insert(new Recommends(null, member.getId(), detailBoard.getNo(), null));
								}
							} else {
								System.out.println("<����� �� ���� ��õ�ϰ� �ֽ��ϴ�.>");
								System.out.println("");
							}*/
						}
					}
				}
				break;
			case "2": // �ۼ�
				System.out.print("�Խñ� ����>");
				String title = sc.nextLine();
				System.out.print("�Խñ� ����>");
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
					System.out.println("�Խñ��� ��ϵǾ����ϴ�.");
				} else {
					System.out.println("�Խñ��� ��ϵ��� �ʾҽ��ϴ�.");
				}
				break;
			case "3": // ����
				System.out.print("�Խñ� ��ȣ>");
				String uptNo = sc.nextLine();
				Board uptBoard = boardDao.select(uptNo, boardKind);
				if (uptBoard == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� �Խñ��� �����ϴ�.");
				} else {
					if (member.getId().equals(uptBoard.getWriterId()) == false) {
						System.out.println("�ۼ��ڰ� �ٸ��ϴ�. ������ �ۼ��� �Խñ۸� ���� �����մϴ�.");
						break;
					}

					System.out.println("����:" + uptBoard.getTitle());
					System.out.println("����:" + uptBoard.getContent());

					System.out.print("������ ������ �Է��ϼ���(Ent:���)>");
					String uptTitle = sc.nextLine();
					if ("".equals(uptTitle) == false) {
						uptBoard.setTitle(uptTitle);
					}
					System.out.print("������ ������ �Է��ϼ���(Ent:���)>");
					String uptContent = sc.nextLine();
					if ("".equals(uptContent) == false) {
						uptBoard.setContent(uptContent);
					}
					if ("".equals(uptTitle) && "".equals(uptContent)) {
						System.out.println("���� ������ �����ϴ�.");
					} else {
						int uptRow = boardDao.update(uptBoard);
						if (uptRow > 0) {
							System.out.println("[" + uptNo + "]�� �Խñ��� �����Ǿ����ϴ�.");
						} else {
							System.out.println("�Խñ��� �������� �ʾҽ��ϴ�.");
						}
					}
				}
				break;
			case "4": // ����
				System.out.print("�Խñ� ��ȣ>");
				String delNo = sc.nextLine();
				Board delBoard = boardDao.select(delNo, boardKind);
				if (delBoard == null) {
					System.out.println("���� ������ �Խñ��� �����ϴ�.");
					break;
				}

				if ("1".equals(member.getResponsibility()) == false
						&& member.getId().equals(delBoard.getWriterId()) == false) {
					System.out.println("�ۼ��ڰ� �ٸ��ϴ�. ������ �ۼ��� �Խñ۸� ���� �����մϴ�.");
					break;
				}

				int delRow = boardDao.delete(delNo, boardKind);
				if (delRow > 0) {
					System.out.println("[" + delNo + "]�� �Խñ��� �����Ǿ����ϴ�.");
				} else {
					System.out.println("�Խñ��� �������� �ʾҽ��ϴ�.");
				}
				break;
			case "5": // ���ư���
				System.out.println();
				break;
			default:
				System.out.println("�ùٸ��� ���� �޴���ȣ�Դϴ�.");
				break;
			}
			if ("5".equals(select)) {
				break;
			}
		}
	}

}