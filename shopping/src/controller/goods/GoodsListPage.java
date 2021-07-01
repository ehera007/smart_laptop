package controller.goods;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DAO.LoginDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductDTO;

public class GoodsListPage {
	public void goodsList(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		List<ProductDTO> list = dao.goodsList();
		request.setAttribute("lists", list);
		//아이디저장 확인하기 위해 쿠키 확인(여러개가 있는지)
		Cookie [] cookies = request.getCookies(); //request사용자가 갖고 있는 쿠키가 있는지 물어봄
		
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				//쿠키들 중에서 id로 시작하는 이름의 쿠키가 있는지 확인
				if(cookie.getName().startsWith("id")) {//쿠키의 이름을 갖고옴 getName
					request.setAttribute("isId", cookie.getValue()); //쿠키가 갖고 있는 값을 전달 isID에 저장
				}
				//로그아웃될 때 밑에 쿠키가 사라지게끔 해야함
				if(cookie.getName().startsWith("au")) {//쿠키 문자열만 저장 가능 (authinfo 사용 불가)
					HttpSession session = request.getSession();
					LoginDAO ldao = new LoginDAO();
					String userId = cookie.getValue();
					AuthInfo authInfo = ldao.login(userId);
					session.setAttribute("authInfo", authInfo);
				}
			}
		}
		
	}
}
