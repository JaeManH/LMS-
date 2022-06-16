package com.min.serviceImpl;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class coolSMS {
	public void certifiedPhoneNumber(String phoneNumber, String payNum ,String payOrRefund) {
		String api_key = "NCSZADE5ZEC1DZR3"; // coolSMS 사이트에서 받은 인증키
		        String api_secret = "HQMRDEF5F5WUBE15UHVGMYSOY4PVFBJS"; // coolSMS 자체에 발급된 비밀키
		        Message coolsms = new Message(api_key, api_secret);

		        // 4개의 입력값 필요
		        HashMap<String, String> params = new HashMap<String, String>();
		        params.put("to", phoneNumber);    // 수신전화번호
		        params.put("from", "010-7378-0203");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨 -> 발신전화 번호는 coolSMS에 등록해줘야됨
		        params.put("type", "SMS");// type 방식
		        if(payOrRefund.equals("pay")) {
		        	params.put("text", "결제가 완료되었습니다.\n회원님의 결제번호는" + "["+payNum+"]" + "입니다");
		        }else{
		        	params.put("text", "환불이 승인되었습니다.\n결제시 사용된 마일리지와 쿠폰은 반환됩니다.");
		        }
		        
		      	params.put("app_version", "test app 1.2"); // application name and version

		try {
		        	JSONObject obj = (JSONObject) coolsms.send(params);
		            System.out.println(obj.toString());
		        } catch (CoolsmsException e) {
		            System.out.println(e.getMessage());
		            System.out.println(e.getCode());
		        }
			}

}
