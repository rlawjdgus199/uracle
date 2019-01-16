package com.uracle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uracle.Dao.UserDao;
import com.uracle.VO.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserVo login(UserVo vo) {
		return userDao.login(vo);
	}
}
