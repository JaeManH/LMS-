<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원 전체목록 리스트 화면</title>
</head>
<%@ include file="../header.jsp"%>
<body>
	<div class="page-body">
		<div class="container-fluid">
			<div class="page-header">
				<div class="row">
					<div class="col-sm-6">
						<h3>과목 전체 조회</h3>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="./main.do"><i
									class="icofont icofont-ui-home"></i></a></li>
							<li class="breadcrumb-item">과목</li>
							<li class="breadcrumb-item active">과목 전체 조회</li>
						</ol>
					</div>

					<div class="col-sm-6">
						<!-- Bookmark Start-->
						<div class="bookmark">
							<ul>
								<li><a href="javascript:void(0)" data-container="body"
									data-bs-toggle="popover" data-placement="top" title=""
									data-original-title="Icons"><i data-feather="hash"></i></a></li>
								<li><a href="javascript:void(0)" data-container="body"
									data-bs-toggle="popover" data-placement="top" title=""
									data-original-title="Learning"><i
										data-feather="alert-circle"></i></a></li>

							</ul>
						</div>
						<!-- Bookmark Ends-->
					</div>
				</div>
			</div>
		</div>
		<!-- Container-fluid starts-->
		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-3 xl-40 box-col-4">
					<div class="job-sidebar">
						<a class="btn btn-primary job-toggle" href="javascript:void(0)">job
							filter</a>
						<div class="job-left-aside custom-scrollbar">
							<div
								class="default-according style-1 faq-accordion job-accordion"
								id="accordionoc">
								<div class="row">

									<div class="col-xl-12">
										<div class="card">
											<div class="card-header">
												<a href="./user_subjectInsertForm.do"><button
														type="button" class="btn btn-primary btn-lg"
														style="text-align: center">
														과목 등록하러 가기 <span class="icofont icofont-pen-alt-4"></span>
													</button></a>
											</div>
										</div>
									</div>

									<div class="col-xl-12">
										<div class="card">
											<div class="card-header">
												<h5 class="mb-0 p-0">
													<button class="btn btn-link ps-0" data-bs-toggle="collapse"
														data-bs-target="#collapseicon" aria-expanded="true"
														aria-controls="collapseicon">Filter</button>
												</h5>
											</div>
											<div class="collapse show" id="collapseicon"
												aria-labelledby="collapseicon" data-parent="#accordion">
												<div class="card-body filter-cards-view animate-chk">
													<div class="job-filter mb-3">
														<div class="faq-form">
															<input class="form-control" type="text"
																placeholder="Search.."><i class="search-icon"
																data-feather="search"></i>
														</div>
													</div>
													<div class="checkbox-animated">
														<label class="d-block" for="chk-ani"> <input
															class="checkbox_animated" id="chk-ani" type="checkbox">
															Full-time (8688)
														</label> <label class="d-block" for="chk-ani1"> <input
															class="checkbox_animated" id="chk-ani1" type="checkbox">Contract
															(503)
														</label>
													</div>
													<button class="btn btn-primary text-center" type="button">Find
														Subjects</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xl-12">
										<div class="card">
											<div class="card-header">
												<h5 class="mb-0 p-0">
													<button class="btn btn-link ps-0" data-bs-toggle="collapse"data-bs-target="#collapseicon1" aria-expanded="true" aria-controls="collapseicon1">Location</button>
												</h5>
											</div>
											<div class="collapse show" id="collapseicon1"
												aria-labelledby="collapseicon1" data-parent="#accordion">
												<div class="card-body animate-chk">
													<div class="location-checkbox">
														<label class="d-block" for="chk-ani6"> <input class="checkbox_animated" id="chk-ani6" type="checkbox">미정 <span class="d-block">NY (399)</span></label> 
														<label class="d-block" for="chk-ani7"> <input class="checkbox_animated" id="chk-ani7" type="checkbox">미정 <span class="d-block">CA (252)</span></label>
													</div>
												</div>
												<button class="btn btn-block btn-primary text-center"
													type="button">미정</button>
											</div>
										</div>
									</div>

									<div class="col-xl-12">
										<div class="card">
											<div class="card-header">
												<h5 class="mb-0 p-0">
													<button class="btn btn-link ps-0" data-bs-toggle="collapse"data-bs-target="#collapseicon4" aria-expanded="true"aria-controls="collapseicon4">Specific skills</button>
												</h5>
											</div>
											<div class="collapse show" id="collapseicon4"data-parent="#accordion" aria-labelledby="collapseicon4">
												<div class="card-body animate-chk">
													<label class="d-block" for="chk-ani21"> <input
														class="checkbox_animated" id="chk-ani21" type="checkbox">
														HTML,scss & sass
													</label> <label class="d-block" for="chk-ani22"> <input
														class="checkbox_animated" id="chk-ani22" type="checkbox">
														Javascript
													</label> <label class="d-block" for="chk-ani23"> <input
														class="checkbox_animated" id="chk-ani23" type="checkbox">
														Node.js
													</label> <label class="d-block" for="chk-ani24"> <input
														class="checkbox_animated" id="chk-ani24" type="checkbox">
														Gulp & Pug
													</label> <label class="d-block mb-0" for="chk-ani25"> <input
														class="checkbox_animated" id="chk-ani25" type="checkbox">
														Angular.js
													</label>
												</div>
												<button class="btn btn-block btn-primary text-center"
													type="button">All Skills</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-9 xl-60 box-col-8">
					<c:forEach var="sVo" items="${list}" varStatus="vs">
						<div class="card">
							<div class="job-search">
								<div class="card-body">
									<div class="media">
										<img class="img-40 img-fluid m-r-20" src="./assets/images/job-search/2.jpg" alt="">
										<div class="media-body">
											<c:choose>
												<c:when test="${sVo.cod_name  eq 'JAVA'}">
													<span class="badge rounded-pill"
														style="background-color: #006400">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'C'}">
													<span class="badge rounded-pill"
														style="background-color: #AFEEEE">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'HTML'}">
													<span class="badge rounded-pill"
														style="background-color: #6A5ACD">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'PYTHON'}">
													<span class="badge rounded-pill"
														style="background-color: #C71585">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'CSS'}">
													<span class="badge rounded-pill"
														style="background-color: #FFF8DC">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'LINUX'}">
													<span class="badge rounded-pill"
														style="background-color: #40E0D0">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'C#'}">
													<span class="badge rounded-pill"
														style="background-color: #8FBC8F">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'JAVASCRIPT'}">
													<span class="badge rounded-pill"
														style="background-color: #8A2BE2">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'AI'}">
													<span class="badge rounded-pill"
														style="background-color: #FFB6C1">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'BIGDATA'}">
													<span class="badge rounded-pill"
														style="background-color: #000080">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'DEEPLEARNING'}">
													<span class="badge rounded-pill"
														style="background-color: #FA8072">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'VR'}">
													<span class="badge rounded-pill"
														style="background-color: #FFA500">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'AR'}">
													<span class="badge rounded-pill"
														style="background-color: #F0E68C">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'EXCEL'}">
													<span class="badge rounded-pill"
														style="background-color: #B0C4DE">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'POWERPOINT'}">
													<span class="badge rounded-pill"
														style="background-color: #2F4F4F">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'KOTLIN'}">
													<span class="badge rounded-pill"
														style="background-color: #D8BFD8">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq 'SPRING'}">
													<span class="badge rounded-pill"
														style="background-color: #1E90FF">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq '기타'}">
													<span class="badge rounded-pill"
														style="background-color: #008080">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name  eq '형상관리'}">
													<span class="badge rounded-pill"
														style="background-color: #FFD700">${sVo.cod_name}</span>
												</c:when>
												<c:when test="${sVo.cod_name eq 'DATABASE'}">
													<span class="badge rounded-pill"
														style="background-color: #A52A2A">${sVo.cod_name}</span>
												</c:when>
												<c:otherwise>
													<span class="badge rounded-pill"
														style="background-color: #556B2F">${sVo.cod_name}</span>
												</c:otherwise>
											</c:choose>
											<ul class="rating">
												<li><i class="fa fa-star font-warning"></i></li>
												<li><i class="fa fa-star font-warning"></i></li>
												<li><i class="fa fa-star font-warning"></i></li>
												<li><i class="fa fa-star font-warning"></i></li>
												<li><i class="fa fa-star font-warning"></i></li>
											</ul>

											<h6 class="f-w-600">
												<a href="./user_subjectDetail.do?sub_num=${sVo.sub_num}">${sVo.sub_title}</a><span class="pull-right"><p>${sVo.sub_reg_id}</p>
												<fmt:parseDate var='cDate' value="${sVo.sub_regdate}" pattern="yyyy-MM-dd" /> <fmt:formatDate value="${cDate}" /></span>
											</h6>
											<p>${sVo.sub_content}</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<div class="col-sm-12">
                <div class="card">
                
                  <div class="card-body btn-showcase">
                      <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
                      <div class="modal-dialog modal modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content text-center d-block">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">과목 상세보기<small class="text-muted">과목 상세정보</small></h5>
                            <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close" data-bs-original-title="" title=""></button>
                          </div>
                          <div class="modal-body">
                          	<br><br>
                          	<h6 id="modalTitle">ㅇㅇㅇ</h6>
                          	<div id="modalText">dㅇㅇd</div>
                          </div>
                          <div class="modal-footer">
                            <button class="btn btn-light" type="button" data-bs-dismiss="modal" data-bs-original-title="" title="">돌아가기</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
		
		
		
		
		
		
		
		
		
		
	</div>
	
	<script type="text/javascript">
/* 	window.addEventListener("scroll",infiniteScroll);
	
	let isUpdateList = true;
	
	function infiniteScroll(){
		const currentScroll = window.scrollY;
		const windowHeight = window.innerHeight;
		const bodyHeight = document.body.clientHeight;
		if(currentScroll + windowHeight >= boyHeight){
			if(isUpdateList){
				isUpdateList=false;
			}
		}
	} */
	
	
/*  	function modalOpen(subnum){
		console.log("일반회원 과목 상세조회 모달 오픈"+subnum);
		 $.ajax({
			url:"./user_subjectDetail.do",
			method:"POST",
			data:{
				subnum:subnum
			},
			success:function(data){
				console.log("모달 성공");
				console.log(data);
				
				const getTextTitle = document.getElementById('modalTitle');
				getTextTitle.innerHTML = '<h6><span>"+subnum+"</span></h6>';
				const getTextModal = document.getElementById('modalText');
				getTextModal.innerHTML = '<h6>과목설명<span>"+data.sub_content+"</span></h6>';
			}
		 })
	} */ 
	
	
	

	
	
	
	
	
	
	</script>
</body>
<%@include file="../footer.jsp"%>
</html>





