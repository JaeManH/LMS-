<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./admin_header.jsp" %>
<script type="text/javascript">
function download(val){
	location.href="./documentDownload.do?doc_originname="+val.value;
}

function delDoc(val){
	location.href="./classBoardDocDelete.do?cbo_doc_seq="+val.value;
}

function delVideo(val){
	location.href="./classBoardVideoDelete.do?cbo_seq="+val.value;
}
</script>
<script src="//vjs.zencdn.net/7.10.2/video.min.js"></script>
<link href="//vjs.zencdn.net/7.10.2/video-js.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/videojs-youtube/2.6.1/Youtube.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/videojs-youtube/2.6.1/Youtube.min.js"></script>
<script src="https://unpkg.com/videojs-youtube@2.6.1/dist/Youtube.js"></script>

<body>
<div class="page-body">
  <div class="container-fluid">
    <div class="page-header">
      <div class="row">
        <div class="col-sm-6">
<%--           <input type="hidden" name="doc_originname" value="${doc_originname}" readonly="readonly"> --%>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="./adminMain.do">Home</a></li>
            <li class="breadcrumb-item">과정 게시판</li>
            <li class="breadcrumb-item active">과정 게시판 상세</li>
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
                  <ul class="blog-social">
                    <li><i class="icofont icofont-user"></i></li>
                    <li>강사: ${result.cbo_ins_id}</li>
                    <li><i class="icofont icofont-ui-chat"></i>등록일: ${result.cbo_regdate}</li>
                  </ul>
                  <input type="hidden" name="cbo_doc_seq" value="${result.cbo_doc_seq}">
                
                  <c:if test="${result.cbo_cate eq '자료'}">
                  <button value="${doc_originname}" name="doc_originname" type="submit" style="float: right; margin-top: 15px;" class="btn btn-light" onclick="download(this)">다운로드</button>
                  </c:if>
                  
                  <h3 style="margin-top: 20px;">${result.cbo_title}</h3>
                  <h6 style="color: gray;">파일이름 : ${doc_originname}</h6>
                  <!-- 추후 ck에디터로 업데이트 예정 -->
                  
                  
                  <div class="single-blog-content-top">
                    <p>${result.cbo_content}</p>
                  </div>
                  <c:if test="${result.cbo_cate eq '동영상'}">
                  <p>${result.cbo_youtubeadd}</p>
                  <br>
                  <video id="my-player"
    					 class="video-js"
   						 controls
   						 preload="auto"
    					 data-setup='{"techOrder": ["youtube"], "sources": [{ "type": "video/youtube", "src": "${result.cbo_youtubeadd}"}], "youtube": { "ytControls": 2 }}'>
				  </video>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-light" onclick="javascript:history.back(-1)">뒤로가기</button>
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-primary" onclick="modify()">글 수정하기</button>
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-primary" onclick="modify()">글 수정하기</button>
  <c:if test="${result.cbo_cate eq '자료'}">
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-danger" value="${result.cbo_doc_seq}" onclick="delDoc(this)">삭제하기</button>
  </c:if>
  <c:if test="${result.cbo_cate eq '동영상'}">
  <button style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-danger" value="${result.cbo_seq}" onclick="delVideo(this)">삭제하기</button>
  </c:if>
<%--   <a style="float: right; margin-right: 30px; width: 132px;" type="button" class="btn btn-outline-primary" href="./classModifyForm.do?cla_num=${result.cla_num}">글 수정하기</a> --%>
</div>
</body>
<%@include file="./admin_footer.jsp" %>
</html>