<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>첫 페이지</title>
 <script type="text/javascript" src="../resources/js/pay/user_Mypay.js"></script>
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
                  <h3>내 결제내역</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                    <li class="breadcrumb-item">마이페이지</li>
                    <li class="breadcrumb-item active">내 결제내역</li>
                  </ol>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row">
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-header pb-0">
                    <h5><i class="fa fa-barcode"></i>&nbsp;&nbsp;My Payment</h5>
                    <span>내 결제정보를 조회하고 관리합니다.</span>
                    <hr>
                    <div class="card-body">
                     <h4>Payment information&nbsp;&nbsp;<small class="text-muted">내 결제정보</small></h4><br><br>
                     	<p class="txt-primary">-- 결제번호 클릭 시 결제 상세정보 페이지로 이동합니다.</p>
                     	<div class="table-responsive">
                        <table class="table">
                          <thead class="table-primary">
                            <tr>
                              <th scope="col"><i class="fa fa-ticket"></i>&nbsp;결제번호</th>
                              <th scope="col"><i class="fa fa-credit-card-alt"></i>&nbsp;결제 내역</th>
                              <th scope="col"><i class="fa fa-check-circle-o"></i>&nbsp;결제상태</th>
                              <th scope="col"><i class="fa fa-repeat"></i>&nbsp;환불</th>
                              <th scope="col"><i class="fa fa-calendar"></i>&nbsp;결제일자</th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="vo" items="${lists}">
	                        	<tr>
	                              <td onclick="modalOpen('${vo.pay_num}')" ><a href="#" data-bs-toggle="modal" data-original-title="test" data-bs-target="#exampleModal">${vo.pay_num}</a></td>
	                              <td onclick="modalOpen('${vo.pay_num}')" ><a href="#" data-bs-toggle="modal" data-original-title="test" data-bs-target="#exampleModal">${vo.pay_content}</a></td>
	                              <td>
	                              	<c:if test="${vo.pay_status eq '결제'}"><span class="badge rounded-pill badge-primary">결제</span></c:if>
	                              	<c:if test="${vo.pay_status eq '환불대기'}"><span class="badge rounded-pill badge-secondary">환불대기</span></c:if>
	                              	<c:if test="${vo.pay_status eq '환불승인'}"><span class="badge rounded-pill badge-danger">환불승인</span></c:if>
	                              </td>
	                              <td>
	                              	<c:if test="${vo.pay_status eq '결제'}"><button class="btn btn-pill btn-warning btn-xs" type="button" data-bs-toggle="modal" data-original-title="test" data-bs-target="#cancelWhy" onclick="cancelWhy('${vo.pay_num}','${vo.pay_status}')">환불하기</button></c:if>
	                              </td>
	                              <td>${vo.pay_date}</td>
                            	</tr>  	
                          	</c:forEach>
                          </tbody>
                        </table>
                        <!-- 정보 모달 -->
                      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
                      <div class="modal-dialog modal modal-dialog-centered" role="document">
                        <div class="modal-content text-center d-block">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Payment Details&nbsp;&nbsp;<small class="text-muted">결제 상세정보</small></h5>
                            <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close" data-bs-original-title="" title=""></button>
                          </div>
                          <div class="modal-body">
                          	<br><br>
                          	<h1 class="display-1"><i class="fa fa-credit-card-alt"></i></h1><br>
                          	<h6 id="modalTitle">ddd</h6>
                          	<div id="modalText">dd</div>
                          </div>
                          <div class="modal-footer">
                            <button class="btn btn-light" type="button" data-bs-dismiss="modal" data-bs-original-title="" title="">돌아가기</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 정보 모달 -->
                    <!-- 환불사유 모달 -->
                      <div class="modal fade" id="cancelWhy" tabindex="-1" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
                      <div class="modal-dialog modal modal-dialog-centered" role="document">
                        <div class="modal-content ">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Reason for refund&nbsp;&nbsp;<small class="text-muted">환불사유</small></h5>
                            <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close" data-bs-original-title="" title=""></button>
                          </div>
                          <div class="modal-body">
                          	<br>
                          	<div class="text-center d-block">
	                          	<h1 class="display-1"><i class="fa fa-question-circle"></i></h1><br>
	                          	<h6 id="modalTitle">환불 정보를 입력해주세요.</h6>
                          	</div>
                          	<form>
                              <div class="mb-3">
                                <label class="col-form-label" for="canCate">Category&nbsp;&nbsp;<small class="text-muted">환불 카테고리</small></label>
                                <div class="card-body dropdown-basic">
	                               <div class="dropdown">
				                      <div class="btn-group mb-0">
				                        <button class="dropbtn btn-primary btn-round" type="button" data-bs-original-title="" title=""><div id="changeCate">카테고리를 선택해주세요<span><i class="icofont icofont-arrow-down"></i></span></div></button>
				                        <div class="dropdown-content">
				                        	<a href="#" data-bs-original-title="" title="" onclick="drop('단순변심')">단순변심</a>
				                        	<a href="#" data-bs-original-title="" title="" onclick="drop('다른강의 수강')">다른강의 수강</a>
				                        	<a href="#" data-bs-original-title="" title="" onclick="drop('강사 불만족')">강사 불만족</a>
				                        	<a href="#" data-bs-original-title="" title="" onclick="drop('커리큘럼 불만족')">커리큘럼 불만족</a>
				                        </div>
				                      </div>
				                    </div>
				                </div>
                              </div>
                              <div class="mb-3">
                                <label class="col-form-label" for="canReason">Reason&nbsp;&nbsp;<small class="text-muted">환불 사유</small></label>
                                <textarea class="form-control" id="canReason" style="color:tomato;"></textarea>
                              </div>
                            </form>
                            <div id="payNumber" style="display:none;">d</div>
                          </div>
                          <div class="modal-footer">
                          	<div id="changeButton"><button class="btn btn-warning" type="button" onclick="cancelUpdate()">환불 신청</button></div>
                            <button class="btn btn-light" type="button" data-bs-dismiss="modal" data-bs-original-title="" title="">돌아가기</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 모달 -->
                      </div>
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