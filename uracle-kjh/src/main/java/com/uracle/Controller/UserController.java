package com.uracle.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uracle.Service.UserService;
import com.uracle.VO.UserVo;

@Controller
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGET(Model model) {
		//단순 페이지 이동이고 요청 주소와 일치하는 뷰이름을 리턴하는 경우 메소드의 리턴 타입을 void로 하고 아무것도 리턴하지 않아도 된다.
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	//vo는 파라미터 대입받는 매개변수
	//session 과 attr은 뷰에게 데이터를 전달하기위한 매개변수
	//session은 반영구적 - 브라우저를 종료하거나 로그아웃 할 때 까지 유지
	//attr은 일시적- 한번만 유지
	public String login(UserVo vo, HttpSession session, RedirectAttributes attr) {

		UserVo result= userService.login(vo);
		System.out.println(vo);
		//로그인 실패한 경우
		if(result ==null) {
			attr.addFlashAttribute("fail","실패");
			return "redirect:login";
		}
		//로그인에 성공한 경우
		else {
			session.setAttribute("login", result);
			return "redirect:../board/home";
		}
	}
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../board/home";
	}
	
}
