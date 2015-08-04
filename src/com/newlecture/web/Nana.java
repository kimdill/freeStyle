package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 0625
 */
/**
 * Servlet implementation class Nana
 */
@WebServlet("/hello")
public class Nana extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�ѱ۱�������
		response.setCharacterEncoding("UTF-8"); //������ ������ ���ڵ����� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���� �������� ����Ÿ���� �������� ����. �̰Ϳ� �°� �������� ���
		
		String _cnt = request.getParameter("cnt"); // ����� �Է°��� �޴� �ӽú���
		
		int cnt = 10;
		if(_cnt != null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);

		// ���
		PrintWriter out = response.getWriter();
		for(int i=0; i<cnt; i++)			
			out.printf("<b>%d</b> hello �ȳ�<br>\n", i+1);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ѱ۱�������
				response.setCharacterEncoding("UTF-8"); //������ ������ ���ڵ����� ���� 
				response.setContentType("text/html; charset=UTF-8"); //���� �������� ����Ÿ���� �������� ����. �̰Ϳ� �°� �������� ���

		//form�� �ʿ�
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x=0;
		int y=0;
		
		if(_x != null && !_x.isEmpty())
			x = Integer.parseInt(_x);
		
		if(_y != null && !_y.isEmpty())
			y = Integer.parseInt(_y);
		
		int result = x+y;
		
		PrintWriter out = response.getWriter();
		
		out.write("<form action=\"hello\" method=\"post\">");
		out.write("	<ul>");
		out.write("		<li><label for = \"x\">X: </label><input name=\"x\" /></li>");
		out.write("		<li><label for = \"y\">Y: </label><input name=\"y\" /></li>");
		out.write("	</ul>");
		out.write("	<p><input type = \"submit\" value=\"����\" /></p>");
		out.write("</form>");
		out.printf("������� : %d<br>", result);
	}
	
	

}
