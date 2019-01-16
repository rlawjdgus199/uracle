package com.uracle.Controller;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uracle.Service.BoardService;
import com.uracle.VO.BoardVO;


@Controller
@RequestMapping(value = "board/")
public class BoardController {
	@Autowired
	private BoardService boardService;

	/* Board/write요청이 GET방식으로 왔을 때 처리한다 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String insert(Model model) {
		return "board/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registPOST(@ModelAttribute BoardVO boardVO, RedirectAttributes rttr) {
		
		try {
			System.out.println(boardVO);
			boardService.insert(boardVO);
			rttr.addFlashAttribute("msg", "게시글 작성에 성공하셨습니다.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "게시글 작성에 실패하셨습니다.");
			e.printStackTrace();
		}
		
		return "redirect:/board/list";
	}
	//목록보기 처리 요청의 메소드
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		List<BoardVO> list = boardService.list();
		model.addAttribute("list", list);
		return "board/list";
	}
	//메인 페이지 처리 요청의 메소드
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		return "board/home";
	}
	
	//상세보기 처리 요청의 메소드
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("id") int id, Model model) {
		BoardVO vo = boardService.detail(id);
		model.addAttribute("vo",vo);
		
		return "board/detail";
		
	}
	//수정하기보기 처리 요청의 메소드
	@RequestMapping(value = "updateView", method = RequestMethod.POST)
	public String modifyGET(@RequestParam("id") int id, Model model) {
		model.addAttribute("vo", boardService.updateView(id));
		return "board/update";
		
		
	}


	//수정하기 처리 요청의 메소드
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePOST(@ModelAttribute BoardVO boardVO, RedirectAttributes rttr) {
		try {
			System.out.println(boardVO);
			boardService.update(boardVO);
			rttr.addFlashAttribute("msg", "게시글 수정에 성공하셨습니다.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "게시글 수정에 실패하셨습니다.");
			e.printStackTrace();
		}
		
		return "redirect:/board/list";
	}
	
	//게시글 삭제처리 요청의 메소드
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String remove(@RequestParam("id") int id, RedirectAttributes rttr){
		boardService.delete(id);
		rttr.addFlashAttribute("msg", "게시글 삭제에 성공하셨습니다.");
		return "redirect:/board/list";
	}
	


			
}
