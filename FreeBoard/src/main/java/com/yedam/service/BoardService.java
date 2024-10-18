package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	// 목록 가져오기, 변경, 등록, 삭제, 단건조회 기능 있어야 함.
	//전체목록
	List<BoardVO> boardList(SearchDTO search);
	//등록
	boolean registerBoard(BoardVO board);
	//삭제
	boolean removeBoard(int boardNo);
	//수정
	boolean modifyBoard(BoardVO board);
	//단건조회
	BoardVO searchBoard(int boardNo);
	
	//페이징 카운트.
	int getTotalCount(SearchDTO search);
	

}
