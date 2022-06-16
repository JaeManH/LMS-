<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<%@ include file="../header.jsp" %>
<body>
          <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>Dash Board</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="./main.do">메인</a></li>
                    <li class="breadcrumb-item">회원</li>
                    <li class="breadcrumb-item active">대시보드</li>
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
            <div class="user-profile">
              <div class="row">
                <!-- user profile header start-->
                <div class="col-sm-12">
                  <div class="card profile-header"><img class="img-fluid bg-img-cover" src="../assets/images/user-profile/test1.jpg" alt="">
                    <div class="profile-img-wrrap"><img class="img-fluid bg-img-cover" src="../assets/images/user-profile/bg-profile.jpg" alt=""></div>
                    <!-- 배경안에 박스 -->
                    <div class="userpro-box">
                      <div class="img-wrraper">                              
                        <div class="avatar"><img class="img-fluid" alt="" src="../assets/images/user/7.jpg"></div><a class="icon-wrapper" href="./editProfile.do"><i class="icofont icofont-pencil-alt-5"></i></a>
                      </div>
                      <div class="user-designation">
                        <div class="title"><a target="_blank" href=""> 
                        <sec:authentication property="Details" var="info" /><br>
                            <h4>${info.name}<br></h4>
                            <h6>${info.email}</h6></a></div>
                        <div class="social-media">
                          <ul class="user-list-social">
                            <li><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://accounts.google.com/signin"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="https://www.instagram.com"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="https://github.com/"><i class="fa fa-git"></i></a></li>
                          </ul>
                        </div>
                        <div class="follow">
                          <ul class="follow-list">
                            <li>
                              <div class="follow-num counter">325</div><span>등록한 과목</span>
                            </li>
                            <li>
                              <div class="follow-num counter">${mile}</div><span>내 마일리지</span>
                            </li>
                            <li>
                              <div class="follow-num counter">${coup}</div><span>내 쿠폰</span>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- user profile header end-->
                <div class="col-xl-3 col-lg-12 col-md-5 xl-35">
                  <div class="default-according style-1 faq-accordion job-accordion">
                    <div class="row">
                      <div class="col-xl-12">
                        <div class="card">
                          <div class="card-header">
                            <h5 class="p-0">
                              <button class="btn btn-link ps-0" data-bs-toggle="collapse" data-bs-target="#collapseicon2" aria-expanded="true" aria-controls="collapseicon2">About Me</button>
                            </h5>
                          </div>
                          <div class="collapse show" id="collapseicon2" aria-labelledby="collapseicon2" data-parent="#accordion">
                            <div class="card-body post-about">
                              <ul>
                                <li>
                                  <div class="icon"><i data-feather="briefcase"></i></div>
                                  <div>
                                    <h5>생년월일</h5>
                                    <p>${info.birth}</p>
                                  </div>
                                </li>
                                <li>
                                  <div class="icon"><i data-feather="book"></i></div>
                                  <div>
                                    <h5>전화번호</h5>
                                    <p>${info.phone}</p>
                                  </div>
                                </li>
                                <li>
                                  <div class="icon"><i data-feather="heart"></i></div>
                                  <div>
                                    <h5>가입일</h5>
                                    <p>${info.regdate }</p>
                                  </div>
                                </li>
                                <li>
                                  <div class="icon"><i data-feather="map-pin"></i></div>
                                  <div>
                                    <h5>회원 등급
                                    </h5>
                                    <p>
                                     <c:if test = "${info.auth eq 'ROLE_USER'}">일반 회원</c:if>
                                      <c:if test = "${info.auth eq 'ROLE_ADMIN'}">관리자</c:if>
                                      <c:if test = "${info.auth eq 'ROLE_INSTRUCTOR'}">강사</c:if>
                                   </p>
                                  </div>
                                </li>
                              </ul>
                              <div class="social-network theme-form"><span class="f-w-600">Social Networks</span>
                                <button class="btn social-btn btn-fb mb-2 text-center"><i class="fa fa-facebook m-r-5"></i>Facebook</button>
                                <button class="btn social-btn btn-twitter mb-2 text-center"><i class="fa fa-twitter m-r-5"></i>Twitter</button>
                                <button class="btn social-btn btn-google text-center"><i class="fa fa-dribbble m-r-5"></i>Dribbble</button>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-xl-12 col-lg-6 col-md-12 col-sm-6">
                        <div class="card">
                          <div class="card-header">
                            <h5 class="p-0">
                              <button class="btn btn-link ps-0" data-bs-toggle="collapse" data-bs-target="#collapseicon8" aria-expanded="true" aria-controls="collapseicon8">과목</button>
                            </h5>
                          </div>
                          <div class="collapse show" id="collapseicon8" aria-labelledby="collapseicon8" data-parent="#accordion">
                            <div class="card-body social-list filter-cards-view">
                              <div class="media"><!-- <img class="img-50 img-fluid m-r-20 rounded-circle" alt="" src="../assets/images/user/2.png"> -->
                                <div class="media-body"><span class="d-block">1</span><a href="./user_subSelectMySubject.do">등록한 과목 보러가기</a></div>
                              </div>
                              <!-- <div class="media"><img class="img-50 img-fluid m-r-20 rounded-circle" alt="" src="../assets/images/user/3.png">
                                <div class="media-body"><span class="d-block">Sarah Loren</span><a href="javascript:void(0)">Add Friend</a></div>
                              </div>
                              <div class="media"><img class="img-50 img-fluid m-r-20 rounded-circle" alt="" src="../assets/images/user/3.jpg">
                                <div class="media-body"><span class="d-block">Jason Borne</span><a href="javascript:void(0)">Add Friend</a></div>
                              </div>
                              <div class="media"><img class="img-50 img-fluid m-r-20 rounded-circle" alt="" src="../assets/images/user/10.jpg">
                                <div class="media-body"><span class="d-block">Comeren Diaz</span><a href="javascript:void(0)">Add Friend</a></div>
                              </div>
                              <div class="media"><img class="img-50 img-fluid m-r-20 rounded-circle" alt="" src="../assets/images/user/11.png">
                                <div class="media-body"><span class="d-block">Andew Jon</span><a href="javascript:void(0)">Add Friend</a></div>
                              </div> -->
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-xl-12 col-lg-6 col-md-12 col-sm-6">
                        <div class="card">
                          <div class="card-header">
                            <h5 class="p-0">
                              <a href="./myLikelist.do">내 좋아요 목록</a>
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-xl-12 col-lg-6 col-md-12 col-sm-6">
                        <div class="card">
                          <div class="card-header">
                            <h5 class="p-0">
                              <a href="./prefer.do">선호조건 바꾸기</a>
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-xl-12 col-lg-6 col-md-12 col-sm-6">
                        <div class="card">
                          <div class="card-header">
                            <h5 class="p-0">
                              <button class="btn btn-link ps-0" data-bs-toggle="collapse" data-bs-target="#collapseicon13" aria-expanded="true" aria-controls="collapseicon13">Friends</button>
                            </h5>
                          </div>
                          <div class="collapse show" id="collapseicon13" data-parent="#accordion" aria-labelledby="collapseicon13">
                            <div class="card-body avatar-showcase filter-cards-view">
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/3.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/5.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/1.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/2.png" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/3.png" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/6.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/10.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/14.png" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/1.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/4.jpg" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/11.png" alt="#"></div>
                              <div class="d-inline-block friend-pic"><img class="img-50 rounded-circle" src="../assets/images/user/8.jpg" alt="#"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-xl-9 col-lg-12 col-md-7 xl-65">
                  <div class="row">
                    <!-- profile post start-->
                    <div class="col-sm-12">
                      <div class="card">
                        <div class="profile-post">
                          <div class="post-header">
                            <div class="media"><img class="img-thumbnail rounded-circle me-3" src="../assets/images/user/7.jpg" alt="Generic placeholder image">
                              <div class="media-body align-self-center"><a href="social-app.html">
                                  <h5 class="user-name">Emay Walter</h5></a>
                                <h6>22 Hours ago</h6>
                              </div>
                            </div>
                            <div class="post-setting"><i class="fa fa-ellipsis-h"></i></div>
                          </div>
                          <div class="post-body">
                            <div class="img-container">
                              <div class="my-gallery" id="aniimated-thumbnials" itemscope="">
                                <figure itemprop="associatedMedia" itemscope=""><a href="../assets/images/user-profile/post1.jpg" itemprop="contentUrl" data-size="1600x950"><img class="img-fluid rounded" src="../assets/images/user-profile/post1.jpg" itemprop="thumbnail" alt="gallery"></a>
                                  <figcaption itemprop="caption description">Image caption  1</figcaption>
                                </figure>
                              </div>
                            </div>
                            <div class="post-react">
                              <ul>
                                <li><img class="rounded-circle" src="../assets/images/user/3.jpg" alt=""></li>
                                <li><img class="rounded-circle" src="../assets/images/user/5.jpg" alt=""></li>
                                <li><img class="rounded-circle" src="../assets/images/user/1.jpg" alt=""></li>
                              </ul>
                              <h6>+5 people react this post</h6>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.                                     </p>
                            <ul class="post-comment">
                              <li>
                                <label><a href="#"><i data-feather="heart"></i>&nbsp;&nbsp;Like<span class="counter">50</span></a></label>
                              </li>
                              <li>
                                <label><a href="#"><i data-feather="message-square"></i>&nbsp;&nbsp;Comment<span class="counter">70</span></a></label>
                              </li>
                              <li>
                                <label><a href="#"><i data-feather="share"></i>&nbsp;&nbsp;share<span class="counter">20</span></a></label>
                              </li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- profile post end-->
                   
                    <!-- profile post start-->
                    <div class="col-sm-12">
                      <div class="card">
                        <div class="profile-post">
                          <div class="post-header">
                            <div class="media"><img class="img-thumbnail rounded-circle me-3" src="../assets/images/user/7.jpg" alt="Generic placeholder image">
                              <div class="media-body align-self-center"><a href="social-app.html">
                                  <h5 class="user-name">Emay Walter</h5></a>
                                <h6>2 Hours ago</h6>
                              </div>
                            </div>
                            <div class="post-setting"><i class="fa fa-ellipsis-h"></i></div>
                          </div>
                          <div class="post-body">
                            <div class="img-container">
                              <div class="my-gallery" id="aniimated-thumbnials" itemscope="">
                                <figure itemprop="associatedMedia" itemscope=""><a href="../assets/images/user-profile/post4.jpg" itemprop="contentUrl" data-size="1600x950"><img class="img-fluid rounded" src="../assets/images/user-profile/post4.jpg" itemprop="thumbnail" alt="gallery"></a>
                                  <figcaption itemprop="caption description">Image caption  1</figcaption>
                                </figure>
                              </div>
                            </div>
                            <div class="post-react">
                              <ul>
                                <li><img class="rounded-circle" src="../assets/images/user/3.jpg" alt=""></li>
                                <li><img class="rounded-circle" src="../assets/images/user/5.jpg" alt=""></li>
                                <li><img class="rounded-circle" src="../assets/images/user/1.jpg" alt=""></li>
                              </ul>
                              <h6>+20 people react this post</h6>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.                                     </p>
                            <ul class="post-comment">
                              <li>
                                <label><a href="#"><i data-feather="heart"></i>&nbsp;&nbsp;Like<span class="counter">407</span></a></label>
                              </li>
                              <li>
                                <label><a href="#"><i data-feather="message-square"></i>&nbsp;&nbsp;Comment<span class="counter">302</span></a></label>
                              </li>
                              <li>
                                <label><a href="#"><i data-feather="share"></i>&nbsp;&nbsp;share<span class="counter">180</span></a></label>
                              </li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- profile post end                           -->
                  </div>
                </div>
                
              </div>
            </div>
          </div>
          <!-- Container-fluid Ends-->
        </div>
        
 <%@ include file="../footer.jsp" %> 
</body>
</html>