//package com.hsgl.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import cn.emay.sdk.client.api.Client;
//
//public class TestSendSMS {
//
//	public static void main(String[] args) {
//		List<String> telList = new ArrayList<>();
//		telList.add("18610580822");
//		String[] mobiles = (String[])(telList.toArray(new String[]{})); 
//		getClient( "3SDK-BHC-0130-LIXUP", "K#jjdk#*&dj_DLL");
//		
////		int k = client.registEx("K#jjdk#*&dj_DLL");
////		System.out.println("注册返回值:" + k);
//		String sendContent = "短信内容测试11";
//		int res = client.sendSMS(mobiles, "【徽商故里】"+sendContent, 5);
//		if(res == 0){
//			System.out.println("发送成功");
//		}else{
//			System.out.println("发送短信失败,返回码:" + res);
//		}
//	}
//
//	public static Client client;
//	
//	public static Client getClient(String softwareSerialNo,String key){
//		if(client==null){
//			try {
//				client=new Client(softwareSerialNo,key);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return client;
//	}
//}
