package com.uracle.Service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uracle.Dao.BoardDao;
import com.uracle.VO.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	public void insert(HttpServletRequest request) {
		// 매개변수가 request일 때는 파라미터를 읽습니다.
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		if(title.trim().length() == 0){
			title="무제목";
		}
		if(body.trim().length() == 0){
			title="무내용";
		}
		// 필요한 데이터를 생성
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setBody(body);
		vo.setWriter(writer);
		// DAO의 메소드를 호출
		boardDao.insert(vo);
		

	}
	/*클래스에 전체목록 보기 처리를 위한 메소드 구현*/
	@Override
	public List<BoardVO>list(){
		return boardDao.list();
	}

}
