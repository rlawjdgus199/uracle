package com.uracle.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.uracle.VO.BoardVO;


/*게시글 삽입을 위한 메소드 선언*/
public interface BoardService {
	public void insert(BoardVO boardVO)  throws Exception;
	/*전체목록 보기 처리를 위한 메소드 선언*/
	public List<BoardVO> list();
	
//글 번호를 가지고 하나의 게시글을 가져오는 메소드
public BoardVO detail(int id);
	
/*	public BoardVO updateReadCnt(int id);
*/	

//게시글 수정보기 처리를  위한 메소드 선언
public BoardVO updateView(int id);


//게시글 수정 처리를 위한 메소드 선언
public void update(BoardVO boardVO)  throws Exception;

//글번호를 가지고 게시글을 삭제하는 메소드
public void delete(int id);



	

}
