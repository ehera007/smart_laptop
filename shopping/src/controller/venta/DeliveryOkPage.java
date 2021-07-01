package controller.venta;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.DeliveryDTO;

public class DeliveryOkPage {
	public void execute(HttpServletRequest request) {
		DeliveryDTO dto = new DeliveryDTO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setArrivalExpDate(request.getParameter("arrivalExpDate"));
		dto.setDeliveryCom(request.getParameter("deliveryCom"));
		dto.setDeliveryDelFree(request.getParameter("deliveryDelFree"));
		dto.setDeliveryExpDate(request.getParameter("deliveryExpDate"));
		dto.setDeliveryNum(request.getParameter("deliveryNum"));
		dto.setPurchaseNum(request.getParameter("purchaseNum"));
		SalesDAO dao = new SalesDAO();
		dao.deliveryCreate(dto);
	}
}
