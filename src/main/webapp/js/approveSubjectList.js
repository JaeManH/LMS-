function subjectDetail(){
	console.log("과목 상세보기");
	$("#exampleModalmdo").modal({backdrop: 'static', keyboard: false});
}

  	$(document).ready(function(){
		var pageListNum = $("#pageListNum").val();
		$("#list option").each(function(){
			if(pageListNum == $(this).val()){
				$(this).prop("selected",true);
			}else{
				$(this).prop("selected",false);
			}
		});
		});

var pagingAjax= function (){
	console.log("페이징 처리 Ajax 실행")
	var obj = $("#frm").serialize();
	console.log(obj);
	
	$.ajax({
		url:"./approvePage.do",
		type:"post",
		async:true,
		data:$("#frm").serialize(),
		dataType:"json",
		success:function(msg){
			console.log(msg);
			$.each(msg,function(key,value){
				var varHtml="";
			    var n = $(".table tr:eq(0) th").length;
				if(key=="lists"){
				varHtml += "	 <thead class='bg-primary'>";
	            varHtml += "     <tr>";
	            varHtml += "       <th scope='col'><h6 class='f-w-700'>과목번호</h6></th>";
	            varHtml += "       <th scope='col'><h6 class='f-w-700'>과목명</h6></th>  ";
	            varHtml += "       <th scope='col'><h6 class='f-w-700'>카테고리</h6></th>";
	            varHtml += "       <th scope='col'><h6 class='f-w-700'>등록자</h6></th>  ";
	            varHtml += "       <th scope='col'><h6 class='f-w-700'>등록일</h6></th>";
	            varHtml += "       <th scope='col'><h6 class='f-w-700'>승인상태</h6></th>";
				varHtml += "     </tr>";
	            varHtml += "   </thead>";
				varHtml += "	<tbody>";
					
					$.each(value, function(k,v){
					varHtml += "  <tr>";
					varHtml += "   <td ><a href='./admin_subjectDetail.do?sub_num="+v.sub_num+"'>"+v.sub_num+"</a></td>";
	                varHtml += " <td><a href='./admin_subjectDetail.do?sub_num="+v.sub_num+"'>"+v.sub_title+"</a></td>";
	                varHtml += " <td>";
	                if(v.cod_name === "JAVA"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#006400 '>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "C"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #AFEEEE' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "HTML"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#6A5ACD'>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "PYTHON"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #C71585'>"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "CSS"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#FFF8DC'>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "LINUX"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #40E0D0' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "C#"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:	#8FBC8F'>"+v.cod_name+"</span>";
	                }else if(v.cod_name === "JAVASCRIPT"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #8A2BE2' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "AI"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#FFB6C1 '>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "BIGDATA"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #000080' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "DEEPLEARNING"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#FA8072'>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "VR"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #FFA500' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "AR"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:	#F0E68C '>"+v.cod_name+"</span>";
	                }else if(v.cod_name === "EXCEL"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#B0C4DE'>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "POWERPOINT"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #2F4F4F' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "KOTLIN"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:	#D8BFD8'>"+v.cod_name+"</span>";
	                }else if(v.cod_name === "SPRING"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #1E90FF' >"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "기타"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#008080'>"+v.cod_name+"</span>   ";
	                }else if(v.cod_name === "형상관리"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #FFD700'>"+v.cod_name+"</span>  ";
	                }else if(v.cod_name === "DATABASE"){
	                varHtml += "        <span class='badge rounded-pill' style='background-color:#A52A2A'>"+v.cod_name+"</span>   ";
	                }else{
	                varHtml += "        <span class='badge rounded-pill' style='background-color: #556B2F' >"+v.cod_name+"</span>  ";
	                }
	                varHtml += "  </td>                                                                                                 ";
	                varHtml += "  <td>"+v.sub_reg_id+"</td>                                                                             ";
	                varHtml += "  <td>"+v.sub_regdate+"</td>                                                                             ";
	                
			              if(v.sub_status === "A"){
			              varHtml += "    		<td><span class='badge rounded-pill' style='background-color: 	#1E90FF'>승인</span></td>       ";            	  
			              }else if(v.sub_status === "W"){
			              varHtml += "    		<td><span class='badge rounded-pill badge-info'>대기중</span></td>                              ";
			              }else if(v.sub_status === "R"){
			              varHtml += "    		<td><span class='badge rounded-pill badge-warning'>반려</span></td>                             ";
			              }else if(v.sub_status === "D"){
			              varHtml += "    		<td><span class='badge rounded-pill badge-danger'>삭제</span></td>                              ";
			              }
			                 varHtml += "  </tr>                                                                                                      ";	
					
				});
				varHtml += "</tbody>";
			}else{
			varHtml += "<li class='page-item '><a onclick='pageFirst()' class='page-link'  href=''#' aria-label='Previous'><span>«</span><span class='sr-only'>Previous</span></a></li>";
            varHtml += "   <li class='page-item'><a onclick='pagePrev("+value.pageStartNum+","+value.pageList+")' class='page-link'  href='#' aria-label='Previous'><span aria-hidden='true'>이전</span><span class='sr-only'>Previous</span></a></li>";
           for(let i = value.pageStartNum; i<=value.count; i++){
        	   if(value.index+1 == i){
        		   varHtml += "<li class='page-item active' onclick='pageIndex("+i+")'>";
        	   }else{
        		   varHtml += "<li class='page-item' onclick='pageIndex("+i+")'>";
        	   }
            varHtml += "   	<a  class='page-link' href='#'><span>"+i+"</span></a></li>";
           }
            varHtml += "   <li class='page-item'><a onclick='pageNext("+value.pageStartNum+","+value.total+","+value.pageListNum+","+value.pageList+")' class='page-link'  href='#'  aria-label='Next'><span>다음</span><span class='sr-only'>Next</span></a></li>";
            varHtml += "  <li class='page-item'><a onclick='pageLast("+value.pageStartNum+","+value.total+","+value.pageListNum+","+value.pageList+")' class='page-link'  href='#'   aria-label='Next'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>";

			}		
			
                 if(key == "lists"){
                	 $(".table").html(varHtml);
                 }else{
                	 $(".pagination").html(varHtml);
                 }
			});
	},
	error:function(){
		alert("잘못된 요청입니다.");
	}
	});
	
	};

