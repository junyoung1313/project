/**
 * 
 */

	
	
	function passCheck(){
		var pw1=$('#mPassword1').val();
		var pw2=$('#mPassword2').val();
		if(pw1==pw2){
			$('#pwCheck').val('Y');
			$('#pPwCheck').text('비밀번호가 같습니다.').css('color','#0000ff');
		}else{
			$('#pwCheck').val('N');
			$('#pPwCheck').text('비밀번호가 같습니다.').css('color','#ff0000');
		}
	}
	function memberInsertSubmit(){
		var emailCheck=$('#emailCheck').val();
		var pwCheck=$('#pwCheck').val();
		var nickCheck=$('#nickCheck').val();
		
		if(emailCheck!="Y"){
			alert("email을 다시 확인해주세요.");
			return false;
		}
		if(pwCheck!="Y"){
			alert("비밀번호를 다시 확인해주세요.");
			return false;
		}
		if(nickCheck!="Y"){
			alert("별명를 다시확인해주세요.");
			return false;
		}
		document.memberInsertForm.submit();
	}
	
	function checkEnN(path){
		var getStr;
		if(path=='checkId'){
			getStr=$('.memdiv  #mEmail').val();
		}else if(path == 'checkNick'){
			getStr=$(".memdiv  #mNickName").val();
		}else if(path =='checkPw'){
			getStr=$('.memdiv #mPassword').val();
		}
		
		
		
		var checkPath='/mypjt/member/'+path+'?getStr='+getStr;
		
		
		
		fetch(checkPath).then(function(res){
			res.text().then(function(text){
				if(text==1){
					if(path=='checkId'){
						$('.memdiv  #emailCheck').val('N');
						$('#pEmailCheck').css('color','#ff0000').text('사용불가한 Email입니다.');
					}else if(path == 'checkNick'){
						$('.memdiv  #nickCheck').val('N');
						$('#pNickNameCheck').css('color','#ff0000').text('사용불가한 별명입니다.');
					}else if(path== 'checkPw'){
						$('.memdiv  #pwCheck').val('Y');
						console.log($('.memdiv  #pwCheck').val());
					}
					
				}else{
					if(path=='checkId'){
						$('.memdiv  #emailCheck').val('Y');
						$('#pEmailCheck').css('color','#0000ff').text('사용가능한 Email입니다.');
					}else if(path == 'checkNick'){
						$('.memdiv  #nickCheck').val('Y');
						$('#pNickNameCheck').css('color','#0000ff').text('사용가능한 별명입니다.');
					}else if(path== 'checkPw'){
						$('.memdiv  #pwCheck').val('N');
						console.log($('.memdiv  #pwCheck').val());
					}
					
				}
				
			});
		});
		
	}
	
	function memberModifyFormSubmit(){
		if($('#pwCheck').val()=='N'){
			alert('비밀번호를 화인해주세요.');
			return;
		}else if($('#nickCheck').val()=='N'){
			alert('별명을 새로 입력해주세요.');
			return;
		}
		$( "#memberModifyForm" ).submit();
	}
	function memModifyInfoSubmit(){
		$('#memberMyInfoForm').submit();
	}
	
	
	function memPWChange(){
		var pw1= $('mPassword1').val();
		var pw2= $('mPassword2').val();
		if(pw1!=pw2){
			alert("변경할 비밀번호 확인해주세요");
		}else if($('#pwCheck').val()=='N'){
			alert("현재 비밀번호가 맞지 않습니다.");
		}else{
			$('#memberDeleteForm').submit();
		}
	}
	
	
	function memDelete(){
		if($('#pwCheck').val()=='Y'){
			$('#memberDeleteForm').submit();
		}else{
			alert("비밀번호를 다시 확인해주세요.");
		}
	}
	
	function checkLogin(){
		var mEmail=$('#mEmail').val();
		var mPassword=$('#mPassword').val();
		
		fetch('/mypjt/member/checkLogin?mEmail='+mEmail+'&mPassword='+mPassword).then(function(res){
			res.text().then(function(text){
				if(text==1){
					$('#loginCheck').val('Y');
				}else if(text==2){
					$('#loginCheck').val('C');
				}else{
					$('#loginCheck').val('N');
				}
			})
		});
		
	}	
	
	function memberNaviSubmit(){
		if($('#loginCheck').val()=='Y'){
			$('#memberNavi').submit();
		}else if($('#loginCheck').val()=='N'){
			alert('이메일 혹은 비밀번호를 다시 확인해주세요.');
		}else{
			alert('탈퇴한 회원입니다 \n관리자에게 문의하여주세요.');
		}
	}