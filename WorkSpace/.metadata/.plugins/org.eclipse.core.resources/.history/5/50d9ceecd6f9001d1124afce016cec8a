package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khm.KhmVO;

@WebServlet("*.khm")
public class KhmController extends HttpServlet {

	RequestDispatcher rd;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		if (req.getServletPath().equals("/list.khm")) {
			ArrayList<KhmVO> list = new ArrayList<>();
			// <> <- Object를 상속받은 Class타입만 넣을 수 있음
			for (int i = 0; i < 10; i++) {
				KhmVO vo = new KhmVO();
				vo.setField1("필드" + i);
				vo.setField2(10);
				list.add(vo);
			}
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("khm/list.jsp");
		} else {
			System.out.println("잘못된 요청");
			rd = req.getRequestDispatcher("error/list.jsp"); // 나중에 추가예정KHM(20230523)
		}
		rd.forward(req, resp);
	}

}
