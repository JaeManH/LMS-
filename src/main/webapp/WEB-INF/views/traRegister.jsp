<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.min.vo.*"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="viho admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, viho admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="pixelstrap">
    <link rel="icon" href="./assets/images/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="./assets/images/favicon.png" type="image/x-icon">
    <title>viho - Premium Admin Template</title>
    <!-- Google font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <!-- Font Awesome-->
    <link rel="stylesheet" type="text/css" href="../assets/css/fontawesome.css">
    <!-- ico-font-->                              
    <link rel="stylesheet" type="text/css" href="../assets/css/icofont.css">
    <!-- Themify icon-->                          
    <link rel="stylesheet" type="text/css" href="../assets/css/themify.css">
    <!-- Flag icon-->                             
    <link rel="stylesheet" type="text/css" href="../assets/css/flag-icon.css">
    <!-- Feather icon-->                          
    <link rel="stylesheet" type="text/css" href="../assets/css/feather-icon.css">
    <!-- Plugins css start-->                     
    <link rel="stylesheet" type="text/css" href="../assets/css/sweetalert2.css">
    <!-- Plugins css Ends-->                      
    <!-- Bootstrap css-->                         
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
    <!-- App css-->                               
    <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
    <link id="color" rel="stylesheet" href="../assets/css/color-1.css" media="screen">
    <!-- Responsive css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/responsive.css">
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <style type="text/css">
     #exampleFormControlTextarea9 {
    width: 100%;
    height: 6.25em;
    border: none;
    resize: none;
    text-align: left;
     height: 88px;
  overflow: auto;
  margin-top: 8px;
  padding: 12px;
  border: 1px solid #dadada;
  background: #fff;
  font-size: 12px;
  }
    </style>
  </head>
  <body>
    <!-- Loader starts-->
    <div class="loader-wrapper">
      <div class="theme-loader">    
        <div class="loader-p"></div>
      </div>
    </div>
    <!-- Loader ends-->
    <!-- page-wrapper Start-->
    <section>         
    <div class="container-fluid">
                    
                  </div>
            <div class="row m-0">
           <div class="col-12 p-0">    

             
      <div class="container-fluid p-0"> 
        <div class="row m-0">
          <div class="col-12 p-0">    
            <div class="login-card" >
              <form class="theme-form login-form form-wizard" method="post" action="./traSingUpSc.do">
                   <div class="tab">
                   <form  id="form__wrap">
                    <h4>일반회원 회원가입</h4>
                		<h6>LMS</h6>
                		 
                <div class="checkbox_group">

  				<input class="checkbox_animated" style="border-radius: 4px;" type="checkbox" id="check_all" ">
  				<label for="check_all">전체 동의 LMS 이용약관, 개인정보 수집 및 이용, 프로모션 정보
              수신(선택)에 모두 동의합니다.</label>
              
  						 <div class="form-group m-t-15 m-checkbox-inline mb-0">
  			<input type="checkbox" id="check_1" class="normal checkbox_animated" >
 			 <label for="check_1">개인정보 처리방침 동의</label>
                            <label class="form-label" for="exampleFormControlTextarea9"></label>
                            <textarea class="form-control" id="exampleFormControlTextarea9" rows="3">
여러분을 환영합니다. LMS 서비스 및 제품
(이하 ‘서비스’)을 이용해 주셔서 감사합니다.
본 약관은 다양한 LMS 서비스의 이용과 관련하여 LMS 서비스를 제공하는 LMS 주식회사(이하 ‘LMS’)와 
                            이를 이용하는 LMS 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 LMS  서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다. LMS 서비스를 이용하시거나
LMS 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로,
잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
                            </textarea>

                          </div>
                          
    						 <div class="form-group m-t-15 m-checkbox-inline mb-0">
                            <input type="checkbox" id="check_2" class="normal checkbox_animated" >
  							<label for="check_2">서비스 이용약관 동의</label>
                            <label class="form-label" for="exampleFormControlTextarea9"></label>
                            <textarea class="form-control " id="exampleFormControlTextarea9" rows="3">
개인정보보호법에 따라 LMS에 회원가입 신청하시는 분께 수집하는 개인정보의 항목,
개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부
 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
