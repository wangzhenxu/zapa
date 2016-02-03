package com.loiot.baqi.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loiot.baqi.status.AccountType;
import com.loiot.baqi.utils.UserSessionUtils;
import com.loiot.commons.utils.FileUtil;

/**
 * 欢迎页处理器。
 * 
 * @author wangzx
 * 
 */
@Controller
public class HomeController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 跳转欢迎页
	 * 
	 * @return 首页模板位置
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getAreaCoordInfo")
	public String getAreaCoordInfo(HttpServletRequest request,ModelMap model) throws IOException {
		/* Enumeration headerNames = request.getHeaderNames();
		    while (headerNames.hasMoreElements()) {
		        String key = (String) headerNames.nextElement();
		        String value = request.getHeader(key);
		        System.out.println("key=" +key +" value="+value );
		    }*/
	   //System.out.println("a"+new String(request.getParameter("a").getBytes("iso-8859-1"),"utf-8"));
	    String coordListJson =FileUtil.readFileToString(new File("d:\\coordListJson.txt"));
		
		//System.out.println("coordListJson"+coordListJson);
		model.put("coordListJson",coordListJson );
		return "areaCoordInfo";
	}
}
