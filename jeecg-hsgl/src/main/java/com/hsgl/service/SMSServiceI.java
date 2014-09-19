package com.hsgl.service;

import java.util.List;

public interface SMSServiceI {
	
	/**
	 * 发送短信
	 * @param telList
	 * @param sendContent
	 */
	void sendSMS(List<String> telList,String sendContent);

}
