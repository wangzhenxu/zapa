package com.loiot.baqi.service.job;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.loiot.baqi.constant.ApplicationConst;
import com.loiot.baqi.constant.Const;
import com.loiot.baqi.constant.DictionaryUtil;
import com.loiot.baqi.dao.ZpCompanyInfoDao;
import com.loiot.baqi.dao.ZpCompanyJobInfoDao;
import com.loiot.baqi.pojo.ZpCompanyInfo;
import com.loiot.baqi.pojo.ZpCompanyJobInfo;
import com.loiot.baqi.pojo.ZpDictionaryInfo;
import com.loiot.baqi.status.CompanyJobSourceType;
import com.loiot.baqi.status.CompanySourceType;
import com.loiot.baqi.status.DictionaryType;
import com.loiot.baqi.status.HDTypes;
import com.loiot.baqi.status.PauseStartType;
import com.loiot.baqi.utils.HtmlUnitUtil;
import com.loiot.baqi.utils.JsonToObject;
import com.loiot.baqi.utils.JsonUtils;
import com.loiot.baqi.utils.MD5Util;
import com.loiot.baqi.vo.hd.ComapnyAndComapnyJob;
import com.loiot.baqi.vo.hd.CoordInfo;
import com.loiot.baqi.vo.hd.Enterprise;
import com.loiot.baqi.vo.hd.Position;
import com.loiot.baqi.vo.hd.Root;
import com.loiot.commons.utils.FileUtil;
import com.loiot.commons.utils.JsonUtil;
import com.loiot.commons.utils.StringUtil;



/**
 * 账号业务逻辑类
 * 
 * @author zhengrj
 * 
 */
@Service("fetchingHdCompanyAndJobInfoService")
public class FetchingHdCompanyAndJobInfoService extends JobTaskDefine {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
 	private ZpCompanyJobInfoDao zpCompanyJobInfoDao;
    @Resource
   	private ZpCompanyInfoDao zpCompanyInfoDao;
    
