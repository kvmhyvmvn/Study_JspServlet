package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex01_Request")
public class Ex01_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		
		// id가 admin 그리고 pw 가 admin1234일 때 syso 이용해서 아이디 비밀번호 맞음 로그인,
		// 아이디 또는 비번 틀림. 이 출력되게 해보기
		// if("admin".equals(id) && "admin1234".equals(pw)) id <= String 변수가 null일 경우 equals를 사용하면
		// nullpointerException 발생
		if(id != null && pw != null && id.equals("admin") && pw.equals("admin1234")) {
			System.out.println("아이디 비밀번호 맞음. 로그인");
		} else {
			System.out.println("아이디 또는 비밀번호 틀림");
		}

		System.out.println("GET 실행");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST 실행");
		doGet(request, response);
	}

}
