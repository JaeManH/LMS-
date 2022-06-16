<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./admin_header.jsp" %>
<body>
<script type="text/javascript">
function del(val){
	location.href="./mesBoardDelete.do?mes_seq="+val.value;
}
function insertForm(){
	location.href="./messageBoardInsertForm.do";
}

function reply(){
	location.href="./mesBoardReplyForm.do";
}
</script>
<div class="page-body">
  <div class="container-fluid">
    <div class="page-header">
      <div class="row">
        <div class="col-sm-6">
<%--           <h3>${result.mes_cate}</h3> --%>
<%--           <input type="hidden" name="doc_originname" value="${doc_originname}" readonly="readonly"> --%>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="./adminMain.do">Home</a></li>
            <li class="breadcrumb-item">쪽지 게시판</li>
            <li class="breadcrumb-item active">쪽지 게시판 상세보기</li>
          </ol>
        </div>
      </div>
    </div>
  </div>
  <!-- Container-fluid starts-->
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="blog-single">
          <div class="blog-box blog-details">
            <div class="card">
              <div class="card-body">
                <div class="blog-details">
                <input type="hidden" value="${result.mes_seq}" name="mes_seq">
                  <ul class="blog-social">
                    <li><i class="icofont icofont-user"></i></li>
                    <li>송신자 : ${result.mes_sender}</li>
                    <li>수신자 : ${result.mes_recipient}</li>
                    <li style="margin-top: 10px; margin-left: 44px;"><i class="icofont icofont-ui-chat"></i>등록일: ${result.mes_regdate}</li>
                  </ul>
                  <input type="hidden" name="mes_recipient" value="${result.mes_recipient}">
                  <div class="single-blog-content-top">
                    <p>${result.mes_content}</p>
                    <input type="hidden" name="mes_reffer" value="${result.mes_reffer}">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-light" onclick="javascript:history.back(-1)">뒤로가기</button>
  <c:if test="${result.mes_cate eq 'R'}">
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-primary" onclick="reply()">답장하기</button>
  </c:if>
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-danger" value="${result.mes_seq}" onclick="del(this)">삭제하기</button>
</div>
</body>
<%@include file="./admin_footer.jsp" %>
</html>