package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * hr(人力资源hr) 实体类
 * 
 * @author  wangzx 
 * @creation 2015-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpHrInfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long hrId;  //主建 db_column: hr_id 
	    private java.lang.String qqName;  //qq名称 db_column: qq_name 
	    private java.lang.String qqNumber;  //qq号 db_column: qq_number 
	    private java.lang.Long addressId;  //addressId db_column: address_id 
	    private java.lang.Long inPerson;  //录入人 db_column: in_person 
	    private java.util.Date inTime;  //录入时间 db_column: in_time
	    private Integer sendStatus;		//0 等待发送 1已发送成功 2发送失败'
	    private java.util.Date lastSendTime;  //最后发送时间
	    private java.lang.String sender;  //接收人 db_column: in_person 


	public ZpHrInfo(){
	}

	public ZpHrInfo(
		java.lang.Long hrId
	){
		this.hrId = hrId;
	}

	
	
}