//해당 페이지 번호를 클릭 시 해당하는 값을 전송
function pageIndex(idx){
	console.log("입력 받은 index 값 ", idx);
	var index = document.getElementById("index");
	index.value = idx-1;
	 pagingAjax();
}
//글 갯수 변동
function pageList(){
	var index = document.getElementById("index");
	var pageStartNum = document.getElementById("pageStartNum");
	var listNum = document.getElementById("listNum");
	
	index.value=0;
	pageStartNum.value=1;
	listNum.value=document.getElementById("list").value;
	
	pagingAjax();
}
//처음 페이지로이동
function pageFirst(){
	console.log("처음페이지로 이동");
	var index = document.getElementById("index");
	var pageStartNum = document.getElementById("pageStartNum");
	index.value=0;
	pageStartNum.value=1;
	pagingAjax();
}

function pagePrev(pNum,pageListNum){
	console.log("이전 그룹");
	if(0 < pNum - pageListNum){
		pNum -= pageListNum
		var index = document.getElementById("index");
		var pageStartNum = document.getElementById("pageStartNum");
		
		index.value = pNum-1;
		pageStartNum.value = pNum;
	}
	pagingAjax();
}

function pageNext(pNum,total,pageListNum,pageList){
	console.log("다음 그룹으로 이동");
	var idx = Math.ceil(total/pageListNum);
	var max = Math.ceil(idx/pageList);
	console.log(idx, max);
	
	if(max*pageList > pNum+pageList){
		pNum += pageList;
		console.log(pageStartNum);
		
		var index = document.getElementById("index");
		var pageStartNum = document.getElementById("pageStartNum");
		
		index.value = pNum-1;
		pageStartNum.value=pNum;
	}
	pagingAjax();
}

function pageLast(pNum,total,pageListNum,pageList){
	console.log("마지막 페이지로 이동");
	var idx = Math.ceil(total/pageListNum); 
	var max = Math.ceil(idx/pageList);
	
	while(max*pageList > pNum+pageList){
		pNum += pageList;
	}
	
	var index = document.getElementById("index");
	var pageStartNum = document.getElementById("pageStartNum");
	
	index.value=idx-1;
	pNum.value=pNum;
	pagingAjax()
}








//과목 승인처리를 위한 부분
/*window.onload = function(){
	var buttons = document.getElementsByTagName("button");
	console.log(buttons.length);
	for(var i=0; i<buttons.length; i++){
		buttons[i].onclick=function(){
			console.log(this.innerHTML);
			console.log("1",this.parentNode.innerHTML); //승인
			console.log("2",this.parentNode.parentNode.innerHTML);//승인,반려
			console.log(this.parentNode.parentNode.childNodes[1].innerHTML);//반려
			console.log(this.parentNode.parentNode.parentNode.childNodes[1].innerHTML);//과목번호
			console.log(this.parentNode.parentNode.parentNode.parentNode.childNodes[1].innerHTML);//과목번호
			console.log(this.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[7].innerHTML);//과목상태!!!가 아니라 승인상태 태그를 못찾음,,,,
			var id = this.parentNode.parentNode.childNodes[1].innerHTML;
			
			var tmp = this;
			$.ajax({
				url:"./user/subUpdateStatusA.do",
				type:"post",
				data:{"id":id},
				success:function(msg){
					console.log(msg.isc);
					console.log(tmp);
					if(msg.isc){
						tmp.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[9].innerHTML
						= (tmp.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[9].innerHTML=="대기중"?"승인완료":"검토중");
						tmp.innerHTML=(tmp.innerhtml=="승인"?"승인완료":"승인");
					}
				},
				error:function(){
					alert("잘못된 요청입니다.");
				}
			});
		}
	}
}
*/
























