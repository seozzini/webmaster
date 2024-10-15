package chap13;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	//필드
	//생성자
	
	//메소드
	
	public List<Board2> getBoardList() {
		List<Board2> list = new ArrayList<Board2>();
		
		list.add(new Board2("제목1", "내용1", "글쓴이1"));
		list.add(new Board2("제목2", "내용2", "글쓴이2"));
		list.add(new Board2("제목3", "내용3", "글쓴이3"));

		return list;

	}

}
