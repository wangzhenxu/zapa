package com.loiot.baqi.pojo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 客户信息 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpCompanyJobInfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long jobId;  //职位id db_column: job_id 
	    private java.lang.Long companyId;  //所属公司 db_column: company_id 
	    private java.lang.Long typeId;  //职位类型 db_column: typeId 
	    private java.lang.String name;  //职位名称 db_column: name 
	    private java.lang.String reportObject;  //汇报对象 db_column: report_object 
	    private java.lang.Long jobPositionLevelId;  //职位级别 db_column: jobPositionLevelId 
	    private java.lang.Integer zpPersonCount;  //招聘人数 db_column: zp_person_count 
	    private java.lang.Double expectedYearMoneyStart;  //预计年薪开始 db_column: expected_year_money_start 
	    private java.lang.Double expectedYearMoneyEnd;  //预计年薪结束 db_column: expected_year_money_end 
	    private Integer workTermStart;  //工作年限开始 db_column: work_term_start 
	    private Integer workTermEnd;  //工作年限结束 db_column: work_term_end 
	    private java.lang.Integer downTeamPersonCount;  //团队人数 db_column: down_team_person_count 
	    private java.lang.String zpRequire;  //招聘要求 db_column: zp_require 
	    private Integer keywordStatus;//关键字状态
	    private java.lang.Long sex;  //要求性别 db_column: sex 
	    private java.lang.Long educationId;  //要求学历 db_column: educationId 
	    private java.lang.Long englishLevelId;  //要求英语等级 db_column: englishLevelId 
	    private Integer ageStart;  //年龄开始 db_column: age_start 
	    private Integer ageEnd;  //年龄结束 db_column: age_end 
	    private java.lang.Long maritalId;  //婚否 db_column: marital_id 
	    private java.lang.String topSpecialty;  //要求专业 db_column: topSpecialty 
	    private java.lang.String jobTemptText;  //职位诱惑 db_column: job_tempt_text 
	    private java.lang.String jobTemptItem;  //诱惑都好项,逗号分隔 db_column: job_tempt_item 
	    private java.lang.String desc;  //职位描述 db_column: desc 
	    private java.lang.String moreDesc;  //更多描述 db_column: more_desc 
	    private java.lang.Long inPerson;  //录入人 db_column: in_person 
	    private java.util.Date inDatetime;  //录入时间 db_column: in_datetime 
	    private java.util.Date lastUpdateTime;  //最后更新时间 db_column: last_update_time 
	    private Integer isDelete;  //是否删除 db_column: is_delete 
	    private java.lang.Long zpUrgencyStatusId;  //招聘紧急状态 db_column: zp_urgency_status_id 
	    private java.lang.Long areaId;  //所在城区 db_column: area_id 
	    private Long companyAreaId;
	    private java.lang.String inPersonName;
	    private String  companyName;
	    private java.lang.String coordX;  //坐标x db_column: coord_x 
	    private java.lang.String coordY;  //坐标y db_column: coord_y 
	    private String address;//工作地点
	    
	    List<ZpCompanyJobDemandKeys> keys;


	public ZpCompanyJobInfo(){
	}

	public ZpCompanyJobInfo(
		java.lang.Long jobId
	){
		this.jobId = jobId;
	}

	
	
}

