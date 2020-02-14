<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/freeBoard.css?ver=2" type="text/css"><!-- 자유게시판 view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script><!-- jqury script 파일을 서버에서 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/memberJs.js?ver=3" type="text/javascript"></script><!-- memberNav.jsp에서 사용하는 javascript function들을 불러옵니다. -->
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
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
		<form name="freeBoardForm" action="freeBoardWrite" method="get">			<div id="wrap">
				<p>■ 자유 게시판</p>
				<div id="content">
					<div id="outline">
						<input type="text" id="bName" class="fbinput"name="bName" placeholder="작성자"> 
						<input type="password" id="bPassword" name="bPassword" class="fbinput"placeholder="비밀번호"/><br/>
						<input type="text" id="bTitle" name="bTitle" class="fbinput"placeholder="제목">
						<textarea name="bContent"></textarea>
						
						<a href="javascript:document.freeBoardForm.submit();"><span class="btn_naver" id="fbfixbtn">글쓰기</span></a>
					</div>
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