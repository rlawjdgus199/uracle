package com.uracle.Dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uracle.VO.BoardVO;
import com.uracle.VO.UserVo;

//객체를 자동 생성해주고 예외가 발생하면 spring의 데이터베이스 예외롤 변환해서 출력해주는 어노테이션
@Repository
public class UserDaoImpl implements UserDao {

	//동일한 자료형의 객체가 있는 경우 자동으로 주입받는 어노테이션
	@Autowired
	private SqlSession sqlSession;
	
	//매퍼가 있는 공통된 이름을 저장할 변수
	private static final String NAMESPACE="user";
	
	@Override
	public UserVo login(UserVo vo) {
		return sqlSession.selectOne(NAMESPACE+".login",vo);
		
	}
	
	@Override
	public void logout(HttpSession session) {
		
	}
	
	@Override
	public void member(UserVo vo) {
		sqlSession.insert(NAMESPACE + ".member", vo);
	}
	
	@Override
	public int idcheck(String userid) {
		return sqlSession.selectOne(NAMESPACE+".idcheck", userid);
	}

	
	
}
