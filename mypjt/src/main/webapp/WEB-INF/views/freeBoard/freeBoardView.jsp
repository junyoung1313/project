<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=2" type="text/css"><!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/freeBoard.css?ver=2" type="text/css"><!-- 자유게시판 view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script><!-- jqury script 파일을 서버에서 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/memberJs.js?ver=3" type="text/javascript"></script><!-- memberNav.jsp에서 사용하는 javascript function들을 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/freeBoardJs.js" type="text/javascript"></script><!-- 자유게시판에서 사용하는 javascript function들을 불러옵니다. -->
<title>게시글 보기</title>
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
		<form name="freeBoardViewForm">
			<div id="wrap">
				<p>■ 자유 게시판</p><input type="hidden" id="bPassword"value="${dto.bPassword }">
				<div id="content">
						<div id="outline">
						<div id="fbTitle">${dto.bTitle }</div> <div id="fbDate">${dto.bDate }</div>
						<hr/>
						<div id="fbName">${dto.bName }</div> <div class="hgr">답글 수 ${replyCount }</div><div class="hgr">추천 수 ${dto.bGood }</div><div class="hgr">조회 수 ${dto.bHit }</div>
						<hr/>
						<div id="fbContent">${dto.bContent}</div>
						
						</div>
						
						<a href="javascript:promptPw('${dto.bNum}')"><span class="btn_naver" id="fbDelete">글삭제</span></a><br/>
						<a href="freeBoardModifyView?bNum=${dto.bNum }"><span class="btn_naver" id="fbModify">글수정</span></a><br/>
						<a href="freeBoardReplyView?bNum=${dto.bNum }"><span class="btn_naver" id="fbfixbtn">답글쓰기</span></a>
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