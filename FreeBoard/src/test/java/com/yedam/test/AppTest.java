package com.yedam.test;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		ReplyVO rep = new ReplyVO();
		rep.setBoardNo(159);
		rep.setReply("댓글테스트");
		rep.setReplyer("userzz");
		//rep.setReplyNo(7);
		
		//svc.addReply(rep)
		//svc.removeReply(rep.getReplyNo());
		//svc.replyList(159).forEach(reply -> System.out.println(reply));
		//System.out.println(svc.getReply(1));
		
		svc.replyList(159).forEach(reply -> System.out.println(reply));
		
		/*
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);  //인터페이스를 구현하는 클래스로 생각하면 된다. 매퍼가 가진 메소드를 쓴다.
		
		SearchDTO search = new SearchDTO();
		search.setKeyword("user11");
		search.setSearchCondition("W");
		search.setPage(2);
		*/
		
		/*
		//글입력
				BoardVO bvo = new BoardVO();
				bvo.setTitle("mapper테스트");
				bvo.setContent("정상 작동합니다.");
				bvo.setWriter("user11");
				
				if(mapper.insertBoard(bvo)==1) {
					sqlSession.commit();
				}
				
		*/
		
		/*
		//글수정
				BoardVO bvo = new BoardVO();
				bvo.setContent("정상 작동합니다.[수정]");
				bvo.setWriter("user11");
				bvo.setBoardNo(4);
				
				if(mapper.updateBoard(bvo)==1) {
					sqlSession.commit();
				}
		
		 */
		
		/*
		//글삭제
		
		BoardVO bvo = new BoardVO();
		bvo.setContent("정상 작동합니다.[수정]");
		bvo.setWriter("user11");
		bvo.setBoardNo(4);
		
		if(mapper.deleteBoard(bvo.getBoardNo())==1) {
			sqlSession.commit();
		}
		*/
		
		/*
		//목록선택
		//없는 번호 게시글 선택 
		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapper테스트");
		bvo.setContent("정상 작동합니다.[수정]");
		bvo.setWriter("user11");
		bvo.setBoardNo(4);
		
		if(mapper.selectBoard(bvo.getBoardNo())==null) {
			System.out.println("조회된 내용이 없습니다.");
		}
		
		*/

		//있는 번호 게시글 선택 
		/*
		if(mapper.selectBoard(5)==null) {
			System.out.println("조회된 내용이 없습니다.");
		}
		*/
			
		/*
		//목록출력
		List<BoardVO> list = mapper.boardList();
		for(BoardVO bvo2 : list) {
			System.out.println(bvo2.toString());
		}
		*/
		/*
		List<BoardVO> list = mapper.listWithPage(search);
		for(BoardVO bvo2 : list) {
			System.out.println(bvo2.toString());
		}
		*/
				
	}
}
