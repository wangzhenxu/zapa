package com.loiot.baqi.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.loiot.baqi.commons.message.email.EmailClient;
import com.loiot.baqi.commons.message.email.SimpleEmailVo;
import com.loiot.baqi.constant.ApplicationConst;
import com.loiot.baqi.constant.Const;
import com.loiot.baqi.constant.DictionaryUtil;
import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.AccountDao;
import com.loiot.baqi.dao.ZpDictionaryInfoDao;
import com.loiot.baqi.dao.ZpJlExpandInfoDao;
import com.loiot.baqi.dao.ZpJlInfoDao;
import com.loiot.baqi.dao.ZpJlJobLevelsDao;
import com.loiot.baqi.service.ZpJlInfoService;
import com.loiot.baqi.status.AccountType;
import com.loiot.baqi.status.DictionaryType;
import com.loiot.baqi.status.JlAuditType;
import com.loiot.baqi.status.PauseStartType;
import com.loiot.baqi.status.RecommendFlowType;
import com.loiot.baqi.status.ResumeMatchingRegexpType;
import com.loiot.baqi.utils.IdcardUtils;
import com.loiot.baqi.utils.IndexInfoSingleTon;
import com.loiot.baqi.utils.JLBUtils;
import com.loiot.baqi.utils.RegexpUtils;
import com.loiot.baqi.utils.UserSessionUtils;
import com.loiot.baqi.utils.WordUtils;
import com.loiot.baqi.pojo.ZpDictionaryInfo;
import com.loiot.baqi.pojo.ZpJlExpandInfo;
import com.loiot.baqi.pojo.ZpJlInfo;
import com.loiot.baqi.pojo.ZpJlJobLevels;
import com.loiot.commons.utils.DateUtil;
import com.loiot.commons.utils.FileUtil;
import com.loiot.commons.utils.StringUtil;
import com.timeloit.pojo.Account;

/**
 * 简历信息 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-09-19
 */
