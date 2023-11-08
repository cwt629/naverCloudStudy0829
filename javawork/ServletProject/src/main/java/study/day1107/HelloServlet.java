package study.day1107;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 * 
 * HelloServlet 을 뒤에 붙여서 호출하면 아래 있는 클래스를 호출해라. 임의로 바꿀 수 있지만, 바꾸면 서버를 재시작해야 함 그리고
 * forward...에 중요?
 */
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter() : out 객체 느낌 request.getContextPath() : 프로젝트명까지
		 * 받아오기(/ServletProject)
		 */
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// request에 각종 정보 저장

		// result1.jsp 로 포워드(forward)
		/*
		 * 포워드의 특징 1. url 주소 유지 2. request, response 그대로 유지
		 */
		List<String> list = new ArrayList<String>();
		list.add("red");
		list.add("green");
		list.add("magenta");
		list.add("orange");
		list.add("blue");

		request.setAttribute("list", list);
		request.setAttribute("today", new Date());
		request.setAttribute("message", "석현아...롤체 많이 하면 안돼...");

		// result1.jsp로 포워드
		// 매핑주소 기준이다. (ServletProject/ 에서 /이 webapp의 위치)
		RequestDispatcher rd = request.getRequestDispatcher("./day1107/result1.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
