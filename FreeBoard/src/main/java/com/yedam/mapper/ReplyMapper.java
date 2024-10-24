package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectList(int boardNo);
	List<ReplyVO> selectListPaging(@Param("bno")int boardNo, @Param("page")int page); //파라미터 이름정하는 어노테이션
	int removeReply(int replyNo);
	int insertReply(ReplyVO reply);
	ReplyVO selectReply(int replyNo);
	//댓글건수. 반환쿼리
	int selectCount(int boardNo);
	
	
}
