package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 技术评审职位列表 实体类
 * 
 * @author  wangzx 
 * @creation 2015-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpTechnicalAuditPositions  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long auditPositionsId;  //id db_column: audit_positions_id 
	    private java.lang.Long accountId;  //账户id db_column: account_id 
	    private java.lang.Long positionId;  //职位id db_column: position_id 


	public ZpTechnicalAuditPositions(){
	}

	public ZpTechnicalAuditPositions(
		java.lang.Long auditPositionsId
	){
		this.auditPositionsId = auditPositionsId;
	}

	
	
}

