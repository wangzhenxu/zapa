package com.loiot.baqi.pojo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 职位匹配信息 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpJobMatchingInfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long matchId;  //主建匹配id db_column: match_id 
	    private java.lang.Long jobId;  //职位id db_column: job_id 
	    private java.lang.Long jlId;  //简历id db_column: company_id 
	    private java.lang.Long sexId;  //性别 db_column: sex_id 
	    private Integer sexStatus;  //sexStatus db_column: sex_status 
	    private java.lang.Long jobPositionId;  //职位类型 db_column: job_position_id 
	    private Integer jobPositionIdStatus;  //jobPositionIdStatus db_column: job_position_id_status 
	    private java.lang.Long jobPositionLevelId;  //职位级别 db_column: job_position_level_id 
	    private Integer jobPositionLevelIdStatus;  //jobPositionLevelIdStatus db_column: job_position_level_id_status 
	    private java.lang.Long maritalId;  //婚否 db_column: marital_id 
	    private Integer maritalIdStatus;  //maritalIdStatus db_column: marital_id_status 
	    private java.lang.Long salaryRequireId;  //薪水要求id db_column: salary_require_id 
	    private Integer salaryRequireIdStatus;  //salaryRequireIdStatus db_column: salary_require_id_status 
	    private java.lang.Long educationId;  //学历id db_column: education_id 
	    private Integer educationIdStatus;  //educationIdStatus db_column: education_id_status 
	    private java.lang.Long englishLevelId;  //英语等级 db_column: english_level_id 
	    private Integer englishLevelIdStatus;  //englishLevelIdStatus db_column: english_level_id_status 
	    private java.lang.String topSpecialty;  //专业 db_column: top_specialty 
	    private Integer topSpecialtyStatus;  //topSpecialtyStatus db_column: top_specialty_status 
	    private java.util.Date birthday;  //年龄 db_column: birthday 
	    private Integer birthdayStatus;  //birthdayStatus db_column: birthday_status 
	    private java.util.Date jobStarttime;  //工作年薪 db_column: job_starttime 
	    private Integer jobStarttimeStatus;  //jobStarttimeStatus db_column: job_starttime_status 
	    private java.lang.String matchKeword;  //匹配关键字 db_column: match_keword 
	    private java.lang.String noMatchKeyword;  //未匹配关键字 db_column: no_match_keyword 
	    private java.lang.String distance;  //distance db_column: distance 
	    private Integer distanceStatus;  //distanceStatus db_column: distance_status 
	    private java.util.Date inDatetime;  //录入时间 db_column: in_datetime 
	    private java.lang.Long inPerson;  //录入人 db_column: in_person
	    
	    private String companyName; //公司名称
	    private String jobName;//职位名称
	    
	    private Double keywordPercent; //匹配关键字比例
	    private Integer keywordCount;//要求匹配的关键字数量
	    private Integer keywordMatchCount; //以匹配数
	    private String jlName; //简历姓名
	    
	    private java.lang.String coordX;  //坐标x db_column: coord_x 
	    private java.lang.String coordY;  //坐标y db_column: coord_y 
	    private String duration;//秒
	    
	    
	   
	    
	    List<ZpJobMatchingKeys> keys;


	public ZpJobMatchingInfo(){
	}

	public ZpJobMatchingInfo(
		java.lang.Long matchId
	){
		this.matchId = matchId;
	}

	
	
}

