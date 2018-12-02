package com.uracle.Dao;

import java.util.List;


import com.uracle.VO.BoardVO;


public interface BoardDao {
	/*게시글 작성 메소드*/
	public void insert(BoardVO vo);
	
	/*게시글 전체목록 보기를 위한 메소드선언*/
	public List<BoardVO> list();

}
