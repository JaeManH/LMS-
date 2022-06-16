<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindTraPwForm</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="viho admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, viho admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="pixelstrap">
    <link rel="icon" href="./assets/images/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="../assets/images/favicon.png" type="image/x-icon">
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
    <!-- Plugins css Ends-->
        <!-- Plugins css start-->
    <link rel="stylesheet" type="text/css" href="../assets/css/sweetalert2.css">
    <!-- Bootstrap css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
    <!-- App css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
    <link id="color" rel="stylesheet" href="../assets/css/color-1.css" media="screen">
    <!-- Responsive css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/responsive.css">
<script type="text/javascript">
	function findTraId(){
		console.log('아이디 찾기');
		var name = document.getElementById('inputName');
		var email = document.getElementById('inputEmail');
		var id = document.getElementById('inputId');
		console.log(name.value, email.value);
		
		var frm = document.forms[0];
// 		frm.action = "./login.do";
		console.log(frm);
		
		// 유효성 검사 후 Ajax 로그인
		if(name.value == "" || name.value.trim() == ""){
			name.value = "";
			name.focus();
			
			 Swal.fire({
                 icon: 'warning',
                 title: '아이디를 입력해주세요.',
                 timer: 1500,
                 timerProgressBar: true,
                 didOpen: () => {
                   Swal.showLoading()
                   const b = Swal.getHtmlContainer().querySelector('b')
                   timerInterval = setInterval(() => {
                     b.textContent = Swal.getTimerLeft()
                   }, 100)
                 },
                 willClose: () => {
                   clearInterval(timerInterval)
                 }
               }).then((result) => {
                 /* Read more about handling dismissals below */
                 if (result.dismiss === Swal.DismissReason.timer) {
                   console.log('I was closed by the timer')
                 }
             });
			
		}else if(email.value == "" || email.value.trim() == ""){
			email.value = "";
			email.focus();
			 Swal.fire({
                 icon: 'warning',
                 title: '이메일을 입력해주세요.',
                 timer: 1500,
                 timerProgressBar: true,
                 didOpen: () => {
                   Swal.showLoading()
                   const b = Swal.getHtmlContainer().querySelector('b')
                   timerInterval = setInterval(() => {
                     b.textContent = Swal.getTimerLeft()
                   }, 100)
                 },
                 willClose: () => {
                   clearInterval(timerInterval)
                 }
               }).then((result) => {
                 /* Read more about handling dismissals below */
                 if (result.dismiss === Swal.DismissReason.timer) {
                   console.log('I was closed by the timer')
                 }
             });
		}else{
			$.ajax({
// 				url:"./loginCheckText.do", // 반환되는 값을 Text 로 처리
				url:"./findTraPw.do", // 반환되는 값을 Map(JSON) 으로 처리
				dataType :'json',
				data:{"id":id.value,"name":name.value ,"email":email.value},
				success:function(data){
					console.log(data);
					if(data ==true){
						console.log(data);
						alert("임시 비밀번호가 발급되었습니다.메일함을 확인해 주세요");

					}else{
					
						Swal.fire({
							  icon: 'error',
							  title: 'Oops...',
							  text: '정확하게 입력해 주세요!',
							})
						console.log(data);
					}
				},
				error:function(){
					swal("에러"," 장애가 발생");
				}
			})
		}
	}
</script>
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
      <div class="container-fluid p-0">
        <div class="row">
          <div class="col-12">
            <div class="login-card">
              <form class="theme-form login-form needs-validation" novalidate="" method="POST" >
                <h4>일반회원 비밀번호 찾기</h4>
                <h6>아이디 , 이름 ,  이메일을 입력해주세요.</h6>
                  <div class="form-group">
                  <label>아이디</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                    <input class="form-control" type="text" name="id" id="inputId" required="" placeholder="아이디">
                
                  </div>
                </div>
                <div class="form-group">
                  <label>이름</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                    <input class="form-control" type="text" name="name" id="inputName" required="" placeholder="이름">
                
                  </div>
                </div>
                <div class="form-group">
                  <label>이메일</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="email" name="email" id="inputEmail"required="" placeholder="email">
                    
                  
                  </div>
                </div>
              
                <span class="helper-text" id="result"></span>
                <div  class="form-group">
                  <input class="btn btn-success" value="비밀번호 찾기" data-bs-toggle="tooltip" title="btn btn-success"  onclick="findTraId()">
                </div>
                <div class="login-social-title">                
                  <h5>Sign in with</h5>
                </div>
                <div class="form-group">
                  <ul class="login-social">
                    
                  </ul>
                </div>
                <p>Don't have account?<a class="ms-2" href="./loginPage.do">로그인</a></p>
                <p><a class="ms-2" href="./main.do">메인으로</a></p>
                  <input class="btn btn-warning btn-block btn-lg" type="button" value="돌아가기" onclick="history.back(-1)">
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <!-- page-wrapper end-->
    <!-- latest jquery-->
    <script src="../assets/js/jquery-3.5.1.min.js"></script>
    <!-- feather icon js-->
    <script src="../assets/js/icons/feather-icon/feather.min.js"></script>
    <script src="../assets/js/icons/feather-icon/feather-icon.js"></script>
    <!-- Sidebar jquery-->
    <script src="../assets/js/sidebar-menu.js"></script>
    <script src="../assets/js/config.js"></script>
    <!-- Bootstrap js-->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    <script src="../assets/js/bootstrap/popper.min.js"></script>
    <script src="../assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- Plugins JS start-->
    <!-- Plugins JS Ends-->
    <!-- Theme js-->
    <script src="../assets/js/script.js"></script>
    <!-- login js-->
    <!-- Plugin used-->
</body>
</html>