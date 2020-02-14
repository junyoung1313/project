
<!-- login상태의 값을 받아서 login상태를 확인하여 회원 게시판이용여부를 체크하는 부분입니다. -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript">
	function memBoardCheck(s){
		if(s==1){
			alert("로그인 하셔야 합니다.");
		}
		history.back(-1);
	}
</script>
<title>Insert title here</title>
</head>
<body onload="javascript:memBoardCheck(${checkValuse})">

</body>
</html>