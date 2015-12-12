package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 邮件模版 实体类
 * 
 * @author  wangzx 
 * @creation 2015-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZpEmalTemplate  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long emalId;  //主建 db_column: emal_id 
	    private java.lang.String templateTitle;  //模版标题 db_column: template_title 
	    private java.lang.String templateSubject;  //模版主题 db_column: template_subject 
	    private java.lang.String templateContent;  //模版类型，0 hr的简历模版，1求职者的定时模版 2自定义内容模版 db_column: template_content 
	    private Integer templateType;  //模版类型 0 hr模版 1求职者模版 2临时模版 db_column: template_type 
	    private java.util.Date updateTime;  //更新时间 db_column: update_time 
	    private java.lang.Long accountName;  //accountName db_column: account_name 
	    private java.lang.Integer sort;  //排序字段 db_column: sort 


	public ZpEmalTemplate(){
	}

	public ZpEmalTemplate(
		java.lang.Long emalId
	){
		this.emalId = emalId;
	}

	
	
}

