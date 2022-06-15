<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>선호 조건 설정</title>
    <link rel="stylesheet" href="../resources/css/statistics/tag.css">
    <%@ include file="./header.jsp" %>
    <style>
        .tooltiph {
            display: inline-block;
        }

        .tooltiph .tooltiptexth {
            visibility: hidden;
            width: 340px;
            background-color: #24695c;
            color: #fff;
            text-align: center;
            border-radius: 6px;
            padding: 5px 0;

            /* Position the tooltip */
            position: absolute;
            z-index: 1;
        }

        .tooltiph:hover .tooltiptexth {
            visibility: visible;
        }
    </style>
</head>
<%--다른 폴더 안에 들어가면 인클루드 된 파일 경로 앞에 .을 붙여야함--%>
<body>

<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
            <div class="row">
                <div class="col-sm-6">
                    <h3>선호조건 설정</h3>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">

                <form action="./prefer.do" method="post" id="preferForm">
                    <h4>선호과목 명</h4><br>
                    <input id="searchBox" class="input-txt-bx" placeholder="검색어를 입력해주세요">

                    <div id="selSub" style="margin-bottom: 80px"></div>

                    <div class="mb-2">
                        <label class="col-form-label">선호 강의 난이도</label>
                        <div class="tooltiph">
                            <i class="icofont icofont-question-circle"></i>
                            <span class="tooltiptexth">내가 원하는 강의 난이도입니다.</span>
                        </div>
                        <select name="difficulty" class="form-control form-control-primary btn-square" id="difficulty">
                            <option value="0">선택해주세요</option>
                            <option value="easy">초급</option>
                            <option value="normal">중급</option>
                            <option value="hard">고급</option>
                        </select>
                    </div>
                    <div class="mb-2">
                        <label class="col-form-label">선호 강의 시간</label>
                        <div class="tooltiph">
                            <i class="icofont icofont-question-circle"></i>
                            <span class="tooltiptexth">내가 원하는 과정의 총 시간입니다.</span>
                        </div>
                        <select name="time" class="form-control form-control-primary btn-square" id="time">
                            <option value="0">선택해주세요</option>
                            <option value="30-60">30시간~60시간</option>
                            <option value="60-90">60시간~90시간</option>
                            <option value="90-120">90시간~120시간</option>
                            <option value="120-999">120시간 이상</option>
                        </select>
                    </div>

                    <div class="mb-2">
                        <label class="col-form-label">선호 강의 기간</label>
                        <div class="tooltiph">
                            <i class="icofont icofont-question-circle"></i>
                            <span class="tooltiptexth">내가 수강하기를 원하는 과정의 신청가능 기간입니다.</span>
                        </div>
                        <select name="date" class="form-control form-control-primary btn-square" id="date">
                            <option value="0">선택해주세요</option>
                            <option value="1">1개월 이내</option>
                            <option value="3">3개월 이내</option>
                            <option value="6">6개월 이내</option>
                            <option value="12">12개월 이내</option>
                        </select>
                    </div>
                    <br>

                    <br>
                    <br>
                    <button type="button" class="btn btn-primary" onclick="preferCheck()">확인</button>
                    <button type="button" class="btn btn-light" onclick="javascript: history.back()">취소</button>
                </form>
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