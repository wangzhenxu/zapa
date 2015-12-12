package com.loiot.baqi.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 任务 实体类
 * 
 * @author  wangzx 
 * @creation 2015-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskScheduleJob  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
		
	    private java.lang.Long jobId;  //jobId db_column: job_id 
	    private java.util.Date createTime;  //创建时间 db_column: create_time 
	    private java.util.Date updateTime;  //更新时间 db_column: update_time 
	    private java.lang.String jobName;  //任务名称 db_column: job_name 
	    private java.lang.String jobGroup;  //任务分组 db_column: job_group 
	    private java.lang.String jobStatus;  //任务状态 是否启动任务 db_column: job_status 
	    private java.lang.String cronExpression;  //cron表达式  db_column: cron_expression 
	    private java.lang.String description;  //描述  db_column: description 
	    private java.lang.String beanClass;  //任务执行时调用哪个类的方法 包名+类名  db_column: bean_class 
	    private java.lang.String isConcurrent;  // 任务是否有状态 db_column: is_concurrent 
	    private java.lang.String springId;  //spring bean db_column: spring_id 
	    private java.lang.String methodName;  //任务调用的方法名  db_column: method_name 


	public TaskScheduleJob(){
	}

	public TaskScheduleJob(
		java.lang.Long jobId
	){
		this.jobId = jobId;
	}

	
	
}

