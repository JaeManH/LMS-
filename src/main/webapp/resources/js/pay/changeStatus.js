//드롭다운 바뀔때마다 동작
function changeStatus(){
   	var getText = document.getElementById("list").value;
    console.log("text : ", getText);
	location.href="./changeStatusSelect.do?getText="+getText;		
}

//모달 결제 상세
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
				console.log(data);
				var noCoupon;
				if(data.pay_ucounum == null){
					 noCoupon = "사용안함.";
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

//환불정보 받아오기
function cancelWhy(paynum,payStatus){
	console.log("환불정보 모달창 오픈!");
	console.log(paynum);
	if(payStatus == '환불승인'){
		const getButton = document.getElementById('changeButton');
		getButton.innerHTML='<button class="btn btn-danger disabled" type="button" onclick="statusUpdate(0)">승인됨</button>'
	}
	$.ajax({
		url : "./getPayDetail.do",
		method : "post",
		data : {
			paynum : paynum
		},success:function(result){
			console.log(result);
			const getcanCate = document.getElementById('canCate');
			getcanCate.value=result.pay_cancate;
			const getcanReason = document.getElementById('canReason');
			getcanReason.value=result.pay_cancontent;
			const getpayNumber = document.getElementById('payNumber');
			getpayNumber.innerHTML=paynum;
		}
	})
}

//아임포트 환불
function importCancel(payNum){
		 $.ajax({
			 type:"post",
			 url:"./payment/cancel.do",
			 data : {
				paynum : payNum
			},
			 success:function(result){
				console.log(result);
			 }
		 })
}

//상태 변경
function statusUpdate(paynum){
	console.log("상태 변경 후 redirect");
	if(paynum == 0){
		const getcanCate = document.getElementById('payNumber');
		var getPayNumber = getcanCate.innerText;
		console.log(getPayNumber);
		Swal.fire({
				      icon: 'success',
					  title : 'Refund Success',
				      text: "환불이 완료되었습니다!",
				    }).then(function(){
					location.href="./statusUpdate.do?paynum="+getPayNumber;
				})
		importCancel(getPayNumber);
	}else{
		Swal.fire({
				      icon: 'success',
					  title : 'Refund Success',
				      text: "환불이 완료되었습니다!",
				    }).then(function(){
					location.href="./statusUpdate.do?paynum="+paynum;
				})
		importCancel(paynum);
	}
	
	
}