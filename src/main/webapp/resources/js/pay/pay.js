//마일리지 숫자로 연산 및 db 계산값 Controller 보내주기
//결제내용 전송 
  		
  		//결제하기버튼
  		function checkPay(){
  			var listVar = $("input[name='selectPay']:checked").val();
			const getMoney = document.getElementById('money');
			const getTitle = document.getElementById('claTitle');
			const getContent = document.getElementById('claContent');
			var payTitle = getTitle.innerText;
			var payContent = getContent.innerText;
			console.log(payTitle);
			console.log(payContent);
  			var moneyText = getMoney.innerText;
			var regex = /[^0-9]/g;
  			var finalAmount = moneyText.replace(regex, "");
    	  	console.log(listVar);
			console.log(finalAmount);
			var plusMile = parseInt(finalAmount) * 1/10;
    	  	if(listVar == "payco"){
    	  		//함수 안에 가격,결제내용 을 보내줄 예정
    	  		request_pay2("payco",finalAmount,plusMile,payTitle);
    	  	}else if(listVar == "kakaopay"){
    	  		request_pay2("kakaopay",finalAmount,plusMile,payTitle);
    	  	}else if(listVar == "toss"){
    	  		request_pay2("tosspay",finalAmount,plusMile,payTitle);
    	  	};
			
  		}
		
		//쿠폰사용 버튼
		function useCoupon(couCode,couPer){
			$('#exampleModal').modal('hide');
			//최종결제 금액 가져오기
  			const getMoney = document.getElementById('money');
			var moneyText = getMoney.innerText;
			//숫자만 빼오기
  			 var regex = /[^0-9]/g;
  			 var changeMoney = moneyText.replace(regex, "");
			//원금가져오기
			const getClassPrice = document.getElementById('classPrice');
			var classPrice = parseInt(getClassPrice.innerText);
			console.log(classPrice);
			//총 할인금액 가져오기
			const getTotalDiscount = document.getElementById('totalDiscount');
			var totalDiscount = parseInt(getTotalDiscount.innerText);
			console.log(totalDiscount);
			//쿠폰금액 가져오기
			const getCoupon = document.getElementById('useCoupon');
			var couponAmount = parseInt(getCoupon.innerText);
			console.log(couponAmount);
			//사용 마일리지
			const getUsedMilage = document.getElementById('useMileage');
			var useMileage = parseInt(getUsedMilage.innerText);
			console.log(getUsedMilage);
			//쿠폰사용 할인금액 계산
			var changeUseCoupon = (classPrice*1/parseInt(couPer)).toFixed(0);
			getCoupon.innerHTML
				= '<p style="color:tomato;">'+changeUseCoupon+'</p>';
			//쿠폰번호 임시로 찍기
			const getTempCouNum = document.getElementById('couNum');
			getTempCouNum.innerHTML=couCode;			
			//총 할인금액 세팅	
			var plusDiscount = parseInt(changeUseCoupon) + useMileage;
			getTotalDiscount.innerHTML
				='<p style="color:tomato;">'+plusDiscount+'</p>';
			//마지막 결제금액 세팅
			var totalCalc = classPrice- plusDiscount;
			getMoney.innerHTML 
  			    = '<h4><i class="fa fa-credit-card-alt"></i>&nbsp;&nbsp;Final Amount &nbsp;&nbsp;<small class="text-muted">최종 금액</small></h4><br><h1><i class="fa fa-krw"></i>&nbsp;'+totalCalc+'</h1>';
			
		}

  	  
  		//마일리지 사용하기 버튼
  		function useMilage(){
			//원금가져오기
			const getClassPrice = document.getElementById('classPrice');
			var classPrice = parseInt(getClassPrice.innerText);
			//총 금액 가져오기
  			const getMoney = document.getElementById('money');
			var moneyText = getMoney.innerText;
			//숫자만 빼오기
  			 var regex = /[^0-9]/g;
  			 var changeMoney = moneyText.replace(regex, "");
			//총 할인금액 가져오기
			const getTotalDiscount = document.getElementById('totalDiscount');
			//쿠폰금액 가져오기
			const getCoupon = document.getElementById('useCoupon');
			var couponAmount = parseInt(getCoupon.innerText);
			//사용 마일리지
			const getUsedMilage = document.getElementById('useMileage');
  			
			//마일리지 입력값 가져오기
  			var getMile = document.getElementById('milage').value;

			var getMyMilage = document.getElementById('mile');
			var myMilage = getMyMilage.innerText;
			console.log(myMilage);
			
   			if(parseInt(myMilage)<parseInt(getMile)){
				Swal.fire({
				      icon: 'error',
					  title : 'Check Mileage!',
				      text: "보유마일리지가 부족합니다!",
				    });
   			}else if(getMile=="" || parseInt(getMile)<1000){
				Swal.fire({
				      icon: 'error',
					  title : 'Check Please!',
				      text: "마일리지는 1000p 이상부터 사용가능합니다.",
				    });
			}else{
			 //최종할인액
			 var calcTotalDiscount = parseInt(couponAmount)+parseInt(getMile);
			 var totalCalc = classPrice-calcTotalDiscount;
			 Swal.fire({
		      icon: 'success',
			  title : 'Mileage used!',
		      text: '마일리지가 사용되었습니다!',
		    });
			 getTotalDiscount.innerHTML
				= '<p style="color:tomato;">'+calcTotalDiscount+'</p>';
			 getUsedMilage.innerHTML
				= '<p style="color:tomato;">'+getMile+'</p>';
  			 getMoney.innerHTML 
  			    = '<h4><i class="fa fa-credit-card-alt"></i>&nbsp;&nbsp;Final Amount &nbsp;&nbsp;<small class="text-muted">최종 금액</small></h4><br><h1><i class="fa fa-krw"></i>&nbsp;'+totalCalc+'</h1>';
			};

			 
			 
  							
  		}
  		
  
	  var IMP = window.IMP; 
	  IMP.init("imp97334987");
	  
	  
	 //값에 따른 결제창
	 function request_pay2(pgText,finalAmount,plusMile,payTitle){
		//총 할인금액 가져오기
		const getTotalDiscount = document.getElementById('totalDiscount');
		var totalDiscount = parseInt(getTotalDiscount.innerText);
		//원금가져오기
		const getClassPrice = document.getElementById('classPrice');
		var classPrice = parseInt(getClassPrice.innerText);
		//사용 마일리지
		const getUsedMilage = document.getElementById('useMileage');
		var useMileage = parseInt(getUsedMilage.innerText);
		//사용 쿠폰번호
		const getTempCouNum = document.getElementById('couNum');
		var couNum = getTempCouNum.innerText;
		console.log(pgText);
		 IMP.request_pay({
			    pg : pgText,  // KG이니시스 일반결제창 호출(상점아이디 MID-a 적용)
			    amount : finalAmount,
			    name : payTitle, //강의명으로 수정
			    buyer_name : "송중기", //세션값으로 변경
			    buyer_email : "buyer@iamport.kr"
			  }, function(rsp) {
			    if ( rsp.success ) {
			    	var msg = '결제가 완료되었습니다!';
					Swal.fire({
				      icon: 'success',
					  title: 'Payment success',
				      text: msg,
				    }).then(function(){
					location.href="./paySuccess.do?paynum="+rsp.imp_uid+"&finalAmount="+rsp.paid_amount+"&plusMile="+plusMile;
				})
			    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			    	jQuery.ajax({
			    		url: "./payment/pay.do", 
			    		type: 'POST',
			    		dataType: 'json',
			    		data: {
				    		imp_uid : rsp.imp_uid,
				    		merchant_uid : rsp.merchant_uid,
							payRow : classPrice,
							payDiscount : totalDiscount,
							payUmilage : useMileage,
							payCounum : couNum,
							payPlusMilage : plusMile
				    		//기타 필요한 데이터가 있으면 추가 전달
			    		}
			    	}).done(function(data){
			    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
						alert("정상");			    			
			    	});
					
			    } else {
			        Swal.fire({
				      icon: 'error',
					  title: 'Payments failure',
				      text: rsp.error_msg,
				    });
			    }
			});
	 }
	 
	//환불
	 function doF(){
		 $.ajax({
			 type:"post",
			 url:"./payment/cancel.do",
			 success:function(result){
				console.log(result);
				location.href="./payment/moveNext";
				 
			 }
		 })
	 }
	 
	//조회
	 function doCheck(){
		 $.ajax({
			 type:"post",
			 url:"./payment/payInfo.do",
			 success:function(result){
				 console.log(result);
				 location.href="./payment/moveNext";
			 }
		 })
	 }