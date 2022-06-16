<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원 과목 등록 양식 페이지</title>
<style type="text/css">
.uploadResult {
	width:100%;
	background-color:gray;

}
.uploadResult ul{
	display:flex;
	flex-flow:row;
	justify-content: center;
	align-items: center;
}
.uploadResult ul li{
	list-style: none;
	padding: 10px;
}
.uploadResult ul li img{
	width:20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<%@ include file="../header.jsp"%>

<body>
	<div class="page-body">
		<div class="container-fluid">
			<div class="page-header">
				<div class="row">
					<div class="col-sm-6">
						<h3>Create Subject</h3>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.html">Home</a></li>
							<li class="breadcrumb-item">Subject</li>
							<li class="breadcrumb-item active">Create Subject</li>
						</ol>
					</div>
				</div>
			</div>

			<div class="row project-cards">
				<div class="col-md-12 project-list">
					<div class="card">
						<div class="row">
							<div class="card-header pb-0">
								<h5>과목 등록</h5>
								<h6>등록할 과목/커리큘럼에 대한 정보를 입력해주세요!</h6>
							</div>
						</div>
					</div>

					<div class="col-sm-12">
						<div class="card">

							
												      
								<!-- 파일업로드 연습용 -->
								<!-- <form action="./uploadFormAction.do" method="post" enctype="multipart/form-data"> -->
									<div class="row">
										<div class="col">
											<div class="mb-3">
												   <div class="panel-body">
												     <div class="form-group uploadDiv">
												            <input type="file" name='uploadFile' multiple>
												        </div>
												        <div class="uploadResult">
												        	<ul>
												        	
												        	</ul>
												        </div>
												        <button id="uploadBtn">파일업로드 도전!</button>
												  </div>
											</div>
										</div>
									</div>
								<!-- </form> -->
							<!-- 파일업로드 끝 -->
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	//파일의 확장자나 크기 사전 처리 - 체크 안됨..
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880; //5MB
	
	//파일 확장자, 크기 체크
	function checkExtension(fileName, fileSize){
						if(fileSize >= maxSize){
							alert("파일 사이즈 초과입니다.");
							console.log(fileSize);
							return false;
						}else{
							console.log("파일 사이즈 체크 완료");
						}
						if(regex.test(fileName)){
							alert("해당 종류의 파일은 업로드하실 수 없습니다.");
							console.log(fileName);
							return false;
						}else{
							console.log("파일 종류 체크 완료");
							return true;
						}j
	}
	
	var cloneObj = $(".uploadDiv").clone();
	//uploadFile ajax처리부분
		$("#uploadBtn").on("click",function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			console.log("여기까지는 성공",files);
			for(var i=0;i<files.length; i++){
				if(!checkExtension(files[i].name,files[i].size)){
					return false;
				}
				formData.append("uploadFile", files[i]);
			}
			console.log("append후", files);
			$.ajax({
				url:"./uploadAjaxAction.do",
				processData:false,
				contentType:false,
				data:formData,
				async:false,
					type:'POST',
					dataTye:'json',
				success:function(result){
					console.log("성공", result);
					alert("Upload성공");
					showuploadedFile(result);
					$(".uploadDiv").html(cloneObj.html());
				},
				error:function(result){
					
					alert("파일업로드 실패");
				}
			});
		});1
		
		var uploadResult = $(".uploadResult ul");
		function showuploadedFile(uploadResultArr){
			var str = "";
			$(uploadResultArr).each(function(i,obj){
				if(!obj.file_type){
					console.log("파일 이미지 아니다.");
					console.log(obj.image);
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					str+="<li><a href='/user/download.do?fileName="+fileCallPath+"'>"+"<img src='../resources/images/subject/send.png'>"+obj.fileName+"</a></li>";
				}else{
					console.log("파일 이미지다.");
					//str += "<li>"+obj.original_file_name+"</li>";
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					str += "<li><img src='/user/display.do?fileName="+fileCallPath+"'></li>";
				}
				
			});
			uploadResult.append(str);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	</script>
	
	
	<%@ include file="../footer.jsp"%>
</body>
</html>