package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公司职位要求关键字 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpCompanyJobDemandKeys  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long keyId;  //主建 db_column: key_id 
	    private java.lang.Long jobId;  //所属职位 db_column: job_id 
	    private java.lang.String keyword;  //关键字 db_column: keyword 
	    private java.lang.String proportion;  //比重(百分比) db_column: proportion 


	public ZpCompanyJobDemandKeys(){
	}

	public ZpCompanyJobDemandKeys(
		java.lang.Long keyId
	){
		this.keyId = keyId;
	}

	
	
}

