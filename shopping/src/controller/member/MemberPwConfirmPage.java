package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DTO.AuthInfo;

public class MemberPwConfirmPage {
	public String pwConfirm(HttpServletRequest request) {
		String path = null;
		HttpSession session = request.getSession();//session에 있는 pw갖고 오기 위해서
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");//AuthInfo에 있는 패스워드를 갖고옴
		if(request.getParameter("memPw").equals(authInfo.getUserPw())) {
			path = "member/pwChangeOk.jsp";
		}else {
			request.setAttribute("pwFail1", "비밀번호가 틀렸습니다.");
			path = "member/pwChange.jsp";
		}
		return path;
	}
}
