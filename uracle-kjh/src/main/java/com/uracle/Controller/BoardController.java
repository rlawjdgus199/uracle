package com.uracle.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uracle.Service.BoardService;
import com.uracle.VO.BoardVO;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;

	
	
	/*Board/write요청이 GET방식으로 왔을 때 처리한다*/
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert( Model model){

	return "board/insert";
		
		
}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(HttpServletRequest request,RedirectAttributes rttr){
		boardService.insert(request);
		rttr.addFlashAttribute("msg", "게시글 작성에 성공하셨습니다.");
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model){
		List<BoardVO> list = boardService.list();
		model.addAttribute("list", list);
	
	}
	
	}


	

