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
	
<title>회원 정보</title>
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
		<form id="memberMyInfoForm" action="memberModifyView" method="post">
			<div id="wrap">
				<p>■ 회원 정보</p>
				<div id="content">
					
					
					<div class="memdiv">
						<div class="memdivLeft">이메일</div>
						<div class="memdivRight">${sessiondto.mEmail }</div>
						<input type="hidden" id="mEmail"name="mEmail"value="${dto.mEmail }"/>
						<hr/>
					</div>
					<div class="memdiv">
						<div class="memdivLeft">별명</div>
						<div class="memdivRight">${sessiondto.mNickName }</div>
						<hr/>
					</div>
					<div class="memdiv">
						<div class="memdivLeft">가입일</div>
						<div class="memdivRight">${sessiondto.mJoinDate }</div>
						<hr/>
					</div>
					
					
					<a href="javascript:memModifyInfoSubmit()"><span class="btn_green" id="btn_Position3">정보수정</span></a>
					<a href="memberPWChangeView"><span class="btn_green" id="btn_Position2">비번 변경</span></a>
					<a href="memberDeleteView"><span class="btn_green" id="btn_Position1">탈퇴</span></a>
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