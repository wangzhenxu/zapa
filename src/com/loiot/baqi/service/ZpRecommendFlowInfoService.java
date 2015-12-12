package com.loiot.baqi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiot.baqi.commons.message.email.EmailClient;
import com.loiot.baqi.commons.message.email.SimpleEmailVo;
import com.loiot.baqi.constant.ApplicationConst;
import com.loiot.baqi.constant.DictionaryUtil;
import com.loiot.baqi.controller.response.AjaxResponse;
import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.AccountDao;
import com.loiot.baqi.dao.ZpJlExpandInfoDao;
import com.loiot.baqi.dao.ZpJobMatchingInfoDao;
import com.loiot.baqi.dao.ZpRecommendFlowInfoDao;
import com.loiot.baqi.service.ZpRecommendFlowInfoService;
import com.loiot.baqi.status.AccountType;
import com.loiot.baqi.status.DictionaryType;
import com.loiot.baqi.status.JlAuditType;
import com.loiot.baqi.status.JlFlowType;
import com.loiot.baqi.status.PauseStartType;
import com.loiot.baqi.status.RecommendFlowType;
import com.loiot.baqi.utils.UserSessionUtils;
import com.loiot.baqi.pojo.ZpJlExpandInfo;
import com.loiot.baqi.pojo.ZpRecommendFlowInfo;
import com.loiot.baqi.pojo.ZpJlJobLevels;
import com.loiot.commons.utils.DateUtil;
import com.loiot.commons.utils.StringUtil;
import com.timeloit.pojo.Account;


/**
 * 推荐流程 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-11-20
 */
