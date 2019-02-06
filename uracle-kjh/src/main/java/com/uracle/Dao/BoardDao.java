package com.uracle.Dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.uracle.VO.BoardVO;


public interface BoardDao {
	/*게시글 작성 메소드*/
	public void insert(BoardVO vo);
	
	/*게시글 전체목록 보기를 위한 메소드선언*/
	public List<BoardVO> list();
	
	
	//글번호를 가지고 하나의 데이터를 찾아오는 메소드
		public BoardVO detail(int id);

		//글번호를 가지고 조회수를 1증가시키는 메소드
    	public void updateReadCnt(int id);	
		
		//게시글 수정처리를 위한 메소드
		public void update(BoardVO vo);
		
	
		//글번호를 가지고 게시물을 삭제하는 메소드
		public void delete(int id);
		
	

	
	
	}
	



