<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>과정 설문조사</title>
</head>
<%@ include file="../header.jsp" %>
<body>

<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
            <div class="row">
                <div class="col-sm-6">
                    <h3>설문조사</h3>
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
                <h5>${title}</h5>
                <form action="./classCheckList.do" method="post" id="checkForm">
                    <input type="hidden" name="sub_num" value="${sub_num}">
                    <div class="card">
                        <div class="card-header pb-0">
                            <h5>강사와의 소통은 잘 이루어 졌나요?</h5>
                        </div>
                        <div class="card-body animate-chk">
                            <div class="row">
                                <div class="col">
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="communication" value="1"> 매우
                                        아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="communication" value="2"> 조금
                                        아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="communication" value="3"> 보통이다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="communication" value="4"> 그렇다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="communication" value="5"> 매우
                                        그렇다
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header pb-0">
                            <h5>커리큘럼은 잘 짜여졌나요?</h5>
                        </div>
                        <div class="card-body animate-chk">
                            <div class="row">
                                <div class="col">
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="curriculum" value="1"> 매우 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="curriculum" value="2"> 조금 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="curriculum" value="3"> 보통이다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="curriculum" value="4"> 그렇다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="curriculum" value="5"> 매우 그렇다
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header pb-0">
                            <h5>교재와 자료의 양과 질은 충분했나요?</h5>
                        </div>
                        <div class="card-body animate-chk">
                            <div class="row">
                                <div class="col">
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="book" value="1"> 매우 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="book" value="2"> 조금 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="book" value="3"> 보통이다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="book" value="4"> 그렇다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="book" value="5"> 매우 그렇다
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header pb-0">
                            <h5>실습의 양과 질은 충분했나요?</h5>
                        </div>
                        <div class="card-body animate-chk">
                            <div class="row">
                                <div class="col">
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="practice" value="1"> 매우 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="practice" value="2"> 조금 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="practice" value="3"> 보통이다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="practice" value="4"> 그렇다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="practice" value="5"> 매우 그렇다
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header pb-0">
                            <h5>수업에 집중과 몰입이 잘 되도록 구성되었나요?</h5>
                        </div>
                        <div class="card-body animate-chk">
                            <div class="row">
                                <div class="col">
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="immersion" value="1"> 매우 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="immersion" value="2"> 조금 아니다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="immersion" value="3"> 보통이다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="immersion" value="4"> 그렇다
                                    </label>
                                    <label class="d-block">
                                        <input class="radio_animated" type="radio" name="immersion" value="5"> 매우 그렇다
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-light" onclick="javascript: history.back()">취소</button>
                    <button type="button" class="btn btn-primary" id="smitBtn">제출</button>
                </form>
            </div>
        </div>
        <!-- Container-fluid Ends-->
    </div>

</div>
</div>


<%@include file="../footer.jsp" %>
<script>
    $("#smitBtn").on('click', function () {
        var check1 = $('input:radio[name=communication]').is(':checked');
        var check2 = $('input:radio[name=curriculum]').is(':checked');
        var check3 = $('input:radio[name=book]').is(':checked');
        var check4 = $('input:radio[name=practice]').is(':checked');
        var check5 = $('input:radio[name=immersion]').is(':checked');
        console.log("제출 클릭됨");
        if (!(check1 && check2 && check3 && check4 && check5)) {
            alert("모든 항목을 체크해주세요");
            return false;
        }
        console.log("모두 입력됨");
        $("#checkForm").submit();
    });
</script>


</body>
</html>