<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 과목 상세조회 화면</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<link
         href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
         rel="stylesheet"
         integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
         crossorigin="anonymous"
      />
</head>
<%@ include file="./admin_header.jsp" %>
<body>
<div class="page-body">
          <div class="container-fluid">
    <div class="page-header">
    
              <div class="row">
                <div class="col-sm-6">
                  <h3>과목 상세</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item">관리자</li>
                    <li class="breadcrumb-item">과목</li>
                    <li class="breadcrumb-item active">과목 상세보기</li>
                  </ol>
                </div>
              </div>
            </div>
           <div class="row">
              <div class="col-sm-12 col-xl-8">
                  <div class="card">
                    <div class="card-body">
                      <div class="pro-group pt-0 border-0">
                        <div class="product-page-details mt-0">
                          <h3>[ &nbsp; ${results.sub_title} &nbsp; ]</h3>
                          <div class="pro-review">
                            <div class="d-flex">
                              과목번호 : ${results.sub_num}  
                            </div>
                          </div>
                        </div>
                        <div class="product-price">
                        	<c:choose>
								<c:when test="${results.cod_name  eq 'JAVA'}">
									<span class="badge rounded-pill"
									style="background-color: #006400">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'C'}">
									<span class="badge rounded-pill"
										style="background-color: #AFEEEE">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'HTML'}">
									<span class="badge rounded-pill"
										style="background-color: #6A5ACD">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'PYTHON'}">
									<span class="badge rounded-pill"
										style="background-color: #C71585">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'CSS'}">
									<span class="badge rounded-pill"
										style="background-color: #FFF8DC">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'LINUX'}">
									<span class="badge rounded-pill"
										style="background-color: #40E0D0">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'C#'}">
									<span class="badge rounded-pill"
										style="background-color: #8FBC8F">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'JAVASCRIPT'}">
									<span class="badge rounded-pill"
										style="background-color: #8A2BE2">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'AI'}">
									<span class="badge rounded-pill"
										style="background-color: #FFB6C1">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'BIGDATA'}">
									<span class="badge rounded-pill"
										style="background-color: #000080">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'DEEPLEARNING'}">
									<span class="badge rounded-pill"
										style="background-color: #FA8072">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'VR'}">
									<span class="badge rounded-pill"
										style="background-color: #FFA500">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'AR'}">
									<span class="badge rounded-pill"
										style="background-color: #F0E68C">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'EXCEL'}">
									<span class="badge rounded-pill"
										style="background-color: #B0C4DE">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'POWERPOINT'}">
									<span class="badge rounded-pill"
										style="background-color: #2F4F4F">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'KOTLIN'}">
									<span class="badge rounded-pill"
										style="background-color: #D8BFD8">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq 'SPRING'}">
									<span class="badge rounded-pill"
										style="background-color: #1E90FF">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq '기타'}">
									<span class="badge rounded-pill"
										style="background-color: #008080">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name  eq '형상관리'}">
									<span class="badge rounded-pill"
										style="background-color: #FFD700">${results.cod_name}</span>
								</c:when>
								<c:when test="${results.cod_name eq 'DATABASE'}">
									<span class="badge rounded-pill"
										style="background-color: #A52A2A">${results.cod_name}</span>
								</c:when>
								<c:otherwise>
									<span class="badge rounded-pill"
										style="background-color: #556B2F">${results.cod_name}</span>
								</c:otherwise>
							</c:choose>
                        </div>
                        <br>
                      </div>
                      <div class="pro-group">
                        <p> ${results.sub_content}</p>
                      </div>
                      <br>
                      <div class="pro-group">
                        <div class="row">
                          <div class="col-md-12">
                            <table>
                              <tbody>
                                <tr>
                                  <td> <b>${results.sub_tag}${results.cod_tag}</b></td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                         
                        </div>
                      </div>
                  
                    </div>
                  </div>
              </div>
              
              <div class="col-sm-12 col-xl-4">
                  <div class="card">
                    <div class="card-body">
                      <div class="pro-group pt-0 border-0">
                        <div class="product-page-details mt-0">
                          <h3>[ 세부 정보 ]</h3>
                        </div>
                        <br>
                        <div class="product-price">등록자 & 담당강사 정보
                        </div>
                        
                      </div>
                      <br>
                      <div class="pro-group">
                        <div class="row">
                        	<div class="col-sm-10">
                            <table>
                              <tbody>
                              <tr>
                                  <td> <b>등록일 &nbsp;: &nbsp;</b></td>
                                  <td class="txt-success"><fmt:parseDate var='cDate' value="${results.sub_regdate}" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${cDate}"/></td>
                                </tr>
                                <tr>
                                  <td> <b>등록자 &nbsp;: &nbsp;</b></td>
                                  <td class="txt-success">${results.sub_reg_id}</td>
                                </tr>
                                <tr>
                                  <td> <b>담당 강사 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
                                  <td>${results.sub_ins}</td>
                                </tr>
                              </tbody>
                            </table>
                            </div>
                          </div>
                         
                        </div>
                      </div>
                   
           
                    </div>
                  </div>
              </div>
        


          <div class="row">
           <div class="col-sm-12">
            <div class="card">
              <div class="row product-page-main">
                  <ul class="nav nav-tabs border-tab mb-0" id="top-tab" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="top-home-tab" data-bs-toggle="tab" href="#top-home" role="tab" aria-controls="top-home" aria-selected="false">과목상세</a>
                      <div class="material-border"></div>
                    </li>
                    <li class="nav-item"><a class="nav-link" id="profile-top-tab" data-bs-toggle="tab" href="#top-profile" role="tab" aria-controls="top-profile" aria-selected="false">커리큘럼</a>
                      <div class="material-border"></div>
                    </li>
                    <li class="nav-item"><a class="nav-link" id="contact-top-tab" data-bs-toggle="tab" href="#top-contact" role="tab" aria-controls="top-contact" aria-selected="true">요청사항</a>
                      <div class="material-border"></div>
                    </li>
                    <li class="nav-item"><a class="nav-link" id="brand-top-tab" data-bs-toggle="tab" href="#top-brand" role="tab" aria-controls="top-brand" aria-selected="true">첨부파일</a>
                      <div class="material-border"></div>
                    </li>
                  </ul>
                  <div class="tab-content" id="top-tabContent">
                    <div class="tab-pane fade active show" id="top-home" role="tabpanel" aria-labelledby="top-home-tab">
                    <br>
                    	<div class="product-price">${results.sub_title}에서 사용할 버전  
                    	<p class="mb-0 m-t-20">&nbsp;&nbsp; ${results.cur_version}</p><br>
                        </div>
                        <div class="product-price">수강 난이도
                    	<p class="mb-0 m-t-20">&nbsp;&nbsp; ${results.cur_level}</p><br>
                        </div>
                        <div class="product-price">수강 시간
                    	<p class="mb-0 m-t-20">&nbsp;&nbsp; ${results.cur_time} 시간</p><br>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="top-profile" role="tabpanel" aria-labelledby="profile-top-tab">
                     <p class="mb-0 m-t-20">${results.cur_detail}</p>
                    </div>
                    <div class="tab-pane fade" id="top-contact" role="tabpanel" aria-labelledby="contact-top-tab">
                    <p class="mb-0 m-t-20">${results.cur_subcontent}</p>
                    </div>
                    <div class="tab-pane fade" id="top-brand" role="tabpanel" aria-labelledby="brand-top-tab">
                    <p class="mb-0 m-t-20">${results.cur_file}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </div>
           <c:if test="${results.sub_status eq 'R'}">
          <div class="row">
           <div class="col-sm-12">
            <div class="card">
              <div class="row product-page-main">
                  <ul class="nav nav-tabs border-tab mb-0" id="top-tab" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="top-home-tab" data-bs-toggle="tab" href="#top-home" role="tab" aria-controls="top-home" aria-selected="false">반려사유</a>
                      <div class="material-border"></div>
                    </li>
                  </ul>
                  <div class="tab-content" id="top-tabContent">
                    <div class="tab-pane fade active show" id="top-home" role="tabpanel" aria-labelledby="top-home-tab">
                    <br>
                    	<div class="product-price">반려사유  
                    	<p class="mb-0 m-t-20">&nbsp;&nbsp; ${results.sub_rejection}</p><br>
                        </div>
                        <div class="product-price">수강 난이도
                    	<p class="mb-0 m-t-20">&nbsp;&nbsp; ${results.cur_level}</p><br>
                        </div>
                        <div class="product-price">수강 시간
                    	<p class="mb-0 m-t-20">&nbsp;&nbsp; ${results.cur_time} 시간</p><br>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </div>
            </c:if>
            
            
             <div class="row">
           <div class="col-sm-12">
            <div class="card">
            <div class="col-sm-12 col-xl-2">
              <div class="row product-page-main">
                             <button id="confirm" class="btn btn-outline-primary-2x" type="button" onclick="_gaq.push(['_trackEvent', 'example', 'try', 'sweet-5']);">승인하기</button>
                </div>
                </div>
              </div>
            </div>
            </div>
            

            </div>
            </div>
     
      <script type="text/javascript">
