<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css?ver=1" type="text/css">

<div id="header">
	<a href="../freeBoard/freeBoardList"><img alt="Logo" src="<%=request.getContextPath() %>/img/logo.jpg" id="headerLogo"></a>
</div>

<!-- view page에서 header관련(현재는 임시logo만 있는 상태이지만 추가 가능) 요청을 처리하는 링크설청이 되어있는 view page(content page에 import해서 사용.) -->