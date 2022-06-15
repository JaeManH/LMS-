<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
    <title>첫 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>

<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
        </div>
    </div>
    <!-- Container-fluid starts-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                <div class="card-header pb-0">
                    <h5>Recommended courses</h5>
                  </div>
                    <div class="card-header pb-0">
                        <%--                    <sec:authorize access="isAuthenticated()">--%>
                        <%--	<p>--%>
                        <%--		--%>
                        <%--		<sec:authentication property="principal"  var="id" /><br>--%>
                        <%--	    principal =>  시큐리티 세션 아아디 : ${id}<br>--%>
                        <%--		<sec:authentication property="Details" var="info" /><br>--%>
                        <%--		시큐리티 세션 .디테일 부분--%>
                        <%--		이름 : ${info.name}<br>--%>
                        <%--		이메일 : ${info.email} <br>--%>
                        <%--		생년월일 : ${info.birth}<br>--%>
                        <%--		프로필 : ${info.profile}<br>--%>
                        <%--		가입일 :   ${info.regdate}<br>--%>
                        <%--		은행 :   ${info.bank}<br>--%>
                        <%--		계좌번호 :   ${info.banknum }<br>--%>
                        <%--		회원상태 : ${info.delflag } <br>--%>
                        <%--		회원권한 : ${info.auth} <br>--%>
                        <%--		비밀번호 : <sec:authentication property="Credentials" /><br>--%>
                        <%--		시큐리티 세션 권한: <sec:authentication property="Authorities" /><br>--%>
                        <%--	</p>--%>
                        <%--</sec:authorize>--%>
                        <div class="row">
                            <div class="col-xl-4 xl-50 col-sm-6 box-col-6">
                                <div class="card">
                                    <div class="product-box learning-box">
                                        <div class="product-img"><img class="img-fluid top-radius-blog"
                                                                      src="../resources/images/main01.jpeg.jpg" alt="">
                                            <div class="product-hover">
                                                <ul>
                                                    <li><a href="learning-detailed.html"><i class="icon-link"></i></a>
                                                    </li>
                                                    <li><a href="learning-detailed.html"><i class="icon-import"></i></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="details-main"><a href="learning-detailed.html">
                                            <div class="bottom-details">
                                                <h6>JSP 전문가 과정</h6>
                                            </div>
                                        </a>
                                            <p>JSP 전문가가 되고 싶은 수강자들을 모집중이며 난이도가 있는 과정이니 중급개발자 이상 지원을 권장드립니다.</p>
                                            <br>
                                            <button class="btn btn-primary" type="button">Go Detail</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 xl-50 col-sm-6 box-col-6">
                                <div class="card">
                                    <div class="product-box learning-box">
                                        <div class="product-img"><img class="img-fluid top-radius-blog"
                                                                      src="../resources/images/main03.jpg" alt="">
                                            <div class="product-hover">
                                                <ul>
                                                    <li><a href="learning-detailed.html"><i class="icon-link"></i></a>
                                                    </li>
                                                    <li><a href="learning-detailed.html"><i class="icon-import"></i></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="details-main"><a href="learning-detailed.html">
                                            <div class="bottom-details">
                                                <h6>빅데이터 기초 과정</h6>
                                            </div>
                                        </a>
                                            <p>빅데이터를 취미 혹은 배경지식이 없는 상태에서 배워보고 싶은 수강자들을 모집중입니다.</p>
                                            <br>
                                            <button class="btn btn-primary" type="button">Go Detail</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 xl-50 col-sm-6 box-col-6">
                                <div class="card">
                                    <div class="product-box learning-box">
                                        <div class="product-img"><img class="img-fluid top-radius-blog"
                                                                      src="../resources/images/main02.jpg" alt="">
                                            <div class="product-hover">
                                                <ul>
                                                    <li><a href="learning-detailed.html"><i class="icon-link"></i></a>
                                                    </li>
                                                    <li><a href="learning-detailed.html"><i class="icon-import"></i></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="details-main"><a href="learning-detailed.html">
                                            <div class="bottom-details">
                                                <h6>Security 심화강좌</h6>
                                            </div>
                                        </a>
                                            <p>웹 분야 데이터 보안에 관심이 많은 수강자를 모집중입니다. 심화강좌이기때문에 중급개발자 이상 지원을 권장합니다.</p>
                                            <br>
                                            <button class="btn btn-primary" type="button">Go Detail</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <h5>Recommended Instructor</h5>
                        <hr>
                        <div class="row">
	                        <div class="col-sm-12 col-xl-6">
				                <div class="card">
				                  <div class="card-header d-flex justify-content-between align-items-center pb-0">
				                    <h5><i class="fa fa-user"></i>&nbsp;&nbsp;Min Kyun Jeon</h5>
				                    <div class="setting-list">
				                      <ul class="list-unstyled setting-option">
				                        <li>
				                          <div class="setting-primary"><i class="icon-settings"></i></div>
				                        </li>
				                        <li><i class="view-html fa fa-code font-primary"></i></li>
				                        <li><i class="icofont icofont-maximize full-card font-primary"></i></li>
				                        <li><i class="icofont icofont-minus minimize-card font-primary"></i></li>
				                        <li><i class="icofont icofont-refresh reload-card font-primary"></i></li>
				                        <li><i class="icofont icofont-error close-card font-primary"></i></li>
				                      </ul>
				                    </div>
				                  </div>
				                  <div class="card-body">
				                    <p>“처음부터 다 이해하고 잘 할 수 있는 일은 없습니다.”<br>
										IT를 몰라서 SW 개발을 해본 적이 없어서..’ 이러한 두려운 마음은 열정과 자신감만 있다면 못할 일이 없습니다.
										풀리지 않는 문제는 없습니다.
										취업을 위한 가장 중요한 시기에 SW분야의 정확한 기술과 경험을 전수하고
										난해한 문제점을 같이 고민하고 풀어가겠습니다.
										목표한 곳까지의 “페이스메이커”가 되어 끝까지 함께 하겠습니다.</p>
				                  </div>
				                </div>
				              </div>
				              <div class="col-sm-12 col-xl-6">
				                <div class="card">
				                  <div class="card-header d-flex justify-content-between align-items-center pb-0">
				                    <h5><i class="fa fa-user"></i>&nbsp;&nbsp;Jung Gi Song</h5>
				                    <div class="setting-list">
				                      <ul class="list-unstyled setting-option">
				                        <li>
				                          <div class="setting-primary"><i class="icon-settings"></i></div>
				                        </li>
				                        <li><i class="view-html fa fa-code font-primary"></i></li>
				                        <li><i class="icofont icofont-maximize full-card font-primary"></i></li>
				                        <li><i class="icofont icofont-minus minimize-card font-primary"></i></li>
				                        <li><i class="icofont icofont-refresh reload-card font-primary"></i></li>
				                        <li><i class="icofont icofont-error close-card font-primary"></i></li>
				                      </ul>
				                    </div>
				                  </div>
				                  <div class="card-body">
				                    <p>“여러분과 좋은 인연을 맺고 싶습니다.”<br>
										"관심"이 인생의 전부는 아니지만 현재 여러분의 "취업"이었으면 좋겠습니다.
										모든 일은 "취업"에서부터 시작됩니다.<br><br>
										저도 여러분을 "관심"있게 지켜볼 수 있도록 힘내겠습니다 :)</p>
				                  </div>
				                </div>
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
<!-- footer start-->
</div>
</div>


<%@include file="./footer.jsp" %>


</body>
</html>