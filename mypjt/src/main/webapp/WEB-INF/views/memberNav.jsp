<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberNav.css?ver=1" type="text/css">

<form id="memberNavi" action="../member/memberLogin" method="post">
	<div id="memberNav">
		<div id="memInnerNav">
		<!--여기 메뉴들 작성  --><input type="hidden" value="N" id="loginCheck">
			<c:if test="${sessiondto==null }"><a href="../member/memberInsertView">회원가입</a>  |  <a href="#">비번찾기</a>  |  <input type="text"id="mEmail"name="mEmail" placeholder="이메일"onchange="checkLogin()"/>  |  <input type="password" id="mPassword"name="mPassword" placeholder="암호" onchange="checkLogin()"/>  |  <a href="javascript:memberNaviSubmit()"><span id="loginout">로그인</span></a></c:if>
			<c:if test="${sessiondto!=null }">
				${sessiondto.mNickName }님 반갑습니다.   <a href="../member/memberMyInfo">내 정보</a>  |  <a href="../member/memberLogout"><span id="loginout">로그아웃</span></a>
			</c:if>
			
		</div>
	</div>
</form>


<!-- view page에서 회원관련 요청을 처리하는 링크설청이 되어있는 view page(content page에 import해서 사용.) -->