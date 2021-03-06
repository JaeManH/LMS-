package com.min.iamport;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.dao.PayDao;
import com.min.service.IPayService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.PaymentBalance;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping(value = "/user/payment/**")
public class IamportController {
	IamportClient client;
	
	@Autowired
	private IPayService service;
	
	public IamportController() {
		this.client = this.getTestClient();
	}

	IamportClient getTestClient() {
		String test_api_key = "6254766231323012";
		String test_api_secret = "pPahPWfgL5Xjc0j1CQgSNRxcOYIV6CpwrzNhw3xi8vBlwVn9LD1zuzMjxveE7EazeYQL2o3bUFxqAUzm";
		return new IamportClient(test_api_key, test_api_secret);
	}
	
	void getToken() {
		try {
			IamportResponse<AccessToken> auth_response = client.getAuth();
			assertNotNull(auth_response.getResponse());
			assertNotNull(auth_response.getResponse().getToken());
			
			System.out.println("get token str: " + auth_response.getResponse().getToken());
			
		}catch(IamportResponseException e){
			System.out.println(e.getMessage());
			
			switch(e.getHttpStatusCode()) {
			case 401 : System.out.println("401");break;
			case 500 : System.out.println("500");break;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//?????? ??? insert
	@PostMapping("pay.do")
	public void getPay(String merchant_uid, String imp_uid,String payRow,String payDiscount,int payUmilage,String payCounum,Authentication user,int payPlusMilage) {
		System.out.println("merchant_uid ??? ?? : " + merchant_uid + "pay : "+payPlusMilage);
		System.out.println("imp_uid??? ?? : " + imp_uid); //????????????
		try {
			//payco??? kcp??? ??????
			//?????????????????? ?????? pay_response??? ??????
			//IamportResponse<PaymentBalance> payment_response = client.paymentBalanceByImpUid(test_Imp_uid);
			IamportResponse<Payment> pay_response = client.paymentByImpUid(imp_uid);
			System.out.println(pay_response.getResponse().getMerchantUid()); //???????????? o
			System.out.println(pay_response.getResponse().getBuyerName()); //??????????????? o
			System.out.println(pay_response.getResponse().getName()); // ????????? o
			System.out.println(pay_response.getResponse().getAmount()); // ?????? o
			System.out.println(pay_response.getResponse().getStatus()); // ???????????? o
			System.out.println(pay_response.getResponse().getPayMethod()); // ???????????? o
			System.out.println(pay_response.getResponse().getPaidAt()); // ???????????? o
			System.out.println(pay_response.getResponse().getPgProvider()); //payco (pg???)
			System.out.println(pay_response.getResponse().getPgTid()); // 20220517

//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			String formatData = simpleDateFormat.format(pay_response.getResponse().getPaidAt());
//			System.out.println(formatData + "????????? ??????"); 
			
			Map<String, Object> map= new HashMap<String, Object>();
			map.put("pay_num", pay_response.getResponse().getImpUid()); // ???????????? ok
			map.put("pay_tra_buyer",user.getPrincipal()); // ?????????????????? : ????????? ???????????? ok
			map.put("pay_cla_num", "CLA003"); // ???????????? : ?????? ??????????????? ??????
			map.put("pay_price", pay_response.getResponse().getAmount()); //?????? ok
			map.put("pay_method", pay_response.getResponse().getPayMethod()); //???????????? ok
			map.put("pay_pg", pay_response.getResponse().getPgProvider()); // payco(pg???) ok
			map.put("pay_status", "??????"); //????????????(??????,????????????,????????????) ok
			map.put("pay_date", pay_response.getResponse().getPaidAt()); //???????????? ok
			map.put("pay_content", pay_response.getResponse().getName()); //????????? ok
			map.put("pay_raw", payRow);	//????????????????????? ?????? ok
			map.put("pay_discount", payDiscount);	//????????????????????? ?????? ok
			map.put("pay_candate", "");//?????? ?????? ?????? ?????? update
			map.put("pay_cancate", "");//?????? ???????????? update
			map.put("pay_cancontent", ""); // ?????? ?????? ??????  update
			if(payUmilage == 0) {
				map.put("pay_ucounum", "");
			}else {
				map.put("pay_ucounum", payCounum);
				Map<String, Object> couponMap = new HashMap<String, Object>();
				couponMap.put("cou_code", payCounum);
				service.updateCoupon(couponMap);
			}
			map.put("pay_umilage", payUmilage);
			Map<String,Object> mileMap = new HashMap<String, Object>();
			mileMap.put("useMilage", payUmilage);
			mileMap.put("tra_id", user.getPrincipal());
			service.updateMileage(mileMap);
			map.put("plusMileage", payPlusMilage);
			map.put("tra_id", user.getPrincipal());
			//insert ??????
			int n = service.payInsert(map);
			System.out.println(n + "@@@!!@@@@@@@@");
			
		} catch (IamportResponseException e) {
			
			System.out.println(e.getMessage());
			
			switch(e.getHttpStatusCode()) {
			case 401: System.out.println("401??????");break;
			case 500: System.out.println("500??????");break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//vo??? ????????? db ??????? or Map ????????? db ??????
		this.getToken();
	}
	
	//?????? ??????.
	@RequestMapping(value = "cancel.do", method = RequestMethod.POST)
	public void testCancelPaymentAlreadyCancelledImpUid(String paynum) {
        CancelData cancel_data = new CancelData(paynum, true); //imp_uid??? ?????? ????????????
        System.out.println("?????? ok~");
        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
           
            if(payment_response.getResponse() == null) {
            	System.out.println("?????? ????????? ???????????????.!!");
            }
//            assertNull(payment_response.getResponse()); // ?????? ????????? ????????? response??? null??????
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
}
