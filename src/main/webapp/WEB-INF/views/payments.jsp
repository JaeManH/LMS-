<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>첫 페이지</title>
  <!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
  <script type="text/javascript" src="./resources/js/pay/pay.js"></script>
</head>
<%-- <%@ include file="../admin/admin_header.jsp" %> --%>
<body>
  
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>결제하기</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                    <li class="breadcrumb-item">강좌</li>
                    <li class="breadcrumb-item active">결제하기</li>
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
                    <h5><i class="fa fa-credit-card-alt"></i>&nbsp;&nbsp; Payment</h5>
                    <span>강좌를 결제합니다.</span>
                    <hr>
                  </div>
                  <div class="card-body">
                  	<h5>Class info &nbsp;&nbsp;<small class="text-muted">강좌정보</small></h5><br>
                    <h6 class="card-title">JSP과정</h6><br>
                    <p>&nbsp; jsp과정 설명은 ~~이다</p> 
                    <hr>
                    <h5>Pay info &nbsp;&nbsp;<small class="text-muted">금액정보</small></h5><br>
                    <dl class="row">
					  <dt class="col-sm-3">강좌금액</dt>
					  <dd class="col-sm-9">30000</dd>
					  <dt class="col-sm-3">사용 쿠폰</dt>
					  <dd class="col-sm-9"><div id="useCoupon">0</div></dd>
					  <dt class="col-sm-3">사용 마일리지</dt>
					  <dd class="col-sm-9"><div id="useMileage">0</div></dd>
					  <dt class="col-sm-3">총 할인금액</dt>
					  <dd class="col-sm-9"><div id="totalDiscount">0</div></dd>
					</dl>
					<br>
					<h5>Coupon &nbsp;&nbsp;<small class="text-muted">쿠폰사용</small></h5><br>
					<button class="btn btn-primary" type="button">쿠폰 사용하기</button><br><br>
                    <div class ="btns">
	 					<h5>Milage&nbsp;&nbsp;<small class="text-muted">마일리지 사용</small></h5><br><input type="number" name="milage" id="milage">&nbsp;
	 					<button class="btn btn-info btn-sm" type="button" onclick="useMilage()">사용하기</button><br><br>
						<br>
						<h5>Method of payment &nbsp;&nbsp;<small class="text-muted">결제방식 선택</small></h5><br>
					 	<input type="radio" name="selectPay" value="payco">&nbsp;페이코&nbsp;&nbsp;<img src="./resources/images/pay/payco.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	<input type="radio" name="selectPay" value="kakaopay">&nbsp;카카오페이&nbsp;&nbsp;<img src="./resources/images/pay/kakao.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	<input type="radio" name="selectPay" value="toss">&nbsp;토스결제&nbsp;&nbsp;<img src="./resources/images/pay/toss.png"/>
					 	<br>
						<hr>
						
						<div id='money' class="figure text-end d-block">
							<h4><i class="fa fa-credit-card-alt"></i>&nbsp;&nbsp;Final Amount &nbsp;&nbsp;<small class="text-muted">최종 금액</small></h4><br>
							<h1><i class="fa fa-krw"></i>&nbsp;30000</h1>
						</div>
						<br>
						<div class="figure text-end d-block">
							<button class="btn btn-danger btn-lg" type="button" onclick="checkPay()">&nbsp;&nbsp;&nbsp;&nbsp;결제하기&nbsp;&nbsp;&nbsp;&nbsp;</button>
							<button class="btn btn-light btn-lg" type="button" onclick="">&nbsp;&nbsp;&nbsp;&nbsp;뒤로가기&nbsp;&nbsp;&nbsp;&nbsp;</button>
							<h1><a href="javascript:doCheck()">정보확인</a></h1>
							<a href="javascript:doF()">결제 취소</a>
						</div>
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
                <p class="mb-0">Copyright 2022-06 © viho All rights reserved.</p>
              </div>
              <div class="col-md-6">
                <p class="pull-right mb-0">Hand crafted & made with <i class="fa fa-heart font-secondary"></i></p>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>



<%-- <%@include file="../admin/admin_footer.jsp" %> --%>


  
</body>
</html>