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
                  <h3>과정 업데이트</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="./adminMain.do">Home</a></li>
                    <li class="breadcrumb-item">과정 전체</li>
                    <li class="breadcrumb-item">과정 상세</li>
                    <li class="breadcrumb-item">과정 수정</li>
                  </ol>
                </div>
                <div class="col-sm-6">
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row">
              <div class="col-sm-12">
				<div class="card">
                  <div class="card-header pb-0">
                    <h5>과정 신청서</h5>
                  </div>
                  <form class="form theme-form" action="./classModify.do" method="post">
                    <div class="card-body">
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleFormControlInput1">과정 제목</label>
                            <input name="cla_title" class="form-control" id="exampleFormControlInput1" type="text" placeholder="과목의 제목을 입력해주세요">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div>
                            <label class="form-label" for="exampleFormControlTextarea2">과정 상세내용</label>
                            <textarea name="cla_content" class="form-control" id="exampleFormControlTextarea2" placeholder="과목의 상세 내용을 입력해주세요" rows="3"></textarea>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleFormControlInput3">과정 정원</label>
                            <input name="cla_maxpeo" class="form-control" id="exampleFormControlInput3" type="number" placeholder="과정의 정원을 입력해주세요">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleFormControlInput4">과정 가격</label>
                            <input name="cla_price" class="form-control" id="exampleFormControlInput4" type="number" placeholder="과정의 희망 가격을 입력해주세요">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleFormControlInput5">과정 일일 교육시간</label>
                            <input name="cla_dailytime" class="form-control" id="exampleFormControlInput5" type="number" placeholder="과정의 일일 교육시간을 입력해주세요">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleFormControlInput7">과정 시작일</label>
                            <input name="cla_startdate" class="form-control" id="exampleFormControlInput6" type="date" min="${now}" placeholder="과정의 시작일을 입력해주세요">
                          </div>
                        </div>
                      </div>
<!--                       <div class="row"> -->
<!--                         <div class="col"> -->
<!--                           <div class="mb-3"> -->
<!--                             <label class="form-label" for="exampleFormControlInput7">과정 시작일</label> -->
<!--                             <input name="cla_enddate" class="form-control" id="exampleFormControlInput7" type="date" readonly="readonly"> -->
<!--                           </div> -->
<!--                         </div> -->
<!--                       </div> -->
<!--                       <div class="row"> -->
<!--                         <div class="col"> -->
<!--                           <div class="mb-3"> -->
<!--                             <label class="form-label" for="exampleFormControlSelect9">과목 목록</label> -->
<!--                             <select class="form-select digits" id="exampleFormControlSelect9" name="sub" onchange="selectBoxChange(this.value)"> -->
<!--                               <option>과목을 선택해주세요</option> -->
<%--                             <c:forEach items="${lists}" var="vo"> --%>
<%--                               <option>${vo.sub_num}</option> --%>
<%--                               <option disabled="disabled">${vo.sub_title}</option> --%>
<%--                             </c:forEach> --%>
<!--                             </select> -->
<!--                             <br> -->
<!--                             <label class="form-label" for="exampleFormControlInput1">선택한 과목</label> -->
<!--                             <input readonly="readonly" class="form-control" type="text" id="changeInput" name="subList"> -->
<!--                             <br> -->
<!--                             <label class="form-label" for="exampleFormControlInput1">추가된 과목</label> -->
<!--                             <span id="subListed"></span> -->
<!--                           </div> -->
<!--                         </div> -->
<!--                       </div> -->
                    </div>
                    <div class="card-footer text-end">
                      <button class="btn btn-primary" type="submit" onclick="modify()">신청</button>
                      <input class="btn btn-light" type="reset" value="취소">
                    </div>
                  </form>
                </div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
function modify(){
	
}
</script>
<%@include file="./admin_footer.jsp" %>
</html>