//상세정보 모달 값 받아오기
function modalOpen(paynum){
	console.log("모달오픈!모달오픈!" + paynum);
	 $.ajax({
			 url:"./getPayDetail.do",
			 method :"POST",
			 data :{
				paynum : paynum
			},success:function(data){
				console.log("성공이다");
				console.log(typeof data);
				var j = JSON.stringify(data)
				console.log(j);
				var noCoupon;
				if(data.pay_ucounum == null){
					 noCoupon = "사용안함";
				}else{
					noCoupon =data.pay_ucounum;
				}
				const getTextTitle = document.getElementById('modalTitle');
				getTextTitle.innerHTML='<h6><span style="color:tomato;">'+paynum+'</span>&nbsp;의 결제내역입니다.<br>'
				+"<h6>----------------------------------------------------------</h6>";
				const getTextModal = document.getElementById('modalText');
				getTextModal.innerHTML = '<h6>결제 번호&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+paynum+'</span></h6><br>'
				+'<h6>결제내역&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_content+'</span></h6><br>'
				+'<h6>결제방식&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_pg+'</span></h6><br>'
				+'<h6>결제상태&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_status+'</span></h6><br>'
				+'<h6>결제일자&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_date+'</span></h6><br>'
				+'<h6>결제원가&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_raw+'</span></h6><br>'
				+'<h6>결제 할인가&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_discount+'</span></h6><br>'
				+'<h6>결제시 사용된 쿠폰번호&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+noCoupon+'</span></h6><br>'
				+'<h6>결제시 사용된 마일리지&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_umilage+'</span></h6><br>'
				+'<h6>----------------------------------------------------------</h6><br>'
				+'<h5>최종 결제액&nbsp;&nbsp;:&nbsp;&nbsp;<span style="color:tomato;">'+data.pay_price+'</span></h5><br>';
				
				 
			 }
		 })
}

//환불 버튼 클릭시
function cancelWhy(paynum,payStatus){
	const payNumber= document.getElementById('payNumber');
	payNumber.innerHTML=paynum;
}

//드롭다운 클릭 시에
function drop(why){
	const changeCate = document.getElementById('changeCate');
	changeCate.innerText=why;
}

//환불신청 버튼 클릭시에
function cancelUpdate(){
	
	const getCate = document.getElementById('changeCate');
	const payNumber= document.getElementById('payNumber');
	const getContent = document.getElementById('canReason');
	var canReason = getContent.value;
	var getPayNumber = payNumber.innerText;
	if(getCate.innerText == "카테고리를 선택해주세요"){
		Swal.fire({
				      icon: 'error',
					  title : 'Check Please!',
				      text: "카테고리를 선택해주세요",
				    });
	}else if(canReason==""){
		Swal.fire({
				      icon: 'error',
					  title : 'Check Please!',
				      text: "환불사유를 입력해주세요!",
				    });
	}else{
		$('#cancelWhy').modal('hide');
		$.ajax({
		url:"./cancelUpdate.do",
		method : "post",
		data : {
			pay_num : getPayNumber,
			pay_cancate : getCate.innerText,
			pay_status : "환불대기",
			pay_cancontent : canReason
		},success:function(){
		}
		})
		Swal.fire({
				      icon: 'success',
					  title : 'Refund Success',
				      text: "환불신청이 완료되었습니다!",
				    }).then(function(){
					location.href = "./user_Mypay.do";
				})
		
	}
	
}