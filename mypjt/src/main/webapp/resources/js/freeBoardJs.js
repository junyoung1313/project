/**
 * 
 */

	function promptPw(bNum){
		var bPassword=prompt('비밀번호를 입력해주세요.','비밀번호');
		if(bPassword!=null){
			if(bPassword==$('#bPassword').val()){
				$(location).attr('href','freeBoardDelete?bNum='+bNum);
			}else if(bPassword!=$('#bPassword').val()){
				alert('비밀번호가 틀렸습니다.');
			}
		}
		
		
	}
	function pwcheck(){
		if($('#brPassword').val()=='N'){
			alert("비밀번호가 틀립니다.");
		}else{
			$('#freeBoardModifyForm').submit();
		}
	}
	
	function pwServerCheck(bNum){
		fetch('pwServerCheck?bNum='+bNum+'&bPassword='+$('#bPassword').val()).then(function (res){
			res.text().then(function (text){
				if(text==1){
					$('#brPassword').val('Y');
				}else{
					$('#brPassword').val('N');
				}
			})
		})
	}