package chap13;

import java.util.List;

public class BoardExam604 {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board2> list = dao.getBoardList();
		for(Board2 board : list) {
			System.out.println(board.toString());
		}
	}//main end

}//class end
