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
 * 0625
 */

@WebServlet("/add")
public class Add extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ѱ۱�������
		response.setCharacterEncoding("UTF-8"); //������ ������ ���ڵ����� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���� �������� ����Ÿ���� �������� ����. �̰Ϳ� �°� �������� ���
		
		PrintWriter out = response.getWriter();
		
		int x=0;
		int y=0;
		int result = 0;
		
		String _result = request.getParameter("result");
		if(_result != null)
			result = Integer.parseInt(_result);
				
		if(request.getMethod().equals("POST")){
			
			String _btn = request.getParameter("btn");
			if(_btn.equals("Application")){
				ServletContext application = request.getServletContext();
				application.setAttribute("app", result);
				out.write("<p>Application�� ���� �Ϸ�</p>");
			}
			else if(_btn.equals("Sesstion")){
				HttpSession session = request.getSession();
				session.setAttribute("ss", result);
				out.write("<p>Sesstion�� ���� �Ϸ�</p>");
				
			}
			else if(_btn.equals("Cookie")){
				Cookie cookie = new Cookie("ck", String.valueOf(result));
				cookie.setMaxAge(24*60*60); // 24�ð�
				response.addCookie(cookie);
				
				out.write("<p>Cookie�� ���� �Ϸ�</p>"); //IN-FIELE�� �����
			}
			else{
				
				String _x = request.getParameter("x");//getParameter("input name") 
				String _y = request.getParameter("y");
				
				if(_x != null && !_x.isEmpty())
					x = Integer.parseInt(_x);
				
				if(_y != null && !_y.isEmpty())
					y = Integer.parseInt(_y);
				
				result = x+y;
			}
					
		}
		
		out.write("<form action=\"add\" method=\"post\">"); //action = ����� ���޹޴� servlet
		out.write("	<ul>");
		out.write("		<li><label for = \"x\">X: </label><input name=\"x\" /></li>");
		out.write("		<li><label for = \"y\">Y: </label><input name=\"y\" /></li>");
		out.write("	</ul>");
		out.write("	<p>");
		out.printf("<input type = \"hidden\" name=\"result\" value=\"%d\" />", result);
		out.write("	<input type = \"submit\" name=\"btn\" value=\"����\" />");
		out.write("	<input type = \"submit\" name=\"btn\" value=\"Application\" />&nbsp");
		out.write("	<input type = \"submit\" name=\"btn\" value=\"Sesstion\" />&nbsp");
		out.write("	<input type = \"submit\" name=\"btn\" value=\"Cookie\" />");
		out.write("	</p>");
		out.write("</form>");
		out.printf("������� : %d<br>", result);
		out.println("<a href=\"myPage\">����������</a>");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		service(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		service(request, response);
	}
	
	

}
