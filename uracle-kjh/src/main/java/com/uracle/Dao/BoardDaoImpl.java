package com.uracle.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uracle.VO.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "board";

	@Override
	public void insert(BoardVO vo) {
		sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<BoardVO> list() {
		return sqlSession.selectList(NAMESPACE + ".getList");
	}
	@Override
	public BoardVO detail(int id) {
		return sqlSession.selectOne(NAMESPACE+ ".detail",id);
	}
	@Override
	public void updateReadCnt(int id) {
		sqlSession.update(NAMESPACE+ ".updateReadCnt", id);
	}

	
	@Override
	public void update(BoardVO vo) {
		sqlSession.update(NAMESPACE+".update", vo);
	}
	
	
	@Override
	public void delete(int id) {
		sqlSession.delete(NAMESPACE+".delete",id);
	}




}
