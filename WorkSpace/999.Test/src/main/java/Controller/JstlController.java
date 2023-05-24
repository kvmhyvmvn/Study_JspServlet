package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.js")
public class JstlController extends HttpServlet {

	RequestDispatcher rd;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		if (req.getServletPath().equals("/list.js")) {
			ArrayList<String> strArr = new ArrayList<>();
			for (int i = 1; i <= 5; i++) {
				System.out.println(strArr.add("A" + i));
			}
			req.setAttribute("strArr", strArr);
			rd = req.getRequestDispatcher("jstl/list.jsp");
		} else if (req.getServletPath().equals("/listdetail.js")) {
			rd = req.getRequestDispatcher("jstl/listdetail.jsp");
		} else {
			rd = req.getRequestDispatcher("jstl/error.jsp"); // 나중에 추가
		}
		rd.forward(req, resp);
	}
}
