package controller.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet 만들기(서블릿 상속받아서 메인컨트롤러가 서블릿이 됨)
public class MainController extends HttpServlet 
	implements Servlet{
	//반환할 게 없으니까 보이드 //겟이랑 포스트랑 둘다 따로 만들면 힘드니까 한번에 다 되게끔 만들기 위해서
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		//URI = /shopping/index.html
		//context = /shopping
		if(command.equals("/main.sm")) { //포워드 되야함 : 주소는 바뀌는데 이름은 그대로여야함
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("main/home.jsp");
			dispatcher.forward(request, response);
		}
	}
	@Override //겟방식을 받는
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override //포스트방식을 받는
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
}
