package com.dsvc.blk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsvc.util.ContextUtil;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	ContextUtil contextUtil;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/home",method=RequestMethod.GET)
	@ResponseBody
	public String home(){
		//ContextUtil
		System.out.println(request.getRealPath("/"));
		System.out.println(contextUtil.getContextPath());
		System.out.println(contextUtil.getRealPath("/"));
		System.out.println(contextUtil.getCurrentHttpServletRequest().getRequestURL());
		return "success";
	}
}