1. 수집하는 개인정보 이용자는 회원가입을 하지 않아도 과정 보기, 과목 보기 등 LMS 서비스를 회원과 동일하게 이용할 수 있습니다.
 이용자가 과목 등록, 과정 등록, 글 작성,   강의지원 등과 같이 강사 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 
LMS 서비스 이용을 위해 필요한 최소한의 개인정보를 수집          합니다.</textarea>
                          </div>
				
   						 <div class="form-group m-t-15 m-checkbox-inline mb-0">
   						 <input type="checkbox" id="check_3" class="normal checkbox_animated" >
  							<label for="check_3">마케팅 수신 동의</label>
                            <label class="form-label" for="exampleFormControlTextarea9"></label>
                            <textarea class="form-control"  id="exampleFormControlTextarea9" rows="3">
LMS에서 제공하는 이벤트/혜택 등 다양한 정보를 휴대전화(LMS앱 알림 또는 문자), 이메일로 받아보실 수 있습니다.
 일부 서비스(별도 회원 체계로 운영하거나 LMS 가입 이후 추가 가입하여 이용하는 서비스 등)의 경우,
개별 서비스에 대해 별도 수신 동의를 받을 수 있으며, 이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니다.
                            </textarea>
                          </div>
						</div>
						<br>
                        <div class="text-end btn-mb">
                          <button class="btn btn-secondary" id="prevBtn" type="button" onclick="nextPrev(-1)">Previous</button>
                          <button class="btn btn-primary next-button" id="nextBtn"  type="submit" onclick="nextPrev(1)" disabled>Next</button>
                        </div>
                                          <input class="btn btn-warning btn-block btn-xs " type="button" value="뒤로가기" onclick="history.back(-1)">
                        
                        <form  id="form__wrap">
                      </div>
                      
                <div class="tab">
                <h4>일반회원 회원가입</h4>
                <h6>계정을 만들려면 개인 정보를 입력하세요</h6>
                <div class="form-group">
                  <label>이름</label>
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                    <input class="form-control" type="text" id="name" name="name" required="" placeholder="이름">
                  </div>
                      <span class="check_font" id="name_check"></span>
                  <div class="form-group">
                  <label>아이디</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="text" id="id" name="id" required="" placeholder="id" >
                   
                  </div>
                   <span class="check_font" id="id_check"></span>
                
                </div>
                <div class="row">
                
                <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                <label>비밀번호</label>
                  <div class="small-group">
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                      <input class="form-control" type="password" id="pw" name="pw" required="" placeholder="******">
                    </div>
  					</div>
  					</div></div>
  					<div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                <label>비밀번호 확인</label>
                  <div class="small-group">
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                      <input class="form-control" type="password" id="pwChcek" required="" placeholder="******">
                    </div>
  					</div>
  					</div></div>
  					  <span class="check_font" id="pw_check"></span>
  					
  					
                 <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                <label>전화번호</label>
                  <div class="small-group">
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                      <input class="phoneNumber form-control" type="text" name="phone" id="phone" maxlength='13' value="010" required="" onkeyup="keyup" placeholder="010-">
                    </div>
  					</div>
  					</div>
  					  <span class="check_font" id="phone_check"></span></div>
  					
  					
  					 <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
  					<label>생년월일</label>
  					<div class="small-group">
  					
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                      <input class="form-control digits" type="date" name="birth" id="birth" required="" id="validationCustom01">
                    </div>
                  </div>
                  
                </div>
                </div>
                </div>
               <div class="row">
                <div class="form-group">
                  <label>Email Address</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="email" id="email" name="email" required="" placeholder="Test@gmail.com">
                  </div>
                </div>
                <span class="check_font" id="email_check"></span>
  <div class="col-lg-12">

      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
               
              <div class="form-group">
                <button class="btn btn-outline-secondary btn-xs" id="prevBtn" type="button" onclick="nextPrev(-1)">이전</button>
                </div>
                <div class="form-group">
                  <button class="btn btn-primary btn-block" type="submit" id="reg_submit">회원가입</button>
                </div>
                <div class="login-social-title">                
                  <h5>signup with</h5>
                </div>
                <div class="form-group">
                  <ul class="login-social">
                    <li><a href="https://www.linkedin.com/login" target="_blank"><i data-feather="linkedin"></i></a></li>
                    <li><a href="https://www.linkedin.com/login" target="_blank"><i data-feather="twitter"></i></a></li>
                    <li><a href="https://www.linkedin.com/login" target="_blank"><i data-feather="facebook"></i></a></li>
                    <li><a href="https://www.instagram.com/login" target="_blank"><i data-feather="instagram">                  </i></a></li>
                  </ul>
                </div>
                </div>
                 
                <p>이미 계정이 있으신가요?<a class="ms-2" href="./loginPage.do">로그인</a></p>
                  <p><a class="ms-2" href="../app/main.do">메인으로</a></p>
              <div class="text-center"><span class="step"></span><span class="step"></span></div>
              </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  
        
    <!-- page-wrapper end-->
    <!-- latest jquery-->
    <script>
