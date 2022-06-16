<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
	 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <link rel="stylesheet" type="text/css" href="../assets/css/daterange-picker.css">
 <link rel="stylesheet" type="text/css" href="../assets/css/dropzone.css">
     <link rel="stylesheet" type="text/css" href="../assets/css/date-picker.css">
    
<meta charset="UTF-8">
<title>강사 경력 등록 양식 페이지</title>
	<style>
.uploadResult {
	width: 100%;
	
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 50px;
}


</style>
 <script> 

 function insCar(){
	console.log('경력 등록 작동');
	var frm = document.forms[1];
	frm.action = './insertCar.do';
	 console.log(frm);
	 
		Swal.fire({
			 title: '경력 등록',
			  text: '로그인을 다시 해야합니다.',
		      icon: 'warning',
		      showCancelButton: true,
		      confirmButtonColor: '#3db39d',
			  cancelButtonColor: '#e4818b',
		      confirmButtonText: '등록하기',
		      cancelButtonText: '취소',
		      reverseButtons: true, // 버튼 순서 거꾸로
		      
		    }).then((result) => {
		    	 if (result.value) {
					frm.submit();
				  }
		    })
		
}
 
</script> 
</head>
<%@ include file="./header.jsp" %>
<body>
         <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>강사 경력등록</h3>
                    <sec:authentication property="Details" var="info" /><br>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">메인</a></li>
                    <li class="breadcrumb-item">강사</li>
                    <li class="breadcrumb-item active">강사 경력 등록</li>
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
            <div class="row">
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-body">
                  <form  method="post" >
                    <div class="form theme-form">
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label>이름</label>
                            <input class="form-control" type="text" value="${info.name}" placeholder="${info.name}">
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label class="form-label" for="validationCustom01">경력코드</label>
                                 <input class="form-control digits" type="text" name="car_seq" value="${info.career}" required="" id="validationCustom01">
                                <div class="valid-feedback">Looks good!</div>
                                  
                          </div>
                        </div>
                        
                        <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label class="form-label" for="validationCustom02">전화번호</label>
                            <input class="form-control" type="text" id="validationCustom02" required="" value="${info.phone}">
                           
                          </div>
                        </div>
                          <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label class="form-label" for="validationCustom02">직위</label>
                            <input class="form-control" type="text" id="validationCustom02" name="car_position" required="" placeholder="직위">
                            <div class="valid-feedback">Looks good!</div>
                                  <div class="invalid-feedback">직위를 입력해주세요.</div>
                          </div>
                        </div>
                      </div>
                   
                      <div class="row">
                      <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label>재직시 소속</label>
                            <input class="form-control" type="text" name="car_depart" placeholder="소속">
                          </div>
                        </div>
                     <div class="col-sm-6 col-md-6">
                          <div class="mb-3">
                            <label>재직기간</label>
                            <div class="form-group">
                             <input class="form-control digits" type="text" name="daterange" value="01/15/2017 - 02/15/2017">
                        </div>
                          </div>
                        </div>
                      
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label>담당 업무 내용</label>
                            <textarea class="form-control" name="car_content" id="exampleFormControlTextarea4" rows="3"></textarea>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label>파일 등록</label>
                          
					<input class="form-control " type="file" name="car_file" aria-label="file example" required="" multiple >                              </div>
                          
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="text-end"><a class="btn btn-secondary me-3" onclick="insCar()" >Add</a><a class="btn btn-danger" href="./">Cancel</a></div>
                        </div>
                      </div>
                      </form>
                    </div>
                  </div>
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
   <script src="../assets/js/datepicker/daterange-picker/moment.min.js"></script>
    <script src="../assets/js/datepicker/daterange-picker/daterangepicker.js"></script>
    <script src="../assets/js/datepicker/daterange-picker/daterange-picker.custom.js"></script>
    <script src="../assets/js/dropzone/dropzone.js"></script>
    <script src="../assets/js/dropzone/dropzone-script.js"></script>
    <script src="../assets/js/tooltip-init.js"></script>
    <!-- Plugins JS Ends-->
    <!-- Theme js-->
    <script src="../assets/js/script.js"></script>
    <script src="../assets/js/theme-customizer/customizer.js"></script>
    <!-- login js-->
    <!-- Plugin used-->
<script type="text/javascript">


</script>
</body>
</html>