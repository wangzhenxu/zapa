package com.loiot.baqi.pojo;

import java.util.List;

import com.loiot.commons.utils.DateUtil;
import com.timeloit.pojo.Node;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 简历信息 实体类
 * 
 * @author  wangzx 
 * @creation 2015-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpJlInfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long jlId;  //jlId db_column: jl_id 
	    private java.lang.String name;  //姓名 db_column: name 
	    private java.lang.Long sex;  //性别 0 男 1女 db_column: sex 
	    private java.lang.Long jobId;  //jobId db_column: job_id 
	    private java.lang.String emal;  //邮箱 db_column: emal 
	    private java.lang.String phone;  //手机号 db_column: phone 
	    private java.lang.String identityCard;  //身份证 db_column: identity_card 
	    private java.lang.Long maritalId;  //婚否 db_column: marital_id 
	    private java.lang.Long salaryRequireId;  //薪水要求 db_column: salary_require_id 
	    private Integer famousCompanyUpdateStatus;  //知名企业分析状态 db_column: famous_company_update_status 
	    private java.lang.Long educationId;  //学历id db_column: education_id 
	    private java.lang.String schoolTag;  //最高毕业学校 db_column: SchoolTag 
	    private java.lang.Long inPerson;  //录入人 db_column: in_persion 
	    private java.util.Date inTime;  //录入时间 db_column: in_time 
	    private java.util.Date lastOperatorTime;  //最后更新时间 db_column: last_operator_time 
	    private java.util.Date jobStartTime;  //工作开始时间 db_column: job_start_time 
	    private Integer importStatus;  //导入状态 db_column: import_status 
	    private java.lang.Long jobPositionId;  //职位id db_column: job_position_id 
	    private java.lang.Long jobPositionLevelId;  //职位级别id db_column: job_position_level_id 
	    private java.lang.String nowAddress;  //现住址 db_column: now_address 
	    private java.lang.Long englishLevelId;  //英语等级 db_column: english_level_id 
	    private java.lang.String topSpecialty;  //专业 db_column: top_specialty 
	    private java.util.Date birthday;  //生日 c=dv_column: birthday 
	    //扩展信息
	    private java.lang.String jlFilePath;  //简历存放路径 db_column: jl_file_path 
	    private java.lang.String jlContent;  //简历内容 db_column: jl_content
	    
	    
	    private java.lang.Long jlExpandId;  //简历扩展id db_column: jl_expand_id 
	    private java.lang.Long technicianAuditPerson;  //创建技术评审人 db_column: technician_audit_person 
	    private java.lang.String technicianAuditPersonName;  //创建技术评审名称 
	    private java.util.Date technicianAuditTime;  //创建技术评审时间 db_column: technician_audit_time 
	    private java.lang.Integer auditTypeId;  //评审状态 db_column: audit_type_id 
	    private Long hellpPersonId; //帮助上传简历人
	    private java.lang.String hellpPersonName; //帮助上传简历人名称
	    private java.lang.String inPersonName;   

	    private java.lang.String coordX;  //坐标x db_column: coord_x 
	    private java.lang.String coordY;  //坐标y db_column: coord_y 
	    
		private List<ZpJlJobLevels> zpJlJobLevels; //职位列表

	    private Integer recommendFlowStatus; //推荐流程状态

	public ZpJlInfo(){
	}

	public ZpJlInfo(
		java.lang.Long jlId
	){
		this.jlId = jlId;
	}

	public int getAge(){
		int age=0;
		if(this.getBirthday()!=null){
			String jlBirthdayStr = DateUtil.toString(this.getBirthday(), DateUtil.DEFAULT_SHORT_FORMAT);
			age= DateUtil.compareDate(jlBirthdayStr,  null, 2); 
		}
		return age;
	}
	
	
}

