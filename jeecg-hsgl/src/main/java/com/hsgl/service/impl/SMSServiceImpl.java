package com.hsgl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.emay.sdk.client.api.Client;

import com.hsgl.service.SMSServiceI;

@Service("sMSServiceI")
public class SMSServiceImpl implements SMSServiceI {

	private static Client client=null;
	private String softwareSerialNo;
	private static String key = "K#jjdk#*&dj_DLL";

	public String getSoftwareSerialNo() {
		return softwareSerialNo;
	}

	public void setSoftwareSerialNo(String softwareSerialNo) {
		this.softwareSerialNo = softwareSerialNo;
	}

	public String getKey() {
		return key;
	}

	@Override
	public Client getClient(String softwareSerialNo,String key){
		if(client==null){
			try {
				client=new Client(softwareSerialNo,key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	
	public String sendSMS(List<String> telList,String sendContent) {
		String[] mobiles = (String[])(telList.toArray()); 
		getClient( softwareSerialNo, key);
		String msg = "";
		int res = client.sendSMS(mobiles, "【徽商故里】"+sendContent, 5);
		if(res == 0){
		 	msg = "发送成功";
		}else{
			msg = "发送失败,返回码:" + res;
		}
		return msg;
	}

	@Override
	public double getBalance() {
		try {
			getClient( softwareSerialNo, key);
			return client.getBalance();
		} catch (Exception e) {
		}
		return -1;
	}

}
