package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	// 글목록 가져오기.
	List<BoardVO> boardList(); //전체데이터 가져오기(나중에 타이틀,컨텐츠 조건걸어 가져올수도 있음)
	List<BoardVO> listWithPage(SearchDTO search);
	// 글등록.
	int insertBoard(BoardVO board);
	// 글수정.
	int updateBoard(BoardVO board);
	// 글 삭제.
	int deleteBoard(int boardNo);
	// 상세조회.
	BoardVO selectBoard(int boardNo);
	// 조회수 증가(업데이트임/몇번글카운트증가)
	int updateCount(int boardNo);
	// 페이징 계산 건수체크
	int selectCount(SearchDTO search);

}
