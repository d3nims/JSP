package com.sbs.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet3")
public class TestServlet3 extends HttpServlet {
	ArticleDao dao = new ArticleDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)req.getAttribute("msg");
		System.out.println(msg);
		
		response.setContentType("text/html; charset=utf-8");
		String[] ids = req.getParameterValues("chk");
		
		
		PrintWriter writer = response.getWriter();
		List<Article> articles = dao.getAllArticles();
		req.setAttribute("articles", articles);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/list.jsp"); // / -> contextRoot, documentRoot
		rd.forward(req, response);			
		
	}
}
