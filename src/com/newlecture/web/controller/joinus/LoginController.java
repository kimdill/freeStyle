package com.newlecture.web.controller.joinus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mybatis.MyBatisMemberDao;
import com.newlecture.web.vo.Member;

/*@WebServlet("/joinus/login")*/
public class LoginController extends HttpServlet {

	@Override
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
				// �����޽���
				
				request.setAttribute("error", "ȸ���� �ƴմϴ�.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request, response);
			}

			else if (!member.getPwd().equals(pwd)) {
				// �н����尡 Ʋ��
				request.setAttribute("error", "�н����尡 Ʋ���ϴ�.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request, response);
			} else {
				// ���� ����
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);

				response.sendRedirect("../customer/notice");
				
			}
			

		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
