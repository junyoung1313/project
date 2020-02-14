<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberBoard.css?ver=2" type="text/css"><!-- memberBoard view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script><!-- jqury javascript 파일을 서버에서 불러옵니다. -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/memberBoardJs.js"></script><!-- 회원게시판에서 사용하는 javascript function들을 불러옵니다. -->
<title>회원게시판 글쓰기</title>
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
		<form id="memeberBoardWriteForm" action="memberBoardWrite"method="post">
		<input type="hidden" id="mEmail"name="mEmail"value="${sessiondto.mEmail }"/>
		<input type="hidden" id="mNickName"name="mNickName"value="${sessiondto.mNickName }"/>
			<div id="wrap">
				<p>■ 회원 게시판</p>
				<div id="content">
					<input type="text" id="mbTitle" name="mbTitle" class="fbinput"placeholder="제목">
					<textarea id="mbContent"></textarea>



					<a href="javascript:memberBoardSubmit()"><span class="btn_green" id="btn_Position1">글쓰기</span></a>
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