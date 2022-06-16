<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>수강료 지급조회</title>
 <style type="text/css">
	table{
		text-align:center;
	}
</style>
</head>
<%@ include file="./admin_header.jsp" %>
<body>
  
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>수강료 지급조회</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                    <li class="breadcrumb-item">수강료 지급조회</li>
                  </ol>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row">
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-header pb-0">
                    <h5><i class="fa fa-barcode"></i>&nbsp;&nbsp;Tuition payment</h5>
                    <span>수강료 지급내역을 조회합니다.</span>
                    <hr>
                    <div class="card-body">
                     <h4>Payment information&nbsp;&nbsp;<small class="text-muted">지급내역</small></h4><br><br>
                     	<div class="table-responsive">
                        <table class="table">
                          <thead class="table-primary">
                            <tr>
                              <th scope="col"><i class="fa fa-ticket"></i>&nbsp;과정번호</th>
                              <th scope="col"><i class="fa fa-credit-card-alt"></i>&nbsp;강사아이디</th>
                              <th scope="col"><i class="fa fa-check-circle-o"></i>&nbsp;과정총액</th>
                              <th scope="col"><i class="fa fa-repeat"></i>&nbsp;지급액</th>
                              <th scope="col"><i class="fa fa-calendar"></i>&nbsp;지급일자</th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="vo" items="${lists}">
	                        	<tr>
	                              <td>${vo.sal_cla_num}</td>
	                              <td>${vo.sal_ins_id}</td>
	                              <td>${vo.sal_totalprice}</td>
	                              <td>${vo.sal_price}</td>
	                              <td>${vo.sal_date}</td>
                            	</tr>  	
                          	</c:forEach>
                          </tbody>
                        </table>
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



<%@include file="./admin_footer.jsp" %>


  
</body>
</html>