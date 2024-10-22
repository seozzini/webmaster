package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo); // 목록.
	boolean addReply(ReplyVO reply); // 댓글등록.
	boolean removeReply(int replyNO); // 댓글삭제.
	ReplyVO getReply(int replyNO); // 단건조회.
}
