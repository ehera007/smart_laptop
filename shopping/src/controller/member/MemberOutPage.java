package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;

public class MemberOutPage {
	public int memOut(HttpServletRequest request) {
		HttpSession session = request.getSession(); //session을 먼저 갖고와야하거나 순서는 없음
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(request.getParameter("memPw").equals(authInfo.getUserPw())) {
			MemberDAO dao = new MemberDAO();
			dao.memDel(authInfo.getUserId());
			session.invalidate(); //session을 다 날리는 것(완전히 삭제)
			return 1;
		}else {
			session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			return 2;
		}
	}

}
