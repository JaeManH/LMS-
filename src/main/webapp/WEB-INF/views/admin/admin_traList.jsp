<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 일반회원</title>
</head>
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="./js/memberList.js"></script>

<%@ include file="./admin_header.jsp" %>
<body>
   <div class="page-body">
        <div id="container" class="container">
        <div class="col-sm-6">
                  <h3>일반회원</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="./main.do">관리자 메인</a></li>
                    <li class="breadcrumb-item">관리자</li>
                    <li class="breadcrumb-item">회원 관리</li>
                    <li class="breadcrumb-item active">일반 회원 전체 목록</li>
                  </ol>
                </div>
    <form action="#" method="post" id="frm" onsubmit="return chkBox()">
      <div id="select">
      <!-- select listNum 의 값을 변경 -->
      <span>
      	<select class="btn btn-primary" id="list" name="list" onchange="pageList()">
      	  <option value="5">5</option>
      	  <option value="10">10</option>
      	  <option value="15">15</option>
      	</select>
      </span>
          <span><input type="submit" class="btn btn-danger" value="다중삭제"></span>      
      </div>
      
      <table class="table table-hover">
        <thead>
          <tr>
            <th>
                <input type="checkbox" id="checkAll" onclick="checkAlls(this.checked)">
            </th>
          	<th >프로필</th>
            <th>아이디</th>
            <th >이름</th>
            <th >이메일</th>
            <th >가입일</th>
 	        <th >회원상태</th>
          </tr>
        </thead>
        <tbody>
          <jsp:useBean id="traMemberList" class="com.min.bean.MemberListBean" scope="page"/>
          <jsp:setProperty property="lists" name="traMemberList" value="${lists}"/>
          <jsp:setProperty property="user" name="traMemberList" value="${user}"/>
          <jsp:getProperty property="listForm" name="traMemberList"/>
        </tbody>
      </table>
      
      <input type="text" name="index" id="index" value="${row.index}" hidden="true">
      <input type="text" name="pageStartNum" id="pageStartNum" value="${row.pageStartNum}" hidden="true">
      <input type="text" name="pageListNum" id="pageListNum" value="${row.pageListNum}" hidden="true">
     
   
       <!-- pagination with active and disabled state-->
             <div class="col-xl-12">
                      <ul class="pagination justify-content-center pagination-primary">
                        <li class="page-item "><a onclick="pageFirst()" class="page-link"  href="#" aria-label="Previous"><span>«</span><span class="sr-only">Previous</span></a></li>
                        <li class="page-item"><a onclick="pagePrev(${row.pageStartNum},${row.pageList})" class="page-link"  href="#" aria-label="Previous"><span aria-hidden="true">이전</span><span class="sr-only">Previous</span></a></a></li>
                         <c:forEach var="i" begin="${row.pageStartNum}" end="${row.count}" step="1">
                            <li  onclick="pageIndex(${i})" class="page-item "><a class="page-link " href="#"><span>${i}</span></a></li>
                    </c:forEach>
                        <li class="page-item"><a onclick="pageNext(${row.pageStartNum},${row.total},${row.pageListNum},${row.pageList})" class="page-link"  href="#"  aria-label="Next"><span >다음</span></a></li>
                        <li class="page-item"><a onclick="pageLast(${row.pageStartNum},${row.total},${row.pageListNum},${row.pageList})" class="page-link"  href="#" aria-label="Next"><span >»</span></a></li>
                      </ul>
              </div>
            
      
      
    </form>
    
    <!-- 새글쓰기 모달 -->
    
    <div class="modal fade" id="write" role="dialog">
	    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
		        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">게시글 입력</h4>
			   </div>
			   <div class="modal-body">
			          <form method="post" id="frmWriter" class="">
			          
			          </form>
			  </div>
<!-- 			  <div class="modal-footer"> -->
<!-- 			          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
<!-- 		      </div> -->
	      </div>
	    </div>
  </div>
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
              </div>
              
    </div>
</body>
<%@include file="./admin_footer.jsp" %>
  
</body>
</html>