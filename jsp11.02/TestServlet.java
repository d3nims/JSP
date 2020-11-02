package com.sbs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	ArticleDao dao = new ArticleDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		String action = req.getParameter("action");
//		String flag = req.getParameter("flag"); // y, n
//		
//		if(flag.equals("y")) {
//			req.setAttribute("key", "req_val");
//			application.setAttribute("key", "context_val");			
//		}
		
		if(action.equals("req")) {
			String rst = (String)req.getAttribute("key");
			if(rst == null) {
				System.out.println("값이 없습니다.");
			} else {				
				System.out.println(rst);
			}
			
		} else if(action.equals("context")) {
			String rst = (String)application.getAttribute("key");
			if(rst == null) {
				System.out.println("값이 없습니다.");
			} else {				
				System.out.println(rst);
			}
		} else if(action.equals("doLogin")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			Member member = dao.loginCheck(id, pw);
			
			if(member != null) {
				application.setAttribute("loginedMember", member);
			}
			
			req.setAttribute("articles", dao.getAllArticles());
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(req, response);
			
		} else if(action.equals("doLogout")) {
			
			System.out.println("logout");
			application.removeAttribute("loginedMember");
			
			response.sendRedirect("TestServlet?action=list");
			
		} else if(action.equals("list")) {
			
			req.setAttribute("articles", dao.getAllArticles());
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(req, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		doGet(req, response);
	}
}
