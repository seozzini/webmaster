package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	// 목록 가져오기, 변경, 등록, 삭제, 단건조회 기능 있어야 함.
	// 전체목록
	List<BoardVO> boardList(SearchDTO search);
	// 등록
	boolean registerBoard(BoardVO board);
	// 삭제
	boolean removeBoard(int boardNo);
	//수정
	boolean modifyBoard(BoardVO board);
	//단건조회
	BoardVO searchBoard(int boardNo);
	
	//페이징 카운트.
	int getTotalCount(SearchDTO search);
	
	// 사용자별 게시글.
	List<Map<String,Object>> countByWriter();
	
	//캘린더
	List<Map<String, Object>> selectEvent();
	//캘린더 등록
	boolean registerEvent(Map<String, String> map);
	//캘린더 삭제
	boolean deleteEvent(Map<String, String> map);

}
