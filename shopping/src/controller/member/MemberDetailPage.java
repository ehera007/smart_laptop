package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberDetailPage {
	public void memberDetail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); //object로 받아오기 때문에 형변환 필요
		String memId = authInfo.getUserId(); //session에 저장한 내 ID를 갖고와서
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memDetail(memId); //내 정보를 갖고 오기 위해서 dto가 필요
		request.setAttribute("dto", dto);
		
	}
}
