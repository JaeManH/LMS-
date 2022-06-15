<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
<%@ include file="./admin_header.jsp" %>
<body>
<!-- Page Sidebar Ends-->
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>모든 과정</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="./adminMain.do">Home</a></li>
                    <li class="breadcrumb-item active">모든 과정</li>
                  </ol>
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row project-cards">
              <div class="col-md-12 project-list">
                <div class="card">
                  <div class="row">
                    <div class="col-md-6 p-0">
                      <ul class="nav nav-tabs border-tab" id="top-tab" role="tablist">
                        <li class="nav-item"><a class="nav-link active" id="top-home-tab" data-bs-toggle="tab" href="#top-home" role="tab" aria-controls="top-home" aria-selected="true" style="font-size: 13px;"><i data-feather="target"></i>모든 과정</a></li>
                        <li class="nav-item"><a class="nav-link active" id="top-home-tab" data-bs-toggle="tab" href="#top-profile" role="tab" aria-controls="top-home" aria-selected="true" style="font-size: 13px;"><i data-feather="info"></i>모집중</a></li>
                        <li class="nav-item"><a class="nav-link" id="profile-top-tab" data-bs-toggle="tab" href="#top-profile" role="tab" aria-controls="top-profile" aria-selected="false" style="font-size: 13px;"><i data-feather="info"></i>투표중</a></li>
                        <li class="nav-item"><a class="nav-link" id="profile-top-tab" data-bs-toggle="tab" href="#top-profile" role="tab" aria-controls="top-profile" aria-selected="false" style="font-size: 13px;"><i data-feather="info"></i>수강중</a></li>
                        <li class="nav-item"><a class="nav-link" id="contact-top-tab" data-bs-toggle="tab" href="#top-contact" role="tab" aria-controls="top-contact" aria-selected="false" style="font-size: 13px;"><i data-feather="check-circle"></i>종강</a></li>
                      </ul>
                    </div>
                    <div class="col-md-6 p-0">
                      <div class="form-group mb-0 me-0"></div><a class="btn btn-primary" href="./classInsertForm.do"> <i data-feather="plus-square"> </i>과정 등록하기</a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-body">
                    <div class="tab-content" id="top-tabContent">
                      <div class="tab-pane fade show active" id="top-home" role="tabpanel" aria-labelledby="top-home-tab">
                        <div class="row">
             			 <c:forEach items="${lists}" var="vo">
                          <div class="col-xxl-4 col-lg-6" id="${vo.cla_status}">
                            <div class="project-box">
                            <c:if test="${vo.cla_status eq '모집중'}">
                            <span class="badge badge-primary">${vo.cla_status}</span>
                            </c:if>
                             <c:if test="${vo.cla_status eq '승인중'}">
                            <span class="badge badge-danger">${vo.cla_status}</span>
                            </c:if>
                            <c:if test="${vo.cla_status eq '개강전'}">
                            <span class="badge badge-secondary">${vo.cla_status}</span>
                            </c:if>
                            <c:if test="${vo.cla_status eq '수강중'}">
                            <span class="badge badge-secondary">${vo.cla_status}</span>
                            </c:if>
                            <c:if test="${vo.cla_status eq '종강'}">
                            <span class="badge badge-danger">${vo.cla_status}</span>
                            </c:if>
                              <h6>
                              <a href="./classSelectDetail.do?cla_num=${vo.cla_num}" style="color: #0B614B;">${vo.cla_title}</a></h6>
                              <div class="media"><img class="img-20 me-2 rounded-circle" src="../assets/images/user/3.jpg" alt="" data-original-title="" title="">
                                <div class="media-body">
                                  <p>과정 시작일 : ${vo.cla_startdate}</p>
                                </div>
                              </div>
                              <p>${vo.cla_content}</p>
                              <div class="row details">
                                <div class="col-6"><span>정원</span></div>
                                <div class="col-6 font-primary">${vo.cla_maxpeo}</div>
                                <div class="col-6"> <span>일일 수업시간</span></div>
                                <div class="col-6 font-primary">${vo.cla_dailytime}</div>
                                <div class="col-6"> <span>총 수업시간</span></div>
                                <div class="col-6 font-primary">${vo.cla_totaltime}</div>
                              </div>
                              <div class="customers">
                                <ul>
                                  <li class="d-inline-block"><img class="img-30 rounded-circle" src="../assets/images/user/3.jpg" alt="" data-original-title="" title=""></li>
                                  <li class="d-inline-block"><img class="img-30 rounded-circle" src="../assets/images/user/5.jpg" alt="" data-original-title="" title=""></li>
                                  <li class="d-inline-block"><img class="img-30 rounded-circle" src="../assets/images/user/1.jpg" alt="" data-original-title="" title=""></li>
                                  <li class="d-inline-block ms-2">
                                    <h5 style="color: teal;">${vo.cla_price} ₩</h5>
                                  </li>
                                </ul>
                              </div>
                              
                              <sec:authentication property="principal"  var="id" /><br>
						<%-- 	    principal =>  시큐리티 세션 아아디 : ${id}<br> --%>
							  <sec:authentication property="Details" var="info" /><br>
						<%-- 		회원권한 : ${info.auth} <br> --%>
                            </div>
                          </div>
                 		  </c:forEach>
                         </div>
                        </div>
                       </div>
                     </div>
                    </div>
                  </div>
            </div>
          </div>
          <!-- Container-fluid Ends-->
	</div>
</body>
<%@include file="./admin_footer.jsp" %>
</html>