/**
 * 
 */
function memberBoardModifySubmit(){
		$('#memberBoardModifyForm').submit();
	}
function memberBoardSubmit(){
	if($('#mbTitle').val()==''){
		alert("제목을 입력하세요.");
	}
	if(jQuery.trim($('#mbContent').val())==''){
		alert("내용을 입력하세요.");
	}
	var result=confirm("글쓰기를 완료하시겠습니까?");
	if(result){
		$('#memeberBoardWriteForm').submit();
	}
}