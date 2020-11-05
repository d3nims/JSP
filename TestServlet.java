package com.sbs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	ArticleDao dao = new ArticleDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();

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
				session.setAttribute("loginedMember", member);	
			}
			req.setAttribute("articles", dao.getAllArticles());
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(req, response);
			
		} else if(action.equals("doLogout")) {
			
			session.invalidate();
			response.sendRedirect("TestServlet?action=showLogin");
			
		} else if(action.equals("list")) {
			
			
			
			req.setAttribute("test", "el test!!!");
			req.setAttribute("articles", dao.getAllArticles());
			
			for(Article aa : dao.getAllArticles()) {
				
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(req, response);
		} else if(action.equals("showLogin")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(req, response);
		} else if(action.equals("showAdd")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/add.jsp");
			rd.forward(req, response);
		} else if(action.equals("my")) {
			MyBatis mb = new MyBatis();
			mb.getAllArticles();
			
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		doGet(req, response);
	}
}
