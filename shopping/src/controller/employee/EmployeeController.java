package controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet
	implements Servlet{
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(
				contextPath.length());
		if(command.equals("/empList.em")) {
			EmployeeListPage action = new EmployeeListPage();
			action.empList(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"employee/employeeList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empRegest.em")) {
			EmployeeNumPage action = new EmployeeNumPage();
			action.getNum(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"employee/employeeForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empJoin.em")) {
			EmployeeJoinPage action = new EmployeeJoinPage();
			action.empInsert(request);
			response.sendRedirect("empList.em");
		}else if(command.equals("/empInfo.em")) {
			EmployeeInfoPage action = new EmployeeInfoPage();
			action.empInfo(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(""
							+ "employee/employeeInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empModify.em")) {
			EmployeeInfoPage action = new EmployeeInfoPage();
			action.empInfo(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(""
							+ "employee/employeeModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empModifyOk.em")) {
			EmployeeModifyPage action = new EmployeeModifyPage();
			action.empModify(request);
			response.sendRedirect("empList.em");
		}else if(command.equals("/empDelete.em")) {
			EmployeeDeletePage action = new EmployeeDeletePage();
			action.empDelete(request);
			response.sendRedirect("empList.em");
		}else if(command.equals("/empMyPage.em")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empDetail.em")) {
			EmployeeDetailPage action = new EmployeeDetailPage();
			action.employeeDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empSujung.em")) {
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