@Service("zpRecommendFlowInfoService")
@Transactional
public class ZpRecommendFlowInfoService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpRecommendFlowInfoDao zpRecommendFlowInfoDao;
    
    @Resource
	private ZpJobMatchingInfoDao zpJobMatchingInfoDao;
    
    @Autowired
    private EmailClient emailClient;
    
    /**
     * 账号数据访问接口
     */
    @Resource
    private AccountDao accountDao;
    
    @Resource
	private ZpJlExpandInfoDao zpJlExpandInfoDao;
	
	
	 /**
     * 查询 推荐流程列表分页
     * 
     * @param name 推荐流程名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpRecommendFlowInfo> queryZpRecommendFlowInfoListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询推荐流程列表总条数
        int totalResults = zpRecommendFlowInfoDao.getZpRecommendFlowInfoListCount(pMap);

        // 构造一个分页器
        Pager<ZpRecommendFlowInfo> pager = new Pager<ZpRecommendFlowInfo>(totalResults, pageIndex);
        //pager.setPageSize(5);
        // 查询推荐流程列表
        List<ZpRecommendFlowInfo> zpRecommendFlowInfoList = zpRecommendFlowInfoDao.queryZpRecommendFlowInfoList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpRecommendFlowInfoList);
        return pager;
    }
    
    
    
    
    /**
     * 查询 推荐流程（假）分页
     * 
     * @param name 推荐流程名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpRecommendFlowInfo> queryFlasePageList(HashMap<String,Object> pMap, int pageIndex)throws Exception {
    	//假分页
    	Pager<ZpRecommendFlowInfo> pager = this.setPkList(pMap,pageIndex);
    	List<ZpRecommendFlowInfo> zpRecommendFlowInfoList = zpRecommendFlowInfoDao.queryZpRecommendFlowInfoList(pMap);
        pager.setData(zpRecommendFlowInfoList);
        return pager;
    }
    
    /**
     * 设置 假分页id集合到Map中
     * @param pMap
     * @param pageIndex
     * @return
     * @throws Exception
     */
    public Pager<ZpRecommendFlowInfo> setPkList(HashMap<String,Object> pMap,int pageIndex) throws Exception{
    	  // 查询职位匹配信息列表总条数
        List<ZpRecommendFlowInfo> list = zpRecommendFlowInfoDao.queryZpRecommendFlowInfoList(pMap);
        // 构造一个分页器
        Pager<ZpRecommendFlowInfo> pager = new Pager<ZpRecommendFlowInfo>(list.size(), pageIndex, 5,list);
        List<ZpRecommendFlowInfo> idsList = pager.getCurrentPageData();
        List<Long> ids =this.getIds(idsList);
        pMap.put("ids", ids);
        return pager;
    }
	
	 /**
     * 添加 推荐流程
     * 
     * @param p 参数对象
     */
    public ZpRecommendFlowInfo addZpRecommendFlowInfo(ZpRecommendFlowInfo p)throws Exception {
       return  zpRecommendFlowInfoDao.addZpRecommendFlowInfo(p);
    }
    
    /**
     * 修改 推荐流程
     * 
     * @param p 参数对象
     */
    public void updateZpRecommendFlowInfo(ZpRecommendFlowInfo p)throws Exception {
        zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(p);
    }
    
    /**
     * 修改 推荐流程
     * 
     * @param p 参数对象
     */
    public void updateZpRecommendFlowInfo(HashMap<String,Object> pMap)throws Exception {
        zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(pMap);
    }
    
    /**
     * 删除  推荐流程
     * 
     * @param id 主键
     */
    public void deleteZpRecommendFlowInfo(java.lang.Long id)throws Exception {
        zpRecommendFlowInfoDao.deleteZpRecommendFlowInfo(id);
    }
    
    /**
     * 删除  推荐流程
     * 
     * @param id 主键
     */
    public void deleteZpRecommendFlowInfo(ZpRecommendFlowInfo p)throws Exception {
        zpRecommendFlowInfoDao.deleteZpRecommendFlowInfo(p);
    }
    
    /**
     * 获得  推荐流程
     * 
     * @param id 推荐流程Id
     * 
     * @return 返回与ID匹配的推荐流程
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfoById(java.lang.Long id)throws Exception {
        return  zpRecommendFlowInfoDao.getZpRecommendFlowInfoById(id);
    }
    
    /**
     * 获得  推荐流程
     * 
     * @param id 推荐流程Id
     * 
     * @return 返回与ID匹配的推荐流程
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfoById(java.lang.Long id,Long accountId)throws Exception {
        return  zpRecommendFlowInfoDao.getZpRecommendFlowInfoById(id,accountId);
    }
    
    
    /**
     * 获得  推荐流程
     * 
     * @param id 推荐流程Id
     * 
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfo(HashMap<String,Object> pMap)throws Exception {
    	return (ZpRecommendFlowInfo) zpRecommendFlowInfoDao.getZpRecommendFlowInfo(pMap);
    }
    /**
     * 获得  推荐流程
     * 
     * @param name 推荐流程名称
     * 
     * @return 返回与NAME匹配的推荐流程
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfoByName(String name)throws Exception {
        return  zpRecommendFlowInfoDao.getZpRecommendFlowInfoByName(name);
    }
    
    /**
     * 查询 推荐流程列表
     * @return 推荐流程列表
     */
    public List<ZpRecommendFlowInfo> queryZpRecommendFlowInfoList(HashMap<String,Object> pMap)throws Exception {
        return  zpRecommendFlowInfoDao.queryZpRecommendFlowInfoList(pMap);
    }
    
    /**
     * 查询 推荐流程列表
     * @return 推荐流程列表
     */
    public List<ZpRecommendFlowInfo> queryZpRecommendFlowInfoList(ZpRecommendFlowInfo p)throws Exception {
        return  zpRecommendFlowInfoDao.queryZpRecommendFlowInfoList(p);
    }
    
    /**
     * 查询  推荐流程列表条数
     * 
     * @param name 推荐流程名称
     * @return 推荐流程列表条数
     */
    
    public int getZpRecommendFlowInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpRecommendFlowInfoDao.getZpRecommendFlowInfoListCount(pMap);
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<ZpRecommendFlowInfo> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (ZpRecommendFlowInfo b : list) {
            	idsList.add(null);
            }
        }
        return idsList;
    }
    
    /**
     * 统计 推荐流程列表
     * 
     * @return 推荐流程列表
     */
    public List<HashMap<String,Object>> statisticsZpRecommendFlowInfoInfo(HashMap<String, Object> pMap )throws Exception {
    	return  zpRecommendFlowInfoDao.statisticsZpRecommendFlowInfoInfo(pMap);
    }
    
    
    public AjaxResponse AddFlow(ZpRecommendFlowInfo p,int flowType){
    	//技术评审，通过
    	if(RecommendFlowType.WAIT_RECOMMEND_COMPANY.getCode()==flowType){
    		return this.technicianAudit(p);
    	} else
		//将简历推荐到企业（更新状态）
    	if(RecommendFlowType.ALREADY_RECOMMEND_COMPANY.getCode()==flowType){
    		return this.recommandJlToCompany(p);
    	} else
    	//推荐到企业-企业反馈
		if(RecommendFlowType.RECOMMEND_COMPANY_FAILURE.getCode()==flowType){
    		return this.companyRecommandFeedback(p);
    	} else
    	//猎头通知求职者反馈
		if(RecommendFlowType.ALREADY_INVITATION_INTERVIEW_NOTIFY.getCode()==flowType){
    		return this.headhunterNotifyFeedback(p);
    	}else
    	//是否已经去面试的反馈
		if(RecommendFlowType.HUNTER_ALREAD_GOTO_INTERVIEW.getCode()==flowType){
    		return this.isGotoInterviewFeedback(p);
    	}else
    	//面试的反馈
		if(RecommendFlowType.HUNTER_INTERVIEW_PASS.getCode()==flowType){
    		return this.interviewerFeedback(p);
    	}
    	
    	
		
		
		
		
    	return null;
    }
    //技术评审
    public AjaxResponse technicianAudit(ZpRecommendFlowInfo p){
    	try {
    		 HashMap<String,Object> pmap = new HashMap<String,Object>();

            if(UserSessionUtils.getAccount().getType()==AccountType.TECHICAL_AUDIT.getCode()){
         	   pmap.put("matchId", p.getMatchId());
         	   pmap.put("inPerson", UserSessionUtils.getAccount().getAccountId());
         	   int count =this.zpJobMatchingInfoDao.getZpJobMatchingInfoListCount(pmap);
                if(count==0){
             	   return AjaxResponse.ILLEGAL_OPERATER;
                }
            }
            
            if(UserSessionUtils.getAccount().getType()==AccountType.TECHICAL_AUDIT.getCode() || UserSessionUtils.getAccount().getType()==AccountType.ADMIN.getCode()){
             
              //获取企业对接人
              final Account account = getCompanyInterfacePerson();
              if(account==null){
            	   return  new AjaxResponse(-1, "没找到企业对接人");
              }
              
               ZpRecommendFlowInfo newP = new ZpRecommendFlowInfo();
         	   newP.setMatchId(p.getMatchId());
        		   newP.setTechnicianAuditTime(new Date());
        		   newP.setTechnicianAuditContent(p.getTechnicianAuditContent());
        		   newP.setTechnicianAuditStatus((int)JlAuditType.AUDIT_OK.getCode());
        		   newP.setTechnicianAuditPerson(UserSessionUtils.getAccount().getAccountId());
        		   newP.setJlId(p.getJlId());
        		   newP.setCompanyJobId(p.getCompanyJobId());
        		   newP.setFlowStatus((int)RecommendFlowType.WAIT_RECOMMEND_COMPANY.getCode());
        		   newP.setEnterpriseInterfacePerson(account.getAccountId());
        		   this.zpRecommendFlowInfoDao.addZpRecommendFlowInfo(newP);
        		   //更新流程状态
        		   this.updateJlExpandFlowStatus(p.getJlId(),null, JlFlowType.PROCEED.getCode());
            }
     		// 添加成功
     		return AjaxResponse.OK;
     	
     	}
         catch (Exception e) {
 			e.printStackTrace();
 			 //失败
 	        return AjaxResponse.FAILED;
 		}
    }
    
    
    //企业对接人讲简历推荐到企业去
    public AjaxResponse recommandJlToCompany(ZpRecommendFlowInfo p){
    	try {
            if(UserSessionUtils.getAccount().getType()==AccountType.COMPANY_INTERFACER.getCode() || UserSessionUtils.getAccount().getType()==AccountType.ADMIN.getCode()){
         	   ZpRecommendFlowInfo newP = new ZpRecommendFlowInfo();
         	   newP.setAuditId(p.getAuditId());
         	   newP.setEnterpriseDockingPerson(UserSessionUtils.getAccount().getAccountId());
         	   //这个状态没用
         	   newP.setEnterpriseDockingStatus((int)RecommendFlowType.ALREADY_RECOMMEND_COMPANY.getCode());
         	   newP.setEnterpriseDockingTime(new Date());
         	   newP.setFlowStatus((int)RecommendFlowType.ALREADY_RECOMMEND_COMPANY.getCode());
    		   this.zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(newP);
            }
     		// 添加成功
     		return AjaxResponse.OK;
     	
     	}
         catch (Exception e) {
 			e.printStackTrace();
 			 //失败
 	        return AjaxResponse.FAILED;
 		}
    }
    
    //企业推荐反馈
    public AjaxResponse companyRecommandFeedback(ZpRecommendFlowInfo p){
    	try {
            if(UserSessionUtils.getAccount().getType()==AccountType.COMPANY_INTERFACER.getCode() || UserSessionUtils.getAccount().getType()==AccountType.ADMIN.getCode()){
               ZpRecommendFlowInfo newP = new ZpRecommendFlowInfo();
         	   newP.setAuditId(p.getAuditId());
         	   newP.setEnterpriseReplyStatus(p.getEnterpriseReplyStatus());
         	   newP.setEnterpriseReplyContent(p.getEnterpriseReplyContent());
         	   newP.setEnterpriseReplyTime(new Date());
         	   if(p.getEnterpriseReplyStatus()==DictionaryUtil.getCode(DictionaryType.ENTERPRISE_REPLY_STATUS.getCode(), "邀请面试"))
         	   {
         		  //获取电话猎头对接人
         		  final Account account = this.getHeadhunterInterfacePerson();
         		  if(account==null){
                 	   return  new AjaxResponse(-1, "没找到猎头顾问");
                   }
         		  
         		 new Thread(){ 
               	  @Override 
               	  public void run() { 
               		  String nickname=account.getNickName();
               	       String email=account.getEmail();
               	        if(email!=null && StringUtil.isEmail(email) ){
               	         SimpleEmailVo vo = new SimpleEmailVo();
               	            vo.addEmail(email);
               	                     vo.setTitle("憬仪通知");
               	                     vo.setContent(ApplicationConst.getMessage("10103", nickname,String.valueOf("1")));
               	                     emailClient.send(vo);
               	                     log.info("发送时间："+DateUtil.toString(DateUtil.getNow(), DateUtil.DEFAULT_LONG_FORMAT));
               	        }
               	  } 
                   }.start();
             	   newP.setHeadhunterInterfacePerson(account.getAccountId());
         		  //企业反馈通过
         		  newP.setFlowStatus((int)RecommendFlowType.COMPANY_INVITATION_INTERVIEW.getCode());
         	   }else {
         		   //企业没通过
             	   newP.setFlowStatus((int)RecommendFlowType.RECOMMEND_COMPANY_FAILURE.getCode());
             	  
             	   //更新流程状态
        		   this.updateJlExpandFlowStatus(null,p.getAuditId(), JlFlowType.FLOW_END.getCode());
         	   }
    		   this.zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(newP);
    		   
            }
     		// 添加成功
     		return AjaxResponse.OK;
     	}
         catch (Exception e) {
 			e.printStackTrace();
 			 //失败
 	        return AjaxResponse.FAILED;
 		}
    }
    
    //企业推荐反馈
    public AjaxResponse headhunterNotifyFeedback(ZpRecommendFlowInfo p){
    	try {
            if(UserSessionUtils.getAccount().getType()==AccountType.HEAD_HUNTING_MANAGER.getCode() || UserSessionUtils.getAccount().getType()==AccountType.ADMIN.getCode()){
               ZpRecommendFlowInfo newP = new ZpRecommendFlowInfo();
         	   newP.setAuditId(p.getAuditId());
         	   newP.setHrNoticeStatus(p.getHrNoticeStatus());
         	   newP.setHrNoticeFeedbackContent(p.getHrNoticeFeedbackContent());
         	   newP.setHrNoticeTime(new Date());
         	   if(p.getHrNoticeStatus()==DictionaryUtil.getCode(DictionaryType.HEADHUNTER_REPLY_STATUS.getCode(), "已同意面试"))
         	   {
         		  //等待求职者去面试
         		  newP.setFlowStatus((int)RecommendFlowType.WAIT_JOBHUNTER_GOTO_INTERVIEW.getCode());
         	   }else {
          		  newP.setFlowStatus((int)RecommendFlowType.JOBHUNTER_NO_AGREE_INTERVIEW.getCode());
          		  //更新流程状态
       		      this.updateJlExpandFlowStatus(null,p.getAuditId(), JlFlowType.FLOW_END.getCode());

         	   }
    		   this.zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(newP);
            }
     		// 添加成功
     		return AjaxResponse.OK;
     	}
         catch (Exception e) {
 			e.printStackTrace();
 			 //失败
 	        return AjaxResponse.FAILED;
 		}
    }
    
    //是否已经去面试的反馈
    public AjaxResponse isGotoInterviewFeedback(ZpRecommendFlowInfo p){
    	try {
            if(UserSessionUtils.getAccount().getType()==AccountType.HEAD_HUNTING_MANAGER.getCode() || UserSessionUtils.getAccount().getType()==AccountType.ADMIN.getCode()){
               ZpRecommendFlowInfo newP = new ZpRecommendFlowInfo();
         	   newP.setAuditId(p.getAuditId());
         	   newP.setHunterGotoInterviewOperatorTime(new Date());
         	   newP.setHunterGotoInterviewStatus(p.getHunterGotoInterviewStatus());
         	   newP.setHunterReplayContent(p.getHunterReplayContent());
         	   newP.setFlowStatus(p.getHunterGotoInterviewStatus());
    		   this.zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(newP);
    		   
    		   //未去面试，结束流程
    		  if(p.getHunterGotoInterviewStatus() == RecommendFlowType.HUNTER_NO_GOTO_INTERVIEW.getCode()){
    			//更新流程状态
       		    this.updateJlExpandFlowStatus(null,p.getAuditId(), JlFlowType.FLOW_END.getCode());
    		  }
    		   
    		 
            }
     		// 添加成功
     		return AjaxResponse.OK;
     	}
         catch (Exception e) {
 			e.printStackTrace();
 			 //失败
 	        return AjaxResponse.FAILED;
 		}
    }
    
    //面试的反馈
    public AjaxResponse interviewerFeedback(ZpRecommendFlowInfo p){
    	try {
            if(UserSessionUtils.getAccount().getType()==AccountType.HEAD_HUNTING_MANAGER.getCode() || UserSessionUtils.getAccount().getType()==AccountType.ADMIN.getCode()){
               ZpRecommendFlowInfo newP = new ZpRecommendFlowInfo();
         	   newP.setAuditId(p.getAuditId());
               newP.setHunterInterviewStatus(p.getHunterInterviewStatus());
         	   newP.setHunterInerviewReplayContent(p.getHunterInerviewReplayContent());
         	   newP.setHunterInterviewOperatorTime(new Date());
         	   newP.setFlowStatus(p.getHunterInterviewStatus());
         	   this.zpRecommendFlowInfoDao.updateZpRecommendFlowInfo(newP);
         	   
     			//更新流程状态
        		this.updateJlExpandFlowStatus(null,p.getAuditId(), JlFlowType.FLOW_END.getCode());
            }
     		// 添加成功
     		return AjaxResponse.OK;
     	}
         catch (Exception e) {
 			e.printStackTrace();
 			 //失败
 	        return AjaxResponse.FAILED;
 		}
    }
    
    //获取企业对接人
    public Account getCompanyInterfacePerson(){
		 HashMap<String,Object> pmap = new HashMap<String,Object>();
		 pmap.put("type", AccountType.COMPANY_INTERFACER.getCode());
		 pmap.put("isDelete", PauseStartType.START.getCode());
    	 List<Account> list = accountDao.queryAccountList(pmap);
    	 if(list!=null && list.size()>0){
    		return list.get(0);
    	 }
    	 return null;
    }
    
    //获取电话猎头对接人
    public Account getHeadhunterInterfacePerson(){
		 HashMap<String,Object> pmap = new HashMap<String,Object>();
		 pmap.put("type", AccountType.HEAD_HUNTING_MANAGER.getCode());
		 pmap.put("isDelete", PauseStartType.START.getCode());
    	 List<Account> list = accountDao.queryAccountList(pmap);
    	 if(list!=null && list.size()>0){
    		return list.get(0);
    	 }
    	 return null;
    }
    
    //更新流程状态
    public void updateJlExpandFlowStatus(Long jlId,Long auditId,int flowType) throws Exception{
    	HashMap<String,Object> pMap = new HashMap<String,Object>();

    	if(jlId==null) {
    		ZpRecommendFlowInfo flow = this.zpRecommendFlowInfoDao.getZpRecommendFlowInfoById(auditId);
    		jlId = flow.getJlId();
    	}else {
    		//技术评审是，简历id 不为null
    		pMap.put("auditTypeId", JlAuditType.AUDIT_OK.getCode());

    	}
    	
    	pMap.put("qtype", "one");
    	pMap.put("jlId", jlId);
    	pMap.put("recommendFlowStatus", flowType);
    	this.zpJlExpandInfoDao.updateZpJlExpandInfo(pMap);
    }
}
