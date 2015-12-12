
package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 职位匹配关键字信息 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpJobMatchingKeys  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long keyId;  //主建 db_column: key_id 
	    private java.lang.Long jobId;  //所属职位 db_column: job_id 
	    private java.lang.Long jlId;  //简历id db_column: jl_id 
	    private java.lang.String keyword;  //关键字 db_column: keyword 
	    private Integer isMatch;  //是否匹配 db_column: is_match 
	    private java.lang.Long inPerson;  //录入人 db_column: in_person 

	  private java.lang.String inPersonName;

	public ZpJobMatchingKeys(){
	}

	public ZpJobMatchingKeys(
		java.lang.Long keyId
	){
		this.keyId = keyId;
	}

	
	
}

