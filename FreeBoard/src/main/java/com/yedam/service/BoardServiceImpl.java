package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동커밋
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		return mapper.listWithPage(search);
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(boardNo) == 1;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public BoardVO searchBoard(int boardNo) {
		// 글조회 & 조회수 증가.
		mapper.updateCount(boardNo);
		return mapper.selectBoard(boardNo);
	}

	@Override
	public int getTotalCount(SearchDTO search) {
		return mapper.selectCount(search);
	}

	@Override
	public List<Map<String, Object>> countByWriter() {
		return mapper.countByWriter();
	}

	@Override
	public List<Map<String, Object>> selectEvent() { // 서비스 함수
		return mapper.selectEvent();
	}

	@Override
	public boolean registerEvent(Map<String, String> map) {
		return mapper.insertEvent(map) == 1;
	}

	@Override
	public boolean deleteEvent(Map<String, String> map) {
		return mapper.delEvent(map) == 1;
	}
}
