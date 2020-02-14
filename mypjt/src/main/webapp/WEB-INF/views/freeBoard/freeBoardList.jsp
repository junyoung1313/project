<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/shape.css?ver=1" type="text/css"> <!-- view page 구현시 필요한 div의 틀을 구성하는 css리소스를 불러옵니다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/freeBoard.css?ver=1" type="text/css"> <!-- 자유게시판 view page 구현시에 필요한 css리소스를 불러옵니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- jqury script 파일을 서버에서 불러옵니다. -->
<script src="<%=request.getContextPath() %>/js/memberJs.js?ver=3" type="text/javascript"></script><!-- memberNav.jsp에서 사용하는 javascript function들을 불러옵니다. -->
<title>자유게시판</title>
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
		<form name="freeBoardListForm">
			<div id="wrap">
				<p>■ 자유 게시판</p>
				<div id="content">
					<div id="outline">
						<div class="inline">
							<div id="title" class="inOb">제목</div>
							<div id="name" class="inOb">글쓴이</div>
							<div id="date" class="inOb">작성시간</div>
							<div id="hit" class="inOb">조회수</div>
							<div id="good" class="inOb">좋아요</div>
						</div>
						<hr />


						<c:forEach items="${dtos }" var="dto">
							<div class="inline">
							
								<div id="title" class="inOb">
									<c:forEach begin="1" end="${dto.bIndent }" step="1">　</c:forEach>
									<a href="freeBoardView?bNum=${dto.bNum }">${dto.bTitle }</a>
								</div>
								
								<div id="name" class="inOb">${dto.bName }</div>
								<div id="date" class="inOb">${dto.bDate }</div>
								<div id="hit" class="inOb">${dto.bHit }</div>
								<div id="good" class="inOb">${dto.bGood }</div>
							</div>
						</c:forEach>



						<hr />
					</div>



					<div id="pageNum">
					
						<div id="pagewrap">
							<div class="prenext">
								&nbsp;<c:if test="${pageNum>1 }"><a href="?pageNum=${pageNum-1 }">이전</a></c:if>
							</div>
							
							<div id="pageNumber">
								<c:forEach var="page" begin="${startPage }" end="${endPage }" step="1">
									<c:if test="${page==pageNum }"><strong>${page }</strong></c:if>
									<c:if test="${page!=pageNum }"><a href="?pageNum=${page }">${page }</a></c:if>
								</c:forEach>
							</div>
							
							
							<div class="prenext">
								<c:if test="${pageNum<max }"><a href="?pageNum=${pageNum+1 }">다음</a></c:if>&nbsp;
							</div>
						</div>
					</div>



					<a href="freeBoardWriteView"><span class="btn_naver" id="fbfixbtn">글쓰기</span></a>
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