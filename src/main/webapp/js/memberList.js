
window.onload = function(){
	var chks = document.getElementsByName("chk");
	var checkAll = document.getElementById("checkAll");
	for(let i=0;i<chks.length;i++){
		chks[i].onclick = function(){
			if(chks.length==checkCount()){
				checkAll.checked = true;
			}else{
				checkAll.checked = false;
			}
		}
	}
}

// 전체 체크 버튼

function checkAlls(bool){
//	var chks = document.getElementsByName("chk");
//	for(let i=0; i<chks.length;i++){
//		chks[i].checked = bool;
//	}
	$("input:checkbox[name='chk']").prop("checked",bool);
	console.log("check 갯수 : ",checkCount());
}

// 선택된 checked를 확인하는 함수
function checkCount(){
	var cnt = 0;
	var chks = document.getElementsByName("chk");
//	for(let o in chks){
//		console.log("o는 chk의 인덱스 in : " + o);
//		chks[o].checked
//	}	
	for(let o of chks){
		console.log("o는 object of"+o);
		if(o.checked){
			cnt++;
		}
	}	
	return cnt;
	
}


function chkBox(){
	var chks = $("input:checkbox[name='chk']:checked");
	console.log("chks.length : ",chks.length);
	if(chks.length>0){
		document.getElementById("frm").action="./multiDel.do";
	}else{
		swal("삭제오류","한개 이상의 글을 선택하세요.");
		return false;
	}
	
	
	
		
}

	function del(val){
		console.log("삭제 :",val);
		location.href="./multiDel.do?chk="+val;
	}


// 세션의 저장되어 있는 row 의 값에 따른 listNum  의 갯수
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

// 해당 페이지번호를 클릭 했을 때 해당 값을 전송
function pageIndex(idx){
	console.log("입력 받은 index 값 : " + idx);
	var index = document.getElementById("index");
	index.value = idx - 1;
	pageAjax();
}

function pageFirst(){
	console.log("처음 페이지로 이동");
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageStartNum");
	
	index.value = 0; //인덱스 처음으로
	pageNum.value = 1; //출력될페이지의 시작번호
	pageAjax();
}

function pagePrev(pNum, pageList){
	console.log("이전 그룹");
	if(0 < pNum - pageList){//출력될페이지의 시작번호 -출력될 페이지의 하단 번호 갯수
		pNum -= pageList;  //1 = 1-5 = 4
		var index = document.getElementById("index"); //현재 2페이지 가정
		var pageNum = document.getElementById("pageStartNum"); // 1
		
		index.value = pNum - 1; //
		pageNum.value = pNum;
	}
	
	pageAjax();
}


function pageNext(pNum,total, listNum, pageList){
	console.log("다음 페이지");
	var idx = Math.ceil(total/listNum); // 31/5 = 7
	var max = Math.ceil(idx/pageList); // 2 그룹
	
	if(max*pageList > pNum+pageList){
		pNum += pageList;
		
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageStartNum");
		
		index.value = pNum - 1;
		pageNum.value = pNum;
	}
	pageAjax();
}

function pageLast(pNum,total, listNum, pageList){
	console.log("마지막 페이지");
	var idx = Math.ceil(total/listNum); // 31/5 7 index
	var max = Math.ceil(idx/pageList); // 12345 | 67 => 2 묶음
	
	while(max*pageList > pNum+pageList){
		pNum += pageList;			
	}
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageStartNum");
		
		index.value = pNum - 1;
		pageNum.value = pNum;
		pageAjax();
}


// 글 갯수가 변할 때 동작
function pageList(){
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageStartNum");
	var listNum = document.getElementById("pageListNum");
	
	index.value = 0;
	pageNum.value = 1;
	listNum.value = document.getElementById("list").value;
	
	console.log("pageList : " + listNum.value);
	pageAjax();
}



