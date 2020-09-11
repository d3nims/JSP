import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC";
			String user = "sbsst";
			String pass = "";
			
			Connection conn = DriverManager.getConnection(url,user,pass);
			
			Statement stmt = conn.createStatement();
			String sql = "select * from article";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			List<Article> articles = new ArrayList<>();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String body = rs.getString("body");
				
				Article aritlce = new Article();
			}
			
			
		} catch(ClassNotFoundException e1) {
			System.out.println("클래스를 찾지 못했습니다.");
		} catch(SQLException e2) {
			System.out.println("SQL Error.");
		} finally {
			try{
				conn.close();
			} catch(SQLException) {
				
			}
		}
		
		
		
		
		
		String val1 = request.getParameter("key1");
		String val2 = request.getParameter("key2");
		String val3 = request.getParameter("key3");
		

		writer.println("<h1>" + val1 + "</h1>");
		writer.println("<h1>" + val2 + "</h1>");
		writer.println("<h1>" + val3 + "</h1>");
		
		// jsp 파일로 데이터 보내기
		
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
