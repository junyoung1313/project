<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/member.css?ver=2" type="text/css"><!-- member view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script><!-- jqury javascript 파일을 서버에서 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/memberJs.js?ver=3" type="text/javascript"></script><!-- memberNav.jsp에서 사용하는 javascript function들을 불러옵니다. -->

<title>회원 가입</title>
</head> 
<body>
	<!-- view페이지 구성시 기본 틀에 해당하는 회원,헤더,게시판목록 링크가 적혀있는 페이지를 삽입 시켜주는 구문입니다. -->
	<div>
		<jsp:include page="../memberNav.jsp"/>
	</div>
	<div>
		<jsp:include page="../header.jsp"/>
	</div>
	<div>
		<jsp:include page="../nav.jsp"/>
	</div>
	
	<c:set var="isSamePw" value="동일하지 않음"></c:set>
	
	<section>
		<form name="memberInsertForm" action="memberInsert" method="post">
			<div id="wrap">
				<p>■ 회원 관리</p>
				<div id="content">
					<div class="memdiv">
						<input type="text" id="mEmail" name="mEmail" class="meminput" placeholder="이메일" onchange="checkEnN('checkId')" maxlength="30"/>
						<input type="hidden" id="emailCheck" name="emailCheck" value="N"/><br/><p id="pEmailCheck" ></p>
					</div>
					<div class="memdiv">
						<input type="password" id="mPassword1" name="mPassword1"  class="meminput" placeholder="비밀번호" onkeyup="javascript:passCheck()"/>
					</div>
					
					<div class="memdiv">
						<input type="password" id="mPassword2" name="mPassword2"  class="meminput" placeholder="비밀번호 확인" onkeyup="javascript:passCheck()"/><span id="pwCheckSpan" hidden="true">비번 동일.</span>
						<input type="hidden" id="pwCheck"  value="N"/><br/><p id="pPwCheck" ></p>
					</div>
					
					<div class="memdiv">
						<input type="text" id="mNickName"name="mNickName"  class="meminput" placeholder="닉네임" onchange="checkEnN('checkNick')" maxlength="8"/>
						<input type="hidden" id="nickCheck"  value="N"/><br/><p id="pNickNameCheck"></p>
					</div>
					<a href="javascript:memberInsertSubmit()"><span class="btn_green" id="btn_Position1">회원 가입</span></a>
				</div>
			</div>
			<div id="banner"></div>
		</form>
	</section>
	<div>
		<jsp:include page="../footer.jsp"/>
	</div>


</body>
</html>