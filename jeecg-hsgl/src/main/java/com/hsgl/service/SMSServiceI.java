package com.hsgl.service;

import java.util.List;

import cn.emay.sdk.client.api.Client;

public interface SMSServiceI {
	
	public Client getClient(String softwareSerialNo,String key);
	
	
	/**
	 * 发送短信
	 * @param telList
	 * @param sendContent
	 */
	String sendSMS(List<String> telList,String sendContent);

	/**
	 * 查询余额
	 * @return
	 */
	double getBalance();
}