@Service("zpJlInfoService")
@Transactional
public class ZpJlInfoService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpJlInfoDao zpJlInfoDao;
    
    @Resource
    ZpJlExpandInfoDao zpJlExpandInfoDao;
    
    @Resource
  	private ZpJlJobLevelsDao zpJlJobLevelsDao;
    
    @Resource
   	private ZpDictionaryInfoDao zpDictionaryInfoDao;
    
    @Autowired
    private EmailClient emailClient;
    /**
     * 账号数据访问接口
     */
    @Resource
    private AccountDao accountDao;
	
    
    public void nodifyTechnologyAuditJob() throws Exception{
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("auditTypeId", JlAuditType.WAIT_AUDIT.getCode());
    	List<HashMap<String, Object>> list = zpJlExpandInfoDao.queryNotAuditJl(pMap);
    	if(list!=null && list.size()>0){
    		for(HashMap<String,Object> map : list){
    			int jlcount=Integer.parseInt(String.valueOf(map.get("jlcount")));
    			String nickname=String.valueOf(map.get("nickname"));
    			String email=String.valueOf(map.get("email"));
    			 if(email!=null && StringUtil.isEmail(email) ){
    				 SimpleEmailVo vo = new SimpleEmailVo();
        			 vo.addEmail(email);
                     vo.setTitle("憬仪评审通知");
                     vo.setContent(ApplicationConst.getMessage("10101", nickname,String.valueOf(jlcount)));
                     emailClient.send(vo);
                     Thread.sleep(10000);
                     log.info("发送时间："+DateUtil.toString(DateUtil.getNow(), DateUtil.DEFAULT_LONG_FORMAT));
    			 }
    		}
    	}
    }
    
    //通知薪水管理员发薪水
    public void nodifyFinanceJob() throws Exception{
    	String emailMessage="";
    	String auditPassMessage = getAuditPassPerson();
    	String goInterviewMessage = getAlreadyGoInterviewPerson();
    	if(auditPassMessage.length()>0){
    		emailMessage=auditPassMessage;
    	}
    	if(goInterviewMessage.length()>0){
    	   if(emailMessage.length()==0){
    		   emailMessage=auditPassMessage;
    	   }  else{
    		   emailMessage=emailMessage+"\n"+goInterviewMessage;
    	   } 
    	}
    	//没有薪水发放
    	if(emailMessage.length()==0){
    		emailMessage=ApplicationConst.getMessage("10106");
    	}
    	System.out.println("emailContent:"+emailMessage);

    	Account account=this.getSalaryManager();
    	//向薪水管理员发送邮件
		if(account!=null && account.getEmail()!=null && StringUtil.isEmail(account.getEmail()) ){
			 SimpleEmailVo vo = new SimpleEmailVo();
			 vo.addEmail(account.getEmail(),"273035735@qq.com");
            vo.setTitle("憬仪[红包]发放通知");
            vo.setContent(emailMessage);
            emailClient.send(vo);
            log.info("发送时间："+DateUtil.toString(DateUtil.getNow(), DateUtil.DEFAULT_LONG_FORMAT)); 
		}
    	
			
    	
    }
    //获得技术评审通过的信息
    public  String getAuditPassPerson()throws Exception{
    	
         
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("auditTypeId", JlAuditType.AUDIT_OK.getCode());
    	pMap.put("qtype","one");
    	pMap.put("endTime",new Date());
    	pMap.put("startTime",DateUtil.addDays(new Date(), -1));
    	
    	List<HashMap<String, Object>> list = this.zpJlInfoDao.statisticsJlInfo(pMap);
    	String emailContent="";
    	if(list!=null && list.size()>0)
    	{
    		
    		List<ZpDictionaryInfo> dicList = zpDictionaryInfoDao.queryZpDictionaryInfoList();
    		for(HashMap<String,Object> map : list){
    			
    			String realName =String.valueOf(map.get("realName"));	
    			int jlcount =Integer.parseInt(String.valueOf(map.get("jlcount")));	
    			String names =String.valueOf(map.get("names"));	
    			String positions =String.valueOf(map.get("positions"));	
    			String name[]=names.split(",");
    			String position[]=positions.split(",");
    			String nameStr="";
    			for(int i=0;i<name.length;i++){
    				if(i==0){
        				nameStr=name[i]+" "+getDicName(Long.parseLong(position[i]),dicList); 
    				} else{
        				nameStr=nameStr+" 、"+name[i]+" "+getDicName(Long.parseLong(position[i]),dicList); 
    				}
    			}
    			emailContent=emailContent+" \n <br> "+ApplicationConst.getMessage("10104", realName,String.valueOf(jlcount),nameStr);
    			
    			//emailContent=emailContent+emailContent;
    		}
    	}
    	return emailContent;
    }
    
    //已经去面试的信息
    public  String getAlreadyGoInterviewPerson()throws Exception{
    	
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("qtype","two");
    	pMap.put("hunterGotoInterviewStatus",RecommendFlowType.HUNTER_ALREAD_GOTO_INTERVIEW.getCode());
    	pMap.put("endTime",new Date());
    	pMap.put("startTime",DateUtil.addDays(new Date(), -1));
    	List<HashMap<String, Object>> list = this.zpJlInfoDao.statisticsJlInfo(pMap);
    	String emailContent="";
    	if(list!=null && list.size()>0)
    	{
    		List<ZpDictionaryInfo> dicList = zpDictionaryInfoDao.queryZpDictionaryInfoList();
    		for(HashMap<String,Object> map : list){
    			String realName =String.valueOf(map.get("realName"));	
    			String name =String.valueOf(map.get("name"));	
    			Long jobPositionId =Long.parseLong(String.valueOf(map.get("jobPositionId")));	
    			if(emailContent.length()==0){
    				emailContent=ApplicationConst.getMessage("10105", realName,name+" ("+getDicName(jobPositionId, dicList)+")");
    			} else{
    				emailContent=emailContent+" \n <br> " +ApplicationConst.getMessage("10105", realName,name+" ("+getDicName(jobPositionId, dicList)+")");
    			}
    		}
    	}
    	
    	//System.out.println(emailContent);
    	return emailContent;
    }
    
    public  String getDicName(Long code,List<ZpDictionaryInfo> list){
		if(code==null){
			return "";
		}
		String name ="";
		for(ZpDictionaryInfo dic : list){
			//System.out.println(code+"=" + dic.getDictionaryId()  +"结果:"+(dic.getDictionaryId()==code));
			if(dic.getDictionaryId().intValue()==code.intValue()){
				name=dic.getShowName();
				break;
			}
		}
		return name;
	}
    
    //获取薪水管理员对接人
    public Account getSalaryManager(){
		 HashMap<String,Object> pmap = new HashMap<String,Object>();
		 pmap.put("type", AccountType.SALARY_MANAGER.getCode());
		 pmap.put("isDelete", PauseStartType.START.getCode());
    	 List<Account> list = accountDao.queryAccountList(pmap);
    	 if(list!=null && list.size()>0){
    		return list.get(0);
    	 }
    	 return null;
    }
    
	
}
