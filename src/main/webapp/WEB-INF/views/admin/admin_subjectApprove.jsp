<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 전체목록 리스트 화면</title>
</head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="./js/approveSubjectList.js"></script>
<%@ include file="./admin_header.jsp" %>
<body>
   <div class="page-body">
    
    <form action="#" method="post" id="frm" onsubmit="return chkBox()">
		

          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>과목 전체 조회</h3>
                    <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html"><i class="icofont icofont-ui-home"></i></a></li>
                    <li class="breadcrumb-item">관리자</li>
                    <li class="breadcrumb-item">과목 승인</li>
                    <li class="breadcrumb-item active">과목 등록 목록 조회</li>
                  </ol>
                </div>
		
              </div>
            </div>
            <div class="row"> 
               <div class="col-sm-6">
           			<div id="select">
						<select class="btn btn-primary" id="changeStatus" name="changeStatus" onchange="changeStatus()">
							<option>승인상태</option>
							<option value="W">대기</option>
							<option value="A">승인</option>
							<option value="R">반려</option>
						</select>
					</div>
				</div>
		</div>
		
            <div class="row">
              <div class="col-sm-12">
              
                <div class="card">
  				<div class="card-block row">
                  <div class="table-responsive table-border-radius">
                    <table class="table table-hover table-xs table-border-vertical">
                      <thead class="bg-primary">
                        <tr>
                          <th scope="col"><h6 class="f-w-700">과목번호</h6></th>
                          <th scope="col"><h6 class="f-w-700">과목명</h6></th>
                          <th scope="col"><h6 class="f-w-700">카테고리</h6></th>
                          <th scope="col"><h6 class="f-w-700">등록자</h6></th>
                          <th scope="col"><h6 class="f-w-700">등록일</h6></th>
                          	<th scope="col"><h6 class="f-w-700">승인상태</h6></th>
                        </tr>
                      </thead>
    				<tbody>
    					<jsp:useBean id="subjectList" class="com.min.bean.SubjectApproveListBeanAdmin" scope="page"/>
    					<jsp:setProperty property="lists" name="subjectList" value="${lists}"/>
    					<jsp:setProperty property="mem" name="subjectList" value="${mem}"/>
    					<jsp:getProperty property="listForm" name="subjectList"/>
    				</tbody>
                    </table>
                    
                    <input type="hidden" name="index" id="index" value="${row.index}">
					<input type="hidden" name="pageStartNum" id="pageStartNum" value="${row.pageStartNum}">
					<input type="hidden" name="pageListNum" id="pageListNum" value="${row.pageListNum}">
		
                    </div>
                  </div>
                </div>
                
            <!-- pagination with active and disabled state-->
             <div class="col-xl-12">
                      <ul class="pagination justify-content-center pagination-primary">
                        <li class="page-item "><a onclick="pageFirst()" class="page-link"  href="#" aria-label="Previous"><span>«</span><span class="sr-only">Previous</span></a></li>
                         <li class="page-item"><a onclick="pagePrev(${row.pageStartNum},${row.pageList})" class="page-link"  href="#" aria-label="Previous"><span aria-hidden="true">이전</span><span class="sr-only">Previous</span></a></li>
                        <c:forEach var="i" begin="${row.pageStartNum}" end="${row.count}" step="1">
                         	<li class="page-item" ${(i-1)==row.index?"class='active'":"" }><a onclick="pageIndex('${i}')" class="page-link" href="#"><span>${i}</span></a></li>
					  	</c:forEach>
                         <li class="page-item"><a onclick="pageNext(${row.pageStartNum},${row.total},${row.pageListNum},${row.pageList})" class="page-link"  href="#"  aria-label="Next"><span>다음</span><span class="sr-only">Next</span></a></li>
                        <li class="page-item"><a onclick="pageLast(${row.pageStartNum},${row.total},${row.pageListNum},${row.pageList})" class="page-link"  href="#" aria-label="Next"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
                      </ul>
              </div>
              </div>
          <!--
              		<div class="col-sm-12">
                <div class="card">
                
                  <div class="card-body btn-showcase">
                      <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
                      <div class="modal-dialog modal modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content text-center d-block">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">과목 상세보기<small class="text-muted">과목 상세정보</small></h5>
                            <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close" data-bs-original-title="" title=""></button>
                          </div>
                          <div class="modal-body">
                          	<br><br>
                          	<h6 id="modalTitle">ㅇㅇㅇ</h6>
                          	<div id="modalText">dㅇㅇd</div>
                          </div>
                          <div class="modal-footer">
                            <button class="btn btn-light" type="button" data-bs-dismiss="modal" data-bs-original-title="" title="">돌아가기</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div> -->
              
          </div>
       </div>
 </form>
 
 
    </div>
</body>
<%@include file="./admin_footer.jsp" %>
</html>