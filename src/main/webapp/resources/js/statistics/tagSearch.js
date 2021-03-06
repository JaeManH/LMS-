$( function() {
    var input = document.getElementById("searchBox");

    var searchSource ;

    //자동완성 값을 가져오는 ajax 통신
    $.ajax({
        type : 'GET',
        url: './getTags.do',
        async:false,
        dataType : 'json',
        success : function(tag) {
            console.log("통신 성공");
            console.log(typeof (tag));
            searchSource = tag;
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
            var category = $("#category option:selected").val();
            console.log(ui.item.label+"선택됨");
            console.log(category);
            let tag = ui.item.label;
            //아이템 선택 시 밑에 결과를 띄워주는 ajax
            $.ajax({
                type:'POST',
                url: './searchTag.do',
                data:{"tag":tag,"category":category},
                async:true,
                dataType:'json',
                success:function (result) {

                    console.log(result);
                    console.log(category);
                    $("#searchResult").empty();
                    if(category=='과정'){
                        $("#tab2").html('가격');
                        for(let i = 0;i<result.length;i++){
                            $("#searchResult").append("" +
                                "  <tr>" +
                                "                            <td><a href='./classSelectDetail.do?cla_num="+result[i].num+"'>"+result[i].title+"</a></td>" +
                                "                            <td>"+result[i].price+"</td>" +
                                "                            <td>"+result[i].content+"</td>" +
                                "                            <td>"+result[i].regdate.substring(0,10)+"</td>" +
                                "                        </tr>");
                        }
                    }else{
                        $("#tab2").html('강사명');
                        for(let i = 0;i<result.length;i++){
                            $("#searchResult").append("" +
                                "  <tr>" +
                                "                            <td><a href='./classSelectDetail.do?cla_num="+result[i].num+"'>"+result[i].title+"</a></td>" +
                                "                            <td>"+result[i].ins+"</td>" +
                                "                            <td>"+result[i].content+"</td>" +
                                "                            <td>"+result[i].regdate.substring(0,10)+"</td>" +
                                "                        </tr>");
                        }
                    }



                },
                error: function () {
                    console.log("통신 실패");
                }
            })

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

} );
