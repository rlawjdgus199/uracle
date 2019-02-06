package com.uracle.Service;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.uracle.Dao.BoardDao;
import com.uracle.VO.BoardVO;
import com.uracle.VO.UserVo;




@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDao boardDao;
	
	@Override
	public void insert(BoardVO boardVO) throws Exception{
		boardDao.insert(boardVO);
		
	}
	/*@Override
	public void insert(HttpServletRequest request) throws Exception{
		BoardVO vo=new BoardVO();
		HttpSession session = request.getSession();
		UserVo user=(UserVo)session.getAttribute("login");
		vo.setWriter(user.getUserid());
		boardDao.insert(vo);
		
	}*/
	/*클래스에 전체목록 보기 처리를 위한 메소드 구현*/
	@Override
	public List<BoardVO>list(){
		return boardDao.list();
	}
	
	
	/* 상세보기 처리를 위한 메소드 구현*/
	@Override
	public BoardVO detail(int id) {
		//조회수 1 증가하는 메소드 호출
		boardDao.updateReadCnt(id);
		return boardDao.detail(id);
	}

	// 조회수 증가 제외하고 detail과 같음
	/*@Override
	public BoardVO updateReadCnt(int id) {
		
		return boardDao.detail(id);
	}
	*/
	//게시글 수정보기 처리를 위한 메소드 구현
	@Override
	public BoardVO updateView(int id) {
	 return boardDao.detail(id);
	}

	//게시글 수정처리를 위한 메소드 구현
	@Override
	public void update(BoardVO boardVO) throws Exception{
		 boardDao.update(boardVO);
	}
	
	@Override
	public void delete(int id) {
		boardDao.delete(id);
	}

	
	}
	
	

