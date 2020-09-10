package com.sbs.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String val1 = request.getParameter("key1");
		String val2 = request.getParameter("key2");
		String val3 = request.getParameter("key3");
		

		writer.println("<h1>" + val1 + "</h1>");
		writer.println("<h1>" + val2 + "</h1>");
		writer.println("<h1>" + val3 + "</h1>");
		
		// jsp 파일로 데이터 보내기
		if()
		request.setAttribute("num1", val1);
		request.setAttribute("num2", val2);
		request.setAttribute("num3", val3);
		
		
		// 포워딩 - A가 했던 일을 B에게 넘겨주는 작업.
		
		// 상대경로 - 나 자신(파일) 기준으로 경로를 타고 들어가는 것.
		// 절대경로 - 기준점 잡고 거기서부터 경로 타고 들어가는 것.
		RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");   // [ / ]-> contexRoot,documentRoot
		rd.forward(request, response);
		
		response.sendRedirect("test.jsp?key1=1000&key2=2000&key3=3000");
	}

}
