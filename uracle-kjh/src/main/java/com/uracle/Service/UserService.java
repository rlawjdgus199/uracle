package com.uracle.Service;

import javax.servlet.http.HttpSession;

import com.uracle.VO.BoardVO;
import com.uracle.VO.UserVo;

public interface UserService {

	
	//로그인 처리를 위한 메소드
	public UserVo login(UserVo vo);
	
	//로그아웃 처리를 위한 메소드
	public void logout(HttpSession session);
	
	//회원가입 처리를 위한 메소드
	public void member(UserVo vo)  throws Exception;
}
