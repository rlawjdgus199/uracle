package com.uracle.Dao;

import javax.servlet.http.HttpSession;

import com.uracle.VO.UserVo;

//member 테이블 작업을 위한 인터페이스
public interface UserDao {

	//로그인 처리 메소드 -id와 pw를 받아서 id와 name을 가져오는 메소드
	public UserVo login(UserVo ve);
	
	//로그아웃
	public void logout(HttpSession session);
	
	//회원가입을 처리해주는 메소드
	public void member(UserVo ve);
	
	//ID중복확을 처리해주는 메소드
	public int idcheck(String userid);
}
