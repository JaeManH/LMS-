
$( function() {
	var searchSource ;
	var input = document.getElementById("searchBox");
        //자동완성 값을 가져오는 ajax 통신
		$.ajax({
	    type : 'GET',
	    url: './getSubjectList.do',
	    async:false,
	    dataType : 'text',
	    success : function(sub) {
	        console.log("통신 성공");
	       searchSource =JSON.parse(sub);
           console.log(searchSource);
	    },
	    error: function(){
	        console.log("통신실패");
	    }
	});
		 //자동완성 기능
    $( "#searchBox" ).autocomplete({
      source: searchSource,
      select : function(event, ui) { // item 선택 시 이벤트
          console.log(ui.item.value+"선택됨");
          var isc = overlapCheck(ui.item.value);
          if(isc){
              return false;
          }
          $("#selSub").append("<div class='subName'><em class='tag_text'>"+ui.item.label+"<img class='cancelImg' src='../resources/images/statistics/cancel.png'></em><input type='hidden' value='"+ui.item.value+"' name='subjects'/></div>");
      },
      focus : function(event, ui) { // 포커스 시 이벤트
          return false;
      },
      minLength : 1, // 최소 글자 수
      autoFocus : true, // true로 설정 시 메뉴가 표시 될 때, 첫 번째 항목에 자동으로 초점이 맞춰짐
      classes : { // 위젯 요소에 추가 할 클래스를 지정
          'ui-autocomplete' : 'highlight'
      },
      delay : 300, // 입력창에 글자가 써지고 나서 autocomplete 이벤트 발생될 떄 까지 지연 시간(ms)
      disable : false, // 해당 값 true 시, 자동완성 기능 꺼짐
      position : { my : 'right top', at : 'right bottom'}, // 제안 메뉴의 위치를 식별
      close : function(event) { // 자동완성 창 닫아질 때의 이벤트
          console.log(event);
          input.value='';
      }
    });
    //선택한 과목 취소 시 작동
    $(document).on("click",".cancelImg",function(){
        console.log("태그 삭제 클릭");
        $(this).parent().parent().remove();
    });
  } );
//선호조사 폼 유효성 검사
function preferCheck(){
    var cnt = document.getElementsByClassName("subName");
    var time = $("#time option:selected").val();
    var date = $("#date option:selected").val();
    var difficulty = $("#difficulty option:selected").val();
    if(difficulty==0){
        alert("선호하는 난이도를 선택해 주세요");
        return false;
    }
    if(cnt.length<3){
        alert("선호하는 과목을 3개이상 선택해주세요");
        return false;
    }
    if(time==0){
        alert("선호하는 시간을 선택해주세요");
        return false;
    }
    if(date==0){
        alert("선호하는 기간을 선택해주세요");
        return false;
    }
    document.getElementById("preferForm").submit();
}
//과목 선택 중복검사 중복일경우 true 반환
function overlapCheck(val){
    var ele = document.getElementsByName("subjects");
    for (let i = 0 ; i<ele.length;i++){
        if(ele[i].value == val){
            return true;
        }
    }
}



