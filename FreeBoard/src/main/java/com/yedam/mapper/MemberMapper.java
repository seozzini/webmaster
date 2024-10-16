package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	
		public List<MemberVO> members();
		public int insertMember(MemberVO member); //insertMember의 매개값은 Member type
		public int updateMember(MemberVO member);
		public int deleteMember(String memberId);
		public MemberVO selectMember(String memberId); //단건조회
		
	}