    public void doTask(){
    	try {
    		
    		//log.info("ffffffffffffffffffffffffffffffffffffffffff");
			paseHdSiteInfo();
			
			log.info("任务执行完毕");
    		
    		/*String ccsJson =FileUtil.readFileToString(new File("d:\\companyAndJobAll.txt"));
    		List<ComapnyAndComapnyJob> ccs =JsonUtil.toList(ccsJson, ComapnyAndComapnyJob.class);
    		this.persistenceInfoToDataBase(ccs);
*/    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	

    public  String getCoordInfoForHttp(String coordListJson) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		 //String  homeJson =FileUtil.readFileToString(new File("d:\\home_job.txt"));
    	/*if(StringUtil.isBlank(coordListJson)){
   		 	coordListJson =FileUtil.readFileToString(new File("d:\\coordListJson.txt"));
    	}else{
        	FileUtil.writeStringToFile("d:\\coordListJson.txt", coordListJson);
    	}*/
    	String url = ApplicationConst.ACCESS_DOMAIN+"getAreaCoordInfo.action";  
    	WebClient webClient = HtmlUnitUtil.WebClientInit();
		WebRequest req = new WebRequest(new URL(url), HttpMethod.POST);
		req.setCharset("utf-8");
		Map<String, String > params=new HashMap<String,String>();
		params.put("coordListJson", coordListJson);
		params.put("a", "中国");
		req.setRequestParameters(HtmlUnitUtil.translateParams(params));
        //final WebClient webClient = new WebClient();  
      
        // 1 启动JS  
        webClient.getOptions().setJavaScriptEnabled(true);  
        // 2 禁用Css，可避免自动二次请求CSS进行渲染  
        webClient.getOptions().setCssEnabled(false);  
        // 3 启动客户端重定向  
        webClient.getOptions().setRedirectEnabled(true);  
      
        // 4 js运行错误时，是否抛出异常  
        webClient.getOptions().setThrowExceptionOnScriptError(false);  
        // 5 设置超时  
        webClient.getOptions().setTimeout(50000);  
          
        HtmlPage htmlPage = webClient.getPage(req); 
        //webClient.addRequestHeader("coordListJson", coordListJson);

        // 等待JS驱动dom完成获得还原后的网页  
        webClient.waitForBackgroundJavaScript(10000);  
        // 网页内容  
       // System.out.println(htmlPage.asXml());  
        
        HtmlDivision div = htmlPage.getHtmlElementById("coordInfo");  
        String coordsJson = div.asText();
        webClient.closeAllWindows();
        log.info("coords info=" + coordsJson);
        return coordsJson;
    }
	
	
	
	public static void autoLogin(){
		String loginCookie;
		try {
			loginCookie = FileUtil.readFileToString(new File("d:\\login_cookie.txt"));
			List<HashMap> cookies = JsonUtil.toList(loginCookie, HashMap.class);
			
			
			//AllCookies.addAll(cookies);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//解析猎上网信息
	public  void paseHdSiteInfo() throws Exception{
		String userName = "18500357912";
		String pwd = "123456";
		login(userName, pwd, "");
		if(1==0){
			return;
		}
		
		String priority="priority=2&";
		priority="";
		
		//java
		String url4 = "http://hd.hunteron.com/api/v1/position/query?_t="+System.currentTimeMillis()+"&cityId=30101&"+priority+"query=Java&size=15&start=0";
		paseHdSiteInfo(url4,DictionaryUtil.getCode(DictionaryType.JOB_POSITION.getCode(), Const.ONE));
		
		//PHP
		url4 = "http://hd.hunteron.com/api/v1/position/query?_t="+System.currentTimeMillis()+"&cityId=30101&"+priority+"query=PHP&size=15&start=0";
		paseHdSiteInfo(url4,DictionaryUtil.getCode(DictionaryType.JOB_POSITION.getCode(), Const.TWO));
		
		//Android
		url4 = "http://hd.hunteron.com/api/v1/position/query?_t="+System.currentTimeMillis()+"&cityId=30101&"+priority+"query=Android&size=15&start=0";
		paseHdSiteInfo(url4,DictionaryUtil.getCode(DictionaryType.JOB_POSITION.getCode(), Const.THREE));
		
		
	}
	
	public void  paseHdSiteInfo(String positionURL,Long typeId){
		//String url4 = "http://hd.hunteron.com/api/v1/position/getHomepagePositions?_t="+System.currentTimeMillis()+"&size=2";
		String url4= positionURL;
		
		String homeJson = HtmlUnitUtil.webClientGet(url4,1000,2000); //获取企业信息
		
		  
		 //String  homeJson =FileUtil.readFileToString(new File("d:\\home_job.txt"));

		
		   HashMap map=null;
		   Root root=null;
		   List<CoordInfo> positons=new ArrayList<CoordInfo>();
		   List<ComapnyAndComapnyJob> ccs = new ArrayList<ComapnyAndComapnyJob>(); 
		   try {
			     Root homeRoot = JsonUtils.fromJsonToObject(homeJson.trim(), Root.class);
			     int i=0;
			     for(Position p :homeRoot.getData().getPositions()){
			    	 //0：需要申请 1：不需要申请 2：不能申请-->
			    	 if(p.getPositionType()!=1){
			    		continue;
			    	 }
			    	/* i++;
			    	 if(i==10){
			    		 break;
			    	 }*/
			    	 
			    	 
			    	 String url5="http://hd.hunteron.com/api/v1/position/detail?_t="+System.currentTimeMillis()+"&positionId="+p.getPositionId();
			 		 String jobRootJson = HtmlUnitUtil.webClientGet(url5,2000,4000); //获取职位信息
			 		 root = JsonUtils.fromJsonToObject(jobRootJson.trim(), Root.class);
			 		 
			 		 HashMap<String, Enterprise> enterMap = root.getData().getEnterprises();
			 		 Enterprise enterBean = enterMap.get(String.valueOf(p.getEnterpriseId()));
					 
			 		 System.out.println("start companyJob:"+p.getPositionId());
			 		 ZpCompanyJobInfo companyJob = convertCompanyJobInfoPoToLocalBean(root.getData().getPosition(), typeId,enterBean.getHighlights());
					 System.out.println(companyJob);
			 		 System.out.println("end companyJob:"+p.getPositionId());
			 		 
			 		 //System.out.println("start company:"+p.getEnterpriseId());
					 ZpCompanyInfo company = convertCompanyInfoPoToLocalBean(enterBean);
					 System.out.println(company);
			 		 //System.out.println("end company:"+p.getEnterpriseId());
			 		
			 		//坐标集合
			 		CoordInfo coord = new CoordInfo();
			 		coord.setHdLocation(companyJob.getAddress());
			 		coord.setHdPositionId(Integer.parseInt(companyJob.getHdCode().toString()));
			 		positons.add(coord);
			 		
			 		ComapnyAndComapnyJob cs = new ComapnyAndComapnyJob();
			 		cs.setCompany(company);
			 		cs.setCompanyJob(companyJob);
			 		//职位和企业信息
			 		ccs.add(cs);
			     }
			     
			     setCoordInfo(ccs, positons);
			     //FileUtil.writeStringToFile("d:\\companyAndJobAll.txt", JsonUtil.toJson(ccs));
		    	 this.persistenceInfoToDataBase(ccs);

		   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String f="";
	}
	
	public void persistenceInfoToDataBase(List<ComapnyAndComapnyJob> ccs){
		Collections.reverse(ccs);//集合倒转
		for(ComapnyAndComapnyJob cj : ccs){
			HashMap<String, Object> pMap= new HashMap<String,Object>();
			pMap.put("hdCode", cj.getCompany().getHdCode());
			pMap.put("source",CompanySourceType.HD.getCode());
			try {
				List<ZpCompanyInfo> companyList = this.zpCompanyInfoDao.queryZpCompanyInfoList(pMap);
				ZpCompanyInfo company = cj.getCompany();
				company.setLastUpdateTime(new Date());
				company.setInPerson(1l);
				
				ZpCompanyJobInfo companyJob = cj.getCompanyJob();
				companyJob.setInPerson(1l);
				companyJob.setInDatetime(new Date());
				companyJob.setLastUpdateTime(new Date());
				if(companyList==null || companyList.size()==0){
					this.zpCompanyInfoDao.addZpCompanyInfo(company);
					companyJob.setCompanyId(company.getCompanyId());
					//this.zpCompanyJobInfoDao.addZpCompanyJobInfo(companJob);
				}
				
				
				pMap.clear();
				pMap.put("hdCode", companyJob.getHdCode());
				pMap.put("source",CompanySourceType.HD.getCode());
				List<ZpCompanyJobInfo> companyJobList = this.zpCompanyJobInfoDao.queryZpCompanyJobInfoList(pMap);
				if(companyJobList==null || companyJobList.size()==0){
					if(companyJob.getCompanyId()==null){
						companyJob.setCompanyId(companyList.get(0).getCompanyId());
					}
					this.zpCompanyJobInfoDao.addZpCompanyJobInfo(companyJob);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//设置坐标信息
	public  void setCoordInfo(List<ComapnyAndComapnyJob> ccs ,List<CoordInfo> positons) throws Exception{
		String coordListJson = JsonUtils.toJson(positons);
		coordListJson =getCoordInfoForHttp(coordListJson);
		List<CoordInfo> coords = JsonUtils.toList(coordListJson, CoordInfo.class);
		
		for(int i=0;i<coords.size();i++){
			CoordInfo coord = coords.get(i);
			ZpCompanyJobInfo job = ccs.get(i).getCompanyJob();
			job.setCoordX(coord.getCoordX());
			job.setCoordY(coord.getCoordY());
			String areaName =coord.getAreaName();
			if(!StringUtil.isBlank(areaName)){
				List<ZpDictionaryInfo> dicList = DictionaryUtil.getTypes(DictionaryType.COMPANY_AREA.getCode());
				for(ZpDictionaryInfo info :dicList){
					if(info.getShowName().equals(areaName)){
						job.setAreaId(info.getDictionaryId());
						break;
					}
				}
			}
			if(!StringUtil.isBlank(job.getCoordX()) && !StringUtil.isBlank(job.getCoordY()) && job.getAreaId()==null){
				log.warn("areaName=" +areaName +"  没有获取到行政区id ");
			}
		}
	}
	
	//转换公司信息
	public static ZpCompanyInfo convertCompanyInfoPoToLocalBean(Enterprise enterBean){
		ZpCompanyInfo company=new ZpCompanyInfo();
		company.setAddress(enterBean.getAddress());
		company.setName(enterBean.getName());
		company.setDesc("<div style=\"text-indent: 26px; white-space: pre-wrap; \">"+enterBean.getIntroduce()+"</div>");
		company.setScaleId(HDTypes.getScaleId(enterBean.getScale()));
		company.setRegtime(HDTypes.getRegTime(enterBean.getCreateTime()));
		company.setFinancingLevelId(HDTypes.getFinancingLevel(enterBean.getDevelopStatus()));
		company.setIndustryId(HDTypes.getIndustryId(enterBean.getIndustryIds()));
		company.setCompanyNature(HDTypes.getCompanyNature(enterBean.getStyle()));
		company.setIsDelete((int)PauseStartType.START.getCode());
		company.setHdCode(enterBean.getEnterpriseId());
		company.setSource((int)CompanySourceType.HD.getCode());
		return company;
	}
	
	//转换职位信息
	public static ZpCompanyJobInfo convertCompanyJobInfoPoToLocalBean(Position hdPosi,Long jobTypeId,String highlights){
		ZpCompanyJobInfo job =new ZpCompanyJobInfo();
		job.setTypeId(jobTypeId);
		job.setName(hdPosi.getPositionTitle());
		job.setJobPositionLevelId(HDTypes.getJobPositionLevelId(hdPosi.getPositionTitle(), hdPosi.getWorkExpRequired()));
		job.setReportObject(hdPosi.getReportTo());
		job.setZpPersonCount(hdPosi.getHeadCount());
		job.setExpectedYearMoneyStart(hdPosi.getMinShowAnnualSalary());
		job.setExpectedYearMoneyEnd(hdPosi.getMaxShowAnnualSalary());
		HDTypes.setWorkExpRequired(hdPosi.getWorkExpRequired(), job);
		job.setDownTeamPersonCount(HDTypes.getDownTeamPersonCount(hdPosi.getSubordinate()));
		job.setDesc("<span style=\"white-space: pre-wrap; \">"+hdPosi.getJobDescription()+"</span>");
		job.setMoreDesc("<span style=\"white-space: pre-wrap; \">"+hdPosi.getJobRequirement()+"</span>");
		job.setSex(HDTypes.getSexId(hdPosi.getGenderRequired()));
		job.setEducationId(HDTypes.getEducationId(hdPosi.getDegreeRequired()));
		job.setEnglishLevelId(HDTypes.getEnglishLevelId(hdPosi.getLanguageRequired()));
		
		job.setJobTemptText(highlights);
		job.setIsDelete((int)PauseStartType.START.getCode());
		job.setAddress(hdPosi.getLocation());
		job.setZpUrgencyStatusId(HDTypes.getZpUrgencyStatusId(hdPosi.getPriority()));
		job.setHdCode(Long.parseLong(String.valueOf(hdPosi.getPositionId())));
		job.setSource((int)CompanyJobSourceType.HD.getCode());
		job.setRequireInterviewNum(hdPosi.getInterviewTimes());
		return job;
	}
	
	
	
	
	/**
	 * 模拟登陆 猎上
	 * @param userName
	 * @param pwd
	 * @param yzm
	 * @throws FailingHttpStatusCodeException
	 * @throws IOException
	 */
	public  void login(String userName, String pwd, String yzm) throws FailingHttpStatusCodeException, IOException{
		
		String url0 = "http://hd.hunteron.com/#/index?redirect=http%253A%252F%252Fhd.hunteron.com%252F%2523%252Fpositions%252Fmatch";
		HtmlUnitUtil.webClientGet(url0,1000,2000); //获取cookie
		
		String url1 = "http://hd.hunteron.com/api/ucenter/link?_t=1453105469239&date=1453105469218";
		String response = HtmlUnitUtil.webClientGet(url1,1000,2000); //获取cookie的同时获取授权码
		Map<String, Object> jsonMap = JsonToObject.parseJSON2Map(response);
		Map<String, Object> dataMap = (Map<String, Object>) jsonMap.get("data");
		String realm = (String) dataMap.get("realm");
		String nonce = (String) dataMap.get("nonce");
		String a = MD5(pwd);
		String b = MD5(a + "5OGP56W65A6D6LSD") + "x";
		String o = jsFunction(a, userName,realm, nonce);
		String s = jsFunction(b, userName,realm, nonce);
		
		String url3 = "http://hd.hunteron.com/api/ucenter/login?_t="+System.currentTimeMillis();
		Map<String, String > params = new HashMap<String, String>();
		params.put("loginName",userName);
		params.put("authorizeCode",o);
		params.put("twoAuthorizeCode",s);
		params.put("noRemind","true");
	//	params.put("imageVeriCode","yrez");
		String webClientPost = HtmlUnitUtil.webClientPost(url3, params);
		//System.out.println(webClientPost);
	}

	

	private  String jsFunction(String a0, String userName,  String realm, String nonce) {
		String a1 = MD5(userName + ":" + realm + ":" + a0);
		String r = MD5("POST:/ucenter/login");
		String o = MD5(a1 + ":" + nonce + ":" + r);
		return o;
	}
	
	
	private  String MD5(String string) {
		String md5yzm = MD5Util.encode(string);
		//String md5yzm = MD5.digest(string);
//		md5yzm  = md5yzm.substring("MD5:".length());
		//System.out.println("md5 :"+md5yzm);
		return md5yzm;
		
	}


	
	
	
	
	

}
