<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
<%@ include file="./admin_header.jsp" %>
<body>
<div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>쪽 지</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="./adminMain.do">Home</a></li>
                    <li class="breadcrumb-item">쪽지 게시판</li>
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
                    <h5>쪽지 작성</h5>
                  </div>
                  <form class="form theme-form" action="./mesBoardReply.do" method="post">
                    <div class="card-body">
                    <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleInputPassword2">송신자</label>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleInputPassword2">수신자</label>
                            <input name="mes_recipient" class="form-control" id="exampleInputPassword2" type="text" placeholder="내용을 입력해주세요" readonly="readonly" value="${mes_recipient}">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="mb-3">
                            <label class="form-label" for="exampleInputPassword2">내용</label>
                            <textarea name="mes_content" class="form-control" id="exampleFormControlTextarea4" rows="3"></textarea>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="card-footer text-end">
                      <button class="btn btn-primary" type="submit">보내기</button>
                      <input class="btn btn-light" type="reset" value="취소">
                    </div>
                  </form>
                </div>
			</div>
		</div>
	</div>
</div>
</body>
<%@include file="./admin_footer.jsp" %>
</html>