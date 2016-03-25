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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loiot.baqi.service.job.FetchingHdCompanyAndJobInfoService;
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
     
	@Autowired
	FetchingHdCompanyAndJobInfoService fetchingHdCompanyAndJobInfoService;
	/**
	 * 跳转欢迎页
	 * 
	 * @return 首页模板位置
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getAreaCoordInfo")
	public String getAreaCoordInfo(HttpServletRequest request,ModelMap model) throws IOException {
	    String coordListJson = request.getParameter("coordListJson");
	    //coordListJson= "[{\"hdLocation\":\"朝阳区酒仙桥北路甲10号院105号楼\",\"hdPositionId\":78565},{\"hdLocation\":\"朝阳区酒仙桥北路甲10号院105号楼\",\"hdPositionId\":78565}]";
	    
	    //System.out.println("-----------:"+coordListJson+"----------------");
		/*if(StringUtils.isBlank(coordListJson)){
			System.out.println("-------------------null--------------");
		}*/
		request.setAttribute("coordListJson", coordListJson);
		//request.setAttribute("fff", 111);

		//System.out.println("aaaaaa:"+request.getAttribute("coordListJson"));
	    //model.put("coordListJson",coordListJson );
	    //model.put("fff",111 );
		
		return "areaCoordInfo";
	}
	
	/**
	 * 测试爬虫
	 * 
	 * @return 首页模板位置
	 * @throws IOException 
	 */
	@RequestMapping(value = "/testTask")
	public String doTask(HttpServletRequest request,ModelMap model) throws IOException {
		fetchingHdCompanyAndJobInfoService.doTask();
		//fetchingHdCompanyAndJobInfoService.getCoordInfoForHttp(null);
		return "succeed";
	}
	
}
