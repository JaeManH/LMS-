<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="../assets/css/dropzone.css">
     <link rel="stylesheet" type="text/css" href="../assets/css/date-picker.css">
         <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
     
<meta charset="UTF-8">
<title>일반회원 과목 등록 양식 페이지</title>
  <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<%@ include file="../header.jsp" %>
<body>
         <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>개인정보 수정</h3>
                    <sec:authentication property="Details" var="info" /><br>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">메인</a></li>
                    <li class="breadcrumb-item">회원</li>
                    <li class="breadcrumb-item active">개인정보 수정</li>
                  </ol>
                </div>
                <div class="col-sm-6">
                  <!-- Bookmark Start-->
                  <div class="bookmark">
                    <ul>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Tables"><i data-feather="inbox"></i></a></li>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Chat"><i data-feather="message-square"></i></a></li>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Icons"><i data-feather="command"></i></a></li>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Learning"><i data-feather="layers"></i></a></li>
                      <li><a href="javascript:void(0)"><i class="bookmark-search" data-feather="star"></i></a>
                        <form class="form-inline search-form">
                          <div class="form-group form-control-search">
                            <input type="text" placeholder="Search..">
                          </div>
                        </form>
                      </li>
                    </ul>
                  </div>
                  <!-- Bookmark Ends-->
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="edit-profile">
              <div class="row">
                <div class="col-xl-4">
                  <div class="card">
                    <div class="card-header pb-0">
                      <h4 class="card-title mb-0">내 정보</h4>
                      <div class="card-options"><a class="card-options-collapse" href="#" data-bs-toggle="card-collapse"><i class="fe fe-chevron-up"></i></a><a class="card-options-remove" href="#" data-bs-toggle="card-remove"><i class="fe fe-x"></i></a></div>
                    </div>
                    <div class="card-body">
                      <form>
                        <div class="row mb-2">
                          <div class="profile-title">
                            <div class="media">                        <img class="img-70 rounded-circle" alt="" src="../assets/images/user/7.jpg">
                              <div class="media-body">
                                <h3 class="mb-1 f-20 txt-primary">${info.name}</h3>
                                <p class="f-12">${info.id}</p>
                              </div>
                            </div>
                          </div>
                        </div>
                         <div class="container-fluid">
            
          </div>
                       
                        <div class="mb-3">
                          <label class="form-label">이메일</label>
                          <input class="form-control" placeholder="${info.email}"  >
                        </div>
                        <div class="mb-3">
                          <label class="form-label">전화번호</label>
                         <input class="form-control" placeholder="${info.phone}"  >
                        </div>
                        <div class="mb-3">
                          <label class="form-label">생년월일</label>
                          <input class="form-control" placeholder="${info.birth }">
                        </div>
                         <sec:authorize access="hasAuthority('ROLE_INSTROCTUR')">
                        <div class="mb-3">
                          <label class="form-label">은행</label>
                          <input class="form-control" placeholder="${info.bank }">
                        </div>
                           <div class="mb-3">
                          <label class="form-label">계좌번호</label>
                          <input class="form-control" placeholder="${info.banknum }">
                        </div>
                         </sec:authorize><br>
                        
                      </form>
                    </div>
                  </div>
                </div>
                <div class="col-xl-8">
                   <sec:authorize access="hasAuthority('ROLE_USER')">
                  <form class="card " action="./editUser.do" method="POST">
                     </sec:authorize>
                   <sec:authorize access="hasAuthority('ROLE_INSTROCTUR')">
                    <form class="card " action="./editIns.do" method="POST">
                   </sec:authorize>
                    <div class="card-header pb-0">
                      <h4 class="card-title mb-0">내 정보 수정하기</h4>
                      <div class="card-options"><a class="card-options-collapse" href="#" data-bs-toggle="card-collapse"><i class="fe fe-chevron-up"></i></a><a class="card-options-remove" href="#" data-bs-toggle="card-remove"><i class="fe fe-x"></i></a></div>
                    </div>
                      <div class="card-body">
                       <div class="row">
                       <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                         <input class="form-control digits" type="hidden" value="${info.id}" required="" id="id">
                          
                            <label class="form-label" for="validationCustom01">생년월일</label>
                                 <input class="form-control digits" type="date" name="birth" value="${info.birth}" required="" id="validationCustom01">
                                <div class="valid-feedback">Looks good!</div>
                                  <div class="invalid-feedback">생년월일을 선택해주세요..</div>
                          </div>
                        </div>
                        
                        <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label class="form-label" for="validationCustom02">전화번호</label>
                            <input class="form-control" type="text" id="validationCustom02" name="phone" required="" value="${info.phone}">
                            <div class="valid-feedback">Looks good!</div>
                                  <div class="invalid-feedback">전화번호를 선택해주세요..</div>
                          </div>
                        </div>
                        <div class="col-md-12">
                          <div class="mb-3">
                            <label class="form-label" for="pw" >비밀번호</label>
                            <input class="form-control" id=pw name="pw" type="text" required=""  >
                           
                           
                          </div>
                        </div>
                         <div class="col-md-12">
                          <div class="mb-3">
                            <label class="form-label" for="pwChcek" >비밀번호 확인</label>
                            <input class="form-control" id=pwChcek  type="text" required=""  >
                            <div id="pw_check"></div>
                          </div>
                        </div>
                        <div class="col-md-12">
                          <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input class="form-control" type="email" name="email" required="" value="${info.email}"  >
                         <div class="valid-feedback"">Looks good!</div>
                            <div class="invalid-feedback" >이메일을 입력해주세요</div>
                          </div>
                            
                        </div>
                        <sec:authorize access="hasAuthority('ROLE_INSTROCTUR')">
                        <div class="col-md-5">
                          <div class="mb-3">
                            <label class="form-label">은행</label>
                            <select class="form-control btn-square" id="bank" name="bank" value="${info.bank}"  required="" aria-label="select example" >
                              <option >--은행 선택--</option>
                              <option  value="농협">농협</option>
                              <option  value="우리">우리</option>
                              <option  value="신한">신한</option>
                              <option  value="카카오">카카오</option>
                            </select>
                             <div class="valid-feedback">Looks good!</div>
                             <div class="invalid-feedback">은행을 선택해주세요</div>
                          </div>
                        </div>
                         <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label class="form-label">계좌번호</label>
                            <input class="form-control" type="text" value="${info.banknum }" name="banknum" required="">
                          </div>
                           <div class="valid-feedback">Looks good!</div>
                           <div class="invalid-feedback">계좌번호를 입력해주세요</div>
                        </div>
                        </sec:authorize>
