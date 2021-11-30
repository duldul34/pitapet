package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.MemberManager;
import model.dto.Member;
import model.service.exception.MemberNotFoundException;
import model.service.exception.PasswordMismatchException;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		
		try {
			// 모델에 로그인 처리를 위임
			MemberManager memMan = MemberManager.getInstance();
			Member member = memMan.login(memberId, password);
	
			// 세션에 사용자 아이디, 등급 저장
			HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, memberId);
            session.setAttribute("identity", member.getIdentity());
            
            if(member.getIdentity().equals("M"))
            	return "redirect:/manager/listSitterApply";
            else
            	return "redirect:/mainpage";			
		} catch (MemberNotFoundException e) {
            request.setAttribute("loginIdFailed", true);
			request.setAttribute("exception", e);
            
			return "/member/loginForm.jsp";			
		} catch (PasswordMismatchException e) {
            request.setAttribute("loginPwFailed", true);
			request.setAttribute("exception", e);
           
			return "/member/loginForm.jsp";			
		}		
    }
}

