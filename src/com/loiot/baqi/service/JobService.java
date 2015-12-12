package com.loiot.baqi.service;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.loiot.baqi.dao.TaskScheduleJobDao;
import com.loiot.baqi.pojo.TaskScheduleJob;
import com.loiot.baqi.service.job.NotifyJob;
import com.loiot.commons.utils.DateUtil;



/**
 * 账号业务逻辑类
 * 
 * @author zhengrj
 * 
 */
@Service("jobService")
public class JobService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
 	private TaskScheduleJobDao taskScheduleJobDao;

    
    public void doInitScheduler() throws Exception{
    	List<TaskScheduleJob> list = taskScheduleJobDao.queryTaskScheduleJobList();
    	
    	String a="5";
    	//initWorkScheduler(list);
    	initStorehouseProductWarningSchedulerT(list);

 	  /* List<WorkSchedule> list=workScheduleDao.findAll("from WorkSchedule t where t.autoAlertAble=?1 and t.startTime>=?2",true,new Date());
 	   initWorkScheduler(list);
        initStorehouseProductWarningScheduler();
 	 //  initAccessPointDataCollectionScheduler();
 	  // initAccessPointClientEventScheduler();
*/ 
    	}
    
    
    public void initStorehouseProductWarningSchedulerT(List<TaskScheduleJob> taskList)
    		throws SchedulerException, ParseException {
		   Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		   Map<JobDetail,List<Trigger>> map=new HashMap<JobDetail,List<Trigger>>();
		    for(TaskScheduleJob task : taskList){
		    	   Object object = null;  
		           Class clazz = null;    
		    	try {
					clazz = Class.forName(task.getBeanClass());
					object = clazz.newInstance();  
				} catch (Exception e) {
					e.printStackTrace();
				} 
		    	 if (object == null) {  
		             log.error("任务名称 = [" + task.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");  
		             return;  
		         }  
		    	//StorehouseProductWarningJob.class是类名可以写在数据库中 ，表达式0 00 00 * * ?也是可以写在数据库中
		         JobDetail job =JobBuilder.newJob(NotifyJob.class).withIdentity("j_"+task.getJobId(), "g_"+task.getJobGroup()).build();
		         job.getJobDataMap().put("taskObj", task);
		         CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("t_"+task.getJobId(), "g_"+task.getJobGroup()).withSchedule(CronScheduleBuilder.cronSchedule(task.getCronExpression())).build();
		         List<Trigger> triggerList=new ArrayList<Trigger>();
		    	 triggerList.add(trigger);
		       	 map.put(job, triggerList);
		    }
		      
		    sched.scheduleJobs(map,true);
		   if(!sched.isStarted()){
			   sched.start();   // 启动调度器 
		   }
		      
	}

 	public void initWorkScheduler(List<TaskScheduleJob> list)
 			throws SchedulerException, ParseException {
 		   Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
 		   //Map<JobDetail,List<Trigger>> map=new HashMap<JobDetail,List<Trigger>>();
 		    /*for(TaskScheduleJob t:list){
 		        JobDetail job =JobBuilder.newJob(JobNotify.class).withIdentity("j_"+t.getJobId(), ""+t.getJobGroup()).build();
		    	 CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("t_"+t.getJobId(), "t+"+t.getJobGroup()).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
		         List<Trigger> triggerList=new ArrayList<Trigger>();
		    	 triggerList.add(trigger);
		       	 map.put(job, triggerList);
 		    }*/
		       JobDetail job =JobBuilder.newJob(NotifyJob.class).withIdentity("job1", "group1").build();  
  		      Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
		      sched.scheduleJob(job, trigger);   // 注册并进行调度  
 		    
 		  
 		    
 		     
 		    /*// 通过过JobDetail封装HelloJob，同时指定Job在Scheduler中所属组及名称，这里，组名为group1，而名称为job1。  
 		    JobDetail job =JobBuilder.newJob(OaJob.class).withIdentity("job1", "group1").build();  
   
 		    // 创建一个SimpleTrigger实例，指定该Trigger在Scheduler中所属组及名称。  
 		    // 接着设置调度的时间规则.当前时间运行  
 		  // Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();
 		      sched.scheduleJob(job, trigger);   // 注册并进行调度  
*/        
 		   if(!sched.isStarted()){
 			   sched.start();   // 启动调度器 
 		   }
 		      
 	}
 	
 	public void deleteWorkScheduleJobs(List<Object> list) throws SchedulerException{
 		/*List<String> keys=new ArrayList<String>();
 		 for(WorkSchedule t:list){
 			 keys.add("J_"+t.getId());
 		 }
 		 deleteJobs(keys);*/
 	}
 	
 	public void deleteJobs(List<String> keys) throws SchedulerException{
 		/* List<JobKey> JobKeys=new ArrayList<JobKey>();
 		 for(String key:keys){
 			 JobKey jk=new JobKey(key);
 			 JobKeys.add(jk);
 		 }
 		 Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
 		 sched.deleteJobs(JobKeys);*/
 	}
 	
 	public void initAccessPointDataCollectionScheduler()
 			throws SchedulerException {
 		   
 		  /* Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
 		   Map<JobDetail,List<Trigger>> map=new HashMap<JobDetail,List<Trigger>>();
 		  
 		       	 JobDetail job =JobBuilder.newJob(AccessPointDataCollectionJob.class).withIdentity("J_AccessPointDataCollectionJob", "G_AccessPointDataCollectionJob").build();
 		    	
 		    	 CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("T_AccessPointDataCollectionJob", "T_AccessPointDataCollectionJob")  
 		                 .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")).build();
 		       
 		    	 
 		    	 List<Trigger> triggerList=new ArrayList<Trigger>();
 		    	 triggerList.add(trigger);
 		       	 
 		         map.put(job, triggerList);
 		  	    sched.scheduleJobs(map,true);
 		  
 		    
 	
 		   if(!sched.isStarted()){
 			   sched.start();   // 启动调度器 
 		   }*/
 		      
 	}
 	
 	public void initAccessPointClientEventScheduler()
 			throws SchedulerException {
 		  /* 
 		   Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
 		   Map<JobDetail,List<Trigger>> map=new HashMap<JobDetail,List<Trigger>>();
 		  
 		       	 JobDetail job =JobBuilder.newJob(AccessPointClientEventJob.class).withIdentity("J_AccessPointClientEventJob", "G_AccessPointClientEventJob").build();
 		    	
 		    	 CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("T_AccessPointClientEventJob", "T_AccessPointClientEventJob")  
 		                 .withSchedule(CronScheduleBuilder.cronSchedule("0 00 00 * * ?")).build();
 		       
 		    	 
 		    	 List<Trigger> triggerList=new ArrayList<Trigger>();
 		    	 triggerList.add(trigger);
 		       	 
 		         map.put(job, triggerList);
 		  	    sched.scheduleJobs(map,true);
 		  
 		    
 	
 		   if(!sched.isStarted()){
 			   sched.start();   // 启动调度器 
 		   }*/
 		      
 	}
     
     public void initStorehouseProductWarningScheduler()
     		throws SchedulerException {
 		 /*  Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
 		   Map<JobDetail,List<Trigger>> map=new HashMap<JobDetail,List<Trigger>>();
 		      //StorehouseProductWarningJob.class是类名可以写在数据库中 ，表达式0 00 00 * * ?也是可以写在数据库中
 		         JobDetail job =JobBuilder.newJob(StorehouseProductWarningJob.class).withIdentity("J_StorehouseProductWarningJob", "G_StorehouseProductWarningJob").build();
 		    	 CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("T_StorehouseProductWarningJob", "T_StorehouseProductWarningJob").withSchedule(CronScheduleBuilder.cronSchedule("0 00 00 * * ?")).build();
 		         List<Trigger> triggerList=new ArrayList<Trigger>();
 		    	 triggerList.add(trigger);
 		       	 map.put(job, triggerList);
 		  	     sched.scheduleJobs(map,true);
 		   if(!sched.isStarted()){
 			   sched.start();   // 启动调度器 
 		   }*/
 		      
 	}

}
