package com.loiot.baqi.status;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loiot.baqi.constant.Const;
import com.loiot.baqi.constant.DictionaryUtil;
import com.loiot.baqi.pojo.ZpCompanyJobInfo;
import com.loiot.commons.utils.RandomUtil;

/**
 * 猎上网 状态集合
 * @author Administrator
 *
 */
public class HDTypes {
    private static Logger log = LoggerFactory.getLogger(HDTypes.class);


    //公司规模类型
	public static Long  getScaleId(Integer hdTypeId){
		Long value=null;
		if(hdTypeId==null){
			value= null;
		}else
		if(hdTypeId.intValue()==1){//50-150
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_SCALE.getCode(), Const.TWO);
		}
		else
		if(hdTypeId.intValue()==2){//100-499
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_SCALE.getCode(), Const.THREE);
		}else
		if(hdTypeId.intValue()==3){//500-999人
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_SCALE.getCode(), Const.FOUR);
		}
		else
		if(hdTypeId.intValue()==4){//1000-4999人
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_SCALE.getCode(), Const.FIVE);
		}
		else
		if(hdTypeId.intValue()==5){//500-999人
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_SCALE.getCode(), Const.FOUR);
		}
		else
		if(hdTypeId.intValue()==6){//10000+人
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_SCALE.getCode(), Const.SEVEN);
		}
		else {
			value =null;
			log.warn("新加类型 :getScaleId:"+hdTypeId);
		}
		if(value==null){
			log.info("getScaleId is null");
		}
		return value;
	}
	
	 //公司注册时间
	public static Date  getRegTime(Double millisecond){
		Date value=null;
		if(millisecond==null){
			value= null;
			log.info("getRegTime is null");
		}else
		{
			value=new Date(millisecond.longValue());
		}
		return value;
	}
	
	
 	//融资阶段
	public static Long  getFinancingLevel(Integer hdTypeId){
		Long value=null;
		if(hdTypeId==null){
			value= null;
		}else
		if(hdTypeId.intValue()==3){//A轮 
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.ONE);
		}else
		if(hdTypeId.intValue()==4){//B轮 
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.TWO);
		}
		else
		if(hdTypeId.intValue()==5){//c轮 
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.THREE);
		}
		else
		if(hdTypeId.intValue()==6){//D轮 
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.FOUR);
		}
		else
		if(hdTypeId.intValue()==0){//未知
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.ZERO);
		}
		else
		if(hdTypeId.intValue()==1){//未融资
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.FIVE);
		}else
		if(hdTypeId.intValue()==7){//上市公司
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_FINANCING_LEVEL.getCode(), Const.SIX);
		}
		else {
			value =null;
			log.warn("新加类型 :getFinancingLevel:"+hdTypeId);
		}
		if(value==null){
			log.info("getFinancingLevel is null");
		}
		return value;
	}
	
	
	//所属行业
	public static Long  getIndustryId(String hdTypeId){
		Long value=null;
		if(StringUtils.isBlank(hdTypeId)){
			value= null;
		}else{
			String industaryId = hdTypeId.split(",")[0];
			if(industaryId.equals("10103")){ //互联网
				value=DictionaryUtil.getCode(DictionaryType.COMPANY_NATURE.getCode(), Const.SEVEN);
			}else
			if(industaryId.equals("10104")){ //软件/IT服务
				value=DictionaryUtil.getCode(DictionaryType.COMPANY_NATURE.getCode(), Const.EIGHT);
			}else {
				value =null;
				log.warn("新加类型 :getIndustryId:"+hdTypeId);
			}
		}
		if(value==null){
			log.info("getIndustryId is null");
		}
		return value;
	}
	
	
	//公司性质
	public static Long  getCompanyNature(Integer hdTypeId){
		Long value=null;
		if(hdTypeId==null){
			value= null;
		}else
		if(hdTypeId.intValue()==0){//外商独资/外企办事处
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_NATURE.getCode(), Const.SEVEN);
		}else
		if(hdTypeId.intValue()==5){//民营
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_NATURE.getCode(), Const.FOUR);
		}else
		if(hdTypeId.intValue()==7){//其它
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_NATURE.getCode(), Const.EIGHT);
		}
		else {
			value =null;
			log.warn("新加类型 :getcompanyNature:"+hdTypeId);
		}
		if(value==null){
			log.info("getcompanyNature is null");
		}
		return value;
	}
	
	
	/*//职位类型
	public static Long  getTypeId(Integer hdTypeId){
		Long value=null;
		if(hdTypeId==null){
			value= null;
		}else
		if(hdTypeId.intValue()==0){//民营
			value=DictionaryUtil.getCode(DictionaryType.COMPANY_NATURE.getCode(), Const.FOUR);
		}else {
			value =null;
			log.warn("新加类型 :getTypeId:"+hdTypeId);
		}
		if(value==null){
			log.info("getTypeId is null");
		}
		return value;
	}*/
	
	public static Long   getJobPositionLevelId(String title,Integer workExpRequired){
		Long value=null;
		if(StringUtils.isBlank(title)){
			value= null;
		}else
		if(title.indexOf("资深")!=-1 || title.indexOf("高级")!=-1 || workExpRequired>=3 ){
			value=DictionaryUtil.getCode(DictionaryType.JOB_POSITION_LEVE.getCode(), Const.THREE);
		}
		if(value==null){
			log.info("getJobPositionLevelId is null");
		}
		return value;
		
	}
	
	
	public static void setWorkExpRequired(Integer type,ZpCompanyJobInfo job){
		
		Long value=null;
		if(type==null){
			value= null;
		}else
		if(type.intValue()==0){//不限
			value=2l;
		}else
		if(type.intValue()==1){//1-3年
			job.setWorkTermStart(1);
			job.setWorkTermEnd(3);
			value=2l;
		}
		else
		if(type.intValue()==3){//3-5年
			job.setWorkTermStart(3);
			job.setWorkTermEnd(5);
			value=2l;
		}
		else
		if(type.intValue()==5){//5-10年
			job.setWorkTermStart(5);
			job.setWorkTermEnd(10);
			value=2l;
		}else
		if(type.intValue()==10){//10年以上
			job.setWorkTermStart(10);
			job.setWorkTermEnd(20);
			value=2l;
		}else {
			value =null;
			log.warn("新加类型 :setWorkExpRequired:"+type);
		}
		if(value==null){
			log.info("setWorkExpRequired is null");
		}
	}
	//招聘人数
	public static Integer  getDownTeamPersonCount(String title){
		Integer value=null;
		if(StringUtils.isBlank(title)){
			value= null;
		}else
		if(title.split("-").length==1){
			value=0;
		}else
		if(title.split("-").length==2){
			int maxCount = Integer.parseInt(title.split("-")[1].replace("人", ""));
			int minCount = Integer.parseInt(title.split("-")[0].replace("人", ""));
			return (maxCount+minCount)/2;
		}
		return value;
	}
	
	//性别
	public static Long  getSexId(Integer type){
		Long value=null;
		if(type==null || type.intValue()==0){
			value= null;
		}else
		if(type.intValue()==1){//男
			value=DictionaryUtil.getCode(DictionaryType.SEX.getCode(), Const.ONE);
		}else
		if(type.intValue()==2){//女
			value=DictionaryUtil.getCode(DictionaryType.SEX.getCode(), Const.TWO);
		}else {
			value =null;
			log.warn("新加类型 :getSexId:"+type);
		}
		/*if(value==null){
			log.info("getSexId is null");
		}*/
		return value;
	}
	//获得学历
	public static Long getEducationId(Integer type){
		Long value=null;
		if(type==null || type.intValue()==0){
			value= null;
		}else
		if(type.intValue()==1){//专科以上
			value=DictionaryUtil.getCode(DictionaryType.EDUCATION.getCode(), Const.ONE);
		}else
		if(type.intValue()==2){//本科以上
			value=DictionaryUtil.getCode(DictionaryType.SEX.getCode(), Const.TWO);
		}else
		if(type.intValue()==3){//硕士以上
			value=DictionaryUtil.getCode(DictionaryType.SEX.getCode(), Const.THREE);
		}else
		if(type.intValue()==4){//博士以上
			value=DictionaryUtil.getCode(DictionaryType.SEX.getCode(), Const.FOUR);
		}else {
			value =null;
			log.warn("新加类型 :getEducationId:"+type);
		}
		if(value==null){
			log.info("getEducationId is null");
		}
		return value;
	}
	
	//英语等级
	public static Long  getEnglishLevelId(String title){
		Long value=null;
		if(StringUtils.isBlank(title)){
			value= null;
		}else
		if(title.indexOf("英语")!=-1){
			value=DictionaryUtil.getCode(DictionaryType.ENGLISH_LEVEL.getCode(), Const.ONE);
		}
		/*if(value==null){
			log.info("getEnglishLevelId is null");
		}*/
		return value;
	}
	
	//是否是急聘
	public static Long  getZpUrgencyStatusId(Integer type){
		Long value=null;
		if(type==null){
			value= null;
		}else
		if(type.intValue()==0){//不急
			value=DictionaryUtil.getCode(DictionaryType.JOB_URGENCY.getCode(), Const.TWO);
		}else
		if(type.intValue()==2){//紧急
			value=DictionaryUtil.getCode(DictionaryType.JOB_URGENCY.getCode(), Const.ONE);
		}else {
			value =null;
			log.warn("新加类型 :getZpUrgencyStatusId:"+type);
		}
		if(value==null){
			log.info("getZpUrgencyStatusId is null");
		}
		return value;
	}
	
	
	
	public static void main(String[] args) {
		Integer count = HDTypes.getDownTeamPersonCount("5-10");
		System.out.println("下属人数："+count);
	}
	
	
	
	
}
