package com.loiot.baqi.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.loiot.baqi.constant.DictionaryUtil;
import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.ZpJlExpandInfoDao;
import com.loiot.baqi.dao.ZpJlInfoDao;
import com.loiot.baqi.dao.ZpJlJobLevelsDao;
import com.loiot.baqi.service.ZpJlInfoService;
import com.loiot.baqi.status.DictionaryType;
import com.loiot.baqi.status.JlAuditType;
import com.loiot.baqi.status.ResumeMatchingRegexpType;
import com.loiot.baqi.utils.IdcardUtils;
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
    
    @Autowired
    private EmailClient emailClient;
	
	 /**
     * 查询 简历信息列表分页
     * 
     * @param name 简历信息名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpJlInfo> queryZpJlInfoListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询简历信息列表总条数
        int totalResults = zpJlInfoDao.getZpJlInfoListCount(pMap);

        // 构造一个分页器
        Pager<ZpJlInfo> pager = new Pager<ZpJlInfo>(totalResults, pageIndex);

        // 查询简历信息列表
        List<ZpJlInfo> zpJlInfoList = zpJlInfoDao.queryZpJlInfoList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpJlInfoList);
        return pager;
    }
	
	 /**
     * 添加 简历信息
     * 
     * @param p 参数对象
     */
    public void addZpJlInfo(ZpJlInfo p,String jobIds)throws Exception {
    	
    	zpJlInfoDao.addZpJlInfo(p);
     	ZpJlExpandInfo p1 = new ZpJlExpandInfo ();
     	p1.setJlId(p.getJlId());
     	p1.setJlFilePath(p.getJlFilePath());
     	p1.setJlContent(p.getJlContent());
     	p1.setAuditTypeId((int)JlAuditType.NO_SELECT_AUDIT_PERSON.getCode());
     	if(p.getHellpPersonId()!=null){
         	p1.setHellpPersonId(UserSessionUtils.getAccount().getAccountId());
     	}
        zpJlExpandInfoDao.addZpJlExpandInfo(p1);
        
        this.addLevel(jobIds, p.getJlId());
    }
    
    /**
     * 修改 简历信息
     * 
     * @param p 参数对象
     */
    public void updateZpJlInfo(ZpJlInfo p,String jobIds)throws Exception {
        zpJlInfoDao.updateZpJlInfo(p);
        
        if(!StringUtils.isBlank(jobIds)){
        	//先删除后，添加级别
            ZpJlJobLevels pt = new ZpJlJobLevels();
            pt.setJlId(p.getJlId());
            this.zpJlJobLevelsDao.deleteZpJlJobLevels(pt);
            
            this.addLevel(jobIds, p.getJlId());
        }
        
    }
    
    
    public void addLevel(String jobIds,Long jlId) throws Exception{
    	//添加职位
        if(jobIds!=null && jobIds.length()>0){
        	String args[]= jobIds.split(",");
        	for(int i=0;i<args.length;i++){
        		ZpJlJobLevels jobLevel = new ZpJlJobLevels();
        		jobLevel.setJlId(jlId);
        		jobLevel.setJobLevelId(Long.parseLong(args[i]));
        		this.zpJlJobLevelsDao.addZpJlJobLevels(jobLevel);
        	}
        }
    }
    
    /**
     * 删除  简历信息
     * 
     * @param id 主键
     */
    public void deleteZpJlInfo(java.lang.Long id)throws Exception {
        zpJlInfoDao.deleteZpJlInfo(id);
    }
    
    /**
     * 删除  简历信息
     * 
     * @param id 主键
     */
    public void deleteZpJlInfo(ZpJlInfo p)throws Exception {
        zpJlInfoDao.deleteZpJlInfo(p);
    }
    
    /**
     * 获得  简历信息
     * 
     * @param id 简历信息Id
     * 
     * @return 返回与ID匹配的简历信息
     */
    public ZpJlInfo getZpJlInfoById(java.lang.Long id)throws Exception {
        return  zpJlInfoDao.getZpJlInfoById(id);
    }
    
    /**
     * 获得  简历信息
     * 
     * @param id 简历信息Id
     * 
     * @return 返回与ID匹配的简历信息
     */
    public ZpJlInfo getZpJlInfoById(java.lang.Long id,Long accountId)throws Exception {
        return  zpJlInfoDao.getZpJlInfoById(id,accountId);
    }
    
    /**
     * 获得  简历信息
     * 
     * @param name 简历信息名称
     * 
     * @return 返回与NAME匹配的简历信息
     */
    public ZpJlInfo getZpJlInfoByName(String name)throws Exception {
        return  zpJlInfoDao.getZpJlInfoByName(name);
    }
    
    /**
     * 查询 简历信息列表
     * @return 简历信息列表
     */
    public List<ZpJlInfo> queryZpJlInfoList(HashMap<String,Object> pMap)throws Exception {
        return  zpJlInfoDao.queryZpJlInfoList(pMap);
    }
    
    /**
     * 查询 简历信息列表
     * @return 简历信息列表
     */
    public List<ZpJlInfo> queryZpJlInfoList(ZpJlInfo p)throws Exception {
        return  zpJlInfoDao.queryZpJlInfoList(p);
    }
    
    /**
     * 查询  简历信息列表条数
     * 
     * @param name 简历信息名称
     * @return 简历信息列表条数
     */
    
    public int getZpJlInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpJlInfoDao.getZpJlInfoListCount(pMap);
    }
    
    
    public ZpJlInfo paseWord(File file,CommonsMultipartFile commonFile,String fileName) throws Exception{
			String txt = WordUtils.getWordText(file.getPath(),fileName);
			ZpJlInfo zp = this.regxWordKeyword(txt,file,commonFile,fileName);
		  return zp;
    }
    
    public String getJlRegexp(String regType){
    	 List<ZpDictionaryInfo> regexpList = DictionaryUtil.getRegexpList();
    	 for(ZpDictionaryInfo zi :regexpList){
    		 if(zi.getName().equals(regType)){
    			return zi.getValue(); 
    		 }
    	 }
    	return "";
    }
    
    
    public  ZpJlInfo regxWordKeyword(String content,File file,CommonsMultipartFile commonFile,String fileName) throws Exception{
    	ZpJlInfo bean = new ZpJlInfo();
    	//自定义异常（解析不了word2007）
    	if(content.length()<10){
    		throw  new java.lang.ClassNotFoundException();
    	}
    	//bean.setJlContent(content);
    	Matcher matcher=null;
    	String regexpStr=null;
    	List<String> matchs =null;
    	int count=0;
    	String matcherString="";
    	String idcard = "exits";
    	String birthdate="exits";
    	RegexpUtils instance = RegexpUtils.getInstance();
    	
    	matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.ID_CARD_REGEXP.getTitle()), content);
    	//身份证
    	if(matchs.size()==1){
    		matcherString=matchs.get(0);
    		bean.setIdentityCard(matcherString);
    		String sex = IdcardUtils.getGenderByIdCard(matcherString);
    		int age = IdcardUtils.getAgeByIdCard(matcherString);
    		int birthYear =IdcardUtils.getYearByIdCard(matcherString);
    		int birthMonth =IdcardUtils.getMonthByIdCard(matcherString);
    		int birthDay =IdcardUtils.getDateByIdCard(matcherString);

    		bean.setSex(DictionaryUtil.getCode(DictionaryType.SEX.getCode(), sex));
    		//Date new2 = DateUtil.addYear(new Date(), -age);
    		Date birthD =DateUtil.toDate(birthYear+"-"+birthMonth+"-"+birthDay);
    		bean.setBirthday(birthD);
    	} else {
    		idcard="noExits";
    	}
    	//身份证不存在
    	if(idcard.equals("noExits")){
    		//性别
    		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.SEX_REGEXP.getTitle()), content);
    		if(matchs.size()==1){
    			matcherString=matchs.get(0);
        		bean.setSex(DictionaryUtil.getCode(DictionaryType.SEX.getCode(), matcherString));
    		}
    		
    		// 出生日期
    		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.BIRTHDATE_REGEXP.getTitle()), content);
    		if(matchs.size()==1){
    			matcherString=matchs.get(0);
    			String new1=JLBUtils.dealbirthday(matcherString);
    			Date new2 = DateUtil.toDate(new1);
        		bean.setBirthday(new2);
    		}
    	}
    	
    	//年龄
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.AGE_REGEXP.getTitle()), content);
		if(matchs.size()==1 && bean.getBirthday()==null){
			matcherString=matchs.get(0);
			int ageInt = Integer.parseInt(matcherString);
			Date new2 = DateUtil.addYear(new Date(), -ageInt);
			bean.setBirthday(new2);
		}
    	//姓名
    	matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.NAME_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
			bean.setName(matcherString);
		}
    	//邮箱
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.EMAIL_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
    		bean.setEmal(matcherString);
		}
		
		//手机
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.PHONE_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
    		bean.setPhone(matcherString);
		}
		//学校名称
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.SCHOOLTAG_REGEXP.getTitle()), content);
		if(matchs.size()>=1){
			for(int i =0;i<matchs.size();i++){
				matcherString=matchs.get(i);
	    		bean.setSchoolTag(matcherString);
	    		if(matcherString.indexOf("大学")!=-1){
	    			matcherString="本科";
	    			Long v = DictionaryUtil.getCode(DictionaryType.EDUCATION.getCode(),JLBUtils.dealDeEducation(matcherString));
	    			bean.setEducationId(v);
	    			//break;
	    		} /*if(matcherString.indexOf("学院")!=-1){
	    			matcherString="专科";
	    			Long v = DictionaryUtil.getCode(DictionaryType.EDUCATION.getCode(),JLBUtils.dealDeEducation(matcherString));
	    			bean.setEducationId(v);
	    		}*/
			}
			
		}
		if(bean.getEducationId()==null){
			//最高学历
			matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.TOP_SCHOOLTAG_REGEXP.getTitle()), content);
			if(matchs.size()>0){
				matcherString=matchs.get(0);
				System.out.println("最高学历:" +matcherString );
				Long v = DictionaryUtil.getCode(DictionaryType.EDUCATION.getCode(),JLBUtils.dealDeEducation(matcherString));
				bean.setEducationId(v);
			}
		}
		
		//婚否
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.MARITAL_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
    		bean.setMaritalId(DictionaryUtil.getCode(DictionaryType.IS_MARRY.getCode(), matcherString));
		}
		//英语等级 (11)
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.ENGLISH_LEVEL_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
			Long v = DictionaryUtil.getCode(DictionaryType.ENGLISH_LEVEL.getCode(),JLBUtils.englishLevel(matcherString));
			bean.setEnglishLevelId(v);
		}
		//专业
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.TOP_SPECIALTY_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
    		bean.setTopSpecialty(matcherString);
		}
		//工作年限
		matchs = instance.matchGroupB(getJlRegexp(ResumeMatchingRegexpType.JOB_WORK_TERM_REGEXP.getTitle()), content);
		if(matchs.size()==1){
			matcherString=matchs.get(0);
			int new1 = Integer.parseInt(matcherString);
			Date new2 = DateUtil.addYear(new Date(), -new1);
    		bean.setJobStartTime(new2);
		}
		
		//DictionaryUtil.getName(code);
		//String filePath = fileName.substring(fileName.lastIndexOf("."));
		String file1Path="/temp/"+fileName;
     	File newFile1;
        newFile1 = FileUtil.createFile(ApplicationConst.UPLOAD_JL_PATH+file1Path);
         //将文件写到新的文件当中
        commonFile.getFileItem().write(newFile1);
        //file1Path = ApplicationConst.UPLOAD_JL_URL+file1Path;
        bean.setJlFilePath(file1Path);
         
		return bean;
	}
    
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
	
}
