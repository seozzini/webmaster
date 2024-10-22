package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true); // true는 파라미터에 값이 들어가면 자동 commit 한다는말
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> replyList(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.selectList(boardNo);
	}
	
	@Override
	public boolean addReply(ReplyVO reply) {
		return mapper.insertReply(reply) == 1;
		
	}
	
	@Override
	public boolean removeReply(int replyNO) {
		return mapper.deleteReply(replyNO) == 1;
	}
	
	@Override
	public ReplyVO getReply(int replyNO) {
		return mapper.selectReply(replyNO);
	}
	
	
}
