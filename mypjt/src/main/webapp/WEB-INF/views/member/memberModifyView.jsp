<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/member.css?ver=2" type="text/css"><!-- member view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script><!-- jqury javascript 파일을 서버에서 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/memberJs.js?ver=3" type="text/javascript"></script><!-- memberNav.jsp에서 사용하는 javascript function들을 불러옵니다. -->
<title>회정 정보 수정</title>
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
	
	
	
	<section>
		<form id="memberModifyForm"name="memberModifyForm" action="memberModify" method="post">
			<div id="wrap">
				<p>■ 회원 정보</p>
				<div id="content">
					<div class="memdiv">
						<div class="memdivLeft">Email</div>
						<div class="memdivRight">:  <input type="hidden" id="mEmail"name="mEmail"value="${sessiondto.mEmail }"class="meminput"/> ${sessiondto.mEmail }</div>
					</div>
					<div class="memdiv">
						<div class="memdivLeft">비밀번호</div> 
						<div class="memdivRight">:  <input type="password" id="mPassword"name="mPassword" class="meminput" onchange="checkEnN('checkPw')"/><br/>
							<input type="text" id="pwCheck" value="N">										
						</div>
					</div>
					<div class="memdiv">
						<div class="memdivLeft">별명:</div>
						<div class="memdivRight">:  <input type="text"id="mNickName"name="mNickName" value="${sessiondto.mNickName }"class="meminput" onchange="checkEnN('checkNick')"/>
						</div>
						<br/><input type="hidden" id="nickCheck" value="N"><p id="pNickNameCheck"></p>
					</div>
					<a href="javascript:memberModifyFormSubmit()" onclick=""><span class="btn_green" id="btn_Position2">정보 변경</span></a>
					<a href="javascript:history.back();"><span class="btn_green" id="btn_Position1">뒤로가기</span></a>
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