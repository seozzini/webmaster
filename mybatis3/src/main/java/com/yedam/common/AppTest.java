package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//MEMBER DAO 기능 사용해보기 위한 테스트 클래스
public class AppTest {
	public static void main(String[] args) {
		//MemberDAO dao = new MemberDAO();//JDBC용
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class); //MemberMapper->인터페이스
		
		//등록
		
		/*
		//insert
		Member mbr = new Member();
		mbr.setMemberId("test99");
		mbr.setMemberName("연습99");
		mbr.setPhone("010-9999-9999");
		mbr.setPassword("999");
		
		if(dao.insertMember(mbr)==1){
			sqlSession.commit();
		}//인서트했으니 밑에서 목록 보일 것임
		*/
		
		
		//update
		Member mbr = new Member();
		mbr.setMemberId("test99");
		mbr.setMemberName("연습99");
		mbr.setPhone("010-9999-8888");
		mbr.setPassword("9999");
		
		
		
		if(dao.updateMember(mbr)==1){
			sqlSession.commit();
		}
		
		
		/*
		//삭제
		Member mbr = new Member();
		mbr.setMemberId("test99");
		
		if(dao.deleteMember(mbr.getMemberId())==1){
			sqlSession.commit();
		}
		*/
		
		List<Member> result = dao.members();
		for(Member member:result) {
			System.out.println(member.toString());
		}
	}
}
