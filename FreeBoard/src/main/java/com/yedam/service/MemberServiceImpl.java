package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

// 회사초기 돈없어서 오라클 못사서
// mysql (insertMember, updateMember 메소드)
// 오라클 구매 -> oracle (membrInsert, memberUpdate 메소드로 바꿔버렸음)
public class MemberServiceImpl implements MemberService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true); //true는 파라미터에 값이 들어가면 자동 commit 한다는말
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member)==1;
	}
	
	@Override
	public boolean retireMember(String memberId) {
		return mapper.deleteMember(memberId)==1;
	}
	
	@Override
	public List<MemberVO> memberList() {
		return mapper.members();
	}

}
