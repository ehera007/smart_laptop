package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsController extends HttpServlet implements Servlet{
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/goodsList.gd")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.gd")) {
			GoodsNumberPage action = new GoodsNumberPage();
			action.goodsNum(request);
			response.setCharacterEncoding("utf-8");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("goods/goodsJoin.jsp");
			dispatcher.include(request, response);
		}else if(command.equals("goodsJoin.gd")) {
			GoodsJoinPage action = new GoodsJoinPage();
			action.goodsJoin(request);
			response.sendRedirect("goods/goodsList.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
}
