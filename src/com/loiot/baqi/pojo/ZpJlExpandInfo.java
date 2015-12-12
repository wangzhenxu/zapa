package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 简历扩展信息 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpJlExpandInfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long jlExpandId;  //简历扩展id db_column: jl_expand_id 
	    private java.lang.Long jlId;  //简历id db_column: jl_id 
	    private java.lang.String jlFilePath;  //简历存放路径 db_column: jl_file_path 
	    private java.lang.String jlContent;  //简历内容 db_column: jl_content 
	    private java.lang.Long technicianAuditPerson;  //创建技术评审人 db_column: technician_audit_person 
	    private java.util.Date technicianAuditTime;  //创建技术评审时间 db_column: technician_audit_time 
	    private java.lang.Integer auditTypeId;  //评审状态 db_column: audit_type_id 
	    private Integer recommendFlowStatus; //推荐流程状态
	    private Long hellpPersonId; //帮助上传简历人
	public ZpJlExpandInfo(){
	}

	public ZpJlExpandInfo(
		java.lang.Long jlExpandId
	){
		this.jlExpandId = jlExpandId;
	}

	
	
}

