import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	Dao dao = new Dao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		PrintWriter pw = response.getWriter();
		
		if(cmd.equals("list")) {
			List<Article> articles = dao.getAllArticles();

		pw.println("번호 : " + a.getId());
		pw.println("제목 : " + a.getTitle());
		pw.println("내용 : " + a.getBody());
		pw.println("작성자 : " + a.getNickname());
		pw.println("조회수 : " + a.getHit());
		
		pw.println("<hr>");
		}
		
		}
		

	}
