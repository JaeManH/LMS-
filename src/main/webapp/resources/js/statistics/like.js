$("#likeBtn").on('click',function () {
   var claid = document.getElementById("claid").value;
   //TODO 과정 id 값 넘겨서 가져오기
   console.log('좋아요 버튼 클릭 됨');
   console.log(claid);
   if(claid==null){
      return false;
   }
   $.ajax({
      url:'./clickLike.do',
      data:{"claid":claid},
      type:'POST',
      async: true,
      dataType:'text',
      success:function (result) {
         if(result=="비로그인"){
            alert("로그인 해야 좋아요가 가능합니다");
            return false;
         }
         console.log(result);
         $("#likeCnt").text(result);
      },
      error:function () {
         console.log("통신실패")
      }

   })
});