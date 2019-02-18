package com.uracle.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uracle.Service.UserService;
import com.uracle.VO.UserVo;

@Controller
@RequestMapping("user/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginGET(Model model) {

		return "user/login";

	}

	// 단순 페이지 이동이고 요청 주소와 일치하는 뷰이름을 리턴하는 경우 메소드의 리턴 타입을 void로 하고 아무것도 리턴하지 않아도 된다.

	@RequestMapping(value = "login", method = RequestMethod.POST)
	// vo는 파라미터 대입받는 매개변수
	// session 과 attr은 뷰에게 데이터를 전달하기위한 매개변수
	// session은 반영구적 - 브라우저를 종료하거나 로그아웃 할 때 까지 유지
	// attr은 일시적- 한번만 유지
	/*
	 * public String login(UserVo vo, HttpSession session, RedirectAttributes attr)
	 * { UserVo result= userService.login(vo); System.out.println(vo); //로그인 실패한 경우
	 * if(result ==null) { attr.addFlashAttribute("fail","실패"); return
	 * "redirect:../user/login"; } //로그인에 성공한 경우 else {
	 * session.setAttribute("login", result); return "redirect:../board/list"; } }
	 */
	public String login(UserVo vo, HttpSession session, RedirectAttributes attr, HttpServletRequest request) {
		UserVo result = userService.login(vo);
		// 로그인 실패한 경우
		if (result == null) {
			attr.addFlashAttribute("fail", "실패");
			return "redirect:/user/login";
		}
		// 로그인에 성공한 경우
		else {
			session.setAttribute("login", result);
			return "redirect:/board/list";

		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}

	// 회원가입
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public String member(Model model) {
		return "user/member";

	}

	@RequestMapping(value = "member", method = RequestMethod.POST)
	public String memberPOST(UserVo vo, RedirectAttributes rttr) {

		try {
			userService.member(vo);
			rttr.addFlashAttribute("msg", "회원가입에  성공하셨습니다.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "회원가입에  실패하셨습니다.");
			e.printStackTrace();
		}
		return "redirect:/user/login";
	}
	
	@RequestMapping("/idcheck.do")
    @ResponseBody
    public Map<Object, Object> idcheck(@RequestBody String userid) {
        
		int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = userService.idcheck(userid);
        map.put("cnt", count);
 
        return map;
    }


}
