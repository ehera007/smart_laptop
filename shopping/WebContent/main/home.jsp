<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 안되었을 때  -->
<c:if test="${empty authInfo }">
<form action="login.sm" method="get" name="frm">
<table border = 1>
	<tr><td colspan="3">아이디저장 | 자동로그인</td></tr>
	<tr><td>아이디</td>
		<td><input type="text" name="userId"/><span>${userFail }</span></td>
		<td rowspan="2">
			<input type="image" src="images/img1.jpg" width="60" alt="login" />
		</td></tr>
	<tr><td>비밀번호</td>
		<td><input type="password" name="userPw"/><span>${pwFail }</span></td></tr>
	<tr><td colspan="3">
			<a href="#">아이디</a>/<a href="#">비밀번호 찾기</a> |
			<a href="memAgree.mem">회원가입</a>
		</td></tr>
</table>
</form>
</c:if>
<c:if test="${!empty authInfo }">
<!-- 로그인 되었을 때 -->
	<c:if test="${authInfo.grade == 1 }">
	<!-- 일반 회원 -->
	<a href="myPage.mem">mypage</a>
	<a href="goodsCartList.gd">장바구니로 가기</a>
	</c:if>
	<c:if test="${authInfo.grade != 1 }">
	<!-- 직원 -->
	<a href="empMyPage.em">mypage</a>
	<a href="goodsList.gd">상품등록</a>
	<a href="#">공지사항</a>
	<!-- 관리자 -->
	<a href="empList.em">직원 리스트</a>
	<a href="memList.mem">회원 리스트</a>
	</c:if>
	<a href="logout.sm">로그아웃</a>
</c:if>
<hr/>
<!-- 로그인 상관없이 상품뜨게 하기 위해 if문 아래 코드 작성 -->
   <!-- 상품리스트 출력 -->
   <!-- tr은 행을 만들기때문에 td로 돌려주고 tr로 3의 배수씩 잘라주라는 명령어 줘야함 -->
   <script> //상품 상세페이지를 보기 전에 로그인을 하였는지 확인하기 위해서 if문 돌려줌
      function goodsBuy(prodNum){
         if(${authInfo == null}){
            alert("로그인을 하셔야합니다.");
            return false;
         }else{
            location.href='prodInfo.gd?prodNum='+prodNum;
         }
      }
   </script>
   <table align="center">
      <tr>
      <c:forEach items="${lists }" var="dto" varStatus="cnt"> <!-- lists를 dto로 받아옴 -->
         <!-- varStaus 명령어는 값을 1씩증가하게 만듬-> index : 0부터 1씩 증가, count : 1부터 1씩 증가 -->
         <td><a href="javascript:goodsBuy('${dto.prodNum}')"> <!-- goodsbuy라는 함수를 값으로 전달하기 위해서 ()를 사용해서 날려줌 -->
            <img width="200" height="200" src="goods/upload/${dto.prodImage.split(',')[0] }"><br/><!-- split으로 대표 이미지 하나를 가져옴, ','로 파일을 구분하고 [0]으로 첫번째 이미지라는 걸 알려줌 -->
            ${dto.prodName }<br/>
            가격 : <fmt:formatNumber value="${dto.prodPrice }" type="currency" /></a></td>
         <c:if test="${cnt.count % 3 == 0 }"> <!-- 열을 3개씩해서 행을 나누기 위해 cnt.count를 이용, 3으로 나눴을때 0이면 tr실행한다는 의미 == 행바꿈 -->
            </tr><tr></c:if></c:forEach>
      
      </tr>
   </table>
</body>
</html>