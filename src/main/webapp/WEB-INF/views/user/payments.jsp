<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>결제하기</title>
  <!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
  <script type="text/javascript" src="../resources/js/pay/pay.js"></script>
  <%@ include file="../payAlert.jsp" %>
  <style type="text/css">
	table{
		text-align:center;
	}
</style>
</head>
<%@ include file="../header.jsp" %>
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
                    <h6 class="card-title" id="claTitle">입문자도 할 수 있는 JSP 과정</h6><br>
                    <ul>
                    	<li>
                    		<div id="claContent"><i class="fa fa-angle-double-right txt-primary m-r-10"></i>이 과정은 jsp 입문자도 쉽게 접근할수 있도록 커리큘럼이 짜진 강의이며 jsp와 Servlet에 중점적인 과목들이 포함되어 있습니다.</div>
                    	</li>
                    </ul>
                    
                    <hr>
                    <h5>Pay info &nbsp;&nbsp;<small class="text-muted">금액정보</small></h5><br>
                    <dl class="row">
					  <dt class="col-sm-3">강좌금액</dt>
					  <dd class="col-sm-9"><div id="classPrice">30000</div></dd>
					  <dt class="col-sm-3">사용 쿠폰</dt>
					  <dd class="col-sm-9"><div id="useCoupon">0</div></dd>
					  <dt class="col-sm-3">사용 마일리지</dt>
					  <dd class="col-sm-9"><div id="useMileage">0</div></dd>
					  <dt class="col-sm-3">총 할인금액</dt>
					  <dd class="col-sm-9"><div id="totalDiscount">0</div></dd>
					</dl>
					<br>
					<h5>Coupon &nbsp;&nbsp;<small class="text-muted">쿠폰사용</small></h5><br>
					<button class="btn btn-primary" type="button" data-bs-toggle="modal" data-original-title="test" data-bs-target="#exampleModal" >쿠폰 사용하기</button><br>
					<br>
					<!-- 모달모달 -->
					<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
                      <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Coupon&nbsp;&nbsp;<small class="text-muted">쿠폰선택</small></h5>
                            <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close" data-bs-original-title="" title=""></button>
                          </div>
                          <div class="modal-body">
                          	<div class="table-responsive">
		                        <table class="table">
		                          <thead class="table-primary">
		                            <tr>
		                              <th scope="col"><i class="fa fa-ticket"></i>&nbsp;쿠폰번호</th>
		                              <th scope="col"><i class="fa fa-tag"></i>&nbsp;쿠폰명</th>
		                              <th scope="col"><i class="fa fa-percent"></i>&nbsp;할인율</th>
		                              <th scope="col"><i class="fa fa-calendar"></i>&nbsp;발급일자</th>
		                              <th scope="col"><i class="fa fa-check-square-o"></i>&nbsp;사용하기</th>
		                            </tr>
		                          </thead>
		                          <tbody>
		                          	<c:forEach var="vo" items="${lists}">
		                          		<c:if test="${vo.cou_delflag eq 'Y'}">
			                          		<tr>
				                              <td>${vo.cou_code}</td>
				                              <td>${vo.cou_name}</td>
				                              <td>${vo.cou_per}%</td>
				                              <td>${vo.cou_date}</td>
				                              <td><button class="btn btn-primary btn-xs" type="button" onclick="useCoupon('${vo.cou_code}',${vo.cou_per})">사용하기</button></td>
			                            	</tr>
		                          		</c:if>
		                          	</c:forEach>
		                          </tbody>
		                        </table>
                      		</div>
                          </div>
                          <div class="modal-footer">
                            <button class="btn btn-light" type="button" data-bs-dismiss="modal" data-bs-original-title="" title="">돌아가기</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 모달 끝 -->
                    <div class ="btns">
	 					<h5>Milage&nbsp;&nbsp;<small class="text-muted">마일리지 사용</small></h5><br><input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  placeholder="0p" name="milage" id="milage">&nbsp;
	 					<button class="btn btn-info btn-sm" type="button" onclick="useMilage()">사용하기</button><br>
	 					<small class="text-muted">회원님의 보유 마일리지는 <b><span style="color:tomato" id="mile">${mile}</span> point</b> 입니다.</small>
	 					<br>
						<br>
						<h5>Method of payment &nbsp;&nbsp;<small class="text-muted">결제방식 선택</small></h5><br>
					 	<input type="radio" name="selectPay" value="payco" checked="checked">&nbsp;페이코&nbsp;&nbsp;<img src="../resources/images/pay/payco.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	<input type="radio" name="selectPay" value="kakaopay">&nbsp;카카오페이&nbsp;&nbsp;<img src="../resources/images/pay/kakao.png"/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	<input type="radio" name="selectPay" value="toss">&nbsp;토스결제&nbsp;&nbsp;<img src="../resources/images/pay/toss.png"/>
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
						</div>
						<br><br>
						<div id="couNum" style="display: none;">0</div>
					</div>
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