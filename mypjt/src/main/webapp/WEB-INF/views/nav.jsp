<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/nav.css?ver=1" type="text/css">
<hr/>
<div id="nav">
	<a href="../freeBoard/freeBoardList">자유게시판</a> | <a href="../memberBoard/memberBoardList">회원게시판</a>

</div>
<hr/>


<!-- view page에서 게시판 항목의 링크를 설정해둔 view page(content page에 import해서 사용.) -->