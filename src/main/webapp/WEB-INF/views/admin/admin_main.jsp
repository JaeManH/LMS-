<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>첫 페이지</title>
</head>
<%@ include file="./admin_header.jsp" %>
<body>
  
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>Admin Page</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                    <li class="breadcrumb-item">중분류</li>
                    <li class="breadcrumb-item active">소분류</li>
                  </ol>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row">
                            <div class="col-xl-4 xl-50 col-sm-6 box-col-6">
                                <div class="card">
                                    <div class="product-box learning-box">
                                        <div class="product-img"><img class="img-fluid top-radius-blog"
                                                                      src="../resources/images/main01.jpg" alt="">
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
          <!-- Container-fluid Ends-->
        </div>

      </div>
    </div>



<%@include file="./admin_footer.jsp" %>


  
</body>
</html>