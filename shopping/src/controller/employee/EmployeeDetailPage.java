package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;

public class EmployeeDetailPage {
	public void employeeDetail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empUserid = authInfo.getUserId();
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.empDetail(empUserid);
		request.setAttribute("dto", dto);
	}
}
