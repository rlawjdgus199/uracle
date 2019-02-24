package com.uracle.Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uracle.Dao.UserDao;
import com.uracle.VO.BoardVO;
import com.uracle.VO.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//회원 로그인 정보
	@Override
	public UserVo login(UserVo ve) {
		return userDao.login(ve);
	}
	
	
	//회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	//회원 가입
	@Override
	public void member(UserVo ve) throws Exception{
		userDao.member(ve);
		
	}
	
	@Override
	public int idcheck(String userid) {
		return userDao.idcheck(userid);
	}
	
	
}
