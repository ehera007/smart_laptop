package controller.venta;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.DeliveryDTO;

public class CreateDeliveryPage {
	public void execute(HttpServletRequest request) {
		SalesDAO dao = new SalesDAO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeliveryDTO dto = dao.deliverySelect(request.getParameter("purchaseNum"));
		request.setAttribute("purchaseNum", request.getParameter("purchaseNum"));
		request.setAttribute("dto", dto);
	}
}