/*      $('.approve').on("click",function(){
    	alert('승인 클릭 이벤트 발생'); 
     }); */
     
/*      var btn = "test";
     $(document).ready(function(){
    	 $("button[name=approve]").click(function(){
    		 btn=$(this).attr("value");
    	 });
     }); */
/*      
     function changeStatus(){
    	 alert("승인 버튼이 클릭이되었습니다.");
     } */
      $("#confirm").click(function () {
    	 Swal.fire({
       	  title: '해당 과목을 승인하시겠습니까?',
       	  showDenyButton: true,
       	  showCancelButton: true,
       	  confirmButtonText: '승인',
       	  denyButtonText: '반려',
       	}).then((result) => { //버튼 클릭시 결과
       	  if (result.isConfirmed) {
       	    Swal.fire('승인처리되었습니다!', './subUpdateStatusA.do', 'success');
	       	history.back();
       	  } else if (result.isDenied) {
       		const { value: text } = Swal.fire({
       		  input: 'textarea',
       		  inputLabel: '반려사유',
       		  inputPlaceholder: '반려사유를 입력해주세요.',
       		  inputAttributes: {
       		    'aria-label': '반려사유를 입력해주세요.'
       		  },
       		  showCancelButton: true,
       		confirmButtonText: '저장'
       		}).then((result) => {
       			if (result.isConfirmed) {
       	       	    Swal.fire('반려사유가 등록되었습니다!', '', 'success')
       	       	  } else if (result.isDenied) {
       	       		Swal.fire('Changes are not saved', '', 'info')
       	       	  }
       		})

       		if (text) {
       		  Swal.fire(text)
       		} 
       	   /*  Swal.fire('Changes are not saved', '', 'info') */
       	  }
       	})
    	  });

 	
     
     </script>
</body>
<%@include file="./admin_footer.jsp" %>
</html>