package com.uracle.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.uracle.VO.BoardVO;


@Repository
public class BoardDaoImpl implements BoardDao{
	@Inject
	  private SqlSession sqlSession;

	private static final String NAMESPACE="board";
	  @Override
	  public void insert(BoardVO vo){
		  sqlSession.insert(NAMESPACE+".insert", vo);
	  }
	  @Override
	  public List<BoardVO> list() {
	  	return  sqlSession.selectList(NAMESPACE+".getList");
	  }


}
