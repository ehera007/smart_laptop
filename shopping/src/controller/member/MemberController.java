package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet 
	implements Servlet{
	private void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/memAgree.mem")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("member/agree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memRegist.mem")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memJoin.mem")) {
			MemberJoinPage action = new MemberJoinPage();
			action.memInsert(request);
			response.sendRedirect("main.sm");
		}else if(command.equals("/memList.mem")){
			MemberListPage action = new MemberListPage();
			action.memList(request);
			//받을 때 깨지면 requset(받은값), 보낼때 깨지면 response(보낸값)
			response.setCharacterEncoding("utf-8");
			//내가 요청한 주소(.mem)로 내가 원하는 페이지(.jsp)가 열릴 수 있게끔
			RequestDispatcher dispatcher = //dispatcher 변수가 밑에 주소가 됨
					request.getRequestDispatcher(
							"member/memberList.jsp");//requset를 통해서 원하는 페이지를 염
			//List주소에 내용 없어서 include,forward아무거나 해도 됨
			dispatcher.include(request, response);
		}else if(command.equals("/memInfo.mem")) {
			MemberInfoPage action = new MemberInfoPage();
			action.memInfo(request);
			response.setCharacterEncoding("utf-8");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"member/memberInfo.jsp");	
			dispatcher.include(request, response);
		}else if(command.equals("/memMod.mem")) {
			MemberInfoPage action = new MemberInfoPage();
			action.memInfo(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("member/memberModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memModifyOk.mem")) {
			MemberModifyPage action = new MemberModifyPage();
			action.memUpdate(request);
			response.sendRedirect("memList.mem");
		}else if(command.equals("/memDel.mem")) {
			MemberDeletePage action = new MemberDeletePage();
			action.memDel(request);
			response.sendRedirect("memList.mem");
		}else if(command.equals("/myPage.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memDetail.mem")){
			//session 페이지가 닫힐 때까지 언제 어디서든 사용 가능 (굳이 값을 날리지 않아도 됨) / request는 쿼리스트링으로 날려줘야지만 계속 사용 가능
			MemberDetailPage action = new MemberDetailPage();
			action.memberDetail(request); //request를 전달해줘야 session 만들어서 사용 가능(만들어주기 위해서)
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memSujung.mem")) {
			MemberDetailPage action = new MemberDetailPage();
			action.memberDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memSujung.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memSujungOk.mem")) {
			memberUpdatePage action = new memberUpdatePage();
			int i = action.memberUpdate(request);
			if(i == 1) {
				response.sendRedirect("memDetail.mem");
			}else {
				response.sendRedirect("memSujung.mem");
			}
		}else if(command.equals("/memOut.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/outPw.jsp"); //탈퇴 전 비밀번호 확인 후 진행하기 위해
			dispatcher.forward(request, response);	
		}else if(command.equals("/memOutOk.mem")) {
			MemberOutPage action = new MemberOutPage();
			int i = action.memOut(request);
			if(i==1) {
				response.sendRedirect("main.sm");
			}else {
				response.sendRedirect("memOut.mem");
			}
		}else if(command.equals("/memPwChange.mem")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/pwChange.jsp"); 
			dispatcher.forward(request, response);
		}else if(command.equals("/pwChageOk.mem")) {
			MemberPwConfirmPage action = new MemberPwConfirmPage();
			String path = action.pwConfirm(request);		
			RequestDispatcher dispatcher = request.getRequestDispatcher(path); 
				dispatcher.forward(request, response);
		}else if(command.equals("/ChangePw.mem")) {
			MemberPwChagePage action = new MemberPwChagePage();
			int i = action.pwChange(request);
			if(i==1) {
				response.sendRedirect("main.sm");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("member/pwChange.jsp"); 
				dispatcher.forward(request, response);
			}
		}else if(command.equals("/idSearch.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/idSearch.jsp"); 
			dispatcher.forward(request, response);
		}else if(command.equals("/idFind.mem")) {
			IdSearchPage action = new IdSearchPage();
			action.idFind(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/idFind.jsp"); 
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
}
