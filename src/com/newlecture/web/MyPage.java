package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 0626
 */

@WebServlet("/myPage")
public class MyPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�ѱ۱�������
		response.setCharacterEncoding("UTF-8"); //������ ������ ���ڵ����� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���� �������� ����Ÿ���� �������� ����. �̰Ϳ� �°� �������� ���
		
		ServletContext application = request.getServletContext(); //���ø����̼� �����
		HttpSession session = request.getSession(); //���� �����
		
		PrintWriter out = response.getWriter();
		
		int app = 0;
		int ss = 0;
		int ck = 0;
		
		Object _app = application.getAttribute("app");
		Object _ss = session.getAttribute("ss");
		
		Cookie[] cookies = request.getCookies();
		String _ck = "";
		
		if(cookies != null)
			for (Cookie cookie : cookies)
				if("ck".equals(cookie.getName())) // ���� ��Ű�� �̸��� ã���� �ϴ� �Ͱ� ������
					_ck = cookie.getValue();
		
		if(_app != null)
			app = (int) _app;
		
		if(_ss != null)
			ss = (int) _ss;
		
		if(_ck != null)
			ck = Integer.parseInt(_ck);
		
		out.printf("Application: %d<br>", app);
		out.printf("Session: %d<br>", ss);
		out.printf("Cookie: %d<br>", ck);
		out.println("<a href=\"add\">����������</a>");

	}

}
