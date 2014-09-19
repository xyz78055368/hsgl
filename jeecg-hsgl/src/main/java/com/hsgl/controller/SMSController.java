package com.hsgl.controller;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sMSController")
public class SMSController {
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(params="save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson save(){
		return new AjaxJson();
	}
	
	@RequestMapping(params="uploadEcxel",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson uploadExcel(){
		return new AjaxJson();
	}

	@RequestMapping(params="addorupdate")
	public ModelAndView addOrUpdate(){
		return new ModelAndView("com/hsgl/sms/SMSPage");
	}
}