<!--                         <div class="col-md-12"> -->
<!--                           <div> -->
<!--                             <label class="form-label">프로필 변경</label> -->
<!--                              <div> -->
<%--                         <input class="form-control" type="file" aria-label="file example" name="profile" required="" value="${info.profile}" > --%>
<!--                          <div class="valid-feedback">Looks good!</div> -->
<!--                         <div class="invalid-feedback">Example invalid form file feedback</div> -->
<!--                       </div> -->
<!--                           </div> -->
<!--                         </div> -->
                      </div>
                    </div>
                    <div class="card-footer text-end">
                      <button class="btn btn-primary" type="button" id="reg_submit" disabled="disabled">Update Profile</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid Ends-->
        </div>
        
  <!-- footer start-->
        <footer class="footer">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-6 footer-copyright">
                <p class="mb-0">Copyright 2021-22 © viho All rights reserved.</p>
              </div>
              <div class="col-md-6">
                <p class="pull-right mb-0">Hand crafted & made with <i class="fa fa-heart font-secondary"></i></p>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>
    <script type="text/javascript">

    var empJ = /\s/g;
    // 아이디 정규식 a-z 0-9로 시작하는 5~20자리 아이디를 만들수있다.
    var idregex = /^.*(?=^.{5,20}$)(?=.*\d)(?=.*[a-z]).*$/;
  
 	// 비밀번호 정규식 대소문자포함 4~12자리
	var pwJ = /^[A-Za-z0-9]{4,15}$/; 
	// 이름정규식 한글 또는 영어 2~6
    var nameJ = /^[가-힣a-zA-Z]{2,6}$/;
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰 번호 정규식
	var phoneJ = /^\d{3}-\d{3,4}-\d{4}$/;
	//이름 정규화
	

	$("#pw").blur(function() {

		var pw = $("#pw").val();
		var id = $("#id").val();
		var pwChcek = $("#pwChcek").val();
	    var checkNumber = pw.search(/[0-9]/g);
	    var checkEnglish = pw.search(/[a-z]/ig);
	 
	    if(pwJ.test(pw)){
			$("#pw_check").text('');
			$("#pwChcek").show();
			console.log("통과");
		}else if(pw.search(id) > -1){
			$('#pw_check').text("비밀번호에 아이디가 포함되었습니다.");
			$('#pw_check').css('color', 'red');
			$("#reg_submit").attr("disabled", true);
			$("#pwChcek").hide();
			}else{
				$('#pw_check').text("비밀번호는 대소문자,숫자 포함 4~15자리만 가능합니다 :)");
				$('#pw_check').css('color', 'red');
				$("#reg_submit").attr("disabled", true);
				$("#pwChcek").hide();
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
	
	$("#bank").blur(function() {

		var bank = $("#bank").val();
		
	  
	 
	    if(bank == ""){
	    	$('#bank').text("은행 선택해주세요");
			$('#pw_check').css('color', 'red');
			$("#reg_submit").attr("disabled", false);

			console.log("통과");
		}else{
			$("#reg_submit").attr("disabled", true);
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
			var auth = '${info.auth}'
			
			console.log(traEmail);	
			if(auth == "ROLE_INSTRUCTOR"){
			$.ajax({
	            url : '${pageContext.request.contextPath}/ins/CheckInsEmail.do?email='+ traEmail,
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
		}else{
			
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
		}
			});
			
			
		    $("#reg_submit").click(function() {
			    Swal.fire({
			      title: '개인정보 수정',
			      text: "다시 로그인하셔야합니다!",
			      icon: 'warning',
			      showCancelButton: true,
			      confirmButtonColor: '#3db39d',
				  cancelButtonColor: '#e4818b',
			      confirmButtonText: '확인',
			      cancelButtonText: '취소',
			      reverseButtons: false, // 버튼 순서 거꾸로
			      
			    }).then((result) => {
			      if (result.isConfirmed) {
			    	  $("form").submit() 
			      }
			    })
			});	
				
				
			
			
    </script>
    <!-- latest jquery-->
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
      <script src="../assets/js/form-validation-custom.js"></script>
    <!-- Plugins JS start-->
    	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    
    <script src="../assets/js/sweet-alert/sweetalert.min.js"></script>
    <script src="../assets/js/datepicker/date-picker/datepicker.js"></script>
    <script src="../assets/js/datepicker/date-picker/datepicker.en.js"></script>
    <script src="../assets/js/datepicker/date-picker/datepicker.custom.js"></script>
    <script src="../assets/js/dropzone/dropzone.js"></script>
    <script src="../assets/js/dropzone/dropzone-script.js"></script>
    <script src="../assets/js/tooltip-init.js"></script>
    <!-- Plugins JS Ends-->
    <!-- Theme js-->
    <script src="../assets/js/script.js"></script>
    <script src="../assets/js/theme-customizer/customizer.js"></script>
    <!-- login js-->
    <!-- Plugin used-->

</body>
</html>