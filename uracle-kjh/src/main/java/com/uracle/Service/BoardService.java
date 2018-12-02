package com.uracle.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



import com.uracle.VO.BoardVO;


/*게시글 삽입을 위한 메소드 선언*/
public interface BoardService {
	public void insert(HttpServletRequest request);
	/*전체목록 보기 처리를 위한 메소드 선언*/
	public List<BoardVO> list();

}
