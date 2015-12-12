package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 简历职位级别列表 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpJlJobLevels  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long jlJobLevelId;  //简历职位列表主建 db_column: jl_job_level_id 
	    private java.lang.Long jlId;  //简历id db_column: jl_id 
	    private java.lang.Long jobLevelId;  //职位级别id db_column: job_level_id 


	public ZpJlJobLevels(){
	}

	public ZpJlJobLevels(
		java.lang.Long jlJobLevelId
	){
		this.jlJobLevelId = jlJobLevelId;
	}

	
	
}

