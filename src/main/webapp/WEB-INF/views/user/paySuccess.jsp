<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>결제완료</title>
</head>
<%@ include file="../header.jsp" %>

<body>
  
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>결제완료</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                    <li class="breadcrumb-item">결제</li>
                    <li class="breadcrumb-item active">결제완료</li>
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
            <div class="row">
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-header pb-0">
                    <h5><i class="fa fa-smile-o"></i>&nbsp;&nbsp;Complete Payment</h5>
                    <span>강좌 결제 완료</span>
                    <hr>
                  </div>
                  <div class="card-body figure text-center d-block">
                  		<br><br>
                  		<h1 class="display-1"><i class="fa fa-shopping-bag"></i></h1><br><br>
                  		<h4 class="f-w-600"><span style="color:tomato"><b>${finalAmount}</b></span>원 결제가 성공적으로 <span style="color:tomato"><b>완료</b></span>되었습니다.</h4><br>
                  		<ul>
                  			<li><i class="fa fa-caret-right txt-secondary m-r-10"></i><span style="color:tomato"><b>${plusMile}</b></span>p가 마일리지로 적립되었습니다.</li>
                  			<c:if test="${coupon ne '0'}">
                  			<li><i class="fa fa-caret-right txt-secondary m-r-10"></i><span style="color:tomato"><b>${coupon}</b></span>이 발급되었습니다.</li>
                  			</c:if>
                  		</ul>
                  		<br><br>
                  		<h5 class="f-w-600">회원님의 결제번호는 <span style="color:tomato"><b>${paynum}</b></span> 입니다.</h5><br><br>
                  		<button class="btn btn-primary btn-lg" type="button">마이페이지로 가기</button>&nbsp;&nbsp;
                  		<button class="btn btn-warning btn-lg" type="button">강좌설명으로 가기</button><br><br><br><br>
                  		
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid Ends-->
        </div>
      </div>
    </div>



<%@include file="../footer.jsp" %>


  
</body>
</html>