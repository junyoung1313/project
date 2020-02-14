<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberBoard.css?ver=2" type="text/css"><!-- memberBoard view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/memberBoardJs.js"></script><!-- 회원게시판에서 사용하는 javascript function들을 불러옵니다. -->
<title>회원 글 수정</title>
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
		<form id="memberBoardModifyForm" action="memberBoardModify" method="post">
			<div id="wrap">
				<p>■ 회원 게시판</p>
				<div id="content">
					<input type="hidden" id="mbNum"name="mbNum"value="${dto.mbNum }"/>
					<input type="text" id="mbTitle" name="mbTitle" class="fbinput"placeholder="제목"value="${dto.mbTitle }"/>
					<textarea name="mbContent">${dto.mbContent }</textarea>


					<c:if test="${sessiondto.mEmail==dto.mEmail }">
						<a href="javascript:memberBoardModifySubmit()"><span class="btn_green" id="btn_Position1">수정</span></a>
					</c:if>
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