//     $(".checkbox_group").on("click", "#check_all", function () {
//     	var checked = $(this).is(":checked");
//     	if(checked){
//          $(this).parents(".checkbox_group").find('input').prop("checked", checked);
//          $("#nextBtn").attr("disabled",false);
//     	}else{
//     		 $(this).parents(".checkbox_group").find('input').prop("checked", checked);
//     		 $("#nextBtn").attr("disabled",true);
//     	}
//     });

  

// // 체크박스 개별 선택
// $(".checkbox_group").on("click", ".normal", function() {
//     var is_checked = true;

//     $(".checkbox_group .normal").each(function(){
//         is_checked = is_checked && $(this).is(":checked");
//     });

//     $("#check_all").prop("checked", $(this).is(":checked"));
// });
    
    $(".checkbox_group").on("click", "#check_all", function () {
  	var checked = $(this).is(":checked");
  	if(checked){
       $(this).parents(".checkbox_group").find('input').prop("checked", true);
       $("#nextBtn").attr("disabled",false);
  	}else{
  		 $(this).parents(".checkbox_group").find('input').prop("checked", false);
  		 $("#nextBtn").attr("disabled",true);
  	}
  });


// 체크박스 개별 선택
$(".checkbox_group").on("click", ".normal", function() {
    var is_checked = true;

    $(".checkbox_group .normal").each(function(){
        is_checked = is_checked && $(this).is(":checked");
    });
    
    $("#check_all").prop("checked", is_checked);
    if(is_checked){
		 $("#nextBtn").attr("disabled",false);

    }else{
 		 $("#nextBtn").attr("disabled",true);

    }
    
});
    
    
    
    
    
    
    
    var empJ = /\s/g;
    // 아이디 정규식 a-z 0-9로 시작하는 5~20자리 아이디를 만들수있다.
    var idregex = /^.*(?=^.{5,20}$)(?=.*\d)(?=.*[a-z]).*$/;
  
 	// 비밀번호 정규식 대소문자포함 4~12자리
	var pwJ = /^[A-Za-z0-9]{4,15}$/; 
	// 이름정규식 한글 또는 영어 2~6
    var nameJ = /^[가-힣a-zA-Z]{2,6}$/;
	// 이메일 검사 정규식 특수문자 점(.) 하이픈(-) 언더바(_) 만 사용가능
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰 번호 정규식
	var phoneJ = /^\d{3}-\d{3,4}-\d{4}$/;
	//이름 정규화
	$("#name").blur(function() {
		if (nameJ.test($(this).val())) {
				console.log(nameJ.test($(this).val()));
				$("#name_check").text('');
		} else {
			$('#name_check').text('이름을 확인해주세요');
			$('#name_check').css('color', 'red');
		}
	});
	//아이디 중복확인 및 정규화
	$("#id").blur(function() {
		// id = "id_reg" / name = "userId"
		var traId = $('#id').val();
		console.log(traId);	
		$.ajax({
// 			url : './CheckTraId.do',
            url : '${pageContext.request.contextPath}/user/CheckTraId.do?id='+ traId,
// 			data:'id='+traId,
			type : 'get',
			success : function(data) {
				
		console.log("1 = 중복o / 0 = 중복x : "+ data);							
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다.");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						//0인경우
						if(idregex.test(traId)){
							$("#id_check").text('사용 가능합니다.');
							$("#reg_submit").attr("disabled", false);
							$('#id_check').css('color', 'blue');
						}else if(traId == ""){
							
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
						}else{
							$('#id_check').text("아이디는 대소문자,숫자 포함 5~20자리만 가능합니다 :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
		
		$("#pw").blur(function() {

			var pw = $("#pw").val();
			var id = $("#id").val();
			var pwChcek = $("#pwChcek").val();
		    var checkNumber = pw.search(/[0-9]/g);
		    var checkEnglish = pw.search(/[a-z]/ig);
		 
		    if(pwJ.test(pw)){
				$("#pw_check").text('');
				$("#reg_submit").attr("disabled", false);

				console.log("통과");
			}else if(pw.search(id) > -1){
				$('#pw_check').text("비밀번호에 아이디가 포함되었습니다.");
				$('#pw_check').css('color', 'red');
				$("#reg_submit").attr("disabled", true);
				}else{
					$('#pw_check').text("비밀번호는 대소문자,숫자 포함 4~15자리만 가능합니다 :)");
					$('#pw_check').css('color', 'red');
					$("#reg_submit").attr("disabled", true);
				}		

			
		});
		
		$("#pwChcek").blur(function() {

			var pw = $("#pw").val();
			var id = $("#id").val();
			var pwChcek = $("#pwChcek").val();
		  
		 
		    if(pw != pwChcek){
		    	$('#pw_check').text("비밀번호 확인이 틀렸습니다.");
				$('#pw_check').css('color', 'red');
				$("#reg_submit").attr("disabled", true);

				console.log("통과");
			}else{
				$("#pw_check").text('');
				$("#reg_submit").attr("disabled", false);
			}	
		   
			
		});
		
		
		//전화번호 정규화
		$(document).on("keyup", ".phoneNumber", function() { 
		
			$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
				
			});
		
		
		//아이디 중복확인 및 정규화
		$("#email").blur(function() {
			// id = "id_reg" / name = "userId"
			var traEmail = $('#email').val();
			console.log(traEmail);	
			$.ajax({
	            url : '${pageContext.request.contextPath}/user/CheckTraEmail.do?email='+ traEmail,
//	 			data:'id='+traId,
				type : 'get',
				success : function(data) {
					
			console.log("이메일 : 1 = 중복o / 0 = 중복x : "+ data);							
					if (data == 1) {
							// 1 : 아이디가 중복되는 문구
							$("#email_check").text("사용중인 이메일입니다.");
							$("#email_check").css("color", "red");
							$("#reg_submit").attr("disabled", true);
						} else {
							//0인경우
							if(mailJ.test(traEmail)){
								$("#email_check").text('사용 가능합니다.');
								$("#reg_submit").attr("disabled", false);
								$("#email_check").css("color", "blue");
							}else if(traEmail == ""){
								
								$('#email_check').text('이메일를 입력해주세요 :)');
								$('#email_check').css('color', 'red');
								$("#reg_submit").attr("disabled", true);				
							}else{
								$('#email_check').text("이메일 형식에 맞게 입력해주세요 :)");
								$('#email_check').css('color', 'red');
								$("#reg_submit").attr("disabled", true);
							}						
						}
					}, error : function() {
							console.log("실패");
					}
				});
			});
			
</script>
 </script>
    <script src="../assets/js/jquery-3.5.1.min.js"></script>
    <!-- feather icon js-->
    <script src="../assets/js/icons/feather-icon/feather.min.js"></script>
    <script src="../assets/js/icons/feather-icon/feather-icon.js"></script>
    <!-- Sidebar jquery-->
    <script src="../assets/js/sidebar-menu.js"></script>
    <script src="../assets/js/config.js"></script>
    <!-- Bootstrap js-->
    <script src="../assets/js/bootstrap/popper.min.js"></script>
    <script src="../assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- Plugins JS start-->
    <script src="../assets/js/form-wizard/form-wizard.js"></script>

    <script src="../assets/js/sweet-alert/sweetalert.min.js"></script>
    <!-- Plugins JS Ends-->
    <!-- Theme js-->
    <script src="../assets/js/script.js"></script>
    <!-- login js-->
    <!-- Plugin used-->
   
  </body>
</html>