<%--
  Created by IntelliJ IDEA.
  User: JaeMan
  Date: 2022-06-08
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>태그 페이지</title>


</head>
<%@include file="./header.jsp" %>
<body>
<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
            <div class="row">
                <div class="col-sm-6">
                    <h3>태그 검색</h3>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/main.do">Home</a></li>
                        <li class="breadcrumb-item active">태그 검색</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <h1>태그 검색 페이지</h1>
                <select style="width: 150px;"  id="category">
                    <option  value="과정" >과정</option>
                    <option  value="과목" >과목</option>
                </select>
                <input id="searchBox" style="width: 300px;">
                <hr>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col" >이름</th>
                        <th scope="col" id="tab2" style="width: 80px;">가격</th>
                        <th scope="col">과정내용</th>
                        <th scope="col" style="width: 200px;">등록일</th>
                    </tr>
                    </thead>
                    <tbody id="searchResult">
                    <c:forEach var="vo" items="${lists}" varStatus="vs">
                        <tr>
                            <td>${vo.cbo_ins_id}</td>
                            <td><a href="./classBoardSelectDetail.do?cbo_seq=${vo.cbo_seq}">${vo.cbo_title}</a>
                            </td>
                            <td>${vo.cbo_cate}</td>
                            <td>${vo.cbo_regdate}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <!-- Container-fluid Ends-->
    </div>

</div>
</div>

<%@include file="./footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="../resources/js/statistics/tagSearch.js"></script>
</body>

</html>
