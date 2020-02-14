<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/freeBoard.css?ver=2" type="text/css"><!-- 자유게시판 view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script><!-- jqury script 파일을 서버에서 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/memberJs.js?ver=3" type="text/javascript"></script><!-- memberNav.jsp에서 사용하는 javascript function들을 불러옵니다. -->
<title>답글 쓰기</title>
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
		<form name="freeBoardReplyForm" action="freeBoardReply" method="post">
			<div id="wrap">
				<p>■ 자유 게시판</p>
				<input type="text" id="bNum" name="bNum" value="${dto.bNum }" hidden="true"/>
				<input type="text" id="bGroup" name="bGroup" value="${dto.bGroup }"hidden="true" />
				<input type="text" id="bStep" name="bStep" value="${dto.bStep }" hidden="true"/>
				<input type="text" id="bIndent" name="bIndent" value="${dto.bIndent }" hidden="true"/>
				<input type="text" id="bTitle" name="bTitle" value="Re : ${dto.bTitle }" hidden="true">
				
				<div id="content">
					<input type="text" id="bName" name="bName" class="fbinput"value="${dto.bName }">
					<input type="password" id="bPassword" class="fbinput"name="bPassword"
						placeholder="비밀번호" /><br /> <input type="text" value="Re : ${dto.bTitle }" class="fbinput"disabled="disabled">
					<textarea name="bContent">${dto.bContent }</textarea>

					<a href="javascript:document.freeBoardReplyForm.submit()"><span
						class="btn_naver" id="fbfixbtn">답글달기</span></a>
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