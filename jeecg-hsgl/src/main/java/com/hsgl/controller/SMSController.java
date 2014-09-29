package com.hsgl.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.hsgl.service.SMSServiceI;
import com.hsgl.vo.SendSMSRequest;

@Controller
@RequestMapping("/sMSController")
public class SMSController {
	 
	@Autowired
	private SMSServiceI sMSServiceI;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(params="save",method=RequestMethod.POST)
	@ResponseBody
	public String save(HttpServletRequest request){
		String telsStr = request.getParameter("tels");
		if(StringUtil.isBlank(telsStr)){
			return "手机号码不能为空";
		}
		String sendMsg =  request.getParameter("sendMsg");
		if(StringUtil.isBlank(telsStr)){
			return "短信内容不能为空";
		}
		List<String> tels =Arrays.asList( telsStr.split("\n"));

		String msg = sMSServiceI.sendSMS(tels,sendMsg);
		request.setAttribute("balance", sMSServiceI.getBalance());
		return msg;
	}
	
	@RequestMapping(params="uploadEcxel",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson uploadExcel(){
		return new AjaxJson();
	}

	@RequestMapping(params="addorupdate")
	public ModelAndView addOrUpdate(HttpServletRequest req){
		req.setAttribute("balance", sMSServiceI.getBalance());
		ModelAndView mav = new ModelAndView("");
		
		return new ModelAndView("com/hsgl/sms/SMSPage");
	}
}
