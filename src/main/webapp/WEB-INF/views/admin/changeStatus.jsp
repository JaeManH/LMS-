<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>첫 페이지</title>
<script type="text/javascript" src="../resources/js/pay/changeStatus.js"></script>
<style type="text/css">
	table{
		text-align:center;
	}
	input:disabled {
    	color: tomato;
	}
</style>
</head>
<%@ include file="./admin_header.jsp" %>
<%@ include file="../payAlert.jsp" %>
<body>
  
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>환불대기/승인</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                    <li class="breadcrumb-item">결제관리</li>
                    <li class="breadcrumb-item active">환불대기/승인</li>
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
                    <h5><i class="fa fa-check-square-o"></i>&nbsp;&nbsp;Refund Approval</h5>
                    <span>회원들의 환불 신청목록을 확인하고 승인합니다.</span>
                    <hr>
                  </div>
                  <div class="card-body">
                     <h4>Refund application&nbsp;&nbsp;<small class="text-muted">환불신청</small></h4><br><br>
                     	<div class="figure text-end d-block">
		                    <select class="btn btn-primary" id="list" name="list" onchange="changeStatus()">
		                    <c:choose>
		                       <c:when test="${status eq '환불대기'}">
		                       	<option value="환불대기" selected>환불대기</option>
		                       	<option value="환불승인">환불승인</option>
		                       </c:when>
		                       <c:when test="${status eq '환불승인'}">
		                       	<option value="환불대기">환불대기</option>
		                       	<option value="환불승인" selected>환불승인</option>
		                       </c:when>
		                       <c:otherwise>
		                       	<option value="환불대기" selected>환불대기</option>
		                       	<option value="환불승인">환불승인</option>
		                       </c:otherwise>
		                    </c:choose>
				            </select>
		            	</div>
                     	<p class="txt-primary">- 결제번호 클릭 시 결제 상세정보와 환불사유 페이지로 이동합니다.</p>
                     	<div class="table-responsive">
                        <table class="table">
                          <thead class="table-primary">
                            <tr>
                              <th scope="col"><i class="fa fa-ticket"></i>&nbsp;결제번호</th>
                              <th scope="col"><i class="fa fa-user"></i>&nbsp;구매자</th>
                              <th scope="col"><i class="fa fa-check-circle-o"></i>&nbsp;결제상태</th>
                              <th scope="col"><i class="fa fa-calendar"></i>&nbsp;결제일자</th>
                              <th scope="col"><i class="fa fa-calendar"></i>&nbsp;환불일자</th>
                              <th scope="col"><i class="fa fa-check-square-o"></i>&nbsp;&nbsp;환불사유/승인</th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="vo" items="${lists}">
	                        	<tr>
	                              <td onclick="modalOpen('${vo.pay_num}')" ><a href="#" data-bs-toggle="modal" data-original-title="test" data-bs-target="#exampleModal">${vo.pay_num}</a></td>
	                              <td>${vo.pay_tra_buyer}</td>
	                              <td>
	                              	<c:if test="${vo.pay_status eq '환불대기'}"><span class="badge rounded-pill badge-secondary">환불대기</span></c:if>
	                              	<c:if test="${vo.pay_status eq '환불승인'}"><span class="badge rounded-pill badge-danger">환불승인</span></c:if>
	                              </td>
	                              <td>${vo.pay_date}</td>
	                              <td>${vo.pay_candate}</td>
	                              <td>
	                              	<c:if test="${vo.pay_status eq '환불대기'}"><button class="btn btn-danger btn-xs" type="button" data-bs-toggle="modal" data-original-title="test" data-bs-target="#cancelWhy" onclick="cancelWhy('${vo.pay_num}','${vo.pay_status}')">환불사유</button>&nbsp;<button class="btn btn-primary btn-xs" type="button" onclick="statusUpdate('${vo.pay_num}')">승인하기</button></c:if>
	                              	<c:if test="${vo.pay_status eq '환불승인'}"><button class="btn btn-danger btn-xs" type="button" data-bs-toggle="modal" data-original-title="test" data-bs-target="#cancelWhy" onclick="cancelWhy('${vo.pay_num}','${vo.pay_status}')">환불사유</button>&nbsp;<button class="btn btn-danger btn-xs disabled" type="button">승인됨</button></c:if>
	                              </td>
                            	</tr>  	
                          	</c:forEach>
                          </tbody>
                        </table>
                        <!-- 상세정보 모달 -->
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
                          	<div id="modalText">ddd</div>
                          </div>
                          <div class="modal-footer">
                            <button class="btn btn-light" type="button" data-bs-dismiss="modal" data-bs-original-title="" title="">돌아가기</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 상세정보 모달 -->
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
	                          	<h6 id="modalTitle">환불 상세 정보입니다.</h6><br>
                          	</div>
                          	<form>
                              <div class="mb-3">
                                <label class="col-form-label" for="canCate">Category&nbsp;&nbsp;<small class="text-muted">환불 카테고리</small></label>
                                <input class="form-control" id="canCate" type="text" value="" data-bs-original-title="" title="" disabled="disabled">
                              </div>
                              <div class="mb-3">
                                <label class="col-form-label" for="canReason">Reason&nbsp;&nbsp;<small class="text-muted">환불 사유</small></label>
                                <textarea class="form-control" id="canReason" disabled="disabled" style="color:tomato;"></textarea>
                              </div>
                            </form>
                            <div id="payNumber" style="display:none;"></div>
                          </div>
                          <div class="modal-footer">
                          	<div id="changeButton"><button class="btn btn-primary" type="button" onclick="statusUpdate(0)">승인하기</button></div>
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
          <!-- Container-fluid Ends-->
        </div>
      </div>
    </div>



<%@include file="./admin_footer.jsp" %>


  
</body>
</html>