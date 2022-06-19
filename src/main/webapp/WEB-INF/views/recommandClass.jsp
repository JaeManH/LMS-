<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>추천 과정</title>
    <link rel="stylesheet" href="../resources/css/statistics/tag.css">
    <%@ include file="./header.jsp" %>
</head>
<%--다른 폴더 안에 들어가면 인클루드 된 파일 경로 앞에 .을 붙여야함--%>
<body>

<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
            <div class="row">
                <div class="col-sm-6">
                    <h3>추천 과정</h3>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">

                <div class="card">
                    <div class="card-body">
                        <div class="tab-content" id="top-tabContent">
                            <div class="tab-pane fade show active" id="top-home" role="tabpanel"
                                 aria-labelledby="top-home-tab">
                                <div class="row">
                                    <c:forEach items="${lists}" var="vo">
                                        <div class="col-xxl-4 col-lg-6" id="${vo.cla_status}">
                                            <div class="project-box">
                                                <c:if test="${vo.cla_status eq '모집중'}">
                                                    <span class="badge badge-primary">${vo.cla_status}</span>
                                                </c:if>
                                                <c:if test="${vo.cla_status eq '준비중'}">
                                                    <span class="badge badge-secondary">${vo.cla_status}</span>
                                                </c:if>
                                                <c:if test="${vo.cla_status eq '수강중'}">
                                                    <span class="badge badge-secondary">${vo.cla_status}</span>
                                                </c:if>
                                                <c:if test="${vo.cla_status eq '종강'}">
                                                    <span class="badge badge-danger">${vo.cla_status}</span>
                                                </c:if>
                                                <h6>
                                                    <a href="./classSelectDetail.do?cla_num=${vo.cla_num}"
                                                       style="color: #0B614B;">${vo.cla_title}</a></h6>
                                                <div class="media"><img class="img-20 me-2 rounded-circle"
                                                                        src="../assets/images/user/3.jpg" alt=""
                                                                        data-original-title="" title="">
                                                    <div class="media-body">
                                                        <p>과정 시작일 : ${vo.cla_startdate}</p>
                                                    </div>
                                                </div>
                                                <p>${vo.cla_content}</p>
                                                <div class="row details">
                                                    <div class="col-6"><span>정원</span></div>
                                                    <div class="col-6 font-primary">${vo.cla_maxpeo}</div>
                                                    <div class="col-6"><span>일일 수업시간</span></div>
                                                    <div class="col-6 font-primary">${vo.cla_dailytime}</div>
                                                    <div class="col-6"><span>총 수업시간</span></div>
                                                    <div class="col-6 font-primary">${vo.cla_totaltime}</div>
                                                </div>
                                                <%!
                                                    String[] color = {"primary","secondary","danger","dark","info","warning","success","light"};

                                                    public String ranColor(int n){
                                                        return color[n];
                                                    }

                                                %>
                                                <div class="customers">
                                                    <ul>
                                                        <li class="d-inline-block ms-2">
                                                            <h5 style="color: teal;">${vo.cla_price} ₩</h5>
                                                        </li>
                                                        <li style="text-align: right;padding-left: 15px">
                                                            <c:forEach items="${vo.cla_tags}" var="tag">
                                                                    <span class="badge round-badge-<%out.print(ranColor((int)(Math.random()*8)));%>"
                                                                          style="position: relative; ">${tag}</span>
                                                            </c:forEach>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <!--                               <div class="project-status mt-4"> -->
                                                <!--                                 <div class="media mb-0"> -->
                                                <!--                                   <p>70% </p> -->
                                                <!--                                   <div class="media-body text-end"><span>Done</span></div> -->
                                                <!--                                 </div> -->
                                                <!--                                 <div class="progress" style="height: 5px"> -->
                                                <!--                                   <div class="progress-bar-animated bg-primary progress-bar-striped" role="progressbar" style="width: 70%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div> -->
                                                <!--                                 </div> -->
                                                <!--                               </div> -->
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
        <!-- Container-fluid Ends-->
    </div>

</div>
</div>


<%@include file="./footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="../resources/js/statistics/prefer.js"></script>


</body>
</html>