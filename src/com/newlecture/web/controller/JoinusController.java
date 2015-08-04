package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/joinus/*")
public class JoinusController {
	
	@RequestMapping("login")
	public String join(){
		
		return "joinus.login";
		
	}

/*	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		if (request.getMethod().equals("POST")) {
			
			
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");

			MemberDao md = new MyBatisMemberDao();
			Member member = md.getMember(uid);

			
			if (member == null) {
				// 오류메시지
				
				request.setAttribute("error", "회원이 아닙니다.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request, response);
			}

			else if (!member.getPwd().equals(pwd)) {
				// 패스워드가 틀림
				request.setAttribute("error", "패스워드가 틀립니다.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request, response);
			} else {
				// 인증 성공
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);

				response.sendRedirect("../customer/notice");
				
			}
			

		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
			dispatcher.forward(request, response);
		}
	}*/
}
