<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JaeMan
  Date: 2022-06-09
  Time: 오후 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>내 좋아요 목록</title>
</head>
<%@ include file="../header.jsp" %>
<body>

<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
            <div class="row">
                <div class="col-sm-6">
                    <h3>내 좋아요 목록</h3>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                        <li class="breadcrumb-item">마이페이지</li>
                        <li class="breadcrumb-item active">내 좋아요 목록</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <table class="table table-hover" style="text-align: center">
                    <thead>
                    <tr>
                        <th scope="col">과정명</th>
                        <th scope="col">상태</th>
                        <th scope="col" style="width: 115px;"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vo" items="${lists}" varStatus="vs">
                        <tr>
                            <td style="text-align: left;padding-left: 100px;"><a href="./classSelectDetail.do?cla_num=${vo.cla_num}">${vo.cla_title}</a></td>
                            <td>${vo.cla_status}</td>
                            <td>
                                <button type="button" class="btn btn-primary" onclick="likeCancel('${vo.cla_num}',this)">취소
                                </button>
                            </td>
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


<%@include file="../footer.jsp" %>
<script>
    function likeCancel(claid,btn) {
        console.log(claid);
        console.log('좋아요 버튼 클릭 됨');
        $.ajax({
            url: './clickLike.do',
            data: {"claid": claid},
            type: 'POST',
            async: true,
            dataType: 'text',
            success: function (result) {
                console.log(result);
                $("#likeCnt").text(result);
            },
            error: function () {
                console.log("통신실패")
            }

        })
        btn.parentNode.parentNode.remove();
        console.log(btn);
    }
</script>


</body>
</html>