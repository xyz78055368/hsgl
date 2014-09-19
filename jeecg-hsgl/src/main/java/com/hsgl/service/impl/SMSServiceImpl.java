package com.hsgl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.emay.sdk.client.api.Client;

import com.hsgl.service.SMSServiceI;

@Service
public class SMSServiceImpl implements SMSServiceI {

	private static Client client=null;

	public synchronized static Client getClient(String softwareSerialNo,String key){
		if(client==null){
			try {
				client=new Client(softwareSerialNo,key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	
	public void sendSMS(List<String> telList,String sendContent) {
		String[] mobiles = (String[])(telList.toArray()); 
		
		int res = client.sendSMS(mobiles, sendContent, 5);
		if(res == 1){
			System.out.println("发送成功");
		}
	}

}