var pageAjax = function(){
	console.log("index 페이지 처리 Ajax")
	console.log($("#frm").serialize())
	$.ajax({
		url:"./traPage.do",
		type:"post",
		async:true,
		data:$("#frm").serialize(),
		dataType:"json",
		success:function(msg){
			console.log(msg);
		 	$.each(msg,function(key,value){
            var varHtml = "";
            var n = $(".table tr:eq(0) th").length;
            if(key=="lists"){
            varHtml += "<thead>                                                                  ";
            varHtml += "   <tr>                                                                 ";
            varHtml += "      <th><input type='checkbox' id='checkAll' onclick='checkAll(this.checked)'></th>";
            varHtml += "      <th>프로필</th>                                                  ";
            varHtml += "      <th>아이디</th>                                                    ";
            varHtml += "      <th>이름</th>                                                    ";
            varHtml += "      <th>이메일</th>                                                  ";
            varHtml += "      <th>가입일</th>                                                  ";
            varHtml += "      <th>회원상태</th>                                                ";
            varHtml += "   </tr>                                                                ";
            varHtml += "</thead>                                                                 ";
            varHtml +="<tbody>";
            $.each(value, function(k,v){
               varHtml +="<tr>                                                                                                                                ";
	           varHtml +="  <td><input type='checkbox' name='chk' value='"+v.id+"'></td>                                                                           ";			
               varHtml +="  <td>"+replyImage(v.profile)+"</td>                                                                                                                              ";
               varHtml +="    <td onclick='modalOpen("+v.Id+")'><a href='#' data-bs-toggle='modal' data-original-title='test' data-bs-target='#exampleModal'>"+v.id+"</a></td>                                   ";
               varHtml +="  <td>"+v.name+"</td>                                                                                                                    ";
               varHtml +="  <td>"+v.email+"</td>                                                                                                                        ";
               varHtml +="  <td>"+v.regdate+"</td>                                                                                                      ";
			   varHtml +="  <th>"+v.delflag+"</th>                                                                                                                        ";	
               varHtml +="</tr>                                                                                                                               ";
               varHtml +="<tr>                                                                                                                                ";                                                                                                                     
            });
				varHtml +="</tbody>";
            }else{
			varHtml += "<li class='page-item '><a onclick='pageFirst()' class='page-link'  href=''#' aria-label='Previous'><span>«</span><span class='sr-only'>Previous</span></a></li>";
            varHtml += "   <li class='page-item'><a onclick='pagePrev("+value.pageStartNum+","+value.pageList+")' class='page-link'  href='#' aria-label='Previous'><span aria-hidden='true'>이전</span><span class='sr-only'>Previous</span></a></li>";
           for(let i = value.pageStartNum; i<=value.count; i++){
        	   if(value.index+1 == i){
        		   varHtml += "<li class='page-item active' onclick='pageIndex("+i+")'>";
        	   }else{
        		   varHtml += "<li class='page-item ' onclick='pageIndex("+i+")' >";
        	   }
            varHtml += "   	<a href='#'  class='page-link' ><span>"+i+"</span></a></li>";
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
			alert("잘못된 요청");
		}
	})
};


//새글 작성
function writeBoard(){
	console.log("글 작성");
	//화면을 구성해서 append 처리 
	showWrite();
	$("#write").modal({backdrop:'static', keyboard:false});
	
}
function replyImage(depth) {
		var replyImg = "";
		for (let i = 0; i < depth; i++) {
		replyImg+="&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		if(depth!=0) {
				replyImg+="<img src='./images/reply.png' alt=''>";
		}
		
		return replyImg;
	}
var showWrite = function(){
	html = "";
//		 html += " <div class='form-group'>";
//		 html += "   <label for='id'>아이디 : </label>";
//		 html += "   <input type='email' class='form-control' id='id' readonly value=''>";
//		 html += " </div>";
		 html += " <div class='form-group'>";
		 html += "   <label for='title'>제목 : </label>";
		 html += "   <input type='text' class='form-control' name='title'  id='title' required>";
		 html += " </div>";
		 html += " <div class='form-group'>";
		 html += "   <label for='title'>내용 : </label>";
		 html += "   <textarea class='form-control' row = '5'  name='content'  id='content' ></textarea>";
		 html += " </div>"
		 html += "	<div class='modal-footer'>                                                        ";
	     html += "    <input type='button' class='btn btn-success' value='새글입력' onclick='writeVal()'>";
	     html += "    <input type='reset' class='btn btn-info' value='초기화'>";
         html += "    <button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";
	     html += "  </div>                                                                             ";
		$("#frmWriter").html(html);
}

function writeVal(){
	console.log("새글작성");
	var frmWrite = document.getElementById("frmWriter");
	frmWrite.action ="./write.do";
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	const extractTextPattern =/(<[^>]+)>/gi;
	let convertTitle = title.value.replace(extractTextPattern,'');
	title.value = convertTitle;
	console.log("변경된 title값 :", convertTitle);
	if(title.value.trim() == "" ){
		swal("새글작성 오류","제목은 필수값 입니다.");
		title.value="";
	}else{
		frmWrite.submit();
	}
}


//글 수정
function modify(seq){
	console.log("선택된 글 번호",seq);
//DOM 탐색을 ID나 class.. 아니라 속성의 값(글자)를 탐색하여 선택함
	var id = "[href*='+seq+']";
	//화면을 구성해서 append 처리 
	 $(id).css("background","orange");

	ajaxModify(seq);
	$("#modify").modal({backdrop:'static', keyboard:false});

//	showModify();
//	$("#modify").modal();
	
}


function modalHide(){
	$("#modify").modal("hide");
}

var ajaxModify = function(seq){
	console.log("ajaxModify",seq);
	$.ajax({
		url : "./modifyForm.do",
		method : "post",
		data : "seq="+seq,
//		dataType : "json",
		success: function(msg){
			console.log(msg, typeof msg);
			var json = JSON.parse(msg);
			console.log(json, typeof json);
		 html = "";
		 html += " <div class='form-group'>";
		 html += "   <label for='id'>아이디 : </label>";
		 html += "<input type='hidden' name='seq' value='"+json.seq+"'> ";
		 html += "   <b class='form-control'>"+json.id+" </b> ";
		 html += " </div>";
	
		 html += " <div class='form-group'>";
		 html += "   <label for='regdate'> 작성일 : </label>";
		 html += "   <b class='form-control'>"+json.regdate+" </b> ";
		 html += " </div>";
		 html+="      <label for = 'title'>제목:</label>                                      ";
		 html+="      <input type = 'text'  class= 'form-control' id='title' name = 'title' required value='"+json.title+"'>";
		 html+="    </div>"; 
		 html += " <div class='form-group'>";
		 html += "   <label for='title'>내용 : </label>";
		 html += "   <textarea class='form-control' row = '5'  name='content'  id='content' >"+json.content+"</textarea>";
		 html += " </div>"	 
	
		 html += "	<div class='modal-footer'>                                                        ";
	     html += "    <input type='button' class='btn btn-success' value='글수정' onclick='modifyVal()'>";
	     html += "    <input type='reset' class='btn btn-info' value='초기화'>";
         html += "    <button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";
	     html += "  </div>  ";  

		 $("#frmModify").html(html);
		},
		error: function(){
			alert("잘못된 요청 처리")	
		}
	});
}

function modifyVal(){
   var frm = $("#frmModify")
   var idx = document.getElementById("index").value;
//   console.log(frm.serialize());
//   console.log(idx);
   $.ajax({
      url : "./modify.do",
      type : "post",
      data : frm.serialize(),
      success : function(msg){
         console.log(msg)
         if(msg.isc == "true"){
            $("#modify").modal("hide");
        pageAjax();
         }else{
            location.href="./logout.do";
         }
      },error:function(){
         alert("잘못된 요청 처리");
      }
       
   });
}


function reply(seq){
	console.log("선택된 글 번호",seq);
//DOM 탐색을 ID나 class.. 아니라 속성의 값(글자)를 탐색하여 선택함
	var id = "[href*='+seq+']";
	//화면을 구성해서 append 처리 
	 $(id).css("background","orange");

	$("#reply").modal({backdrop:'static', keyboard:false});
	ajaxReply(seq);

	
}


function modalHide(){
	$("#reply").modal("hide");
}


var ajaxReply = function(seq){
   $.ajax({
      url:"./replyForm.do",
      type:"post",
      data:{"seq":seq},
      dataType:"json",
      success:function(r){
         console.log(r);
         $("#frmReply").html("");
//         html += " <div class='form-group'>";
//          html += "   <label for='id'>아이디 : </label>";
//          html += "   <input type='email' class='form-control' id='id' readonly value=''>";
//          html += " </div>";

//         var div = $("<div>").attr("class","form-group");
//         var input = $("<input>").attr({"type":"hidden","name":"seq","value":r.obj.seq});
//         var label = $("<label></label>").text("부모글 정보("+r.obj.seq+")");
//         var p = $("<p>").attr("class","form-control").text("조회수 /"+r.obj.readcount + " 작성일 / " + r.obj.regdate + "작성자 / "+r.obj.id);
//         div.append(input).append(label).append(p);
//         $("#frmReply").append(div);
         
         html ="";
         html += "<div class='form-group'>";
         html += "<input type='hidden' name='seq' value='"+r.obj.seq+"'>";
         html += "<label>부모글의 정보("+r.obj.seq+")</label>";
         html += "<b>조회수:"+r.obj.readcount+" / 작성일 :"+r.obj.regdate+"/ 작성자:"+r.obj.id+"</b>";
         html += "</div>";
         
         
         html +="<div class='form-group'>";
         html +="<label>작성자</label>";
         html +="<b>"+r.sessionId+"</b>";
         html +="</div>";
         
         html +="<div class='form-group'>";
         html +="<label id='tit'>제목(원본)</label>";
         html +="<input type='text' class='form-control' id='title' name='title' value='"+r.obj.title+"'>";
         html +="</div>";
         
         html +="<div class='form-group'>";
         html +="<input type='hidden' id='hiddenContent' value='"+r.obj.content+"'>";
         html +="<label id='con'>내용(원본)</label>";
         html += "<textarea rows='5' class='form-control' id='Textarea' name='content' onclick='chk()'>"+r.obj.content+"</textarea>";         
         html +="</div>";
         
         html += "   <div class='modal-footer'>                                                        ";
          html += "    <input type='button' class='btn btn-success' value='답글작성' onclick='replyVal()'>";
         html += "    <span onclick='reset()'><input type='reset' class='btn btn-info' value='초기화'></span>";
         html += "    <button type='button' class='btn btn-danger' data-dismiss='modal'>취소</button>";
           html += "  </div> ";
         
         $("#frmReply").html(html);
         
      },
      error:function(){
         alert("잘못된 요청 처리 값");   
      }
      
   });
}

function reset(){
   console.log("리셋");
   document.getElementById("tit").innerHTML = "제목(원본)";
   document.getElementById("con").textContent = "내용(원본)";
}

function chk(){
   var tit = document.getElementById("tit");
   var con = document.getElementById("con");
   var title = document.getElementById("title");
   var Textarea = document.getElementById("Textarea");
   
   var hiddenContent = document.getElementById("hiddenContent");
   
   console.log(tit,con,title,Textarea,hiddenContent);
   
   if(Textarea.value == hiddenContent.value){
      con.innerHTML = "답글내용";
      tit.innerHTML = "답글제목";
      Textarea.value="";
      title.value="";
   }
}

function replyVal(){
	var tit = document.getElementById("tit").textContent; //제목(원본) -> 답글 제목
	console.log(tit);
	if(tit == "제목(원본)"){
		swal("답글작성 오류","제목과 내용을 작성해주세요");
		return;
	}
	var parentSeq = document.getElementsByName("seq")[0].value;
	var title = document.getElementById("title");
	var content = document.getElementsByName("content")[0];
	
	const extractTextPattern =/(<[^>]+)>/gi;
	let convertTitle = title.value.replace(extractTextPattern,'');
	let convertContent = content.value.replace(extractTextPattern,'');
	console.log(convertTitle,convertContent);
	
	$.ajax({
		url:"./reply.do",
		type:"post",
		data:{"seq":parentSeq,"title":convertTitle,"content":convertContent},
		success:function(msg){
			if(msg.isc == "true"){
				pageAjax();
				$("#reply").modal("hide");
			}else{
				swal("답글작성 오류","다시 작성해 주세요");
			}
		},error:function(){
			alert("잘못된 요청 처리")	
		}
	});
	
}

