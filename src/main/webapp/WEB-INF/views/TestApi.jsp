<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>API TEST 페이지입니다</title>
  <!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
  <script type="text/javascript" src="./resources/js/pay/pay.js"></script>
  
</head>
<body>
	 
	 <div class ="btns">
	 	
	 	<input type="radio" name="selectPay" value="payco">&nbsp;페이코&nbsp;&nbsp;<img src="./resources/images/pay/payco.png"/>&nbsp;&nbsp;
	 	<input type="radio" name="selectPay" value="kakaopay">&nbsp;카카오페이&nbsp;&nbsp;<img src="./resources/images/pay/kakao.png"/>&nbsp;&nbsp;
	 	<input type="radio" name="selectPay" value="toss">&nbsp;토스결제&nbsp;&nbsp;<img src="./resources/images/pay/toss.png"/>
	 	<br>
	 	<br>
		<input type="button" id="check3" onclick="request_pay2()" value="페이코">
		<input type="button" id="check4" onclick="requestPay3()" value="카카오페이">
		<input type="button" id="check4" onclick="requestPay4()" value="토스">
		<br>
		<br>
		마일리지&nbsp;&nbsp;<input type="number" name="milage" id="milage">&nbsp;
		<input type="button" id="check6" onclick="useMilage()" value="사용하기"><br><br><hr>
		<div id='money'>
			<h4>결제금액</h4>
			<h2>30000 원</h2>
		</div>
		<input type="button" id="check6" onclick="checkPay()" value="결제">
		
		<h1><a href="javascript:doCheck()">정보확인</a></h1>
		<a href="javascript:doF()">결제 취소</a>
	</div>
</body>
</html>